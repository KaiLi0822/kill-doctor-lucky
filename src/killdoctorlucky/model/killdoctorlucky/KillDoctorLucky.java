package killdoctorlucky.model.killdoctorlucky;

import java.io.IOException;
import java.util.List;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.space.Space;

/**
 * The KillDoctorLucky game interface.
 */
public interface KillDoctorLucky extends KillDoctorLuckyViewModel {

  /**
   * Sets the mansion.
   * 
   * @param mansionName   the mansionName
   * @param mansionHeight the mansionHeight
   * @param mansionWidth  the mansionWidth
   */
  void setMansion(String mansionName, int mansionHeight, int mansionWidth);

  /**
   * Sets the setDoctorLucky.
   * 
   * @param doctorName   the doctorName
   * @param doctorHealth the doctorHealth
   */
  void setDoctorLucky(String doctorName, int doctorHealth);

  /**
   * Sets the maximum number of turns.
   * 
   * @param maxTurnIn the maximum number
   */
  void setMaxTurn(int maxTurnIn);

  /**
   * Adds the player.
   * 
   * @param playerType the playerType
   * @param playerName the playerName
   * @param spaceIndex the spaceIndex
   * @param maxItem    the maxItem
   */
  void addPlayer(PlayerType playerType, String playerName, int spaceIndex, int maxItem);

  /**
   * Gets the players information.
   * 
   * @return the players information
   */
  String getPlayersInfo();

  /**
   * Initiate the game.
   * 
   * @param readable the specification of the game
   */
  void initiateGame(Readable readable);

  /**
   * Draws the map.
   * 
   * @return the map file path
   * @throws IOException if map generating failed throw an IOException
   */
  String outputMap() throws IOException;

  /**
   * Moves player.
   * 
   * @param playerName  the player name
   * @param targetSpace the target space
   */
  void movePlayer(String playerName, int targetSpace);

  /**
   * Picks up item.
   * 
   * @param player the player
   * @param item   the item
   */
  void pickUpItem(String player, String item);

  /**
   * Gets the mansion information.
   * 
   * @return the mansion information
   */
  String getMansionInfo();

  /**
   * Gets the neighbors.
   * 
   * @param index space index
   * @return the neighbors
   */
  List<Space> getNeighborsBySpaceIndex(int index);

  /**
   * Gets the space name by index.
   * 
   * @param index the index
   * @return the space name
   */
  String getSpaceNameByIndex(int index);

  /**
   * Gets space info.
   * 
   * @param index the index
   * @return space info
   */
  String getSpaceInfo(int index);

  /**
   * Sets the pet.
   * 
   * @param petName the pet name
   */
  void setPet(String petName);

  /**
   * Gets the number of space.
   * 
   * @return space number
   */
  int getSpaceNumFromMansion();

  /**
   * Moves the pet.
   * 
   * @param index the space index
   */
  void movePet(int index);

  /**
   * Gets the item name with the most damage.
   * 
   * @param playerName the player name
   * @return the item name
   */
  String getMostDamageItemNameByPlayerName(String playerName);

  /**
   * Player makes an attempt with item.
   * 
   * @param playerName the player name
   * @param itemName   the item name
   * @return true if the attempt was done else false
   */
  Boolean makeAttempt(String playerName, String itemName);

  /**
   * Gets pet info.
   * 
   * @return pet info
   */
  String getPetInfo();

  /**
   * Gets the limited neighbors info.
   * 
   * @param spaceIndex the space index
   * @return the neighbors info
   */
  String getNeighborsInfoBySpaceIndex(int spaceIndex);

  /**
   * Gets the limited items info.
   * 
   * @param spaceIndex the space index
   * @return the items info
   */
  String getItemsInfoBySpaceIndex(int spaceIndex);
}
