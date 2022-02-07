package com.cometdefense.game.actors.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.cometdefense.game.shared.DisplayContext.SPRITE_SCALE;

public abstract class Actor {
    protected final Sprite sprite;
    protected final Rectangle rect;

    public Actor(Sprite sprite, Rectangle rect) {
        this.sprite = sprite;
        this.rect = rect;
    }

    public abstract void update();

    public void draw(SpriteBatch batch) {
        sprite.setSize(rect.width, rect.height);
        sprite.setPosition(rect.x, rect.y);
        sprite.draw(batch);
    }
}
