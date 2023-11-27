/**
 * 
 */
package killdoctorlucky.controller;

/**
 * 
 */
public interface KillDoctorLuckyControllerFeature {
  void startGame();
  
  
  void startGame(String mansionFile);
  
  int[] movePlayer(String playerName, int spaceIndex);  
  
  void pickUpItem(String playerName, String itemName);

}
