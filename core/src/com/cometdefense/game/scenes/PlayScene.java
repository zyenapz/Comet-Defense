package com.cometdefense.game.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.cometdefense.game.actors.ActorFactory;
import com.cometdefense.game.actors.PlayerBullet;
import com.cometdefense.game.actors.utils.Actor;
import com.cometdefense.game.scenes.utils.Scene;
import com.cometdefense.game.actors.Player;
import com.cometdefense.game.shared.AssetContainer;

import static com.cometdefense.game.shared.AssetID.TEX_BULLET;
import static com.cometdefense.game.shared.AssetID.TEX_PLAYER;

public class PlayScene extends Scene {
    // Sprites
    private Player thePlayer;

    // Actor factory
    private ActorFactory actorFactory;

    // Asset container
    private AssetContainer assetContainer;

    // * * * * * * * * * * * * * * * * * * * *
    //    Resource creation / destruction
    // * * * * * * * * * * * * * * * * * * * *

    @Override
    public void create() {
        // Create asset container
        assetContainer = new AssetContainer();
        assetContainer.loadTexture(TEX_PLAYER, "images/icon.png");
        assetContainer.loadTexture(TEX_BULLET, "images/bullet.png");

        // Create actor factory
        actorFactory = new ActorFactory(assetContainer);
        PlayerBullet bullet = actorFactory.constructPlayerBullet(new Vector2(30, 30));

        // Create the player
        thePlayer = actorFactory.constructPlayer();

    }

    @Override
    public void dispose() {
        assetContainer.dispose();
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
