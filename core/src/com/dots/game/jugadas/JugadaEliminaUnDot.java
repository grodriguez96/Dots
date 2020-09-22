package com.dots.game.jugadas;

import com.dots.game.Tablero;

import java.util.ArrayList;
import java.util.Scanner;

public class JugadaEliminaUnDot extends Jugada {

/**/
public int realizarjugada(Tablero dots, int marcador,ArrayList<Integer> datos){
boolean w=false;

int puntuacion=dots.aplicargravedad(datos,w);
System.out.println("Tu puntuacion fue : "+puntuacion);
marcador+=puntuacion;
System.out.println("Tu puntuacion es : " +marcador);

return marcador;

	}

}
