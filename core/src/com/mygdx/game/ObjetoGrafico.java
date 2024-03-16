package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import java.awt.Rectangle;

public abstract class ObjetoGrafico {
    private int posicionX, posicionY;
    private Texture textura;
    private Rectangle rectangulo;

    public ObjetoGrafico(Texture textura, int x, int y){
        this.textura = textura;
        posicionX = x;
        posicionY = y;
        rectangulo = new Rectangle(x,y,textura.getWidth(),textura.getHeight());
    }
    public Rectangle getRectangulo(){
        return rectangulo;
    }

}
