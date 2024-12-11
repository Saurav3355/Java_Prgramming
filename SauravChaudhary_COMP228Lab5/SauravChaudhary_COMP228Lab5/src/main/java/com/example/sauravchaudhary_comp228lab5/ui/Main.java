package com.example.sauravchaudhary_comp228lab5.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameAppGUI app = new GameAppGUI();
            app.setVisible(true);
        });
    }
}
