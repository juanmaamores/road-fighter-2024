package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

	private SpriteBatch batch;
	private Jugador jugador;
	private Texture texturaJugador, texturaPista;
	private Pista pista;

	@Override
	public void create () {

		//Obtener el ancho y alto de la pantalla dinamicamente
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		int screenWidthCenter = screenWidth/2;
		int screenHeightCenter = screenHeight/2;

		batch = new SpriteBatch();

		//obtener texturas del disco
		texturaJugador = new Texture(Gdx.files.internal("assets/jugadorNorte.png"));
		texturaPista = new Texture(Gdx.files.internal("assets/pista.png"));

		jugador = new Jugador(texturaJugador, screenWidthCenter - (texturaJugador.getWidth()/2),0);
		pista = new Pista(texturaPista, screenWidthCenter - (texturaPista.getWidth()/2) ,0);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(texturaPista,pista.getRectangulo().x, pista.getRectangulo().y);
		batch.draw(texturaJugador,jugador.getRectangulo().x, jugador.getRectangulo().y);
		batch.end();
		handleInput();
	}

	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			jugador.setRectanguloX(-1);// Mover jugador hacia la izquierda
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			jugador.setRectanguloX(1);// Mover jugador hacia la derecha
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			pista.setRectanguloY(-1);// Mover pista hacia abajo
		}
	}

	@Override
	public void dispose () {
		texturaJugador.dispose();
		texturaPista.dispose();
		batch.dispose();
	}
}
