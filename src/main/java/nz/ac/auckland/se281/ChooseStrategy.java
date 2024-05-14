package nz.ac.auckland.se281;

public class ChooseStrategy {
    private final BotPlayStyle strategy;

    public ChooseStrategy(BotPlayStyle strategy) {
        this.strategy = strategy;
    }

    public String playFinger() {
        return strategy.chooseFinger();
    }
}
