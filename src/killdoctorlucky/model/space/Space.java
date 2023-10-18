package killdoctorlucky.model.space;

import java.util.List;
import killdoctorlucky.model.Nameable;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.item.Item;

/**
 * The space interface.
 */
public interface Space extends Nameable {

  /**
   * Gets the items.
   * 
   * @return the items
   */
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
   * @param name     the item name
   * @param position the item position
   * @param damage   the item damage
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

  /**
   * Gets the item object by its name.
   * 
   * @param name the name
   * @return the item
   */
  Item getItemByname(String name);

  /**
   * Removes an item.
   * 
   * @param item the item
   */
  void removeItem(Item item);

}
