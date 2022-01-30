package com.cometdefense.game.scenes.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.data.SessionData;

public abstract class Scene {

    protected SessionData sessionData;

    public abstract void create();
    public abstract void dispose();

    public abstract void handleEvents();
    public abstract void update();
    public abstract void draw(SpriteBatch batch);

    protected void requestManager(SceneManager manager, SceneRequest request) {
        manager.receiveRequest(request);
    };
}
