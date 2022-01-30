package com.cometdefense.game.shared;

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
