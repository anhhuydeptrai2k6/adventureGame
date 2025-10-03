package com.HUY.adventureGame.nhanVat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Hoat_Anh_Nhan_Vat {

    private Texture[] dungyen = new Texture[11];
    private Texture[] chay = new Texture[12];
    private Texture nhay;
    private Texture[] nhaykep = new Texture[6];
    private Texture roi;

    private float timedoiframe = 0;
    private int[] frame = new int[3];


    public Hoat_Anh_Nhan_Vat(){
        dungyen[0] = new Texture("nhanvat/dungim/dungim000.png");
        dungyen[1] = new Texture("nhanvat/dungim/dungim001.png");
        dungyen[2] = new Texture("nhanvat/dungim/dungim002.png");
        dungyen[3] = new Texture("nhanvat/dungim/dungim003.png");
        dungyen[4] = new Texture("nhanvat/dungim/dungim004.png");
        dungyen[5] = new Texture("nhanvat/dungim/dungim005.png");
        dungyen[6] = new Texture("nhanvat/dungim/dungim006.png");
        dungyen[7] = new Texture("nhanvat/dungim/dungim007.png");
        dungyen[8] = new Texture("nhanvat/dungim/dungim008.png");
        dungyen[9] = new Texture("nhanvat/dungim/dungim009.png");
        dungyen[10] = new Texture("nhanvat/dungim/dungim010.png");

        chay[0] = new Texture("nhanvat/chay/chay000.png");
        chay[1] = new Texture("nhanvat/chay/chay001.png");
        chay[2] = new Texture("nhanvat/chay/chay002.png");
        chay[3] = new Texture("nhanvat/chay/chay003.png");
        chay[4] = new Texture("nhanvat/chay/chay004.png");
        chay[5] = new Texture("nhanvat/chay/chay005.png");
        chay[6] = new Texture("nhanvat/chay/chay006.png");
        chay[7] = new Texture("nhanvat/chay/chay007.png");
        chay[8] = new Texture("nhanvat/chay/chay008.png");
        chay[9] = new Texture("nhanvat/chay/chay009.png");
        chay[10] = new Texture("nhanvat/chay/chay010.png");
        chay[11] = new Texture("nhanvat/chay/chay011.png");

        nhay = new Texture("nhanvat/nhay/nhay.png");
        nhaykep[0] = new Texture("nhanvat/nhay/nhaykep000.png");
        nhaykep[1] = new Texture("nhanvat/nhay/nhaykep001.png");
        nhaykep[2] = new Texture("nhanvat/nhay/nhaykep002.png");
        nhaykep[3] = new Texture("nhanvat/nhay/nhaykep003.png");
        nhaykep[4] = new Texture("nhanvat/nhay/nhaykep004.png");
        nhaykep[5] = new Texture("nhanvat/nhay/nhaykep005.png");

        roi = new Texture("nhanvat/roi/roi.png");
    }

    public void capnhat(float delta, TRANGTHAI trangthai){
        switch (trangthai){
            timedoiframe += Gdx.graphics.getDeltaTime();
            case DUNGYEN:
                if (timedoiframe > 0.05f){
                    frame[0] = (frame[0] + 1) % dungyen.length;
                    timedoiframe = 0;
                }
                break;
            case CHAY:
                if (timedoiframe > 0.05f){
                    frame[1] = (frame[1] + 1) % chay.length;
                    timedoiframe = 0;
                }
                break;
            case NHAYKEP:
                if (timedoiframe > 0.05f){
                    frame[2] = (frame[2] + 1) % nhaykep.length;
                    timedoiframe = 0;
                }
                break;
        }
    }

    public void ve(Batch batch, float x, float y, boolean flipX, TRANGTHAI trangthai){
        Texture veNhanVat = dungyen[0];
        switch (trangthai){
            case DUNGYEN:
                veNhanVat = dungyen[frame];
                break;
            case CHAY:
                veNhanVat = chay[frame];
                break;
            case NHAY:
                veNhanVat = nhay;
                break;
            case NHAYKEP:
                veNhanVat = nhaykep[frame];
                break;
            case ROI:
                veNhanVat = roi;
                break;
        }
        if (flipX){
            batch.draw(veNhanVat, x + 32*2, y, -(32*2), 32*2);
        }else {
            batch.draw(veNhanVat, x, y, 32*2, 32*2);
        }
    }
}
