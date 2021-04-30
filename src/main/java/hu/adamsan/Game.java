package hu.adamsan;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

class Game {

    private final PrintStream out;
    private final MyScanner scanner;
    private final Random random;

    public Game(Scanner scanner, PrintStream out, Random random) {
        this.out = out;
        this.scanner = new MyScanner(scanner);
        this.random = random;
    }

    Game(MyScanner scanner, PrintStream out, Random random) {
        this.out = out;
        this.scanner = scanner;
        this.random = random;
    }

    void play() {
        Choice player = getPlayer();
        if (player == null) return;

        Choice computer = getComputer();

        if (player.tiesWith(computer)) {
            println("It's a tie!");
        } else if (player.beats(computer)) {
            println(player.capitalize() + " beats " + computer.toLowerCase() + ". Player wins!");
        } else if (computer.beats(player)) {
            println(computer.capitalize() + " beats " + player.toLowerCase() + ". The computer wins!");
        }
    }

    private Choice getPlayer() {
        println("Do you pick rock, paper, or scissors?");
        String playerChoice = scanner.nextLine();

        if (!isValid(playerChoice)) {
            println("Move not recognized! Please try again.");
            return null;
        }
        return Choice.valueOf(playerChoice.toUpperCase());
    }

    private Choice getComputer() {
        Choice computer = Choice.values()[random.nextInt(3)];
        println("The computer chose: " + computer.toLowerCase());
        return computer;
    }

    private boolean isValid(String playerChoice) {
        try {
            Choice.valueOf(playerChoice.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private void println(String str) {
        out.println(str);
    }
}
