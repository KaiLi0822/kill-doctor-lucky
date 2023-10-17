/**
 * 
 */
package killdoctorlucky.model.mansion;

import java.util.List;

import killdoctorlucky.model.Nameable;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.space.Space;

/**
 * 
 */
public interface Mansion {

 
  

  int getSpacesNum();
  
  void setSpacesNum(int spacesNumIn);
  
  int getItemsNum(); 
  
  void setItemsNum(int itemsNumIn);
  
  
  void addSpace(int index, String name, String[] points);

  
  List<Space> getSpaces();
  
  int getHeight();
  
  int getWidth();
  


  
  

}
