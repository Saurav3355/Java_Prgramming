package com.example.sauravchaudhary_comp228lab5.models;

public class PlayerAndGame {
    private int playerGameId;
    private int gameId;
    private int playerId;
    private int score;

    public PlayerAndGame(int playerGameId, int gameId, int playerId, int score) {
        this.playerGameId = playerGameId;
        this.gameId = gameId;
        this.playerId = playerId;
        this.score = score;
    }

    public int getPlayerGameId() {
        return playerGameId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getScore() {
        return score;
    }
}
