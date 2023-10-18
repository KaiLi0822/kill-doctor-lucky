package killdoctorlucky.model.item;

import killdoctorlucky.model.Nameable;

/**
 * The item interface.
 */
public interface Item extends Nameable {
  
  /**
   * Gets the position of this Item.
   * 
   * @return the position
   */
  int getPosition();

  /**
   * Gets the damage of this Item.
   * 
   * @return the damage
   */
  int getDamage();


}
