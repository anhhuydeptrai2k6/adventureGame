package com.HUY.adventureGame.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.HUY.adventureGame.MainGame;

public class Lwjgl3Launcher {
    public static void main(String[] args) {
        createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new MainGame(), taoCauHinh());
    }

    private static Lwjgl3ApplicationConfiguration taoCauHinh() {
        Lwjgl3ApplicationConfiguration huyGame = new Lwjgl3ApplicationConfiguration();
        huyGame.setTitle("Game adventure"); //đặt tên game
        huyGame.setWindowedMode(1020, 610);// set cửa sổ game
        huyGame.setResizable(false); // không cho kéo dan cửa sổ
        huyGame.setMaximized(false);//không phóng to toàn màn hình
        huyGame.useVsync(true);
        huyGame.setWindowIcon("iconAdventure.png");
        return huyGame;
    }
}
