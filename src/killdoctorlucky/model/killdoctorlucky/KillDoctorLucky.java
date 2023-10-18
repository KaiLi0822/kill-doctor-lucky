package killdoctorlucky.model.killdoctorlucky;

import java.io.IOException;
import killdoctorlucky.model.character.Character;
import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.mansion.Mansion;
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
   * Gets the mansion.
   * 
   * @return the mansion
   */
  Mansion getMansion();

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
   * Sets the player.
   * 
   * @param playerType the playerType
   * @param playerName the playerName
   * @param spaceIndex the spaceIndex
   * @param maxItem    the maxItem
   */
  void setPlayer(PlayerType playerType, String playerName, int spaceIndex, int maxItem);

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
   * Gets the player by turn.
   * 
   * @param index the turn index
   * @return the player
   */
  Player getPlayerByTurn(int index);

  /**
   * get the doctor lucky.
   * 
   * @return the doctor lucky
   */
  DoctorLucky getDoctorLucky();

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
   * Gets the CharacterSpace.
   * 
   * @param character the character
   * @return the space
   */
  Space getCharacterSpace(Character character);

}
