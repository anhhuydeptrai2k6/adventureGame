package com.HUY.adventureGame.nhanVat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class Hoat_Anh_Nhan_Vat {

    private Texture[] dungyen = new Texture[11];
    private Texture[] chay = new Texture[12];

    private float timedoiframe = 0;
    private int frame = 0;


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
    }

    public void capnhat(float delta, TRANGTHAI trangthai){
        switch (trangthai){
            case DUNGYEN:
                timedoiframe += Gdx.graphics.getDeltaTime();
                if (timedoiframe > 0.05f){
                    frame = (frame + 1) % 11;
                    timedoiframe = 0;
                }
                break;
            case CHAY:
                timedoiframe += Gdx.graphics.getDeltaTime();
                if (timedoiframe > 0.05f){
                    frame = (frame + 1) % 12;
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
        }
        if (flipX){
            batch.draw(veNhanVat, x + 32, y, -32, 32);
        }else {
            batch.draw(veNhanVat, x, y, 32, 32);
        }
    }
}
