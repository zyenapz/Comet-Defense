package com.cometdefense.game.sprites.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Sprite {
    protected final Texture image;
    protected final Rectangle rect;

    public Sprite(Texture image, Rectangle rect) {
        this.image = image;
        this.rect = rect;
    }

    public abstract void update();
    public void draw(SpriteBatch batch) {
        batch.draw(image, rect.x, rect.y, rect.width, rect.height);
    }
}
