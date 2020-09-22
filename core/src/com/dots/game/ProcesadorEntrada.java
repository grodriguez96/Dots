package com.dots.game;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputAdapter;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dots.game.fichas.circulos.Circulos;
import com.dots.game.pantallas.PantallaInfinito;
import com.dots.game.pantallas.PantallaPorTiempo;
import com.dots.game.pantallas.PantallaResultado;
import com.dots.game.pantallas.PantallaPorJugadas;
import com.dots.game.partidas.Partida;
import com.badlogic.gdx.Input.Keys;

import java.util.ArrayList;

import static com.dots.game.Dots.gdp;

public class ProcesadorEntrada {
  //  public static final int BACK;
  private Stage escenario;
  private Circulos[][] circulos;
  private Partida partida;
  private boolean [] repetidores;
  private Actualizar actualizar;
  private ArrayList<Float> datosGraf;
  private ArrayList<Integer> datosAux;


/*Constructor*/
public ProcesadorEntrada(Stage escenario, Circulos[][] circulos, Partida PA) {

    this.circulos = circulos;
    this.escenario = escenario;
    this.partida = PA;
    this.datosGraf = new ArrayList<Float>();//posiciones de las lineas anteriores
    this.actualizar = new Actualizar(escenario,circulos,PA);
    this.repetidores = new boolean[2];
    this.datosAux = new ArrayList<Integer>();


Gdx.input.setInputProcessor(escenario);

    }


/*Procesa las entradas que el usuario realiza*/
public void entrada() {

    repetidores[0] = false;

       /*Para la tecla "back" del dispositivo android*/
    if (Gdx.input.isKeyPressed(Keys.MEDIA_PREVIOUS) && (!repetidores[1])) {
        if (partida.getCro() != null) {
            partida.getCro().setBu(true);
        }

        gdp.pop();
        repetidores[1] = true;
    }
       /*Para la tecla "F1" del teclado del computador*/
    if (Gdx.input.isKeyPressed(Keys.F1) && (!repetidores[1])) {

        if (partida.getCro() != null) {
            partida.getCro().setBu(true);
        }

        gdp.pop();
        repetidores[1] = true;
    }

    if (partida.getCro() != null) {
        if (partida.getCro().getPartida().getTiempo() == 0) {
            Dots.gdp.set(new PantallaResultado(Dots.gdp, partida.getMarcador()));
        }
    }




    for (int i = 0; i < circulos.length; i++) {
        for (int j = 0; j < circulos[i].length; j++) {

            final int finalI = i;
            final int finalJ = j;


            circulos[i][j].addCaptureListener(new InputListener() {


                /*Agregar tres actores mas que seran los bonos*/
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                    int pos = (finalI * 10) + finalJ;
                    partida.Jugar(0, pos);/*Crear camino*/


                    if (!repetidores[1]) {
                        datosGraf.add(circulos[finalI][finalJ].getX());
                        datosGraf.add(circulos[finalI][finalJ].getY());
                        datosAux.add(finalI);
                        datosAux.add(finalJ);
                        repetidores[1] = true;


                    }


                    for (int f = 0; f < circulos.length; f++) {

                        for (int g = 0; g < circulos[f].length; g++) {

                            final int finalF = f;
                            final int finalG = g;

                            circulos[f][g].addCaptureListener(new InputListener() {



                                @Override
                                public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {

                                    int pos = (finalF * 10) + finalG;
                                    int jugada = partida.Jugar(0, pos);

                                    boolean validar = actualizar.actualizarLinea(jugada, datosGraf.get(datosGraf.size() - 2), datosGraf.get(datosGraf.size() - 1), circulos[finalF][finalG].getX(), circulos[finalF][finalG].getY());

                                    if (validar) {
                                        if (jugada == 1) {
                                            datosGraf.add(circulos[finalF][finalG].getX());
                                            datosGraf.add(circulos[finalF][finalG].getY());
                                        } else if (jugada == 2) {

                                            datosGraf.remove(datosGraf.size() - 1);
                                            datosGraf.remove(datosGraf.size() - 1);
                                        }
                                    }

                                }
                            });
                        }
                    }

                    return true;
                }


                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    for (int f = 0; f < circulos.length; f++) {
                        for (int g = 0; g < circulos[f].length; g++) {

                            circulos[f][g].clearListeners();
                        }
                    }
                    if (partida.getCamino().size() > 1) {


                        if (!repetidores[0]) {
                            partida.Jugar(1, 0);
                            Animaciones animaciones = new Animaciones(circulos, partida.getCamino(), escenario, partida);
                            animaciones.bajarficha();
                            actualizar.limpiarGuias();
                            repetidores[0] = true;
                            repetidores[1] = false;
                            datosAux.clear();
                        }
                    } else {
                        Partida.borrarcamino(partida.getCamino());
                        datosAux.clear();
                        repetidores[0] = true;
                        repetidores[1] = false;
                    }

                }

                ;


            });
        }

        if (Gdx.input.isTouched() && repetidores[1]) {
            actualizar.pintarLineaPuntero(datosGraf.get(datosGraf.size() - 2), datosGraf.get(datosGraf.size() - 1), datosAux.get(0), datosAux.get(1));


        }

        actualizar.pintarLineasGuias();


    }
}



public static void entrada2() {

   final int d=Dots.ALTO/3;
    Gdx.input.setInputProcessor(new InputAdapter () {

        public boolean touchDown (int x, int y, int pointer, int button) {
            System.out.println("tocaste en x : "+x);
            System.out.println("tocaste en y : "+y);

            if (  (y<d) ){
                gdp.push(new PantallaPorTiempo(gdp));
            }

            if (  (y>d)  && (y<d*2) ){
                gdp.push(new PantallaPorJugadas(gdp));
            }

            if (  (y>d*2)   ){
                gdp.push(new PantallaInfinito(gdp));
            }

            return true; // return true to indicate the event was handled
        }


    });


}/*

    public void entradaC(Actor eliminarDots){

        eliminarDots.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                System.out.println("entre");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("sali");

                for (int i = 0; i < circulos.length; i++) {
                    for (int j = 0; j < circulos[i].length; j++) {

                        final int finalI = i;
                        final int finalJ = j;


                        circulos[i][j].addCaptureListener(new InputListener() {

                            @Override
                            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                return true;
                            }

                            @Override
                            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                                int pos = (finalI * 10) + finalJ;
                                PA.Jugar(2, pos);
                                Animaciones animaciones = new Animaciones(circulos, PA.getCamino(), escenario, PA);
                                animaciones.bajarficha();
                            }
                        });
                    }

                }


            }
        });
    }

*/


}
