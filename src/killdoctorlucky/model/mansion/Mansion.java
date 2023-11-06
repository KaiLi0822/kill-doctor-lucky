package killdoctorlucky.model.mansion;

import java.util.List;
import killdoctorlucky.model.space.Space;

/**
 * The mansion interface.
 */
public interface Mansion {

  /**
   * Gets the number of spaces.
   * 
   * @return the number of spaces
   */
  int getSpacesNum();

  /**
   * Sets the number of spaces.
   * 
   * @param spacesNumIn the number of spaces
   */
  void setSpacesNum(int spacesNumIn);

  /**
   * Gets the number of items.
   * 
   * @return number of items
   */
  int getItemsNum();

  /**
   * Sets the number of items.
   * 
   * @param itemsNumIn the number of items
   */
  void setItemsNum(int itemsNumIn);

  /**
   * Adds a space.
   * 
   * @param index  the space index
   * @param name   the space name
   * @param points the space points
   */
  void addSpace(int index, String name, String[] points);

  /**
   * Gets the list of spaces.
   * 
   * @return the list
   */
  List<Space> getSpaces();

  /**
   * Gets the height of mansion.
   * 
   * @return the height
   */
  int getHeight();

  /**
   * Gets the width of mansion.
   * 
   * @return the width
   */
  int getWidth();
  
  Space getSpaceByIndex(int index);

}
