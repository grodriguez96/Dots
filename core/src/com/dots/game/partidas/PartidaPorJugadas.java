package com.dots.game.partidas;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.dots.game.Dots;
import com.dots.game.jugadas.JugadaEliminaUnDot;
import com.dots.game.jugadas.JugadaExplosion;
import com.dots.game.jugadas.JugadaLineal;
import com.dots.game.pantallas.PantallaPorJugadas;
import com.dots.game.pantallas.PantallaResultado;

import java.util.ArrayList;
import java.util.Scanner;


public class PartidaPorJugadas extends Partida {

private boolean bool = false;

/*Constructor*/
public PartidaPorJugadas(){
dots.llenartablero();
datos = new ArrayList<Integer>();

}


/*Crea mi camino o realiza la jugada*/
public  int Jugar(int a, int pos){


	;


					if ( (a==0)  &&  (movimientos>0) ){
						jugada = new JugadaLineal();
						int valido = jugada.crearcamino(dots,pos,datos);
                        bool=true;

						return valido;
					}

					if ( (a==1) &&  (movimientos>0) /*&& (bool==true) */){
						jugada = new JugadaLineal();
						marcador = jugada.realizarjugada(dots,marcador,datos);

						movimientos--;
						System.out.println("movi : "+movimientos);

						if(  (movimientos==0)  ){

							Dots.gdp.set(new PantallaResultado(Dots.gdp,marcador));

						}

						//bool=false;
						//jugada = new JugadaEliminaUnDot();

					}

					if ((a==2) && movimientos>0){
						jugada = new JugadaEliminaUnDot();
						datos.add(pos);
						marcador = jugada.realizarjugada(dots,marcador,datos);

						movimientos--;
						System.out.println("movi : "+movimientos);

						if(  (movimientos==0)  ){

							Dots.gdp.set(new PantallaResultado(Dots.gdp,marcador));

						}
					}



				
				
				
				return 0;
				
			}

}
