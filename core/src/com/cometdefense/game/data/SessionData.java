package com.cometdefense.game.data;

public class SessionData {
    // Singleton instance
    private static SessionData instance = new SessionData();

    // Session variables
    private int score;

    private SessionData() {

    }

    public static SessionData getInstance() {
        return instance;
    }

}
