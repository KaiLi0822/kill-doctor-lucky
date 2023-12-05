package killdoctorlucky.controller;

import java.util.List;

/**
 * Represents a Controller Interface used by View.
 */
public interface KillDoctorLuckyControllerFeature {

  /**
   * Starts the game.
   */
  void startGame();

  /**
   * Starts the game given a new mansion specification file.
   * 
   * @param mansionFile the mansion file
   */
  void startGame(String mansionFile);

  /**
   * Moves the player.
   * 
   * @param playerName the player name
   * @param spaceIndex the space index
   * @return the coordinate of space
   */
  int[] movePlayer(String playerName, int spaceIndex);

  /**
   * Picks up an item.
   * 
   * @param playerName the player name
   * @param itemName   the item name
   * @return the result of picking
   */
  Boolean pickUpItem(String playerName, String itemName);

  /**
   * Moves the pet.
   * 
   * @param spaceIndex the target space index
   */
  void movePet(int spaceIndex);

  /**
   * Makes an attempt.
   * 
   * @param playerName the player name
   * @param itemName   the item name
   * @return the results of making, true if the attempt is successful else false
   */
  Boolean makeAttempt(String playerName, String itemName);

  /**
   * Determines if the game is over.
   * 
   * @return true if the game is over
   */
  Boolean isGameOver();

  /**
   * Gets the winner's name.
   * 
   * @return the name
   */
  String getWinner();

  /**
   * Gets the robot selection.
   * 
   * @return the selection
   */
  List<String> robotTurn();
}
