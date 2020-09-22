package com.dots.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dots.game.fichas.circulos.Circulos;
import com.dots.game.partidas.Partida;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Animaciones {

    private Circulos[][] circulos;
    private ArrayList<Integer> datos;
    private Stage escenario;
    private Partida partida;
    private boolean repetido;


    public Animaciones(Circulos[][] circulos, ArrayList<Integer> datos, Stage escenario, Partida PA) {
        this.circulos = circulos;
        this.datos = datos;
        this.escenario = escenario;
        this.partida = PA;
    }


    public void bajarficha() {

        if (datos.size() > 1) {


            final Comparator<Integer> comparador = Collections.reverseOrder();
            Collections.sort(datos, comparador);


            int a, b, l;


            for (l = 0; l < datos.size(); l++) {

                a = datos.get(l) / 10;
                b = datos.get(l) % 10;

                circulos[a][b].addAction(Actions.hide());
            }



            for (l = 0; l < datos.size(); l++) {


                a = datos.get(l) / 10;
                b = datos.get(l) % 10;


                for (int t = a; t > -1; t--) {

                    if ((t - 1) > -1) {
                        repetido = true;




                        final int finalL = l;


                        circulos[t - 1][b].addAction(Actions.sequence(
                                Actions.moveTo(circulos[t][b].getX(), circulos[t][b].getY(), 0.5f),


                                Actions.after(Actions.run(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (finalL + 1 == datos.size()) {
                                            Partida.borrarcamino(datos);
                                            Actualizar actualizar = new Actualizar(escenario, circulos, partida);
                                            actualizar.limpiarCirculos();
                                            actualizar.limpiarFichas();
                                            actualizar.actualizarColores();
                                            actualizar.actualizarPosicion();
                                        }
                                    }
                                }))

                        ));
                    } else if ( t == 0 && !repetido ){

                        final int finalL = l;

                        circulos[t][b].addAction(Actions.after(Actions.run(new Runnable() {
                            @Override
                            public void run() {

                                if (finalL + 1 == datos.size()) {
                                    Partida.borrarcamino(datos);
                                    Actualizar actualizar = new Actualizar(escenario, circulos, partida);
                                    actualizar.limpiarCirculos();
                                    actualizar.actualizarColores();
                                    actualizar.actualizarPosicion();


                                }
                            }
                        })));
                    }else if ( repetido ){

                        final int finalL = l;

                        circulos[t][b].addAction(Actions.after(Actions.run(new Runnable() {
                            @Override
                            public void run() {

                                if (finalL + 1 == datos.size()) {
                                    Partida.borrarcamino(datos);
                                    Actualizar actualizar = new Actualizar(escenario, circulos, partida);
                                    actualizar.limpiarCirculos();
                                    actualizar.actualizarColores();
                                    actualizar.actualizarPosicion();


                                }
                            }
                        })));
                    }

                } //Fin for matriz
            }
        }
    }
}
