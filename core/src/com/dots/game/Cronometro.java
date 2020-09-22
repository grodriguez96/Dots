package com.dots.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.dots.game.pantallas.PantallaResultado;
import com.dots.game.partidas.PartidaPorTiempo;

import static com.dots.game.Dots.gdp;


public class Cronometro extends Thread{
private  PartidaPorTiempo partida;
private  boolean bu=false;

/*Constructor*/

	public void setBu(boolean bu) {
		this.bu = bu;
	}

	public Cronometro(PartidaPorTiempo t){
this.partida=t;


}


/*Ejecucion del hilo cronometro*/
public void run(){
		for(int i=100;i>0;i--){
		this.partida.setTiempo(partida.getTiempo()-1);

			System.out.println("tiempo  :  "+partida.getTiempo());

			if(this.partida.getTiempo()==0){
				//Dots.gdp.pop();

                 //Dots.gdp.set(new PantallaResultado(Dots.gdp,t.marcador));/instanciar aca da error/
				break;

			}


			if(bu) {
				break;
			}


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}


		}//End for

	}


	public PartidaPorTiempo getPartida() {
		return partida;
	}
}
