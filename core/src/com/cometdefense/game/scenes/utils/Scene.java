package com.cometdefense.game.scenes.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.shared.SessionData;

public abstract class Scene {

    protected final SessionData sessionData = SessionData.getInstance();

    public abstract void create();
    public abstract void dispose();

    public abstract void handleEvents();
    public abstract void update();
    public abstract void draw(SpriteBatch batch);

    protected void requestManager(SceneRequest request) {
        SceneManager manager = SceneManager.getInstance();
        manager.receiveRequest(request);
    }
}
