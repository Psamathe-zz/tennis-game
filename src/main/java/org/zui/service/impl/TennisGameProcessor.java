package org.zui.service.impl;

import org.zui.exception.GameNotFinishedException;
import org.zui.exception.InvalidInputException;
import org.zui.model.Game;
import org.zui.model.GameStatus;
import org.zui.model.Player;
import org.zui.service.GameProcessor;
import org.zui.service.ScoreCalculator;

import java.util.List;

public class TennisGameProcessor implements GameProcessor {
    private final ScoreCalculator scoreCalculator;

    private static final List<GameStatus> END_STATUS = List.of(GameStatus.PLAYER_WINS, GameStatus.PLAYER_LOSES);
    public TennisGameProcessor(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    @Override
    public Game processGame(String input) throws InvalidInputException, GameNotFinishedException {
        Player playerA = new Player();
        Player playerB = new Player();
        Game game = new Game(playerA, playerB);

        for (char c : input.toCharArray()) {
            scoreCalculator.calculateScore(game, c);
            System.out.println("Player A: " + game.getPlayer1().getScore() + " / Player B: " + game.getPlayer2().getScore());

            if (GameStatus.PLAYER_WINS.equals(game.getGameStatus())) {
                System.out.println("Player A wins the game");
                break;
            } else if (GameStatus.PLAYER_LOSES.equals(game.getGameStatus())) {
                System.out.println("Player B wins the game");
                break;
            } else if (game.getGameStatus() == GameStatus.BACK_TO_DEUCE) {
                System.out.println("Back to deuce");
            } else if (game.getGameStatus() == GameStatus.ADVANTAGE) {
                System.out.println("Advantage " + (c == 'A' ? "Player A" : "Player B"));
            }
        }

        if (!END_STATUS.contains(game.getGameStatus())) {
            throw new GameNotFinishedException();
        }
        return game;
    }
}
