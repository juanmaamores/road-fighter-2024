package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class RF24 extends Game {

	public SpriteBatch batch;
	public BitmapFont font1;

	@Override
	public void create () {

		batch = new SpriteBatch();
		font1 = new BitmapFont(); // Usa la tipografia por defecto de libgdx
		this.setScreen(new MenuPrincipal(this));

	}

	@Override
	public void render () {
		super.render();
	}



	@Override
	public void dispose () {
		batch.dispose();
		font1.dispose();
	}
}
