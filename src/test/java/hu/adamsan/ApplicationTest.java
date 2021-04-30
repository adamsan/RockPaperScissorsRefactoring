package hu.adamsan;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationTest {

    @Test
    void rockTiesWithRock() {
        MyScanner scanner = mock(MyScanner.class);
        when(scanner.nextLine()).thenReturn("rock");

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(10).thenThrow(new RuntimeException("Random.nextInt() called twice"));

        var out = new RememberingPrintStream(System.out);

        new Application.Game(scanner, out, random).invoke();
        String expected = "Do you pick rock, paper, or scissors?\n" +
                "The computer chose: rock\n" +
                "It's a tie!";
        assertEquals(expected, out.getContent());
    }

    @Test
    void paperTiesWithPaper() {
        MyScanner scanner = mock(MyScanner.class);
        when(scanner.nextLine()).thenReturn("paper");

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(50).thenThrow(new RuntimeException("Random.nextInt() called twice"));

        var out = new RememberingPrintStream(System.out);

        new Application.Game(scanner, out, random).invoke();
        String expected = "Do you pick rock, paper, or scissors?\n" +
                "The computer chose: paper\n" +
                "It's a tie!";
        assertEquals(expected, out.getContent());
    }

    @Test
    void scissorsTiesWithScissors() {
        MyScanner scanner = mock(MyScanner.class);
        when(scanner.nextLine()).thenReturn("scissors");

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(90).thenThrow(new RuntimeException("Random.nextInt() called twice"));

        var out = new RememberingPrintStream(System.out);

        new Application.Game(scanner, out, random).invoke();
        String expected = "Do you pick rock, paper, or scissors?\n" +
                "The computer chose: scissors\n" +
                "It's a tie!";
        assertEquals(expected, out.getContent());
    }
}