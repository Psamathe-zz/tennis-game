package org.zui.service;

import org.zui.exception.GameNotFinishedException;
import org.zui.exception.InvalidInputException;
import org.zui.model.Game;

public interface GameProcessor {
    Game processGame(String input) throws InvalidInputException, GameNotFinishedException;
}
