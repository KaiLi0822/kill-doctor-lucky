package space;

import java.util.List;

import character.Player;
import item.Item;
import killdoctorlucky.Nameable;

/**
 * 
 */
public interface Space extends Nameable{
  
  List<Item> getItems();
  
  /**
   * Gets the points.
   * 
   * @return the points
   */
  int[] getPoints();

  /**
   * Gets the neighbors.
   * 
   * @return the neighbors
   */
  List<Space> getNeighbors();

  /**
   * Adds item into space.
   * 
   * @param newitem the new item
   */
  void addItem(Item newItem);

  /**
   * Adds a neighbor.
   * 
   * @param newSpace the new neighbor
   */
  void addNeighbor(Space newSpace);
  
  /**
   * Adds a player.
   * 
   * @param player the new player
   */
  void addPlayer(Player player);
  


}
