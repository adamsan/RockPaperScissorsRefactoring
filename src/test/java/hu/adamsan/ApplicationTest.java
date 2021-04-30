package hu.adamsan;

import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationTest {

    @Test
    void testMain() {
        Scanner scanner = mock(Scanner.class); // Mockito cannot mock this, because it's a final class!
        when(scanner.nextLine()).thenReturn("rock");

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(10).thenThrow(new RuntimeException("Random.nextInt() called twice"));

        new Application.Game(scanner, System.out, random).invoke();
    }
}