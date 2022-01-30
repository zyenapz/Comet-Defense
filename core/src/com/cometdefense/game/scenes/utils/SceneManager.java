package com.cometdefense.game.scenes.utils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cometdefense.game.scenes.*;

public class SceneManager
{
    // * * * * * * * * * * * * * * * * * * * *
    //          Singleton creation
    // * * * * * * * * * * * * * * * * * * * *

    private static SceneManager instance = new SceneManager();

    private Scene currentScene;

    private SceneManager() {
        Scene initialScene = new PlayScene();
        currentScene = initialScene;
        currentScene.create();
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
