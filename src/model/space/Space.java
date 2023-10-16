package model.space;

import java.util.List;

import model.Nameable;
import model.character.Player;
import model.item.Item;
import model.item.ItemModel;

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
   * @param name the item name
   * @param position the item position
   * @param damage the item damage
   */
  void addItem(String name, int position, int damage);
 


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
  
  /**
   * Gets the index.
   * 
   * @return the index
   */
  int getIndex();
  


}
