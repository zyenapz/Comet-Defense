package com.cometdefense.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cometdefense.game.shared.AssetContainer;
import com.cometdefense.game.shared.AssetID;
import com.cometdefense.game.shared.DisplayContext;

import java.util.Hashtable;

import static com.cometdefense.game.shared.AssetID.TEX_BULLET;
import static com.cometdefense.game.shared.AssetID.TEX_PLAYER;
import static com.cometdefense.game.shared.DisplayContext.SPRITE_SCALE;
import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_WIDTH;

public class ActorFactory {

    private AssetContainer assetContainer;

    public ActorFactory(AssetContainer assetContainer) {
        this.assetContainer = assetContainer;
    }

    public Player constructPlayer() {
        // Fetch texture
        Texture texture = assetContainer.fetchTexture(TEX_PLAYER);

        if(texture != null) {
            // Construct rectangle
            Rectangle rect = new Rectangle();
            rect.width = texture.getWidth() * SPRITE_SCALE;
            rect.height = texture.getHeight() * SPRITE_SCALE;
            rect.x = (VIEWPORT_WIDTH / 2) - (rect.width / 2);
            rect.y = 32;

            // Construct sprite
            Sprite sprite = new Sprite(texture);

            return new Player(sprite, rect);
        }
        else {
            return null;
        }

    }

    public PlayerBullet constructPlayerBullet(Vector2 velocity) {
        // Fetch texture
        Texture texture = assetContainer.fetchTexture(TEX_BULLET);

        if(texture != null) {
            // Construct rectangle
            Rectangle rect = new Rectangle();
            rect.width = texture.getWidth() * SPRITE_SCALE;
            rect.height = texture.getHeight() * SPRITE_SCALE;
            rect.x = 0;
            rect.y = 0;

            // Construct sprite
            Sprite sprite = new Sprite(texture);

            return new PlayerBullet(sprite, rect, velocity);
        }
        else {

            return null;
        }

    }
}
