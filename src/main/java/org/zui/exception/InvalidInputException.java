package org.zui.exception;

/**
 * Custom Exception for Invalid Input
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(char input) {
        super("Invalid input: " + input);
    }
}
