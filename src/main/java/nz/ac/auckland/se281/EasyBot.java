package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyBot implements Bot {

  private Strategy strategy;

  public EasyBot(Choice choice) {}

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String playFinger(int round, int playerInput, boolean loss) {
    this.setStrategy(new Random());
    return strategy.chooseFinger();
  }
}
