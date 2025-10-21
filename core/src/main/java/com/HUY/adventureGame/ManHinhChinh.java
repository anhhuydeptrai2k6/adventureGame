package com.HUY.adventureGame;

import com.HUY.adventureGame.heThong.MainGame;
import com.HUY.adventureGame.heThong.Thao_Tac;
import com.HUY.adventureGame.heThong.Va_Cham;
import com.HUY.adventureGame.map.Lay_Vung_Dat;
import com.HUY.adventureGame.map.Loai_Dat;
import com.HUY.adventureGame.map.Vung_Dat;
import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.HUY.adventureGame.nhanVat.Hoat_Anh_Nhan_Vat;
import com.HUY.adventureGame.nhanVat.Tao_Nhan_Vat;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class ManHinhChinh implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private final MainGame game;

    Tao_Nhan_Vat nhanVat;
    Thao_Tac thaoTac;

    private Texture map;

    ArrayList<Vung_Dat> danhSachDat= new ArrayList<>();

    public ManHinhChinh(MainGame game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        nhanVat = new Tao_Nhan_Vat();
        nhanVat.getDiChuyen().setViTri(100, 200);

        thaoTac = new Thao_Tac(nhanVat.getDiChuyen());
        Gdx.input.setInputProcessor(thaoTac);

        map = new Texture("map/map.png");

        for (Rectangle rectangle : Lay_Vung_Dat.layRectangle("map/map.png")){
            danhSachDat.add(new Vung_Dat(rectangle, Loai_Dat.DATCUNG));
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        nhanVat.act(delta);

        for (Vung_Dat vungDat : danhSachDat){
            Va_Cham.xetVaCham(nhanVat.getDiChuyen(), vungDat);
        }

        batch.begin();
        batch.draw(map, 0, 0);
        nhanVat.ve(batch);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void pause() {}

    @Override
    public void dispose() {}
}
