package com.HUY.adventureGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class ManHinhChinh implements Screen {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private final MainGame game;

    public ManHinhChinh(MainGame game){
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1f);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
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
