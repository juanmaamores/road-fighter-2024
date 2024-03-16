package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.Rectangle;

public abstract class ObjetoMovible extends ObjetoGrafico{

    private float velocidad = 0;
    private Rectangle rectangulo;

    public ObjetoMovible(Texture textura, int x, int y) {
        super(textura, x, y);
    }

}
