package com.HUY.adventureGame.map;

import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.badlogic.gdx.math.MathUtils;

public class Gioi_Han_Map {
    private float mapW;
    private float mapH;

    public Gioi_Han_Map(float mapW, float mapH){
        this.mapW = mapW;
        this.mapH = mapH;
    }

    public void Gioi_Han(Di_Chuyen nhanvat){
        float x = nhanvat.getX();
        float y = nhanvat.getY();
        float w = 32*2;
        float h = 32*2;

        x = MathUtils.clamp(x, 0, mapW - w);
        y = MathUtils.clamp(y, 0, mapH - h);

        nhanvat.setX(x);
        nhanvat.setY(y);
    }
}
