/**
 * 
 */
package model.mansion;

import java.util.List;

import model.Nameable;
import model.item.Item;
import model.space.Space;

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
  


  
  

}
