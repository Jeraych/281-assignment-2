package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Hard implements Bot {

  private Choice choice;
  private Strategy strategy;
  private List<Integer> history;
  private boolean switched = false;

  public Hard(Choice choice) {
    this.choice = choice;
    history = new ArrayList<>();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public String playFinger(int round, int playerInput, boolean loss) {

    if (round > 3) {
      if (loss) {
        switched = !switched;
      }
      if (switched) {
        this.setStrategy(new Top(choice, history));
      } else {
        this.setStrategy(new Random());
      }
    } else {
      this.setStrategy(new Random());
    }
    history.add(playerInput);
    return strategy.chooseFinger();
  }
}
