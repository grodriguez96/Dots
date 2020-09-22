package com.dots.game.pantallas;



import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.dots.game.Cronometro;
import com.dots.game.partidas.Partida;

public class PantallaResultado extends Pantalla {
BitmapFont font ;
private int marcador;

public PantallaResultado(GestorPantalla gdp,int marcador) {
super(gdp);
this.marcador=marcador;
font=new BitmapFont();

font.setColor(Color.BLACK);
 }


@Override
public void render(SpriteBatch batch){

    if (Gdx.input.justTouched())
        gdp.pop();

    batch.begin();

    font.draw(batch,"Tu Puntaje Fue : "+String.valueOf(marcador), 0, Gdx.graphics.getHeight());
  //  font.draw(batch,String.valueOf(marcador), 0, Gdx.graphics.getHeight());

    batch.end();

}

@Override
public void dispose() {

    font.dispose();

}

}

