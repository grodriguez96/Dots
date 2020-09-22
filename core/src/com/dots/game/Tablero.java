package com.dots.game;

import com.dots.game.partidas.Partida;

import java.util.ArrayList;
public class Tablero {

private Casilla[][] casillas;  

/*Instanciacion del tablero*/
public Tablero(int x , int y){
this.casillas = new Casilla[x][y];
}


/*Llena el tablero con el tipo de ficha que le asigne*/
public void llenartablero(){
int k=0;

	 for(int i=0 ; i<casillas.length; i++ ){

	    	 for(int j=0 ; j<casillas[i].length ; j++ ){
	      		 casillas[i][j]=new Casilla(k);
                            }

	     }

}


/*Va creando y validando el camino*/
public int crearcamino(ArrayList<Integer> datos,int pos){

		if (datos.isEmpty()){
			datos.add(pos);
			//mostrarcamino(datos);
			return 0;

		}else {

			datos.add(pos);

			if(repetidos(datos)){
				datos.remove(datos.size() - 1);
				//mostrarcamino(datos);
				return 0;

		}else {

				if(eliminar(datos)){

					datos.remove(datos.size() - 1);
					datos.remove(datos.size() - 1);

					if (datos.size() == 1) {
						datos.clear();
					}
					//mostrarcamino(datos);
					return 2;

				}else


				if (datos.size() > 1) {

					if (!Casilla.posicionesadyacentes(datos) || !fichasconsecutivas(casillas, datos)) {

						datos.remove(datos.size()-1);
						//mostrarcamino(datos);
						return 0;
					}
				}

			}

			//mostrarcamino(datos);
		}

	if (datos.size() == 1){
		Partida.borrarcamino(datos);
		return 0;
	}

return 1;
	}


/*Imprime la matriz*//*No se esta usando en la parte grafica*/
public String toString(){
String c ="";

		 for(int i=0 ; i<casillas.length ; i++ ){

    	     for(int j=0 ; j<casillas[i].length ; j++ ){
    		 c =c + ( "[" +casillas[i][j].tomarvalor() +"]" );
    	    		  }
    	     c=c+"\n";
      }
return c;

	}


/*Verifica que la todas las fichas tengan la misma "figura" asociada*/
public static boolean fichasconsecutivas(Casilla casillas[][],ArrayList<Integer> datos){

Object valor2=casillas[datos.get(datos.size()-1)/10][datos.get(datos.size()-1)%10].tomarvalor();
Object valor1=casillas[datos.get(datos.size()-2)/10][datos.get(datos.size()-2)%10].tomarvalor();

	   	    	        if(valor1!=valor2){
	    			       return (false);
                 	      }

return (true);

}


/**/
public boolean eliminar(ArrayList<Integer> datos){


if (datos.size()>2) {
	if (datos.get(datos.size() - 1) == datos.get(datos.size() - 3)) {
		return true;
	}
}
		return false;
}


/**/
public static boolean repetidos (ArrayList<Integer> datos){

		if (datos.get(datos.size()-1) == datos.get(datos.size()-2)){
			return true;
		}

		return false;
	}


/*Me muestra el vector que contiene al camino (opcional) */
public static void mostrarcamino(ArrayList<Integer> datos){

	for(int i=0;i<datos.size();i++){
		System.out.print("["+datos.get(i)+"]->");
	}
	System.out.println("");

}


/*Llena el vector con todos los elementos a eliminar*/
public void llenarexplosion(ArrayList<Integer> datos){
int a=datos.get(0)/10;
int	b=datos.get(0)%10;
datos.clear();
Object valor=casillas[a][b].tomarvalor();

for(int i=0 ; i<casillas.length; i++ ){

	 for(int j=0 ; j<casillas[i].length ; j++ ){
 		   if(casillas[i][j].tomarvalor()==valor) {
 			   int t=(i*10)+j;
 			  datos.add(t);
 		   }

        }

}

Casilla.ordenardatos(datos);
}


/*Aplica la gravedad xd*/
public int aplicargravedad(ArrayList<Integer> datos,boolean w){
int a,b,puntuacion=0;
Object dato=casillas[datos.get(0)/10][datos.get(0)%10].tomarvalor();

    for(int l=0;l<datos.size();l++){

        if (datos.get(l)>100){ break; }

        a=datos.get(l)/10;
        b=datos.get(l)%10;
        puntuacion++;

           for(int t=a;t>-1;t--){

          	    if( (t-1)>-1 ){
                     casillas[t][b].bajarficha(  casillas[t-1][b].tomarvalor()  );
	                   }

	                else{

		                 casillas[t][b].asignarnuevovalor(dato,w);
	                 }





           }//Fin for matriz


    }//Fin for que recorre "datos"
    return puntuacion;
}


/*Retorna mis casillas*/
public Casilla[][] getCasillas() {
return casillas;
}





}
