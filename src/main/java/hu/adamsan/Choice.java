package hu.adamsan;

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
}