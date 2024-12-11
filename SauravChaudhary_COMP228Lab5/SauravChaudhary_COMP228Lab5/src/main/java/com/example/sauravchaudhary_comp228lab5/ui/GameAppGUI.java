package com.example.sauravchaudhary_comp228lab5.ui;

import com.example.sauravchaudhary_comp228lab5.database.DatabaseOperations;
import com.example.sauravchaudhary_comp228lab5.models.Game;
import com.example.sauravchaudhary_comp228lab5.models.Player;
import com.example.sauravchaudhary_comp228lab5.models.PlayerAndGame;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameAppGUI extends JFrame {
    public GameAppGUI() {
        setTitle("Player and Game Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));


        JPanel playerPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        playerPanel.setBorder(BorderFactory.createTitledBorder("Add Player"));
        JTextField playerIdField = new JTextField();
        JTextField firstNameField = new JTextField();
        JButton addPlayerButton = new JButton("Add Player");
        playerPanel.add(new JLabel("Player ID:"));
        playerPanel.add(playerIdField);
        playerPanel.add(new JLabel("First Name:"));
        playerPanel.add(firstNameField);
        playerPanel.add(new JLabel());
        playerPanel.add(addPlayerButton);


        JPanel gamePanel = new JPanel(new GridLayout(3, 2, 5, 5));
        gamePanel.setBorder(BorderFactory.createTitledBorder("Add Game"));
        JTextField gameIdField = new JTextField();
        JTextField gameTitleField = new JTextField();
        JButton addGameButton = new JButton("Add Game");
        gamePanel.add(new JLabel("Game ID:"));
        gamePanel.add(gameIdField);
        gamePanel.add(new JLabel("Game Title:"));
        gamePanel.add(gameTitleField);
        gamePanel.add(new JLabel());
        gamePanel.add(addGameButton);


        JPanel scorePanel = new JPanel(new GridLayout(4, 2, 5, 5));
        scorePanel.setBorder(BorderFactory.createTitledBorder("Add Score"));
        JTextField scorePlayerIdField = new JTextField();
        JTextField scoreGameIdField = new JTextField();
        JTextField scoreField = new JTextField();
        JButton addScoreButton = new JButton("Add Score");
        scorePanel.add(new JLabel("Player ID:"));
        scorePanel.add(scorePlayerIdField);
        scorePanel.add(new JLabel("Game ID:"));
        scorePanel.add(scoreGameIdField);
        scorePanel.add(new JLabel("Score:"));
        scorePanel.add(scoreField);
        scorePanel.add(new JLabel());
        scorePanel.add(addScoreButton);


        mainPanel.add(playerPanel);
        mainPanel.add(gamePanel);
        mainPanel.add(scorePanel);

        add(mainPanel, BorderLayout.NORTH);


        JTable resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        JButton showResultsButton = new JButton("Show Results");
        add(showResultsButton, BorderLayout.SOUTH);


        addPlayerButton.addActionListener(e -> {
            try {
                Player player = new Player(Integer.parseInt(playerIdField.getText()), firstNameField.getText());
                DatabaseOperations.insertPlayer(player);
                JOptionPane.showMessageDialog(this, "Player added successfully!");
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        addGameButton.addActionListener(e -> {
            try {
                Game game = new Game(Integer.parseInt(gameIdField.getText()), gameTitleField.getText());
                DatabaseOperations.insertGame(game);
                JOptionPane.showMessageDialog(this, "Game added successfully!");
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        addScoreButton.addActionListener(e -> {
            try {
                PlayerAndGame playerGame = new PlayerAndGame(
                        Integer.parseInt(scorePlayerIdField.getText()), // Use Player ID as Record ID for simplicity
                        Integer.parseInt(scoreGameIdField.getText()),
                        Integer.parseInt(scorePlayerIdField.getText()),
                        Integer.parseInt(scoreField.getText())
                );
                DatabaseOperations.insertPlayerGame(playerGame);
                JOptionPane.showMessageDialog(this, "Score added successfully!");
            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        showResultsButton.addActionListener(e -> {
            try {
                ResultSet rs = DatabaseOperations.fetchResults();
                resultTable.setModel(new ResultSetTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameAppGUI app = new GameAppGUI();
            app.setVisible(true);
        });
    }
}
