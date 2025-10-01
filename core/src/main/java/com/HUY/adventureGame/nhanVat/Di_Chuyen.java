package com.HUY.adventureGame.nhanVat;

import com.badlogic.gdx.Gdx;

public class Di_Chuyen {
    private float x, y;
    private float vX = 0, vY = 0;
    private float tocDo = 120f;
    private float lucNhay = 300f;
    private float trongLuc = -500f;

    private boolean flipX = false;
    private boolean dangdungdat = true;
    private boolean dangnhay = false;

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
    public void nhay(){
        if (dangdungdat && !dangnhay){
            vY = lucNhay;
            dangdungdat = false;
            dangnhay = true;
            trangthai = TRANGTHAI.NHAY;
        }
    }
    public void roi(){
        if (!dangdungdat && dangnhay){
            trangthai = TRANGTHAI.ROI;
        }
    }

    public void capnhat(float delta){
        x += vX * delta;
        y += vY * delta;
        vY += trongLuc*delta;
        if (y < 0){
            vY = 0;
            y = 0;
            dangdungdat = true;
            dangnhay = false;
            if (vX == 0){
                trangthai = TRANGTHAI.DUNGYEN;
            }else trangthai = TRANGTHAI.CHAY;
        }
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
