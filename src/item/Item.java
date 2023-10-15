package item;

import killdoctorlucky.Nameable;

/**
 * 
 */
public interface Item extends Nameable{
  
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
