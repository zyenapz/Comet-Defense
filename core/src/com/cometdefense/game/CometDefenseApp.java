package com.cometdefense.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.cometdefense.game.scenes.utils.SceneManager;

import static com.cometdefense.game.data.DisplayContext.VIEWPORT_HEIGHT;
import static com.cometdefense.game.data.DisplayContext.VIEWPORT_WIDTH;

public class CometDefenseApp extends ApplicationAdapter {
	SceneManager manager;
	SpriteBatch batch;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = SceneManager.getInstance();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

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
