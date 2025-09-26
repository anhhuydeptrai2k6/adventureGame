package com.HUY.adventureGame;

import com.badlogic.gdx.Game;


public class MainGame extends Game {
        public void create(){
            setScreen(new ManHinhChinh(this));
        }
}
