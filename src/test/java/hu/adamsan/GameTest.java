package hu.adamsan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach()
    void cleanUp() {
        System.setOut(originalOut);
    }

    @Test
    void rock_beats_scissors_test() {
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(51L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: scissors" + SEPARATOR +
                "Rock beats scissors. Player wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void rock_ties_rock_test() {
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(1918L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: rock" + SEPARATOR +
                "It's a tie!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void rock_beats_scissors_test3() {
        String userChoice = new String("rock");
        Game g = new Game(userChoice, new Random(22L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: paper" + SEPARATOR +
                "Paper beats rock. The computer wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void paper_loses_scissors_test() {
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(51L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: scissors" + SEPARATOR +
                "Scissors beats paper. The computer wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void paper_beats_rock_test() {
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(1918L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: rock" + SEPARATOR +
                "Paper beats rock. Player wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void paper_ties_paper_test() {
        String userChoice = new String("paper");
        Game g = new Game(userChoice, new Random(191L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: paper" + SEPARATOR +
                "It's a tie!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void scissors_tie_scissors_test() {
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(51L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: scissors" + SEPARATOR +
                "It's a tie!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void scissors_loses_rock_test() {
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(1918L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: rock" + SEPARATOR +
                "Rock beats scissors. The computer wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void scissors_beats_paper_test() {
        String userChoice = new String("scissors");
        Game g = new Game(userChoice, new Random(191L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "The computer chose: paper" + SEPARATOR +
                "Scissors beats paper. Player wins!" + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }

    @Test
    void invalid_user_input_test() {
        String userChoice = new String("kislabda");
        Game g = new Game(userChoice, new Random(191L));
        g.play();

        String SEPARATOR = System.lineSeparator();

        String expected = "Do you pick rock, paper, or scissors?" + SEPARATOR +
                "Move not recognized! Please try again." + SEPARATOR;
        assertEquals(expected, outputStream.toString());
    }
}