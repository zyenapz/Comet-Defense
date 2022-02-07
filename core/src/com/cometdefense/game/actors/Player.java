package com.cometdefense.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cometdefense.game.actors.utils.Actor;

import static com.cometdefense.game.shared.Constants.DIAGONAL_FIX;
import static com.cometdefense.game.shared.DisplayContext.SPRITE_SCALE;
import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_WIDTH;

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

        rect.x += velocity.x;
        rect.y += velocity.y;

    }

    private void resetVelocity() {
        velocity.x = 0;
        velocity.y = 0;
    }
}
