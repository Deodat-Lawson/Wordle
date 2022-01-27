package src;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Puzzle {
    ArrayList<String> allWords = new ArrayList();
    private HashSet<String> guessedW = new HashSet();
    private String currWord = "";
    private String guessedWord = "";
    boolean solved = false;

    public Puzzle() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("words.in"));

        for (String a = br.readLine(); a != null; a = br.readLine()) {
            this.allWords.add(a);
        }

        br.close();
        this.genNewWord();
    }

    public void genNewWord() {
        this.currWord = (String) this.allWords.get((int) (Math.random() * (double) this.allWords.size()));

        for (int i = 0; i < this.currWord.length(); ++i) {
            this.guessedWord = this.guessedWord + "\033";
        }

    }

    public boolean isUnsolved() {
        String a = this.guessedWord.toLowerCase();
        return !a.equals(this.currWord);
    }

    public void show() {
        System.out.println();

        for (int i = 0; i < this.currWord.length(); ++i) {
            PrintStream var10000 = System.out;
            String var10001 = this.guessedWord.substring(i, i + 1);
            var10000.print(var10001 + " ");
        }

        System.out.println();
        System.out.println("Lower case = wrong place, Upper case = guessed correctly" + ", \033 = not in word" );
        System.out.print("Guessed Words ");
        Iterator var3 = this.guessedW.iterator();

        while (var3.hasNext()) {
            String a = (String) var3.next();
            System.out.print(a.toUpperCase() + ", ");
        }

    }

    public boolean makeGuess(String guess) {
        guess = guess.toLowerCase();
        this.guessedW.add(guess);

        if(guess.equalsIgnoreCase(currWord)) solved = true;

        for (int i = 0; i < 5; i++) {
            if (this.currWord.substring(i, i + 1).equals(guess.substring(i, i + 1))) {
                String var10001 = this.guessedWord.substring(0, i);
                this.guessedWord = var10001 + this.currWord.substring(i, i + 1).toUpperCase() + this.guessedWord.substring(i + 1);
            }
            else if(this.currWord.contains(guess.substring(i, i + 1))){
                String var10001 = this.guessedWord.substring(0, i);
                this.guessedWord = var10001 + guess.substring(i, i + 1).toLowerCase() + this.guessedWord.substring(i + 1);
            }
            else{
                String var10001 = this.guessedWord.substring(0, i);
                this.guessedWord = var10001 + "\033"+this.currWord.substring(i, i + 1).toLowerCase() + "\033" + this.guessedWord.substring(i + 1);
            }
        }

        return false;
    }

    public String getWord() {
        return "\"" + this.currWord + "\"";
    }
}
