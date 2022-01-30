package com.cometdefense.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cometdefense.game.CometDefenseApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CometDefenseApp(), config);
		config.resizable = true;
		config.width = 800;
		config.height = 600;
	}
}
