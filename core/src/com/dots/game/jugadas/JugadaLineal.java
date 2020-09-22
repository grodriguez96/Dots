package com.dots.game.jugadas;

import com.dots.game.Casilla;
import com.dots.game.Tablero;

import java.util.ArrayList;

public class JugadaLineal extends Jugada{
	
/**/
public int realizarjugada(Tablero dots, int marcador, ArrayList<Integer> datos){
boolean w=false;
       
   	    /*Aqui ya tengo que mis casillas son efectivamente una secuencia*/
		if ( datos.size() > 1){

			boolean bu= Casilla.validarpoligono(datos);

			if(bu){

             	  dots.llenarexplosion(datos);
               	  w=true;
	        }
                  
	    	int puntuacion=dots.aplicargravedad(datos,w);
	    		                      
	    		               
	    	System.out.println("Tu puntuacion fue : "+puntuacion);
	    	marcador+=puntuacion;
	    	System.out.println("Tu puntuacion es : " +marcador);
	    			         
		}//Fin if "Empieza el juego"
	    	   
	    return marcador;	   
	}


/*Debo pasar el crear camino para aca*/
public int crearcamino(Tablero dots, int pos,ArrayList<Integer> datos){

int valido = dots.crearcamino(datos,pos);
return valido;

	}
}
