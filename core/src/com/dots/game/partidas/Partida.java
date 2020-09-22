package com.dots.game.partidas;

import com.dots.game.Cronometro;
import com.dots.game.Tablero;
import com.dots.game.jugadas.Jugada;
import java.util.ArrayList;

public abstract class Partida extends Thread{

protected Tablero dots = new Tablero(6,6);
protected Jugada jugada;
protected ArrayList<Integer> datos;
protected  Cronometro cro;
protected int movimientos=5;
protected int tiempo = 30;
protected int marcador=0;

    public void setCro(Cronometro cro) {
        this.cro = cro;
    }

    public Cronometro getCro() {
        return cro;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**/
public abstract int Jugar(int a,int pos);


/*Retorna mi tablero*/
public Tablero getDots() {
return dots;
}

/**/
 public static void borrarcamino(ArrayList <Integer> datos){
        datos.clear();
    }

    public ArrayList<Integer> getCamino(){

        return datos;
    }


    public int getMovimientos() {
        return movimientos;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getMarcador() {
        return marcador;
    }
}
