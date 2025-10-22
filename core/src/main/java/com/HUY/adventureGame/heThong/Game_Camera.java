package com.HUY.adventureGame.heThong;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

public class Game_Camera {
    private OrthographicCamera camera;
    private float cameraW, cameraH;
    private float mapW, mapH;

    public Game_Camera(float cameraW, float cameraH, float mapW, float mapH){
        this.cameraW = cameraW;
        this.cameraH = cameraH;
        this.mapW = mapW;
        this.mapH = mapH;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, cameraW, cameraH);
    }

    public void follow(float x, float y){
        float camX = x;
        float camY = y;

        camX = MathUtils.clamp(camX, cameraW/2, mapW - cameraW/2);
        camY = MathUtils.clamp(camY, cameraH/2, mapH - cameraH/2);

        if (mapW <= cameraW) camX = cameraW/2;
        if (mapH <= cameraH) camY = cameraH/2;

        camera.position.x += (camX - camera.position.x) * 0.1f;
        camera.position.y += (camY - camera.position.y) * 0.1f;

        camera.update();
    }
    public OrthographicCamera getCamera(){
        return camera;
    }
}
