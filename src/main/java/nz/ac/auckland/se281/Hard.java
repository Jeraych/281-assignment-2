package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Hard implements Bot {

  private Choice choice;
  private Strategy strategy;
  private List<Integer> history;

  public Hard(Choice choice) {
    this.choice = choice;
    history = new ArrayList<>();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String playFinger(int round, int playerInput) {

    if (round > 3) {
      this.setStrategy(new Top(choice, history));
    } else {
      this.setStrategy(new Random());
    }
    history.add(playerInput);
    return strategy.chooseFinger();
  }
}
