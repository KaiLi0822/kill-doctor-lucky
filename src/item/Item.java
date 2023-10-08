package item;

import java.util.Objects;
import killdoctorlucky.Nameable;

/**
 * This class represents a Item. The Item has a name, position and damage.
 */
public class Item implements Nameable {
  private final String name;
  private final int position;
  private final int damage;

  /**
   * Constructs a Item.
   * 
   * @param nameIn     the name of the Item
   * @param positionIn the position of the Item
   * @param damageIn   the damage of the Item
   */
  public Item(String nameIn, int positionIn, int damageIn) {
    this.name = nameIn;
    this.position = positionIn;
    this.damage = damageIn;
  }

  /**
   * Gets the position of this Item.
   * 
   * @return the position
   */
  public int getPosition() {
    return position;
  }

  /**
   * Gets the damage of this Item.
   * 
   * @return the damage
   */
  public int getDamage() {
    return damage;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Item [name=" + name + ", position=" + position + ", damage=" + damage + "]";
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
    Item other = (Item) obj;
    return Objects.equals(name, other.name);
  }

}
