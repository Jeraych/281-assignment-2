package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundCount;
  private String input;
  private int inputInt;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    roundCount = 0;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    roundCount++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));
    MessageCli.ASK_INPUT.printMessage();
    input = Utils.scanner.nextLine();
    try {
      inputInt = Integer.parseInt(input);
    } catch (Exception e) {
      MessageCli.INVALID_INPUT.printMessage();
    }
    if (inputInt > 5) {
      MessageCli.INVALID_INPUT.printMessage();
    }
  }

  public void endGame() {}

  public void showStats() {}
}
