package com.HUY.adventureGame.nhanVat;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tao_Nhan_Vat extends Actor {
    private Hoat_Anh_Nhan_Vat hoatanh;
    private Di_Chuyen diChuyen;

    public Tao_Nhan_Vat(){
        hoatanh = new Hoat_Anh_Nhan_Vat();
        diChuyen = new Di_Chuyen();
    }

    public void act(float delta){
        super.act(delta);
        hoatanh.capnhat(delta, diChuyen.getTrangthai());
        diChuyen.capnhat(delta);
    }

    public void ve(Batch batch){
        hoatanh.ve(batch, diChuyen.getX(), diChuyen.getY(), diChuyen.danglat(), diChuyen.getTrangthai());
    }

    public Di_Chuyen getDiChuyen(){
        return diChuyen;
    }
}
