package com.cometdefense.game.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.cometdefense.game.scenes.utils.Scene;
import com.cometdefense.game.sprites.Player;

import static com.cometdefense.game.shared.DisplayContext.*;

public class PlayScene extends Scene {
    // Textures
    private Texture playerImage;

    // Sprites
    private Player thePlayer;

    // * * * * * * * * * * * * * * * * * * * *
    //    Resource creation / destruction
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void create() {
        // Create the player
        playerImage = new Texture("images/icon.png");

        Rectangle pRect = new Rectangle();
        pRect.width = playerImage.getWidth() * SPRITE_SCALE;
        pRect.height = playerImage.getHeight() * SPRITE_SCALE;
        pRect.x = (VIEWPORT_WIDTH / 2) - (pRect.width / 2);
        pRect.y = 32;

        thePlayer = new Player(playerImage, pRect);
    }

    @Override
    public void dispose() {
        playerImage.dispose();
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
