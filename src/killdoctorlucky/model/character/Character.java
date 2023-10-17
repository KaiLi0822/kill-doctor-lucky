/**
 * 
 */
package killdoctorlucky.model.character;

import killdoctorlucky.model.Nameable;

/**
 * 
 */
public interface Character extends Nameable{
  
  /**
   * return the current space index.
   * @return the currentSpaceIndex
   */
  int getCurrentSpaceIndex();


  /**
   * move character to a new space.
   * @param spaceIndex the targeted space
   * @return the space index after moving
   */
  int move(int spaceIndex);
  


}
