package nz.ac.auckland.se281;

public class ChooseStrategy {
  private final Strategy strategy;

  public ChooseStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public String setStrategy() {
    return strategy.chooseFinger();
  }
}
