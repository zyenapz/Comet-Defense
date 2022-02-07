package com.cometdefense.game.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.actors.ActorFactory;
import com.cometdefense.game.scenes.utils.Scene;
import com.cometdefense.game.actors.Player;

public class PlayScene extends Scene {
    // Textures
    private Texture playerTexture;

    // Sprites
    private Player thePlayer;

    // * * * * * * * * * * * * * * * * * * * *
    //    Resource creation / destruction
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void create() {
        // Create the player
        playerTexture = new Texture("images/icon.png");
        thePlayer = ActorFactory.constructPlayer(playerTexture);
    }

    @Override
    public void dispose() {
        playerTexture.dispose();
    }

    // * * * * * * * * * * * * * * * * * * * *
    //              Scene loop
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void handleEvents() {

    }

    @Override
    public void update() {
        thePlayer.update();
    }

    @Override
    public void draw(SpriteBatch batch) {
        thePlayer.draw(batch);
    }
}
