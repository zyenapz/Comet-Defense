package com.cometdefense.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cometdefense.game.CometDefenseApp;

import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_HEIGHT;
import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CometDefenseApp(), config);
		config.resizable = true;
		config.width = VIEWPORT_WIDTH * 2;
		config.height = VIEWPORT_HEIGHT * 2;
	}
}
