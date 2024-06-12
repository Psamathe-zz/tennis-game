package org.zui.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.zui.exception.InvalidInputException;
import org.zui.model.Game;
import org.zui.model.GameStatus;
import org.zui.model.Player;

import static org.junit.Assert.assertEquals;

public class TennisScoreCalculatorTest  {
    private TennisScoreCalculator calculator;

    @Before
    public void setUp() {
        calculator = new TennisScoreCalculator();
    }

    @Test
    public void testCalculateScore_PlayerAWins() throws InvalidInputException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        // Player A wins the game
        calculator.calculateScore(game, 'A');  // 15-0
        calculator.calculateScore(game, 'B');  // 15-15
        calculator.calculateScore(game, 'A');  // 30-15
        calculator.calculateScore(game, 'B');  // 30-30
        calculator.calculateScore(game, 'A');  // 40-30
        calculator.calculateScore(game, 'A');  // Player A wins

        assertEquals(GameStatus.PLAYER_WINS, game.getGameStatus());
    }

    @Test
    public void testCalculateScore_PlayerBWins() throws InvalidInputException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        // Player B wins the game
        calculator.calculateScore(game, 'B');  // 15-0
        calculator.calculateScore(game, 'A');  // 15-15
        calculator.calculateScore(game, 'B');  // 30-15
        calculator.calculateScore(game, 'A');  // 30-30
        calculator.calculateScore(game, 'B');  // 40-30
        calculator.calculateScore(game, 'B');  // Player B wins

        assertEquals(GameStatus.PLAYER_LOSES, game.getGameStatus());
    }

    @Test
    public void testCalculateScore_BackToDeuce() throws InvalidInputException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        // Back to deuce
        calculator.calculateScore(game, 'A');  // 15-0
        calculator.calculateScore(game, 'B');  // 15-15
        calculator.calculateScore(game, 'A');  // 30-15
        calculator.calculateScore(game, 'B');  // 30-30
        calculator.calculateScore(game, 'A');  // 40-30
        calculator.calculateScore(game, 'B');  // Deuce
        calculator.calculateScore(game, 'A');  // Advantage Player A
        calculator.calculateScore(game, 'B');  // Deuce
        calculator.calculateScore(game, 'A');  // Advantage Player A
        calculator.calculateScore(game, 'A');  // Player A wins

        assertEquals(GameStatus.PLAYER_WINS, game.getGameStatus());
    }

    @Test
    public void testCalculateScore_AdvantagePlayerB() throws InvalidInputException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        // Advantage for Player B
        calculator.calculateScore(game, 'A');  // 15-0
        calculator.calculateScore(game, 'B');  // 15-15
        calculator.calculateScore(game, 'A');  // 30-15
        calculator.calculateScore(game, 'B');  // 30-30
        calculator.calculateScore(game, 'A');  // 40-30
        calculator.calculateScore(game, 'B');  // Deuce
        calculator.calculateScore(game, 'A');  // Advantage Player A
        calculator.calculateScore(game, 'B');  // Deuce
        calculator.calculateScore(game, 'B');  // Advantage Player B
        calculator.calculateScore(game, 'B');  // Player B wins

        assertEquals(GameStatus.PLAYER_LOSES, game.getGameStatus());
    }

    @Test(expected = InvalidInputException.class)
    public void testCalculateScore_InvalidInput() throws InvalidInputException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        // Invalid input
        calculator.calculateScore(game, 'C');
    }
}