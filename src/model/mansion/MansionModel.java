package model.mansion;

import java.util.ArrayList;
import java.util.List;

import model.item.Item;
import model.item.ItemModel;
import model.space.Space;
import model.space.SpaceModel;

/**
 * 
 */
public class MansionModel implements Mansion{
  private final String name;
  private final int height;
  private final int width;
  
  private int spacesNum;
  private int itemsNum;
  
  
  
  private List<Space> spaces = new ArrayList<Space>();


  
  
  
  public MansionModel(String name, int height, int width) {
    super();
    this.name = name;
    this.height = height;
    this.width = width;
  }
  






  @Override
  public void setSpacesNum(int spacesNumIn) {
    spacesNum = spacesNumIn;
    
    
  }

  

  @Override
  public int getSpacesNum() {
    return spacesNum;
  }


  @Override
  public void setItemsNum(int itemsNumIn) {
    itemsNum = itemsNumIn;
    
  }







  @Override
  public int getItemsNum() {
    return itemsNum;
  }
  
  


  @Override
  public void addSpace(int index, String name, String[] points) {
    spaces.add(SpaceModel.getBuilder().index(index).name(name).points(points).build());
    
  }













  @Override
  public List<Space> getSpaces() {
    return spaces;
  }







  @Override
  public String toString() {
    return "Mansion [name=" + name + ", height=" + height + ", width=" + width + ", spacesNum="
        + spacesNum + ", itemsNum=" + itemsNum + "]";
  }
















  
  


}
