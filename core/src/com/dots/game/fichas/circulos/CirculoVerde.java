package com.dots.game.fichas.circulos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;


public class CirculoVerde extends Circulos implements Disposable {

public static final Object VLverde = 0;


/*Constructor*/
public CirculoVerde (){
textura = new Texture("verde.png");
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
