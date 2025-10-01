package com.HUY.adventureGame.heThong;

import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Thao_Tac extends InputAdapter {

    private Di_Chuyen diChuyen;

    public Thao_Tac(Di_Chuyen diChuyen){
        this.diChuyen = diChuyen;
    }

    public boolean keyDown(int keycode){
        switch (keycode){
            case Input.Keys.LEFT:
                diChuyen.sangtrai();
                break;
            case Input.Keys.RIGHT:
                diChuyen.sangphai();;
                break;
        }
        return true;
    }
    public boolean keyUp(int keycode){
        switch (keycode){
            case Input.Keys.LEFT:
                diChuyen.dungim();
                break;
            case Input.Keys.RIGHT:
                diChuyen.dungim();
                break;
        }
        return true;
    }
}
