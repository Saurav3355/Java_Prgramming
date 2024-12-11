package com.example.sauravchaudhary_comp228lab5.models;

public class Game {
    private int gameId;
    private String gameTitle;

    public Game(int gameId, String gameTitle) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }
}
