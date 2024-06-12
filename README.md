# Tennis Game

This project implements a simple tennis scoring system in Java. The scoring system follows standard tennis rules including handling of deuce and advantage.

## Features

- Tracks and displays scores for two players (Player A and Player B).
- Handles scoring according to tennis rules: 0, 15, 30, 40, deuce, advantage.
- Supports handling of different game states: ready to start, player wins, player loses, back to deuce, advantage, continue.

## Installation

1. **Installation**: Ensure you have Java Development Kit (JDK) installed.
2. **Clone the repository**:
   ```bash
   git clone git@github.com:Psamathe-zz/tennis-game.git
3. **Run the program**:
- Open the project in your preferred Integrated Development Environment (IDE).
- Run the `Main` class to see how the game progresses based on input sequences like "ABABAA" (where 'A' represents actions by Player A and 'B' by Player B).
4. **Testing**:
- The project includes JUnit tests to validate the functionality of the Tennis Score Calculator and Game Processor components.
- Navigate to `src/test/java` directory and run `TennisScoreCalculatorTest` and `TennisGameProcessorTest` classes.