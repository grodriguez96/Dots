package com.dots.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dots.game.fichas.circulos.CirculoAmarillo;
import com.dots.game.fichas.circulos.CirculoAzul;
import com.dots.game.fichas.circulos.CirculoNaranja;
import com.dots.game.fichas.circulos.CirculoRojo;
import com.dots.game.fichas.circulos.CirculoVerde;
import com.dots.game.fichas.circulos.Circulos;
import com.dots.game.partidas.Partida;
import java.util.ArrayList;



public class Actualizar {

    public static int radio = (Dots.ALTO / Dots.ALTO) * 20;
    private Stage escenario;
    private Circulos[][] circulos;
    private Partida partida;
    private ArrayList<ShapeRenderer> lineas;
    private ArrayList<Float> posicion;
    private ShapeRenderer linea;
    private int x, y;

    /*Constructor*/
    public Actualizar(Stage escenario, Circulos[][] circulos, Partida PA) {
        this.circulos = circulos;
        this.escenario = escenario;
        this.partida = PA;
        this.lineas = new ArrayList<ShapeRenderer>();
        this.linea = new ShapeRenderer();
        this.posicion = new ArrayList<Float>();

    }


    /*Llena "circulos" con instancias de las clases "circulos"*/
/*Cada circulo de "circulos" se añade como un actor a "escenario"*/
    public void actualizarColores() {

        Tablero tablero = partida.getDots();//Aca tengo mi tablero 6x6 en "tablero"
        Casilla[][] casillas = tablero.getCasillas();
        limpiarEscenario();


        for (int i = 0; i < casillas.length; i++) {

            for (int j = 0; j < casillas[i].length; j++) {

                if (casillas[i][j].tomarvalor() == CirculoVerde.VLverde) {
                    circulos[i][j] = new CirculoVerde();
                    escenario.addActor(circulos[i][j]);
                    circulos[i][j].setHeight(radio);
                    circulos[i][j].setWidth(radio);


                } else if (casillas[i][j].tomarvalor() == CirculoAmarillo.VLamarillo) {
                    circulos[i][j] = new CirculoAmarillo();
                    escenario.addActor(circulos[i][j]);
                    circulos[i][j].setHeight(radio);
                    circulos[i][j].setWidth(radio);

                } else if (casillas[i][j].tomarvalor() == CirculoRojo.VLrojo) {
                    circulos[i][j] = new CirculoRojo();
                    escenario.addActor(circulos[i][j]);
                    circulos[i][j].setHeight(radio);
                    circulos[i][j].setWidth(radio);

                } else if (casillas[i][j].tomarvalor() == CirculoNaranja.VLnaranja) {
                    circulos[i][j] = new CirculoNaranja();
                    escenario.addActor(circulos[i][j]);
                    circulos[i][j].setHeight(radio);
                    circulos[i][j].setWidth(radio);

                } else if (casillas[i][j].tomarvalor() == CirculoAzul.VLazul) {
                    circulos[i][j] = new CirculoAzul();
                    escenario.addActor(circulos[i][j]);
                    circulos[i][j].setHeight(radio);
                    circulos[i][j].setWidth(radio);

                }

            }
        }
    }


    /*Le indico a cada "actor circulo" una posicion del stage*/
    public void actualizarPosicion() {

        int a = 0, b = 0;
        int y = Dots.ALTO / 4;
        int yy = ((y * 3) / 6) - radio;
        int x = Dots.ANCHO / 8;
        int xx = ((x * 7) / 6);

        for (int i = circulos.length - 1; i > -1; i--) {

            for (int j = circulos[i].length - 1; j > -1; j--) {

                //circulos[a][b].setPosition((j * 60) + 40, (i * 60) + 40);
                circulos[a][b].setPosition(x + (j * xx), y + (i * yy));

                b++;

            }
            a++;
            b = 0;
        }
    }


    public void pintarLineaPuntero(float x, float y, int x1, int y1) {

        linea.setProjectionMatrix(escenario.getCamera().combined);

        linea.begin(ShapeRenderer.ShapeType.Filled);
        linea.rectLine(x + (radio / 2), y + (radio / 2), Gdx.input.getX(), Dots.ALTO - Gdx.input.getY(), 5, colorLinea(x1, y1), colorLinea(x1, y1));
        linea.end();


    }

    public void pintarLineasGuias() {
        int f = 0;


        for (int i = 0; i < lineas.size(); i++) {
            lineas.get(i).setProjectionMatrix(escenario.getCamera().combined);

            lineas.get(i).begin(ShapeRenderer.ShapeType.Filled);
            lineas.get(i).rectLine((posicion.get(f) + (radio / 2)), ((posicion.get(f + 1) + (radio / 2))), (posicion.get(f + 2) + (radio / 2)), (posicion.get(f + 3) + (radio / 2)), 5, colorLinea(x, y), colorLinea(x, y));
            lineas.get(i).end();
            f += 4;
        }
    }



public boolean actualizarLinea(int jugada, float x, float y, float x2, float y2) {

        if (jugada == 1) {
            posicion.add(x);
            posicion.add(y);
            posicion.add(x2);
            posicion.add(y2);

            lineas.add(new ShapeRenderer());
            return true;
        } else if (jugada == 2) {
            for (int i = 0; i < 4; i++) {
                posicion.remove(posicion.size() - 1);
            }
            lineas.remove(lineas.size() - 1);

            return true;
        }
        return false;
    }



public void limpiarGuias() {
posicion.clear();
lineas.clear();
    }


/*Limpia las texturas pasadas del escenario*/
public void limpiarEscenario() {

        for (Actor actor : escenario.getActors()) {
            actor.addAction(Actions.removeActor());
        }
    }


/*Hace dispose a cada instancia de fichas ya creada*/
public void limpiarFichas(){

        for (int i = 0; i < circulos.length; i++) {

            for (int j = 0; j < circulos.length; j++) {

                circulos[i][j].dispose();

            }
        }
    }


    public void limpiarCirculos(){

        for (int i = 0; i < circulos.length; i++) {

            for (int j = 0; j < circulos.length; j++) {

                circulos[i][j].dispose();

            }
        }
    }


    public Color colorLinea(int i, int j){

        Color color = new Color();
        Tablero tablero = partida.getDots();
        Casilla[][] casillas = tablero.getCasillas();
        x =i;y=j;

        if (casillas[i][j].tomarvalor() == CirculoVerde.VLverde) {
            return color.set(Color.OLIVE);

        } else if (casillas[i][j].tomarvalor() == CirculoAmarillo.VLamarillo) {
            return color.set(Color.YELLOW);

        } else if (casillas[i][j].tomarvalor() == CirculoRojo.VLrojo) {
            return color.set(Color.RED);

        } else if (casillas[i][j].tomarvalor() == CirculoNaranja.VLnaranja) {
            return color.set(Color.ORANGE);

        } else if (casillas[i][j].tomarvalor() == CirculoAzul.VLazul) {
            return color.set(Color.NAVY);

        }


        return color.set(Color.BLACK);
    }
}
