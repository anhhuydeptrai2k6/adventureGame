package com.HUY.adventureGame.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Lay_Vung_Dat {
    public static ArrayList<Rectangle> layRectangle(String linkanh){
        Pixmap anh = new Pixmap(Gdx.files.internal(linkanh));
        ArrayList<Rectangle> danhsach = new ArrayList<>();

        ArrayList<Rectangle> hangtruoc = new ArrayList<>();

        for (int y = 0; y<anh.getHeight(); y++){
            ArrayList<Rectangle> hangnay = new ArrayList<>();
            int batdau = -1;
            for (int x = 0; x <anh.getWidth(); x++){
                int pixel = anh.getPixel(x, y);
                int alpha = (pixel >>> 24) & 0xff;

                if (alpha > 80){
                    if (batdau == -1) batdau = x;
                }
                else {
                    if (batdau != -1){
                        int chieurong = x - batdau;
                        float yThuc = anh.getHeight() - 1 - y;
                        hangnay.add(new Rectangle(batdau, yThuc, chieurong, 1));
                        batdau = -1;
                    }
                }
            }
            if (batdau != -1){
                int chieurong = anh.getWidth() - batdau;
                float yThuc = anh.getHeight() - 1 - y;
                hangnay.add(new Rectangle(batdau, yThuc, chieurong, 1));
            }

            ArrayList<Rectangle> hangmoi = new ArrayList<>();
            for (Rectangle moi : hangnay){
                boolean dagop = false;
                for (Rectangle cu : hangtruoc){
                    if (moi.x == cu.x && moi.width == cu.width && moi.y + moi.height == cu.y){
                        cu.y = moi.y;
                        cu.height += 1;
                        hangmoi.add(cu);
                        dagop = true;
                        break;
                    }
                }
                if (!dagop){
                    danhsach.add(moi);
                    hangmoi.add(moi);
                }
            }
            hangtruoc = hangmoi;
        }
        anh.dispose();
        return danhsach;
    }
}
