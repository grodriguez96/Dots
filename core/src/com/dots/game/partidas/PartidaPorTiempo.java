package com.dots.game.partidas;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.dots.game.Cronometro;
import com.dots.game.Dots;
import com.dots.game.jugadas.JugadaEliminaUnDot;
import com.dots.game.jugadas.JugadaExplosion;
import com.dots.game.jugadas.JugadaLineal;
import com.dots.game.pantallas.PantallaPorTiempo;
import com.dots.game.pantallas.PantallaResultado;

import java.util.ArrayList;
import java.util.Scanner;

public class PartidaPorTiempo extends Partida {

/*Constructor*/
public PartidaPorTiempo(){
dots.llenartablero();
datos = new ArrayList<Integer>();
cro = new Cronometro(this);
cro.start();

	}



/*Crea mi camino o realiza la jugada*/
public int Jugar(int a,int pos) {



	if ((a==0) && (tiempo>0)){
		jugada = new JugadaLineal();
		int valido = jugada.crearcamino(dots,pos,datos);
		return valido;
	}

	if ( (a==1) && (tiempo>0) ){
		jugada = new JugadaLineal();
		marcador = jugada.realizarjugada(dots,marcador,datos);
	}



  return 0;
}

}
