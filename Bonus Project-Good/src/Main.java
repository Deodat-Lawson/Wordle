package src;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HangingMan hangingMan = new HangingMan();
        Puzzle puzzle = new Puzzle();
        System.out.println("Welcome to Timothy's Wordle");
        System.out.println();

        for (; !puzzle.solved && hangingMan.isntDead(); clearScreen()) {
            hangingMan.show();
            puzzle.show();
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();

            if (!puzzle.allWords.contains(guess)) {
                System.out.println("Not in wordlist, try again!");
                System.out.println();
            } else if (!puzzle.makeGuess(guess)) {
                hangingMan.dieSomeMore();
                System.out.println();
            }
        }

        if (hangingMan.isntDead()) {
            System.out.println("_____.___.               __      __.__        \n\\__  |   | ____  __ __  /  \\    /  \\__| ____  \n /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ \n \\____   (  <_> )  |  /  \\        /|  |   |  \\\n / ______|\\____/|____/    \\__/\\  / |__|___|  /\n \\/                            \\/          \\/ ");
        } else {
            if (puzzle.solved) {
                System.out.println("_____.___.               __      __.__        \n\\__  |   | ____  __ __  /  \\    /  \\__| ____  \n /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ \n \\____   (  <_> )  |  /  \\        /|  |   |  \\\n / ______|\\____/|____/    \\__/\\  / |__|___|  /\n \\/                            \\/          \\/ ");
            } else {
                System.out.println("_____.___.              .____                        \n\\__  |   | ____  __ __  |    |    ____  ______ ____  \n /   |   |/  _ \\|  |  \\ |    |   /  _ \\/  ___// __ \\ \n \\____   (  <_> )  |  / |    |__(  <_> )___ \\\\  ___/ \n / ______|\\____/|____/  |_______ \\____/____  >\\___  >\n \\/                             \\/         \\/     \\/ ");
                System.out.println();
                System.out.println("The word was " + puzzle.getWord());
            }
        }

    }

    public static void clearScreen() {
        System.out.println("\f");
    }
}
