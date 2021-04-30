package hu.adamsan;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationTest {

    @Test
    void testMain() {
        MyScanner scanner = mock(MyScanner.class);
        when(scanner.nextLine()).thenReturn("rock");

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(10).thenThrow(new RuntimeException("Random.nextInt() called twice"));

        var out = new RememberingPrintStream(System.out);

        new Application.Game(scanner, out, random).invoke();
        String expected = "";
        assertEquals(expected, out.getContent());
    }

}