package com.dots.game.jugadas;

import com.dots.game.Tablero;

import java.util.ArrayList;

/**/
public abstract class Jugada {


/**/
public abstract int realizarjugada(Tablero dots, int marcador, ArrayList<Integer> datos);


/**/
public int crearcamino (Tablero dots, int pos,ArrayList<Integer> datos){return 0;}
}
