package killdoctorlucky.model.character;

import java.util.List;
import killdoctorlucky.model.item.Item;

/**
 * The Player Interface.
 */
public interface Player extends Character {

  /**
   * Gets all items.
   * 
   * @return the items list
   */
  List<Item> getItems();

  /**
   * Picks up an item.
   * 
   * @param item the item
   * @throws IllegalStateException if the player have reached the maximum number
   *                               of items
   */
  void pickUpItem(Item item) throws IllegalStateException;

  /**
   * Gets the player type.
   * 
   * @return the player type, human or robot
   */
  PlayerType gePlayerType();

  /**
   * Gets the maximum number of items can be carried.
   * 
   * @return the maximum number of items
   */
  int getMaxItems();

}
