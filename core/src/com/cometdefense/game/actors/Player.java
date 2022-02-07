package com.cometdefense.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cometdefense.game.actors.utils.Actor;
import com.cometdefense.game.shared.DisplayContext;

import static com.cometdefense.game.shared.Constants.DIAGONAL_FIX;
import static com.cometdefense.game.shared.DisplayContext.*;

public class Player extends Actor {

    private float speed = 4;
    private Vector2 velocity;

    public Player(Sprite sprite, Rectangle rect) {
        super(sprite, rect);
        velocity = new Vector2(0, 0);
    }

    @Override
    public void update() {
        resetVelocity();
        move();
        keepWithinBounds();

        rect.x += velocity.x;
        rect.y += velocity.y;

    }

    private void resetVelocity() {
        velocity.x = 0;
        velocity.y = 0;
    }

    private void move() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocity.x -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocity.x += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocity.y += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocity.y -= speed;
        }

        // Diagonal speed fix
        if(velocity.x != 0 && velocity.y != 0) {
            velocity.x *= DIAGONAL_FIX;
            velocity.y *= DIAGONAL_FIX;
        }
    }

    private void keepWithinBounds() {
        // X-axis
        if(rect.x + velocity.x <= 0) {
            rect.x = 0;
            velocity.x = 0;
        }
        else if(rect.x + velocity.x + rect.width >= VIEWPORT_WIDTH) {
            rect.x = VIEWPORT_WIDTH - rect.width;
            velocity.x = 0;
        }

        // Y-axis
        if(rect.y + velocity.y <= 0) {
            rect.y = 0;
            velocity.y = 0;
        }
        else if(rect.y + velocity.y + rect.height >= VIEWPORT_HEIGHT) {
            rect.y = VIEWPORT_HEIGHT - rect.height;
            velocity.y = 0;
        }
    }
}
