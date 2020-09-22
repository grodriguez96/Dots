package com.dots.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dots.game.Dots;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = Gdx.graphics.getWidth();
		config.width = Dots.ANCHO;

		//config.height= Gdx.graphics.getHeight();
		config.height = Dots.ALTO;

		config.title = Dots.TITULO;
		new LwjglApplication(new Dots(), config);
	}
}
