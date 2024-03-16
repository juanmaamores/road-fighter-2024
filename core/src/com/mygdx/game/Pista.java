package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Pista extends ObjetoMovible{

    public Pista(Texture textura, int x, int y) {
        super(textura, x, y);
    }

    public void setRectanguloY(int value){
        this.getRectangulo().y = getRectangulo().y + value;
    }

}
