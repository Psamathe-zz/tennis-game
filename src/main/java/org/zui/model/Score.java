package org.zui.model;

public enum Score {
    ZERO(0), FIFTEEN(15), THIRTY(30), FORTY(40);

    private final int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Score nextScore(Score currentScore) {
        switch (currentScore) {
            case ZERO:
                return FIFTEEN;
            case FIFTEEN:
                return THIRTY;
            case THIRTY:
                return FORTY;
            default:
                throw new IllegalArgumentException("Cannot determine next score for " + currentScore);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
