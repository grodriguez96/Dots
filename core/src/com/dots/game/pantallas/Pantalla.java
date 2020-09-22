package com.dots.game.pantallas;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dots.game.Dots;
import com.dots.game.ProcesadorEntrada;
import com.dots.game.fichas.circulos.Circulos;
import com.dots.game.partidas.Partida;

public abstract class Pantalla  {

    protected Circulos[][] circulos;
    protected ProcesadorEntrada procesador;
    protected Partida partida;
    protected BitmapFont font;
    public static Stage escenario;
    protected ShapeRenderer fondo;


protected GestorPantalla gdp;

    protected Pantalla(GestorPantalla gdp){
    this.gdp = gdp;

 }


/**/
public abstract void render (SpriteBatch batch);


/**/
public abstract void dispose();


}
