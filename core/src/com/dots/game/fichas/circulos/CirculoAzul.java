package com.dots.game.fichas.circulos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;

public class CirculoAzul extends Circulos implements Disposable {

public static final Object VLazul = 4;

/*Constructor*/
 public CirculoAzul (){
textura = new Texture("azul.png");
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
