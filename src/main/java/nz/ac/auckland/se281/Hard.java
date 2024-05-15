package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class Hard implements Bot {

  private Difficulty level;
  private Choice choice;
  private Strategy strategy;

  public Hard(Difficulty level, Choice choice) {
    this.level = level;
    this.choice = choice;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String playFinger(int round, int playerInput) {
    if (round > 3) {
      this.setStrategy(new Top());
    } else {
      this.setStrategy(new Random());
    }

    return strategy.chooseFinger();
  }
}
