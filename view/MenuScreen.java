package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WordGuessKeyListener;
import model.WordGuessGame;

import java.awt.GridLayout;

public class MenuScreen {
    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    private JFrame window;
    private JTextField randomWord = new JTextField();
    private JTextField guessWord = new JTextField();
    private JButton[] letters;
    private JButton newButton = new JButton("New");

    private WordGuessCanvas canvas;
    private GameState gameState = GameState.READY;
    private WordGuessGame wordGuessGame;

    public MenuScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(randomWord);
        northPanel.add(guessWord);
        randomWord.setEditable(false);
        guessWord.setEditable(false);

        cp.add(BorderLayout.NORTH, northPanel);
        canvas = new WordGuessCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southpanel = new JPanel();
        southpanel.setLayout(new GridLayout(4, 7));

        WordGuessKeyListener listener = new WordGuessKeyListener(this);
        letters = new JButton[26];
        for (int i = 97; i < 123; i++) {
            letters[i - 97] = new JButton(" " + (char) i);
            southpanel.add(letters[i - 97]);
            letters[i - 97].addActionListener(listener);
        }
        newButton.addActionListener(listener);
        southpanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southpanel);
        for (var b : letters) {
            b.setEnabled(false);
        }
    }

    public WordGuessGame getWordGuess() {
        return wordGuessGame;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public JButton getNewButton() {
        return newButton;
    }

    public JTextField getrandomWord() {
        return randomWord;
    }

    public JTextField getguessWord() {
        return guessWord;
    }

    public JButton[] getLetters() {
        return letters;
    }

    public void setWordGuess(WordGuessGame wordGuessGame) {
        this.wordGuessGame = wordGuessGame;
    }

    public WordGuessCanvas getCanvas() {
        return canvas;
    }
}
