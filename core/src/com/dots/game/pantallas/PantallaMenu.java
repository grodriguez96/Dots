package com.dots.game.pantallas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dots.game.Dots;
import com.dots.game.ProcesadorEntrada;



public class PantallaMenu extends Pantalla  {

 private OrthographicCamera camera;
 private ShapeRenderer franja1;
 private ShapeRenderer franja2;
 private ShapeRenderer franja3;
 private ShapeRenderer circulo1;
 private ShapeRenderer circulo2;
 private ShapeRenderer circulo3;
 private ShapeRenderer circulo4;
 private Texture D;
 private Texture T;
 private Texture S;
 private Texture reloj;
 private Texture infinito;
 private Texture movimiento;


 /*Constructor*/
public PantallaMenu(GestorPantalla gdp) {
super(gdp);

 font=new BitmapFont();
 font.setColor(Color.BLACK);
 franja1 = new ShapeRenderer();
 franja2 = new ShapeRenderer();
 franja3 = new ShapeRenderer();
 circulo1 = new ShapeRenderer();
 circulo2 = new ShapeRenderer();
 circulo3 = new ShapeRenderer();
 circulo4 = new ShapeRenderer();
 D = new Texture("D.png");
 T = new Texture("T.png");
 S = new Texture("S.png");
 reloj = new Texture("tiempo.png");
 infinito = new Texture("infinito.png");
 movimiento = new Texture("movimiento.png");

 camera = new OrthographicCamera();
 camera.setToOrtho(false,Dots.ANCHO,Dots.ALTO);
 camera.position.set(Dots.ANCHO/2,Dots.ALTO/2,0);



}


@Override
public void render(SpriteBatch batch) {
/*

        if (Gdx.input.justTouched())
            gdp.push(new PantallaPorTiempo(gdp));

*/

    camera.update();




    franja1.setProjectionMatrix(camera.combined);
    franja2.setProjectionMatrix(camera.combined);
    franja3.setProjectionMatrix(camera.combined);
    circulo1.setProjectionMatrix(camera.combined);
    circulo2.setProjectionMatrix(camera.combined);
    circulo3.setProjectionMatrix(camera.combined);
    circulo4.setProjectionMatrix(camera.combined);
    batch.setProjectionMatrix(camera.combined);





    franja1.begin(ShapeRenderer.ShapeType.Filled);
    franja1.rectLine(0,Dots.ALTO/6,Dots.ANCHO,Dots.ALTO/6,Dots.ALTO/2.9f,Color.TEAL,Color.LIME);
    franja1.end();


    franja2.begin(ShapeRenderer.ShapeType.Filled);
    franja2.rectLine(0,(Dots.ALTO/6)*5,Dots.ANCHO,(Dots.ALTO/6)*5,Dots.ALTO/2.9f,Color.DARK_GRAY,Color.GRAY);
    franja2.end();

    franja3.begin(ShapeRenderer.ShapeType.Filled);
    franja3.rectLine(0,(Dots.ALTO/6)*3,Dots.ANCHO,(Dots.ALTO/6)*3,Dots.ALTO/2.9f,Color.PURPLE,Color.PINK);
    franja3.end();

    circulo1.begin(ShapeRenderer.ShapeType.Filled);
    circulo1.circle(Dots.ANCHO-550,Dots.ALTO-25,7);
    circulo1.setColor(Color.BLUE);
    circulo1.end();

    circulo2.begin(ShapeRenderer.ShapeType.Filled);
    circulo2.circle(Dots.ANCHO-530,Dots.ALTO-25,7);
    circulo2.setColor(Color.RED);
    circulo2.end();


    circulo3.begin(ShapeRenderer.ShapeType.Filled);
    circulo3.circle(Dots.ANCHO-550,Dots.ALTO-45,7);
    circulo3.setColor(Color.MAGENTA);
    circulo3.end();

    circulo4.begin(ShapeRenderer.ShapeType.Filled);
    circulo4.circle(Dots.ANCHO-530,Dots.ALTO-45,7);
    circulo4.setColor(Color.OLIVE);
    circulo4.end();






 batch.begin();



 batch.draw(D,Dots.ANCHO-595,Dots.ALTO-50,32,32);
 batch.draw(T,Dots.ANCHO-520,Dots.ALTO-50,32,32);
 batch.draw(S,Dots.ANCHO-485,Dots.ALTO-50,32,32);
 batch.draw(reloj,Dots.ANCHO-150,Dots.ALTO-160,32,32);
 batch.draw(infinito,Dots.ANCHO-150,Dots.ALTO-600,32,32);
 batch.draw(movimiento,Dots.ANCHO-150,Dots.ALTO-385,32,32);
 font.draw(batch,"Partida Por Tiempo",Dots.ANCHO-200,Dots.ALTO-100);
 font.draw(batch,"Partida Por Movimientos",Dots.ANCHO-210,Dots.ALTO-330);
 font.draw(batch,"Partida Infinita",Dots.ANCHO-180,Dots.ALTO-550);
 //font.draw(batch,"Derechos reservados",Dots.ANCHO-595,Dots.ALTO-60);
 font.draw(batch,"Gabriel Rodriguez",Dots.ANCHO-595,Dots.ALTO-680);
 font.draw(batch,"Greg Gomez",Dots.ANCHO-595,Dots.ALTO-660);


 ProcesadorEntrada.entrada2();

 batch.end();


}


@Override
 public void dispose() {
 S.dispose();
 T.dispose();
 D.dispose();
 reloj.dispose();
 infinito.dispose();
 font.dispose();
gdp.pop();

 }


}
