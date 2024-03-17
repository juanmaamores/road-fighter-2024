package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Juego implements Screen {

    final RF24 game;
    private Jugador jugador;
    private Texture texturaJugador, texturaPista;
    private Pista pista;
    private OrthographicCamera camera;

    public Juego(final RF24 game){
        this.game = game;

        //Obtener el ancho y alto de la pantalla dinamicamente
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        int screenWidthCenter = screenWidth/2;
        int screenHeightCenter = screenHeight/2;

        //obtener texturas del disco
        texturaJugador = new Texture(Gdx.files.internal("assets/jugadorNorte.png"));
        texturaPista = new Texture(Gdx.files.internal("assets/pista.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 500, 500);

        jugador = new Jugador(texturaJugador, screenWidthCenter - (texturaJugador.getWidth()/2),0);
        pista = new Pista(texturaPista, screenWidthCenter - (texturaPista.getWidth()/2) ,0);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(texturaPista,pista.getRectangulo().x, pista.getRectangulo().y);
        game.batch.draw(texturaJugador,jugador.getRectangulo().x, jugador.getRectangulo().y);
        game.batch.end();

        controles();

    }

    private void controles() {
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
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        texturaJugador.dispose();
        texturaPista.dispose();
    }
}
