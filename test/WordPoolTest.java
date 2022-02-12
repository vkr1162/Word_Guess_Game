package test;

import model.WordGuessGame;
import model.WordPool;

public class WordPoolTest {

    public static void main(String[] args) {
        WordPool words = new WordPool();
        // String randWord = words.generateWord();
        // System.out.println(randWord);
        WordGuessGame wordGuessGame = new WordGuessGame();
        System.out.println(wordGuessGame.generateWord());
        // System.out.println(wordGuessGame.compareWord("chemistry"));
    }
}
