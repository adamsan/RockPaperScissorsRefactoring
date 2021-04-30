package hu.adamsan;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new Game().invoke();
    }

    static class Game {
        void invoke() {
            System.out.println("Do you pick rock, paper, or scissors?");

            Scanner choice = new Scanner(System.in);

            String playerChoice = choice.nextLine();

            // Making sure that the player enters either rock, paper, or scissors
            // If they don't, move will not be recognized
            if ("rock".equals(playerChoice) ||
                    "paper".equals(playerChoice) ||
                    "scissors".equals(playerChoice)) {
            } else {
                System.out.println("Move not recognized! Please try again.");
            }

            Random randomNumber = new Random();
            // Random number from 0 - 98 (0-32, 33-65, 66-98)
            int computerNumber = randomNumber.nextInt(98);

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
            System.out.println("The computer chose: " + computerMoveChoice);

            // Comparing the choices
            // Both choices are the same (tie)
            if (playerChoice == computerMoveChoice) {
                System.out.println("It's a tie!");
            }
            // Player choose rock --- Computer choose paper (computer wins)
            else if (playerChoice == "rock" && computerMoveChoice == "paper") {
                System.out.println("Paper beats rock. The computer wins!");

            }
            // Player choose rock --- Computer choose scissors (player wins)
            else if (playerChoice == "rock" && computerMoveChoice == "scissors") {
                System.out.println("Rock beats scissors. Player wins!");
            }

            // Player choose paper --- Computer choose rock (player wins)
            else if (playerChoice == "paper" && computerMoveChoice == "rock") {
                System.out.println("Paper beats rock. Player wins!");
            }
            // Player choose paper --- Computer choose scissors (computer wins)
            else if (playerChoice == "paper" && computerMoveChoice == "scissors") {
                System.out.println("Scissors beats paper. The computer wins!");
            }

            // Player choose scissors --- Computer choose rock (computer wins)
            else if (playerChoice == "scissors" && computerMoveChoice == "rock") {
                System.out.println("Rock beats scissors. The computer wins!");
            }

            // Player choose scissors --- Computer choose paper (player wins)
            else {
                System.out.println("Scissors beats paper. Player wins!");
            }
        }
    }
}