package org.zui.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.zui.exception.GameNotFinishedException;
import org.zui.exception.InvalidInputException;
import org.zui.model.Game;
import org.zui.model.GameStatus;
import org.zui.service.ScoreCalculator;

import static org.junit.Assert.assertEquals;

public class TennisGameProcessorTest {
    private TennisGameProcessor processor;

    @Before
    public void setUp() {
        ScoreCalculator calculator = new TennisScoreCalculator();
        processor = new TennisGameProcessor(calculator);
    }

    @Test
    public void testProcessGame_PlayerAWins() throws InvalidInputException, GameNotFinishedException {
        // Player A wins
        String input = "ABABAA";
        Game game = processor.processGame(input);
        assertEquals(GameStatus.PLAYER_WINS, game.getGameStatus());
    }

    @Test
    public void testProcessGame_PlayerBWins() throws InvalidInputException, GameNotFinishedException {
        // Player B wins
        String input = "BABABB";
        Game game = processor.processGame(input);
        assertEquals(GameStatus.PLAYER_LOSES, game.getGameStatus());
    }

    @Test(expected = GameNotFinishedException.class)
    public void testProcessGame_BackToDeuce() throws InvalidInputException, GameNotFinishedException {
        // Back to deuce
        String input = "ABABABABAB";
        Game game = processor.processGame(input);
        assertEquals(GameStatus.BACK_TO_DEUCE, game.getGameStatus());
    }

    @Test(expected = GameNotFinishedException.class)
    public void testProcessGame_AdvantagePlayerA() throws InvalidInputException, GameNotFinishedException {
        // Advantage for Player A
        String input = "ABABABABA";
        Game game = processor.processGame(input);
        assertEquals(GameStatus.ADVANTAGE, game.getGameStatus());
    }

    @Test(expected = GameNotFinishedException.class)
    public void testProcessGame_GameNotFinished() throws InvalidInputException, GameNotFinishedException {
        // Game not finished
        String input = "ABAB";
        Game game = processor.processGame(input);
    }
}
