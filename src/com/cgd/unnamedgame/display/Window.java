package com.cgd.unnamedgame.display;

import com.cgd.unnamedgame.Game;
import com.cgd.unnamedgame.debug.Debug;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    Dimension size;

    public Window(int width, int height, String title, Game game) {
        Debug.Log("Creating window");
        JFrame frame = new JFrame(title);  // Create window contents
        size = new Dimension(width, height);

        frame.setPreferredSize(size);
        frame.setMaximumSize(size);    // Set window size
        frame.setMinimumSize(size);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);  // Center the window on screen
        frame.add(game);  // Add the game to the window

        frame.setVisible(true);  // Show the window

        Debug.Log("Starting game");
        game.start();  // Start the game
    }

}
