package com.cometdefense.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.cometdefense.game.shared.DisplayContext;

import static com.cometdefense.game.shared.DisplayContext.SPRITE_SCALE;
import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_WIDTH;

public class ActorFactory {
    public static Player constructPlayer(Texture texture) {
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
}
