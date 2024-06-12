package org.zui.exception;

/**
 * Custom Exception for Unfinished Game
 */
public class GameNotFinishedException extends Exception {
    public GameNotFinishedException() {
        super("The game has not finished. More input is needed.");
    }
}
