package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Easy implements Bot {

  private Choice choice;
  private Strategy strategy;

  public Easy(Choice choice) {
    this.choice = choice;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String playFinger(int round, int playerInput, boolean loss) {
    this.setStrategy(new Random());
    return strategy.chooseFinger();
  }
}
