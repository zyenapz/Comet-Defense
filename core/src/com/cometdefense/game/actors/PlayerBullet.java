package com.cometdefense.game.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.cometdefense.game.actors.utils.Actor;

public class PlayerBullet extends Actor {

    private Vector2 velocity;

    public PlayerBullet(Sprite sprite, Rectangle rect, Vector2 velocity) {
        super(sprite, rect);
        this.velocity = velocity;
    }
    @Override
    public void update() {
        rect.x += velocity.x;
        rect.y += velocity.y;
    }
}
