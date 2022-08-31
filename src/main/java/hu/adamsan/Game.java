package hu.adamsan;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

class Game {

    public static final String ROCK = "rock";
    public static final String SCISSORS = "scissors";
    public static final String PAPER = "paper";

    private final Random random;
    private Scanner scanner;
    private String userChoice;

    public Game() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public Game(String userChoice, Random random) {
        this.userChoice = userChoice;
        scanner = new Scanner(System.in);
        this.random = random;
    }

    private static boolean isValidChoice(String playerChoice) {
        return ROCK.equals(playerChoice) ||
                PAPER.equals(playerChoice) ||
                SCISSORS.equals(playerChoice);
    }

    private static String getComputerMoveChoice(int computerNumber) {
        String[] choices = {ROCK, PAPER, SCISSORS};
        return choices[computerNumber];
    }

    public void play() {
        println("Do you pick rock, paper, or scissors?");

        String playerChoice = getPlayerChoice();

        if (!isValidChoice(playerChoice)) {
            println("Move not recognized! Please try again.");
            return;
        }

        int computerNumber = random.nextInt(3);
        String computerMoveChoice = getComputerMoveChoice(computerNumber);

        println("The computer chose: " + computerMoveChoice);

        printResults(playerChoice, computerMoveChoice);
    }

    private void printResults(String playerChoice, String computerMoveChoice) {
        if (Objects.equals(playerChoice, computerMoveChoice)) {
            println("It's a tie!");
        } else if (ROCK.equals(playerChoice) && PAPER.equals(computerMoveChoice)) {
            println("Paper beats rock. The computer wins!");

        } else if (ROCK.equals(playerChoice) && SCISSORS.equals(computerMoveChoice)) {
            println("Rock beats scissors. Player wins!");
        } else if (PAPER.equals(playerChoice) && ROCK.equals(computerMoveChoice)) {
            println("Paper beats rock. Player wins!");
        } else if (PAPER.equals(playerChoice) && SCISSORS.equals(computerMoveChoice)) {
            println("Scissors beats paper. The computer wins!");
        } else if (SCISSORS.equals(playerChoice) && ROCK.equals(computerMoveChoice)) {
            println("Rock beats scissors. The computer wins!");
        } else {
            println("Scissors beats paper. Player wins!");
        }
    }

    private String getPlayerChoice() {
        return (userChoice == null) ? scanner.nextLine() : userChoice;
    }

    private void println(String line) {
        System.out.println(line);
    }
}
