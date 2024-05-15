package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundCount;
  private String input;
  private int inputInt;
  private String playerName;
  private boolean inputInvalid;
  private final String ROBOT_NAME = "HAL-9000";
  private String botInput;
  private int botInputInt;
  private Choice played;
  private int roundSum;
  private Difficulty level;
  private Bot HAL9000;
  private boolean playerWon;
  private boolean gameStart = false;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    roundCount = 0;
    playerName = options[0];
    played = choice;
    level = difficulty;
    HAL9000 = BotFactory.createBot(level, choice);
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    gameStart = true;
  }

  public void play() {
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // start round number
    roundCount++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));

    // asking player for input between 0 to 5
    inputInvalid = true;
    while (inputInvalid) {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      try {
        inputInt = Integer.parseInt(input);
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      if (inputInt < 0 || inputInt > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      inputInvalid = false;
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

    // HAL-9000 plays a finger
    botInput = HAL9000.playFinger(roundCount, inputInt, playerWon);
    MessageCli.PRINT_INFO_HAND.printMessage(ROBOT_NAME, botInput);

    // Determine round winner
    botInputInt = Integer.parseInt(botInput);
    roundSum = inputInt + botInputInt;

    // round when number is EVEN, wins by choosing EVEN
    if (Utils.isEven(roundSum)) {
      if (played == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "EVEN", playerName);
        playerWon = true;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "EVEN", ROBOT_NAME);
        playerWon = false;
      }
    }

    // round when number is ODD, wins by choosing ODD
    if (Utils.isOdd(roundSum)) {
      if (played == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "ODD", playerName);
        playerWon = true;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "ODD", ROBOT_NAME);
        playerWon = false;
      }
    }
  }

  public void endGame() {
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
  }

  public void showStats() {
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
  }
}
