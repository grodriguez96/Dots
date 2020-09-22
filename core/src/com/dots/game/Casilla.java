package com.dots.game;

import com.dots.game.fichas.Ficha;
import com.dots.game.fichas.circulos.Circulos;

import java.util.ArrayList;
import java.util.Collections;

public class Casilla {
private Ficha ficha;

/*Dependendo del valor que reciba este constructor variara la instanciacion del tipo de ficha*/
Casilla(int p){
boolean w=false;

	if (p==0){
      this.ficha=new Circulos();
      this.ficha.crearficha(0,w);

     }

/*	if(p==1){
		this.ficha=new FichaLetra();
	    this.ficha.crearficha(0,w);
	}
	*/
}


/*Me devuelve el valor respectivo de cada ficha*/
public Object tomarvalor(){
return (ficha.tomarvalor());
}


/*Asigno un nuevo valor a una ficha(Ramdon)*/
public void asignarnuevovalor(Object dato,boolean w){
this.ficha.crearficha(dato,w);
}


/*Aigna un valor de una ficha ya existente*/
public void bajarficha(Object c){
this.ficha.cambiarvalor(c);
}


/*Ordena el vector "datos" de menor a mayor*/
public static void ordenardatos(ArrayList<Integer> datos){

	Collections.sort(datos);

}


/*verifica que efectivamente las posiciones proporcionadas son consecutivas*/
public static boolean posicionesadyacentes(ArrayList<Integer> datos){

int x=datos.get(datos.size()-1)/10;
int y=datos.get(datos.size()-1)%10;
int px=datos.get(datos.size()-2)/10;
int py=datos.get(datos.size()-2)%10;

	if ((px!=x) && (py!=y)){
		return false;
	}else

	if(( x < px-1 ) || (x > px+1) || (y > py+1) || (y < py-1)){
		return false;
	}




return true;
}


/*Valida si efectivamente existe una posicion que ya es adyacente en "datos"*/
public static boolean validarpoligono(ArrayList<Integer> datos){

ordenardatos(datos);



		          for (int j=0 ; j<datos.size()-1; j++){

		                   if (datos.get(j) == datos.get(j+1)){
		            	         datos.set(j,500);
		            	         ordenardatos(datos);
		                         return true;
		                    }
		          }




return false;
}


}
