package hu.adamsan;

import java.util.Scanner;

public class MyScanner {
    private final Scanner scanner;

    public MyScanner(Scanner scanner){
        this.scanner = scanner;
    }

    public String nextLine(){
        return scanner.nextLine();
    }
}
