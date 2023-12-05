package killdoctorlucky.model.killdoctorlucky;

import java.util.List;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.space.Space;

/**
 * The KillDoctorLucky game interface.
 */
public interface KillDoctorLuckyViewModel {
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
   * Gets the player information by the name.
   * 
   * @param name the player name
   * @return the player information
   */
  String getPlayerInfoByName(String name);

  /**
   * Gets around info.
   * 
   * @param playerName the player
   * @return around info
   */
  String getAroundInfo(String playerName);

  /**
   * Gets the doctor's health.
   * 
   * @return doctor's health
   */
  int getDoctorLuckyHealth();

  /**
   * Gets the player's space index.
   * 
   * @param playerName playerName
   * @return the player's space index
   */
  int getCurrentSpaceIndexByPlayerName(String playerName);

  /**
   * Gets the player type.
   * 
   * @param playerName player name.
   * @return the player type
   */
  PlayerType getPlayerTypeByName(String playerName);

  /**
   * Gets the width.
   * 
   * @return width
   */
  int getWidthFromMansion();

  /**
   * Gets the height.
   * 
   * @return height
   */
  int getHeightFromMansion();

  /**
   * Gets the spaces.
   * 
   * @return spaces
   */
  List<Space> getSpacesFromMansion();

  /**
   * Gets the doctor information.
   * 
   * @return the doctor information
   */
  String getDoctorLuckyInfo();

  /**
   * Gets the doctor's name.
   * 
   * @return doctor's name
   */
  String getDoctorLuckyName();

  /**
   * Gets the doctor's space index.
   * 
   * @return doctor's space index
   */
  int getDoctorLuckyCurrentSpaceIndex();

  /**
   * Gets the pet's name.
   * 
   * @return pet's name
   */
  String getPetName();

  /**
   * Gets the pet's space index.
   * 
   * @return pet's space index
   */
  int getPetCurrentSpaceIndex();

  /**
   * Gets the players.
   * 
   * @return players
   */
  List<Player> getPlayers();

  /**
   * Gets the items.
   * 
   * @param playerName player name
   * @return the items
   */
  List<Item> getItemsByPlayerName(String playerName);

  /**
   * Gets current turn.
   * 
   * @return current turn
   */
  int getTurns();

  /**
   * Gets the items.
   * 
   * @param index space index
   * @return the items
   */
  List<Item> getItemsBySpaceIndex(int index);

}
