package hu.adamsan;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

class Game {

    public static final String ROCK = "rock";
    public static final String PAPER = "paper";
    public static final String SCISSORS = "scissors";
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
        println("Do you pick rock, paper, or scissors?");

        String playerChoice = scanner.nextLine();


        if (!isValid(playerChoice)) {
            println("Move not recognized! Please try again.");
            return;
        }
        String computerMoveChoice = getComputerMoveChoice();
        println("The computer chose: " + computerMoveChoice);
        if (playerChoice.equals(computerMoveChoice)) {
            println("It's a tie!");
        } else if (playerChoice.equals(ROCK) && computerMoveChoice.equals(PAPER)) {
            println("Paper beats rock. The computer wins!");

        } else if (playerChoice.equals(ROCK) && computerMoveChoice.equals(SCISSORS)) {
            println("Rock beats scissors. Player wins!");
        } else if (playerChoice.equals(PAPER) && computerMoveChoice.equals(ROCK)) {
            println("Paper beats rock. Player wins!");
        } else if (playerChoice.equals(PAPER) && computerMoveChoice.equals(SCISSORS)) {
            println("Scissors beats paper. The computer wins!");
        } else if (playerChoice.equals(SCISSORS) && computerMoveChoice.equals(ROCK)) {
            println("Rock beats scissors. The computer wins!");
        } else {
            println("Scissors beats paper. Player wins!");
        }
    }

    private String getComputerMoveChoice() {
        // Random number from 0 - 98 (0-32, 33-65, 66-98)
        int computerNumber = random.nextInt(98);

        String computerMoveChoice;
        if (computerNumber < 32) {
            computerMoveChoice = ROCK;
        } else if (computerNumber > 32 && computerNumber < 66) {
            computerMoveChoice = PAPER;
        } else {
            computerMoveChoice = SCISSORS;
        }
        return computerMoveChoice;
    }

    private boolean isValid(String playerChoice) {
        return ROCK.equals(playerChoice) ||
                PAPER.equals(playerChoice) ||
                SCISSORS.equals(playerChoice);
    }

    private void println(String str) {
        out.println(str);
    }
}
