package com.example.sauravchaudhary_comp228lab5.database;

import com.example.sauravchaudhary_comp228lab5.models.Player;
import com.example.sauravchaudhary_comp228lab5.models.Game;
import com.example.sauravchaudhary_comp228lab5.models.PlayerAndGame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {

    public static void insertPlayer(Player player) throws SQLException {
        String query = "INSERT INTO Player (player_id, first_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, player.getPlayerId());
            pstmt.setString(2, player.getFirstName());
            pstmt.executeUpdate();
        }
    }

    public static void insertGame(Game game) throws SQLException {
        String query = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, game.getGameId());
            pstmt.setString(2, game.getGameTitle());
            pstmt.executeUpdate();
        }
    }

    public static void insertPlayerGame(PlayerAndGame playerGame) throws SQLException {
        String query = "INSERT INTO PlayerAndGame (player_game_id, game_id, player_id, score) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, playerGame.getPlayerGameId());
            pstmt.setInt(2, playerGame.getGameId());
            pstmt.setInt(3, playerGame.getPlayerId());
            pstmt.setInt(4, playerGame.getScore());
            pstmt.executeUpdate();
        }
    }

    public static ResultSet fetchResults() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        String query = "SELECT p.first_name, g.game_title, pg.score " +
                "FROM Player p " +
                "JOIN PlayerAndGame pg ON p.player_id = pg.player_id " +
                "JOIN Game g ON pg.game_id = g.game_id";
        return stmt.executeQuery(query);
    }
}
