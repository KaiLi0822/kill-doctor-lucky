package killdoctorlucky.model.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.item.ItemModel;

/**
 * 
 */
public class PlayerModel extends CharacterModel implements Player{
  
  private List<Item> items;
  private int maxItems;

  /**
   * @param nameIn
   * @param currentSpaceIndexIn
   */
  public PlayerModel(String nameIn, int currentSpaceIndexIn, int maxItemsIn) {
    super(nameIn, currentSpaceIndexIn);
    maxItems = maxItemsIn;
    items = new ArrayList<Item>(maxItemsIn);
  }
  
  @Override
  public void setItem(Item item) throws IllegalStateException{
    if (items.size() == maxItems) {
      throw new IllegalStateException("Can not pick up more items.");
    }else {
      items.add(item);
    }
  }
  
  
  @Override
  public List<Item> getItems() {
    return items;
  }
  
  


  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (Item item : items) {
      sb.append(item.getName());
      sb.append(" ");
    }
    return "Player [name=" + getName() + ", maxItems=" + maxItems + "carriedItems=" + sb.toString()
        + ", currentSpaceIndex=" + getCurrentSpaceIndex() + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    PlayerModel other = (PlayerModel) obj;
    return Objects.equals(getName(), other.getName());
  }


  


}
