package com.HUY.adventureGame;

import com.HUY.adventureGame.heThong.MainGame;
import com.HUY.adventureGame.heThong.Thao_Tac;
import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.HUY.adventureGame.nhanVat.Hoat_Anh_Nhan_Vat;
import com.HUY.adventureGame.nhanVat.Tao_Nhan_Vat;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ManHinhChinh implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private final MainGame game;

    Tao_Nhan_Vat nhanVat;
    Thao_Tac thaoTac;

    public ManHinhChinh(MainGame game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        nhanVat = new Tao_Nhan_Vat();

        thaoTac = new Thao_Tac(nhanVat.getDiChuyen());
        Gdx.input.setInputProcessor(thaoTac);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        nhanVat.act(delta);

        batch.begin();
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
