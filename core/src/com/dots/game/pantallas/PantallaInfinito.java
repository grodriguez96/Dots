package com.dots.game.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.*;
import com.dots.game.Actualizar;
import com.dots.game.Dots;
import com.dots.game.ProcesadorEntrada;
import com.dots.game.fichas.circulos.Circulos;
import com.dots.game.partidas.PartidaInfinita;


public class PantallaInfinito extends Pantalla {

    static int activo = 0;
    BitmapFont font = new BitmapFont();

/*Constructor*/
public PantallaInfinito(GestorPantalla gdp) {
super(gdp);
    font = new BitmapFont();
    font.setColor(Color.BLACK);
    fondo = new ShapeRenderer();
inicio();

    }


/*Instancio los elementos necesarios para jugar y pinto la pantalla*/
private void inicio(){

partida = new PartidaInfinita();

    escenario = new Stage(new StretchViewport(Dots.ANCHO,Dots.ALTO));


circulos = new Circulos[6][6];
Actualizar actualizar = new Actualizar(escenario,circulos,partida);
procesador = new ProcesadorEntrada(escenario,circulos,partida);
actualizar.actualizarColores();
actualizar.actualizarPosicion();
    activo =1;


}


@Override
public void render(SpriteBatch batch) {

    escenario.getCamera().update();



    fondo.setProjectionMatrix(escenario.getCamera().combined);
    batch.setProjectionMatrix(escenario.getCamera().combined);

    fondo.begin(ShapeRenderer.ShapeType.Filled);
    fondo.rectLine(0,0,Dots.ANCHO,Dots.ALTO,Dots.ALTO*Dots.ANCHO,Color.TEAL,Color.LIME);
    fondo.end();


escenario.act();
procesador.entrada();
escenario.draw();

batch.begin();


    font.draw(batch,"Puntaje : "+String.valueOf(partida.getMarcador()), 10 , Dots.ALTO-50);


batch.end();
    }


@Override
 public void dispose() {

        escenario.dispose();
    font.dispose();

    }

public static void resize(int width, int height){
    escenario.getViewport().update(width,height);
}

    public static int getActivo(){
        return activo;
    }
}
