package com.dots.game.partidas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.dots.game.jugadas.JugadaEliminaUnDot;
import com.dots.game.jugadas.JugadaExplosion;
import com.dots.game.jugadas.JugadaLineal;
import com.dots.game.pantallas.PantallaPorJugadas;
import java.util.ArrayList;
import java.util.Scanner;

public class PartidaInfinita extends Partida {



/*Constructor*/
public PartidaInfinita(){
dots.llenartablero();
datos = new ArrayList<Integer>();

}


/*Crea mi camino o realiza la jugada*/
public int Jugar(int a,int pos){




			if (a==0){
				jugada = new JugadaLineal();
				int valido = jugada.crearcamino(dots,pos,datos);
				return valido;
			}

			if (a==1){
				jugada = new JugadaLineal();
				marcador = jugada.realizarjugada(dots,marcador,datos);
			}

	return 0;
	}





}


