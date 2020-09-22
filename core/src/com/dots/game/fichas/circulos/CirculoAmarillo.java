package com.dots.game.fichas.circulos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;


public class CirculoAmarillo extends Circulos implements Disposable {

public static final Object VLamarillo = 2;

/*Constructor*/
public CirculoAmarillo (){
textura = new Texture("amarillo.png");
    }


@Override
public void act(float delta) {
super.act(delta);
    }


@Override
 public void draw(Batch batch, float parentAlpha) {
batch.draw(textura,getX(),getY(),getWidth(),getHeight());

    }


@Override
public void dispose() {
textura.dispose();
    }
}
