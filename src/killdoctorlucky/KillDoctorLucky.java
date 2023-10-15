package killdoctorlucky;

import java.io.IOException;

/**
 * The KillDoctorLucky game which include main character and spaces.
 */
public interface KillDoctorLucky {

  /**
   * Gets the mansion name.
   * 
   * @return the mansion name
   */
  String getMansionName();

  /**
   * Gets the target name.
   * 
   * @return the target name
   */
  String getTargetName();
  
  /**
   * Gets the number of spaces.
   * 
   * @return the number of spaces
   */
  int getSpacesNum();

  /**
   * Gets the items of the target space.
   * 
   * @param index space index
   * @return items
   */
  String getItemsBySpaceIndex(int index);

  /**
   * Outputs the map.
   * 
   * @return the map file path
   * @throws IOException if the file IO failed
   */
  String outputMap() throws IOException;

  /**
   * Gets the neighbors of the target space.
   * 
   * @param index space index
   * @return neighbors
   */
  String getNeighborsBySpaceIndex(int index);

  /**
   * Moves target.
   * 
   * @return the current space
   */
  int moveTargetCharacter();

  /**
   * Gets the space index of the target character.
   * 
   * @return the space index
   */
  int getTargetCurrentSpaceIndex();

  /**
   * Gets the name of the target space.
   * 
   * @param index space index
   * @return the name of the target space
   */
  String getSpaceNameByIndex(int index);

}
