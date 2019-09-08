package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGameBounceUsingOrthoCameraNormCoords extends ApplicationAdapter {

    SpriteBatch batch;
    Texture img;

    Sprite sprite;
    OrthographicCamera camera;

    float speed = 0.4f;
    float x;
    float y;
    float xStep = speed;
    float yStep = speed;
    float viewportWidth = 1.0f;
    float viewportHeight = 1.0f;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        viewportHeight = h / w;

        camera = new OrthographicCamera(viewportWidth, viewportHeight);

        TextureRegion region = new TextureRegion(img, 0, 0, img.getWidth(), img.getHeight());
        sprite = new Sprite(region);
        sprite.setSize(0.2f, 0.2f * sprite.getHeight() / sprite.getWidth());

        x = -sprite.getWidth() / 2f;
        y = -sprite.getHeight() / 2f;

        sprite.setOrigin(sprite.getWidth() / 2f, sprite.getHeight() / 2f);
    }

    @Override
    public void render () {
        float deltaTime = Gdx.graphics.getDeltaTime();

        x += xStep * deltaTime;
        if (x + sprite.getWidth() > 0.5f) {
            x = 0.5f - sprite.getWidth();
            xStep = -speed;
        }

        if (x < -0.5f) {
            x = -0.5f;
            xStep = speed;
        }

        y += yStep * deltaTime;
        if (y + sprite.getHeight() > viewportHeight/2.0f) {
            y = (viewportHeight / 2.0f) - sprite.getHeight();
            yStep = -speed;
        }

        if (y < -viewportHeight/2.0f) {
            y = -viewportHeight/2.0f;
            yStep = speed;
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sprite.setPosition(x, y);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }

}
