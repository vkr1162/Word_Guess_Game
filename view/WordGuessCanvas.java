package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class WordGuessCanvas extends JPanel {
    public static int WIDTH = 500;
    public static int HEIGHT = 500;
    private MenuScreen panel;
    private int healthLevel;

    public WordGuessCanvas(MenuScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // ready to play
        MenuScreen.GameState state = panel.getGameState();
        if (state == MenuScreen.GameState.READY) {
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Click <New> to Start", 70, 150);
        } else {
            if (state == MenuScreen.GameState.GAMEOVER) {
                g2.setColor(Color.red);
                g2.setFont(new Font("courier new", Font.BOLD, 30));
                g2.drawString("YOU LOST", 150, 160);
                g2.drawString("Click <New> to Start", 70, 150);
            }
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier New", Font.BOLD, 20));
            g2.drawString("Health Level", 80, 50);
            for (int i = healthLevel; i > 0; i--) {
                System.out.println(healthLevel);
                g2.fillRect(i * 70 + 10, 80, 50, 60);
            }
        }
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
        System.out.println(healthLevel);
    }

}
