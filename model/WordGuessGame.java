package model;

import java.util.Random;

public class WordGuessGame {

    public WordGuessGame() {
        generateWord();
    }

    public String generateWord() {
        WordPool wordPoolobj = new WordPool();
        Random r = new Random();
        return wordPoolobj.wordPool.get(r.nextInt(wordPoolobj.wordPool.size()));
    }

    public boolean compareWord(String randWord, String n) {
        boolean b = randWord.contains(n.trim());
        System.out.println(b);
        return b;
    }
}
