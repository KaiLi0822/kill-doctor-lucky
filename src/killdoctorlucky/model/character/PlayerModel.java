package killdoctorlucky.model.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import killdoctorlucky.model.item.Item;

/**
 * This class represents the player.
 */
public class PlayerModel extends CharacterModel implements Player {

  private PlayerType playerType;
  private List<Item> items;
  private int maxItems;

  /**
   * Constructor of the player class.
   * @param playerTypeIn the playerType
   * @param nameIn the name
   * @param currentSpaceIndexIn the currentSpaceIndex
   * @param maxItemsIn the maxItem
   */
  public PlayerModel(PlayerType playerTypeIn, String nameIn, int currentSpaceIndexIn,
      int maxItemsIn) {
    super(nameIn, currentSpaceIndexIn);
    playerType = playerTypeIn;
    maxItems = maxItemsIn;
    items = new ArrayList<Item>(maxItemsIn);
  }

  @Override
  public void pickUpItem(Item item) throws IllegalStateException {
    if (items.size() == maxItems) {
      throw new IllegalStateException("Can not pick up more items.");
    } else {
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
    sb.append(name).append(" [playerType=").append(playerType).append(", maxItems=")
        .append(maxItems).append(", carriedItems=[");

    if (items.size() > 0) {
      for (Item item : items) {
        sb.append(item.getName()).append(", ");
        
      }
      sb.setLength(sb.length() - 2);
      
    }
    sb.append("], currentSpaceIndex=").append(getCurrentSpaceIndex()).append("]");
    return sb.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
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
    return Objects.equals(name, other.name);
  }

  @Override
  public PlayerType gePlayerType() {
    return playerType;
  }

  @Override
  public int getMaxItems() {
    return maxItems;
  }

  @Override
  public void removeItemByName(String itemName) {
    for (Item item : items) {
      if (item.getName() == itemName) {
        items.remove(item); 
      }
    }
  }

  @Override
  public String getItemNameWithMaxDamage() {
    String maxName = null;
    int maxDamage = 0;
    for (Item item : items) {
      if (item.getDamage() > maxDamage) {
        maxDamage = item.getDamage();
        maxName = item.getName(); 
      }
    }
    return maxName;
  }

}
