package hu.adamsan;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new Game(new Scanner(System.in), System.out, new Random()).invoke();
    }

    static class Game {

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


        void invoke() {
            println("Do you pick rock, paper, or scissors?");

            String playerChoice = scanner.nextLine();

            // Making sure that the player enters either rock, paper, or scissors
            // If they don't, move will not be recognized
            if ("rock".equals(playerChoice) ||
                    "paper".equals(playerChoice) ||
                    "scissors".equals(playerChoice)) {
            } else {
                println("Move not recognized! Please try again.");
                return;
            }

            // Random number from 0 - 98 (0-32, 33-65, 66-98)
            int computerNumber = random.nextInt(98);

            // Computer chooses a move based on a randomly generated int
            // 0-32 = rock
            // 33-66 = paper
            // 66-98 = scissors
            String computerMoveChoice;
            if (computerNumber < 32) {
                computerMoveChoice = "rock";
            } else if (computerNumber > 32 && computerNumber < 66) {
                computerMoveChoice = "paper";
            } else {
                computerMoveChoice = "scissors";
            }

            // Printing out what the computer chose
            println("The computer chose: " + computerMoveChoice);

            // Comparing the choices
            // Both choices are the same (tie)
            if (playerChoice.equals(computerMoveChoice)) {
                println("It's a tie!");
            }
            // Player choose rock --- Computer choose paper (computer wins)
            else if (playerChoice.equals("rock") && computerMoveChoice.equals("paper")) {
                println("Paper beats rock. The computer wins!");

            }
            // Player choose rock --- Computer choose scissors (player wins)
            else if (playerChoice.equals("rock") && computerMoveChoice.equals("scissors")) {
                println("Rock beats scissors. Player wins!");
            }

            // Player choose paper --- Computer choose rock (player wins)
            else if (playerChoice.equals("paper") && computerMoveChoice.equals("rock")) {
                println("Paper beats rock. Player wins!");
            }
            // Player choose paper --- Computer choose scissors (computer wins)
            else if (playerChoice.equals("paper") && computerMoveChoice.equals("scissors")) {
                println("Scissors beats paper. The computer wins!");
            }

            // Player choose scissors --- Computer choose rock (computer wins)
            else if (playerChoice.equals("scissors") && computerMoveChoice.equals("rock")) {
                println("Rock beats scissors. The computer wins!");
            }

            // Player choose scissors --- Computer choose paper (player wins)
            else {
                println("Scissors beats paper. Player wins!");
            }
        }

        private void println(String str) {
            out.println(str);
        }
    }
}