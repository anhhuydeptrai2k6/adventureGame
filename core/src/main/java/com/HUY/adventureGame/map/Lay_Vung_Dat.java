package com.HUY.adventureGame.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class Lay_Vung_Dat {
    public static ArrayList<Rectangle> layRectangle(String linkanh){
        Pixmap anh = new Pixmap(Gdx.files.internal(linkanh));
        ArrayList<Rectangle> danhsach = new ArrayList<>();

        for (int y = 0; y<anh.getHeight(); y++){
            int batdau = -1;
            for (int x = 0; x <anh.getWidth(); x++){
                int pixel = anh.getPixel(x, y);
                int alpha = pixel & 0xff;

                if (alpha > 0){
                    if (batdau == -1) batdau = x;
                }
                else {
                    if (batdau != -1){
                        int chieurong = x - batdau;
                        danhsach.add(new Rectangle(batdau, y, chieurong, 1));
                        batdau = -1;
                    }
                }
            }
            if (batdau != -1){
                int chieurong = anh.getWidth() - batdau;
                danhsach.add(new Rectangle(batdau, y, chieurong, 1));
            }
        }
        anh.dispose();
        return danhsach;
    }
}
