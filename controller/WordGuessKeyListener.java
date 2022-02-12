package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.WordGuessGame;
import view.MenuScreen;
import view.WordGuessCanvas;

public class WordGuessKeyListener implements ActionListener {
    private MenuScreen panel;
    // LinkedList<Character> al = new LinkedList<>();
    char[] ch;
    String randomWord;
    char[] ch1;
    private int healthLevel = 5;
    WordGuessCanvas canvas = new WordGuessCanvas(panel);

    public WordGuessKeyListener(MenuScreen panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        /// var vg = new WordGuessGame();
        if (button == panel.getNewButton()) {
            var wordGuessGame = new WordGuessGame();
            panel.setWordGuess(wordGuessGame);
            panel.setGameState(MenuScreen.GameState.PLAYING);
            randomWord = wordGuessGame.generateWord();
            panel.getrandomWord().setText(randomWord);
            panel.getguessWord().setText(randomWord);
            panel.getrandomWord().setForeground(Color.red);
            panel.getrandomWord().setFont(new Font("Courier New", Font.BOLD, 15));

            String s = panel.getguessWord().getText();
            String temp = "";
            for (int i = 0; i < randomWord.length(); i++) {
                temp = temp + "*";
            }
            panel.getguessWord().setText(temp);
            // enabling letter buttons
            for (var b : panel.getLetters()) {
                b.setEnabled(true);
            }
            ch = new char[randomWord.length()];
            panel.getguessWord().setFont(new Font("Courier New", Font.BOLD, 15));
            // ch1 = panel.getguessWord().getPassword();

            ch1 = s.toCharArray();
            panel.getCanvas().setHealthLevel(5);
            panel.getCanvas().repaint();
        } else {
            button.setEnabled(false);
            char l = button.getText().charAt(1);
            String n = button.getText();
            // ArrayList<Integer> al = new ArrayList<>();
            // int temp = 0;
            // System.out.println(randomWord.contains(n));
            if (!randomWord.contains(n.trim())) {
                healthLevel = healthLevel - 1;
                panel.getCanvas().setHealthLevel(healthLevel);
                if (healthLevel == 0) {
                    panel.setGameState(MenuScreen.GameState.GAMEOVER);
                }
            }

            for (int i = 0; i < ch.length; i++) {
                if (ch1[i] == l) {
                    ch[i] = l;
                } else {
                    ch[i] = '*';
                }
            }

            String s = new String(ch);
            panel.getguessWord().setText(s);
            panel.getguessWord().setFont(new Font("Courier New", Font.BOLD, 15));
            System.out.println(s);
        }
    }
}
