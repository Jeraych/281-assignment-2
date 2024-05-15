package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  public static Bot createBot(Difficulty level, Choice choice) {
    switch (level) {
      case EASY:
        return new Easy(level, choice);
      case MEDIUM:
        return new Medium(level, choice);
      case HARD:
        return new Hard(level, choice);

      default:
        System.err.println("Choose between EASY, MEDIUM, and HARD");
        System.exit(0);
    }
    return null;
  }
}
