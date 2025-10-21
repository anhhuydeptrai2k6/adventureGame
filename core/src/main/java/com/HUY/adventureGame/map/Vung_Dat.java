package com.HUY.adventureGame.map;

import com.badlogic.gdx.math.Rectangle;

public class Vung_Dat {
    public Rectangle vungdat;
    public Loai_Dat loaiDat;

    public Vung_Dat(Rectangle vungdat, Loai_Dat loaiDat){
        this.loaiDat = loaiDat;
        this.vungdat = vungdat;
    }
}
