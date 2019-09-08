package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGameSimpleBounceRealPixelSize extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x;
	float y;
	float xStep;
	float yStep;
	float speed;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		x = 0f;
		y = 0f;
		speed = 600f;
		xStep = speed;
		yStep = speed;
	}

	@Override
	public void render () {
		float deltaTime = Gdx.graphics.getDeltaTime();
		x += xStep * deltaTime;
		y += yStep * deltaTime;

		if (x < 0f) {
			x = 0f;
			xStep = speed;
		}

		if (x + img.getWidth() > Gdx.graphics.getWidth()) {
			x = Gdx.graphics.getWidth() - img.getWidth();
			xStep = -speed;
		}

		if (y < 0f) {
			y = 0f;
			yStep = speed;
		}

		if (y + img.getHeight() > Gdx.graphics.getHeight()) {
			y = Gdx.graphics.getHeight() - img.getHeight();
			yStep = -speed;
		}

		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
