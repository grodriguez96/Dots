package com.dots.game.fichas.circulos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;


public class CirculoRojo extends Circulos implements Disposable {

public static final Object VLrojo = 1;

/*Constructor*/
public CirculoRojo (){
textura = new Texture("rojo.png");
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
