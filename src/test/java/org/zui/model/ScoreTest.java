package org.zui.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    @Test
    public void testNextScore() {
        assertEquals(Score.FIFTEEN, Score.nextScore(Score.ZERO));
        assertEquals(Score.THIRTY, Score.nextScore(Score.FIFTEEN));
        assertEquals(Score.FORTY, Score.nextScore(Score.THIRTY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNextScoreFromForty() {
        Score.nextScore(Score.FORTY);
    }
}