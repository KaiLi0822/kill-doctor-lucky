package killdoctorlucky.model.character;

import java.util.List;

import killdoctorlucky.model.mansion.Mansion;


/**
 * The Pet interface.
 */
public interface Pet extends Character{
  
  void createRoute(int index, Mansion mansion);
  
  int nextSpaceIndexInRoute(int currentSpaceIndex);
  

}
