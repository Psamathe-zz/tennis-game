package org.zui.service.impl;

import org.zui.exception.InvalidInputException;
import org.zui.model.Game;
import org.zui.model.GameStatus;
import org.zui.model.Player;
import org.zui.model.Score;
import org.zui.service.ScoreCalculator;

public class TennisScoreCalculator implements ScoreCalculator {

    @Override
    public void calculateScore(Game game, char input) throws InvalidInputException {
        Player player = game.getPlayer1();
        Player opponent = game.getPlayer2();

        if (input != 'A' && input != 'B') {
            throw new InvalidInputException(input);
        }

        if (input == 'B') {
            player = game.getPlayer2();
            opponent = game.getPlayer1();
        }

        if (player.isEqualToFORTY() && opponent.isLessThanFORTY()) {
            game.setGameStatus(player == game.getPlayer1() ? GameStatus.PLAYER_WINS : GameStatus.PLAYER_LOSES);
        } else if (player.isEqualToFORTY() && opponent.isEqualToFORTY()) {
            if (player.hasAdvantage()) {
                game.setGameStatus(player == game.getPlayer1() ? GameStatus.PLAYER_WINS : GameStatus.PLAYER_LOSES);
            } else if (opponent.hasAdvantage()) {
                opponent.setAdvantage(false);
                game.setGameStatus(GameStatus.BACK_TO_DEUCE);
            } else {
                player.setAdvantage(true);
                game.setGameStatus(GameStatus.ADVANTAGE);
            }
        } else {
            player.setScore(Score.nextScore(player.getScore()));
            game.setGameStatus(GameStatus.CONTINUE);
        }
    }
}
