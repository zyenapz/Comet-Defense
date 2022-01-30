package com.cometdefense.game.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.scenes.utils.Scene;

public class PlayScene extends Scene {
    private Texture image;

    public PlayScene() {

    }

    // * * * * * * * * * * * * * * * * * * * *
    //    Resource creation / destruction
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void create() {
        image = new Texture("images/badlogic.jpg");
    }

    @Override
    public void dispose() {
        image.dispose();
    }

    // * * * * * * * * * * * * * * * * * * * *
    //              Scene loop
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void handleEvents() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(image, 30, 30);
    }
}
