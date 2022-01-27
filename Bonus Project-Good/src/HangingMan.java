package src;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class HangingMan {
    private int numWrongGuesses;
    String[] HangmanImage = new String[]{"6 guesses left", "5 guesses left", "4 guesses left", "3 guesses left", "2 guesses left", "1 guess left"};

    public HangingMan() {
    }

    public boolean isntDead() {
        return this.numWrongGuesses < 6;
    }

    public void show() {
        System.out.println(this.HangmanImage[this.numWrongGuesses]);
    }

    public void dieSomeMore() {
        ++this.numWrongGuesses;
    }
}
