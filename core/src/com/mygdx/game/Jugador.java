package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Jugador extends Vehiculo{
    private int posicionX, posicionY;
    public Jugador(Texture textura, int x, int y) {
        super(textura, x, y);
        posicionX = x;
        posicionY = y;
    }

    public void setRectanguloX(int value){
        this.getRectangulo().x = getRectangulo().x + value;
    }
}
