package org.zui.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void setUp() {
        player1 = new Player();
        player2 = new Player();
        game = new Game(player1, player2);
    }

    @Test
    public void testInitialization() {
        assertEquals(player1, game.getPlayer1());
        assertEquals(player2, game.getPlayer2());
        assertEquals(GameStatus.READY_TO_START, game.getGameStatus());
    }

    @Test
    public void testSetGameStatus() {
        game.setGameStatus(GameStatus.PLAYER_WINS);
        assertEquals(GameStatus.PLAYER_WINS, game.getGameStatus());
    }
}
