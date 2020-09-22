package com.dots.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.dots.game.pantallas.GestorPantalla;
import com.dots.game.pantallas.PantallaInfinito;
import com.dots.game.pantallas.PantallaMenu;
import com.dots.game.pantallas.PantallaPorJugadas;
import com.dots.game.pantallas.PantallaPorTiempo;


public class Dots extends ApplicationAdapter {


public static final int ANCHO = 600;
public static final int ALTO = 700;
public static final String TITULO = "DOTS";
public static GestorPantalla gdp;
public static SpriteBatch batch;

@Override
public void create () {
batch = new SpriteBatch();
gdp = new GestorPantalla();
	//Gdx.gl.glClearColor(0f, 0f, 0f, 1);
	Gdx.gl.glClearColor(1, 1, 1, 1);
PantallaMenu pm = (new PantallaMenu(gdp));
gdp.push(pm);

	}


@Override
public void render () {
Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
gdp.render(batch);
}


@Override
public void dispose () {
batch.dispose();
	}


	@Override
	public void resize(int width, int height) {

		if ((PantallaInfinito.getActivo() == 1))
		PantallaInfinito.resize(width, height);

		if (PantallaPorJugadas.getActivo() == 1)
			PantallaPorJugadas.resize(width, height);

		if (PantallaPorTiempo.getActivo() == 1)
			PantallaPorTiempo.resize(width, height);
	}
}
