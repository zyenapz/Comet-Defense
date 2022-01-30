package com.cometdefense.game.scenes.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.scenes.*;

import static com.cometdefense.game.shared.DisplayContext.VIEWPORT_HEIGHT;

public class SceneManager
{
    // **==**==**==**== **==**==**==**== **==**==**==**==
    //                      Fields
    // **==**==**==**== **==**==**==**== **==**==**==**==
    private Scene currentScene;
    private BitmapFont font;

    // * * * * * * * * * * * * * * * * * * * *
    //          Singleton creation
    // * * * * * * * * * * * * * * * * * * * *

    private static SceneManager instance = new SceneManager();

    private SceneManager() {
        currentScene = new PlayScene();
        currentScene.create();

        font = new BitmapFont();
    }

    public static SceneManager getInstance() {
        return instance;
    }

    // * * * * * * * * * * * * * * * * * * * *
    //              Delegates
    // * * * * * * * * * * * * * * * * * * * *

    public void handleEvents() {
        // Delegate
        currentScene.handleEvents();
    }

    public void update() {
        // Delegate
        currentScene.update();
    }

    public void draw(SpriteBatch batch) {
        // Delegate
        currentScene.draw(batch);
        drawCurrentSceneLabel(batch);
    }

    private void drawCurrentSceneLabel(SpriteBatch batch) {
        String className = currentScene.getClass().getSimpleName();
        font.draw(batch, className, 0, VIEWPORT_HEIGHT);
    }

    // * * * * * * * * * * * * * * * * * * * *
    //            Request handling
    // * * * * * * * * * * * * * * * * * * * *

    public void receiveRequest(SceneRequest request) {
        processRequest(request);
    }

    private void processRequest(SceneRequest request) {

        Scene newScene;

        switch(request) {
            case GOTO_MENU:
                newScene = new MenuScene();
                break;
            case GOTO_SCORES:
                newScene = new ScoresScene();
                break;
            case GOTO_HELP:
                newScene = new HelpScene();
                break;
            case GOTO_PLAY:
                newScene = new PlayScene();
                break;
            case GOTO_GAMEOVER:
                newScene = new GameOverScene();
                break;
            default:
                newScene = new MenuScene();
                break;
        }

        currentScene.dispose();
        currentScene = newScene;
        currentScene.create();
    }

}
