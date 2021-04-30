package hu.adamsan;

import java.util.Locale;

public enum Choice {
    ROCK, PAPER, SCISSORS;

    boolean tiesWith(Choice other) {
        return this == other;
    }

    public boolean beats(Choice other) {
        return switch (this) {
            case ROCK -> other == SCISSORS;
            case PAPER -> other == ROCK;
            case SCISSORS -> other == PAPER;
        };
    }

    public String capitalize() {
        String s = this.toString();
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public String toLowerCase() {
        return this.toString().toLowerCase();
    }
}