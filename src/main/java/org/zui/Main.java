package org.zui;

import org.zui.exception.GameNotFinishedException;
import org.zui.exception.InvalidInputException;
import org.zui.service.GameProcessor;
import org.zui.service.ScoreCalculator;
import org.zui.service.impl.TennisGameProcessor;
import org.zui.service.impl.TennisScoreCalculator;

public class Main {
    public static void main(String[] args) {
        ScoreCalculator scoreCalculator = new TennisScoreCalculator();
        GameProcessor gameProcessor = new TennisGameProcessor(scoreCalculator);

        String input = "ABABAA"; // Example input

        try {
            gameProcessor.processGame(input);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (GameNotFinishedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
