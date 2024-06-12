package org.zui.model;

public class Player {
    private Score score;
    private boolean hasAdvantage;

    public Player() {
        this.score = Score.ZERO;
        this.hasAdvantage = false;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public boolean hasAdvantage() {
        return hasAdvantage;
    }

    public void setAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }

    public boolean isEqualToFORTY() {
        return score.getValue() == Score.FORTY.getValue();
    }

    public boolean isLessThanFORTY() {
        return score.getValue() < Score.FORTY.getValue();
    }
}
