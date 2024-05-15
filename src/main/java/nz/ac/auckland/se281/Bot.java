package nz.ac.auckland.se281;

public interface Bot {
  void setStrategy(Strategy strategy);

  String playFinger(int round, int playerInput);
}
