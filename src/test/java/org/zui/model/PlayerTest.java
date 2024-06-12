package org.zui.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testInitialScore() {
        Player player = new Player();
        assertEquals(Score.ZERO, player.getScore());
        assertFalse(player.hasAdvantage());
    }

    @Test
    public void testSetScore() {
        Player player = new Player();
        player.setScore(Score.FIFTEEN);
        assertEquals(Score.FIFTEEN, player.getScore());
    }

    @Test
    public void testAdvantage() {
        Player player = new Player();
        player.setAdvantage(true);
        assertTrue(player.hasAdvantage());
    }
}
