package killdoctorlucky.model.character;

import killdoctorlucky.model.mansion.Mansion;


/**
 * The Pet interface.
 */
public interface Pet extends Character{
  
  /**
   * Creates the route of pet.
   * @param index the start index
   * @param mansion the mansion
   */
  void createRoute(int index, Mansion mansion);
  
  /**
   * Gets the next space index by current space.
   * @param currentSpaceIndex current space
   * @return the next space
   */
  int nextSpaceIndexInRoute(int currentSpaceIndex);
  

}
