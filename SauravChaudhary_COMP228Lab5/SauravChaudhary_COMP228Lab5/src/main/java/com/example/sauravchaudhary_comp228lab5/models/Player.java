package com.example.sauravchaudhary_comp228lab5.models;

public class Player {
    private int playerId;
    private String firstName;

    public Player(int playerId, String firstName) {
        this.playerId = playerId;
        this.firstName = firstName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getFirstName() {
        return firstName;
    }
}
