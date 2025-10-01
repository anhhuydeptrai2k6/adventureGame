package com.HUY.adventureGame.nhanVat;

public class Di_Chuyen {
    private float x, y;
    private float vX = 0, vY = 0;
    private float tocDo = 120f;
    private float lucNhay = 300f;
    private float trongLuc = -500f;

    private boolean flipX = false;
    private boolean dangdungdat = true;

    private TRANGTHAI trangthai = TRANGTHAI.DUNGYEN;

    public void sangphai(){
        vX = tocDo;
        flipX = false;
        trangthai = TRANGTHAI.CHAY;
    }
    public void sangtrai(){
        vX = -tocDo;
        flipX = true;
        trangthai = TRANGTHAI.CHAY;
    }

    public void dungim(){
        vX = 0;
        if (dangdungdat){
            trangthai = TRANGTHAI.DUNGYEN;
        }
    }

    public void capnhat(float delta){
        x += vX * delta;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public TRANGTHAI getTrangthai(){
        return trangthai;
    }
    public boolean danglat(){
        return flipX;
    }
}
