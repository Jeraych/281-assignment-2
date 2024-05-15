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
    for (int i : history) {
      if (Utils.isEven(i)) {
        even++;
      } else {
        odd++;
      }
    }

    finger = Integer.toString(Utils.getRandomNumberRange(0, 5));

    if (choice == Choice.EVEN) {
      finger = Integer.toString(Utils.getRandomOddNumber());
    } else {
      finger = Integer.toString(Utils.getRandomEvenNumber());
    }

    return finger;
  }
}
