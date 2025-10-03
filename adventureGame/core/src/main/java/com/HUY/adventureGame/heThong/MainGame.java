package com.HUY.adventureGame.heThong;

import com.HUY.adventureGame.ManHinhChinh;
import com.badlogic.gdx.Game;


public class MainGame extends Game {
        public void create(){
            setScreen(new ManHinhChinh(this));
        }
}
