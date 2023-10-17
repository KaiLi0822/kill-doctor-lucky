package killdoctorlucky.model.killdoctorlucky;

import java.io.IOException;
import java.util.List;

import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.mansion.Mansion;

/**
 * The KillDoctorLucky game which include main character and spaces.
 */
public interface KillDoctorLucky {

  


  void setMansion(String mansionName, int mansionHeight, int mansionWidth);
  
  /**
   * Gets the mansion.
   * 
   * @return the mansion
   */
  Mansion getMansion();
  
  void setDoctorLucky(String doctorName, int doctorHealth);
  
  void setMaxTurn(int maxTurnIn);
  
  void setPlayer(String playerName, int spaceIndex, int maxItem);
  
//  String getMansionInfo();
  
  String getPlayersInfo();
  
  String getPlayerInfoByName();
  
  int getMaxTurn();
  
  Player getPlayerByTurn(int index);
  
  DoctorLucky getDoctorLucky();
  
  void initiateGame(Readable readable);
  

  String outputMap() throws IOException;
//  
//  int getCurrenTurn();
//  
//  String getMansion();
//  
//  /**
//   * Gets the number of spaces.
//   * 
//   * @return the number of spaces
//   */
//  int getSpacesNum();
//  
//  int getItemsNum();
//  
//  
//  
//  
//
//  /**
//   * Gets the doctor name.
//   * 
//   * @return the doctor name
//   */
//  String getDoctorName();
//  
//  
//  int getDoctorHealth();
//  
//  String getDoctorCurrentSpace();
//  
//  
//  
//
//
//  /**
//   * Gets the items of the target space.
//   * 
//   * @param index space index
//   * @return items
//   */
//  String getItemsBySpaceIndex(int index);
//

//
//  /**
//   * Gets the neighbors of the target space.
//   * 
//   * @param index space index
//   * @return neighbors
//   */
//  String getNeighborsBySpaceIndex(int index);
//
//  /**
//   * Moves target.
//   * 
//   * @return the current space
//   */
//  int moveTargetCharacter();
//
//  /**
//   * Gets the space index of the target character.
//   * 
//   * @return the space index
//   */
//  int getTargetCurrentSpaceIndex();
//
//  /**
//   * Gets the name of the target space.
//   * 
//   * @param index space index
//   * @return the name of the target space
//   */
//  String getSpaceNameByIndex(int index);

}
