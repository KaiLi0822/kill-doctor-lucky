package killdoctorlucky.model.killdoctorlucky;

import java.io.IOException;
import java.util.List;

import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.space.Space;

/**
 * The KillDoctorLucky game interface.
 */
public interface KillDoctorLucky {

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
   * Gets the player information by the name.
   * 
   * @param name the player name
   * @return the player information
   */
  String getPlayerInfoByName(String name);

  /**
   * Gets the maximum number of turns.
   * 
   * @return the maximum number of turns
   */
  int getMaxTurn();

  /**
   * Gets the player name by turn.
   * 
   * @param index the turn index
   * @return the player name
   */
  String getPlayerNameByTurn(int index);


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
   * @param player the player name
   * @param targetSpace the target space
   */
  void movePlayer(String playerName, int targetSpace);
  
  /**
   * Picks up item.
   * @param player the player
   * @param item the item
   */
  void pickUpItem(String player, String item);
  
  /**
   * Gets around info.
   * @param playerName the player
   * @return around info
   */
  String getAroundInfo(String playerName);
  
  /**
   * Gets current turn.
   * @return current turn
   */
  int getTurns();
  
  /**
   * Gets the mansion information.
   * @return the mansion information
   */
  String getMansionInfo();
  
  /**
   * Gets the doctor information.
   * @return the doctor information
   */
  String getDoctorLuckyInfo();
  
  /**
   * Gets the player's space index.
   * @return the player's space index
   */
  int getCurrentSpaceIndexByPlayerName(String playerName);
  
  /**
   * Gets the neighbors.
   * @param index space index
   * @return the neighbors
   */
  List<Space> getNeighborsBySpaceIndex(int index);
  
  /**
   * Gets the items.
   * @param index space index
   * @return the items
   */
  List<Item> getItemsBySpaceIndex(int index);
  
  
  /**
   * Gets the player type.
   * @param playerName player name.
   * @return the player type
   */
  PlayerType gePlayerTypeByName(String playerName);
  
  /**
   * Gets the doctor's name.
   * @return doctor's name
   */
  String getDoctorLuckyName();
  
  /**
   * Gets the doctor's space index.
   * @return doctor's space index
   */
  int getDoctorLuckyCurrentSpaceIndex();
  
  /**
   * Gets the doctor's health.
   * @return doctor's health
   */
  int getDoctorLuckyHealth();
  
  /**
   * Gets the space name by index.
   * @param index the index
   * @return the space name
   */
  String getSpaceNameByIndex(int index);
  
  /**
   * Gets space info.
   * @param index the index
   * @return space info
   */
  String getSpaceInfo(int index);
  
  /**
   * Sets the pet.
   * @param petName the pet name
   */
  void setPet(String petName);
  
  /**
   * Gets the pet's name.
   * @return pet's name
   */
  String getPetName();
  
  /**
   * Gets the pet's space index.
   * @return pet's space index
   */
  int getPetCurrentSpaceIndex();
  
  /**
   * Gets the number of space.
   * @return space number
   */
  int getSpaceNumFromMansion();
  
  /**
   * Moves the pet.
   * @param index the space index
   */
  void movePet(int index);
  
  /**
   * Gets the items.
   * @param playerName player name
   * @return the items
   */
  List<Item> getItemsByPlayerName(String name);
  
  String getMostDamageItemNameByPlayerName(String playerName);
  
}
