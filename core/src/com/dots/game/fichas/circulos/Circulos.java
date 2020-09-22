package com.dots.game.fichas.circulos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.dots.game.fichas.Ficha;

import java.util.Random;

public class Circulos extends Ficha implements Disposable{

    protected Texture textura;



@Override
public void crearficha (Object dato,boolean w){
Random ran = new Random();
        if(w){
            while(1==1){
                Object x = ran.nextInt(5);
                if(dato!=x){
                    this.valor=x;
                    break;
                }


            }


        }
        else{
            int x = ran.nextInt(5);
            this.valor=x;}

    }


@Override
public void dispose() {
        textura.dispose();
    }

}
