package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  /**
   * Creates a HAL9000 bot to be played against based on levels specified by enum Difficulty and
   * enum Choice determines the player's win condition so the bot knows how to play against the
   * player.
   *
   * @param level the level of difficulty of bot created
   * @param choice the win condition of the player
   * @return Bot
   */
  public static Bot createBot(Difficulty level, Choice choice) {
    // creates different level of HAL9000 depends on input
    switch (level) {
      case EASY:
        return new EasyBot(choice);
      case MEDIUM:
        return new MediumBot(choice);
      case HARD:
        return new HardBot(choice);

      default:
        System.err.println("Choose between EASY, MEDIUM, and HARD");
        System.exit(0);
    }
    return null;
  }
}
