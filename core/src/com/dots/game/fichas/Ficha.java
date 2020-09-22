package com.dots.game.fichas;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Ficha extends Actor {

protected Object valor;

/*Me devuelve el valor respectivo de cada ficha*/
public Object tomarvalor(){
return(valor);
    }


/*Aigna un valor de una ficha ya existente*/
public void cambiarvalor(Object c){
this.valor = c;
    }


/*Le asigna el nuevo "valor a la ficha*/
public abstract void crearficha(Object dato,boolean w);

}
