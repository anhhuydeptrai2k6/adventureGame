package com.HUY.adventureGame.heThong;

import com.HUY.adventureGame.map.Vung_Dat;
import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.badlogic.gdx.math.Rectangle;

public class Va_Cham {

    public static void vachamTren(Di_Chuyen nhanvat, Rectangle dat){
        Rectangle nhanVat = nhanvat.getRectangle();
        if (nhanvat.getvY() <= 0 && nhanVat.getY() >= dat.y + dat.height - 5 && nhanVat.getY() <= dat.y + dat.height && nhanVat.overlaps(dat)){
            nhanvat.setY(dat.y + dat.height);
            nhanvat.setvY(0);
            nhanvat.setDangDungDat(true);
            nhanvat.setDangnhay(false);
        }
    }
    public static void vachamDuoi(Di_Chuyen nhanvat, Rectangle dat){
        Rectangle nhanVat = nhanvat.getRectangle();
        if (nhanvat.getvY() > 0 && nhanVat.y + nhanVat.height < dat.y + 5 && nhanVat.y + nhanVat.height >= dat.y - 5 && nhanVat.overlaps(dat)){
            nhanvat.setY(dat.y - nhanVat.height);
            nhanvat.setvY(0);
        }
    }
    public static void vachamTrai(Di_Chuyen nhanvat, Rectangle dat){
        Rectangle nhanVat = nhanvat.getRectangle();
        if (nhanvat.getvX() < 0 && nhanVat.x + nhanVat.width > dat.x + dat.width && nhanVat.x < dat.x + dat.width && nhanVat.overlaps(dat)){
            nhanvat.setX(dat.x + dat.width);
        }
    }
    public static void vachamPhai(Di_Chuyen nhanvat, Rectangle dat){
        Rectangle nhanVat = nhanvat.getRectangle();
        if (nhanvat.getvX() > 0 && nhanVat.x + nhanVat.width > dat.x && nhanVat.x < dat.x && nhanVat.overlaps(dat)){
            nhanvat.setX(dat.x - nhanVat.width);
        }
    }

    public static void xetVaCham(Di_Chuyen nhanvat, Vung_Dat vungDat){
        if(!nhanvat.getRectangle().overlaps(vungDat.vungdat)) return;

        switch (vungDat.loaiDat){
            case DATCUNG:
                vachamTren(nhanvat, vungDat.vungdat);
                vachamDuoi(nhanvat, vungDat.vungdat);
                vachamTrai(nhanvat, vungDat.vungdat);
                vachamPhai(nhanvat, vungDat.vungdat);
                break;
        }
    }
}
