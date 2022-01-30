package com.cometdefense.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.cometdefense.game.data.SessionData;
import com.cometdefense.game.scenes.utils.SceneManager;

public class CometDefenseApp extends ApplicationAdapter {
	SceneManager manager;
	SpriteBatch batch;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = SceneManager.getInstance();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800, 600);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		manager.handleEvents();
		manager.update();

		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		manager.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
