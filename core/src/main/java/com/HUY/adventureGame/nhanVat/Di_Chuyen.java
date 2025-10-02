package com.HUY.adventureGame.nhanVat;

import com.badlogic.gdx.Gdx;

public class Di_Chuyen {
    private float x, y;
    private float vX = 0, vY = 0;
    private float tocDo = 250f;
    private float lucNhay = 450f;
    private float lucNhayKep = 250f;
    private float trongLuc = -500f;
    private int soLanNhay = 0;

    private boolean flipX = false;
    private boolean dangdungdat = true;
    private boolean dangnhay = false;

    private TRANGTHAI trangthai = TRANGTHAI.DUNGYEN;

    public void sangphai(){
        vX = tocDo;
        flipX = false;
        if (dangdungdat) trangthai = TRANGTHAI.CHAY;
    }
    public void sangtrai(){
        vX = -tocDo;
        flipX = true;
        if (dangdungdat) trangthai = TRANGTHAI.CHAY;
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
            soLanNhay = 1;
            trangthai = TRANGTHAI.NHAY;
        }else if (soLanNhay == 1 && !dangdungdat){
            vY = lucNhayKep;
            soLanNhay = 2;
            trangthai = TRANGTHAI.NHAYKEP;
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
        if (y <= 0){
            vY = 0;
            y = 0;
            dangdungdat = true;
            dangnhay = false;
            soLanNhay = 0;
            if (vX == 0) trangthai = TRANGTHAI.DUNGYEN;
            else trangthai = TRANGTHAI.CHAY;
        }
        else {
            dangdungdat = false;
            if (vY > 0) {
                if (soLanNhay == 1) trangthai = TRANGTHAI.NHAY;
                else if (soLanNhay == 2) trangthai = TRANGTHAI.NHAYKEP;
            }
            else trangthai = TRANGTHAI.ROI;
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
