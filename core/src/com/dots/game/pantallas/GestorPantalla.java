package com.dots.game.pantallas;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;


public class GestorPantalla {
public Stack<Pantalla> pantallas;

/*Constructor*/
public GestorPantalla (){
 pantallas = new Stack<Pantalla>();
 }


/*Agrega un elemento al tope de la pila*/
public void push (Pantalla pantalla){
 pantallas.push(pantalla);
 }


/*Quita el elemento del tope de la pila*/
public void pop(){
 pantallas.pop().dispose();
 }


/*Quita el elemento del tope de la pila y agrega un nuevo elemento al tope*/
public void set (Pantalla pantalla){
pantallas.pop();
pantallas.push(pantalla);
 }



/**/
public void render (SpriteBatch batch){
//peek es un metodo de stack que me devuelve lo ultimo que entro(el tope)
pantallas.peek().render(batch);
 }






}
