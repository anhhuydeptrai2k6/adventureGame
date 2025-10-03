package com.HUY.adventureGame.heThong;

import com.HUY.adventureGame.nhanVat.Di_Chuyen;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Thao_Tac extends InputAdapter {

    private Di_Chuyen diChuyen;

    private boolean bamphimtrai = false;
    private boolean bamphimphai = false;

    public Thao_Tac(Di_Chuyen diChuyen){
        this.diChuyen = diChuyen;
    }

    public boolean keyDown(int keycode){
        switch (keycode){
            case Input.Keys.LEFT:
                diChuyen.sangtrai();
                bamphimtrai = true;
                break;
            case Input.Keys.RIGHT:
                diChuyen.sangphai();
                bamphimphai = true;
                break;
            case Input.Keys.UP:
                diChuyen.nhay();
                break;
        }
        return true;
    }
    public boolean keyUp(int keycode){
        switch (keycode){
            case Input.Keys.LEFT:
                diChuyen.dungim();
                bamphimtrai = false;
                break;
            case Input.Keys.RIGHT:
                diChuyen.dungim();
                bamphimphai = false;
                break;
            case Input.Keys.UP:
                diChuyen.roi();
        }
        if (bamphimphai && !bamphimtrai) diChuyen.sangphai();
        else if (bamphimtrai && !bamphimphai) diChuyen.sangtrai();
        else if (!bamphimphai && !bamphimtrai) diChuyen.dungim();

        return true;
    }
}
