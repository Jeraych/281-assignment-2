package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy {

  private Choice choice;
  private List<Integer> history;
  private int even;
  private int odd;
  private String finger;

  public Top(Choice choice, List<Integer> history) {
    this.choice = choice;
    this.history = history;
  }

  @Override
  public String chooseFinger() {
    // count how many evens and odds player has played
    for (int i : history) {
      if (Utils.isEven(i)) {
        even++;
      } else {
        odd++;
      }
    }

    // if evens and odds are same amount, play random between 0 and 5
    finger = Integer.toString(Utils.getRandomNumberRange(0, 5));

    // play against the player's choice
    if (even > odd) {
      if (choice == Choice.EVEN) {
        finger = Integer.toString(Utils.getRandomOddNumber());
      } else {
        finger = Integer.toString(Utils.getRandomEvenNumber());
      }
    }
    if (odd > even) {
      if (choice == Choice.EVEN) {
        finger = Integer.toString(Utils.getRandomEvenNumber());
      } else {
        finger = Integer.toString(Utils.getRandomOddNumber());
      }
    }

    return finger;
  }
}
