package hu.adamsan;

import org.junit.jupiter.api.Test;

import static hu.adamsan.Choice.*;
import static org.junit.jupiter.api.Assertions.*;

class ChoiceTest {

    @Test
    void choicesAreTiedWithTheSame() {
        assertTrue(ROCK.tiesWith(ROCK));
        assertTrue(SCISSORS.tiesWith(SCISSORS));
        assertTrue(PAPER.tiesWith(PAPER));
    }

    @Test
    void choicesAreNotTiedWithADifferent() {
        assertFalse(ROCK.tiesWith(SCISSORS));
        assertFalse(SCISSORS.tiesWith(PAPER));
        assertFalse(PAPER.tiesWith(ROCK));
    }

    @Test
    void beats() {
        assertTrue(ROCK.beats(SCISSORS));
        assertTrue(SCISSORS.beats(PAPER));
        assertTrue(PAPER.beats(ROCK));
        assertFalse(SCISSORS.beats(ROCK));
        assertFalse(PAPER.beats(SCISSORS));
        assertFalse(ROCK.beats(PAPER));
    }
}