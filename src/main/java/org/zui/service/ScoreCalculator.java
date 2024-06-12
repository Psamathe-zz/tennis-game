package org.zui.service;

import org.zui.exception.InvalidInputException;
import org.zui.model.Game;

public interface ScoreCalculator {
    void calculateScore(Game game, char input) throws InvalidInputException;
}
