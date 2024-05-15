package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundCount;
  private String input;
  private int inputInt;
  private String playerName;
  private boolean inputInvalid;
  private String botName = "HAL-9000";
  private String botInput;
  private int botInputInt;
  private Choice played;
  private int roundSum;
  private Difficulty level;
  private Bot bot;
  private boolean playerWon;
  private boolean gameStart = false;
  private int roundWonPlayer;
  private int roundWonBot;

  /**
   * Starts a blank new game even if there is already one started, resets everything to initial
   * state and declare the difficulty and win condition chosen by the player, stores the player's
   * name.
   *
   * @param difficulty how difficult the player wishes to play against the bot
   * @param choice how the player would like to play in order to win a round
   * @param options name of the player
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    // starting a new game by resetting everything to initial
    roundCount = 0;
    playerName = options[0];
    played = choice;
    level = difficulty;
    bot = BotFactory.createBot(level, choice);
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    gameStart = true;
    roundWonPlayer = 0;
    roundWonBot = 0;
  }

  /**
   * Plays a round of game if the game has been started. Displays the number of rounds played and
   * asks the player to enter a number between 0 and 5 to play a finger. The bot plays a finger
   * after the player. Determines the winner of the current round.
   */
  public void play() {
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // start round number
    roundCount++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundCount));

    // asking player for input between 0 to 5
    inputInvalid = true;
    while (inputInvalid) {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      try {
        inputInt = Integer.parseInt(input);
      } catch (Exception e) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      if (inputInt < 0 || inputInt > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      inputInvalid = false;
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, input);

    // HAL-9000 plays a finger
    botInput = bot.playFinger(roundCount, inputInt, playerWon);
    MessageCli.PRINT_INFO_HAND.printMessage(botName, botInput);

    // Determine round winner
    botInputInt = Integer.parseInt(botInput);
    roundSum = inputInt + botInputInt;

    // round when number is EVEN, player wins by choosing EVEN
    if (Utils.isEven(roundSum)) {
      if (played == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "EVEN", playerName);
        playerWon = true;
        roundWonPlayer++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "EVEN", botName);
        playerWon = false;
        roundWonBot++;
      }
    }

    // round when number is ODD, player wins by choosing ODD
    if (Utils.isOdd(roundSum)) {
      if (played == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "ODD", playerName);
        playerWon = true;
        roundWonPlayer++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(roundSum), "ODD", botName);
        playerWon = false;
        roundWonBot++;
      }
    }
  }

  /**
   * Cannot end a game if none has been started. Shows the results/stats of the current game played
   * so far, then determine the winner of game with all the rounds played, possible tie if both the
   * player and bot wins equal amount of rounds.
   */
  public void endGame() {
    // detect unstarted game
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    this.showStats();

    // detect if player is the winner
    if (roundWonPlayer > roundWonBot) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
      gameStart = false;
      return;
    }

    // detect if HAL9000 is the winner
    if (roundWonBot > roundWonPlayer) {
      MessageCli.PRINT_END_GAME.printMessage(botName);
      gameStart = false;
      return;
    }

    // if game is a tie
    MessageCli.PRINT_END_GAME_TIE.printMessage();
    gameStart = false;
  }

  /**
   * Displays error message if the game has not been started. Displays the number of games won by
   * the player and the bot
   */
  public void showStats() {
    // detect unstarted game
    if (!gameStart) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // display message of rounds won by player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName,
        Integer.toString(roundWonPlayer),
        Integer.toString(roundCount - roundWonPlayer));

    // display message of rounds won by HAL9000
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        botName, Integer.toString(roundWonBot), Integer.toString(roundCount - roundWonBot));
  }
}
