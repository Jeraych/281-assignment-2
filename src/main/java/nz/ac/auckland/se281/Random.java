package nz.ac.auckland.se281;

public class Random implements BotPlayStyle {

    @Override
    public String chooseFinger() {
        return Integer.toString(Utils.getRandomNumberRange(0, 5));
    }
    
}
