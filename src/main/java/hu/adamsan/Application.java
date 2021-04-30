package hu.adamsan;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            new Game(scanner, System.out, new Random()).play();
        }
    }

}