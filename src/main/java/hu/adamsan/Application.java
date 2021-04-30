package hu.adamsan;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new Game(new Scanner(System.in), System.out, new Random()).play();
    }

}