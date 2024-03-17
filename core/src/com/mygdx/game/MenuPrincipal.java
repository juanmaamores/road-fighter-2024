package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuPrincipal implements Screen {

    final RF24 game;
    private int screenWidth, screenHeight, screenWidthCenter, screenHeightCenter;
    private Texture titulo1, titulo2;
    private float elapsedTime;
    private boolean isFirstImage = true;

    OrthographicCamera camera;

    public MenuPrincipal(final RF24 game){
        this.game = game;
        this.elapsedTime = 0f;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,500,500);

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        screenWidthCenter = screenWidth/2;
        screenHeightCenter = screenHeight/2;

        titulo1 = new Texture(Gdx.files.internal("assets/titulo1.png"));
        titulo2 = new Texture(Gdx.files.internal("assets/titulo2.png"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0.2f,1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        elapsedTime += delta;

        game.batch.begin();
        // Dibujar la imagen dependiendo del tiempo transcurrido
        if (isFirstImage) {
            if (elapsedTime >= 0.5f) {
                isFirstImage = false; // Cambiar a la segunda imagen después de 1 segundo
                elapsedTime = 0f; // Reiniciar el tiempo después de cambiar la imagen
            }
            game.batch.draw(titulo1, 0, 0);
        } else {
            if (elapsedTime >= 0.5f) {
                isFirstImage = true; // Cambiar a la primera imagen después de medio segundo
                elapsedTime = 0f; // Reiniciar el tiempo después de cambiar la imagen
            }
            game.batch.draw(titulo2, 0, 0);
        }
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            game.setScreen(new Juego(game));
            dispose();
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

    }
}
