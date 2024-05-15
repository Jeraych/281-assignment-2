package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  public static Bot createBot(Difficulty level, Choice choice) {
    // creates different level of HAL9000 depends on input
    switch (level) {
      case EASY:
        return new Easy(choice);
      case MEDIUM:
        return new Medium(choice);
      case HARD:
        return new Hard(choice);

      default:
        System.err.println("Choose between EASY, MEDIUM, and HARD");
        System.exit(0);
    }
    return null;
  }
}
