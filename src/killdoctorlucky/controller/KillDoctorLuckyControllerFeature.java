/**
 * 
 */
package killdoctorlucky.controller;

import java.util.List;

/**
 * 
 */
public interface KillDoctorLuckyControllerFeature {
  void startGame();
  
  void startGame(String mansionFile);
  
  int[] movePlayer(String playerName, int spaceIndex);  
  
  Boolean pickUpItem(String playerName, String itemName);
  
  void movePet(int spaceIndex);  

  Boolean makeAttempt(String playerName, String itemName);
  
  Boolean isGameOver();
  
  String getWinner();
  
  List<String> robotTurn();
}
