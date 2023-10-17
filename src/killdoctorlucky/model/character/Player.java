package killdoctorlucky.model.character;

import java.util.List;

import killdoctorlucky.model.item.Item;

/**
 * 
 */
public interface Player extends Character{
  List<Item> getItems();
  
  void setItem(Item item) throws IllegalStateException;

}
