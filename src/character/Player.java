package character;

import java.util.List;

import item.Item;

/**
 * 
 */
public interface Player extends Character{
  List<Item> getItems();
  
  void setItem(Item item) throws IllegalStateException;

}
