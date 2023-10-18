package killdoctorlucky.model.mansion;

import java.util.ArrayList;
import java.util.List;
import killdoctorlucky.model.space.Space;
import killdoctorlucky.model.space.SpaceModel;

/**
 * The mansion model.
 */
public class MansionModel implements Mansion {
  private final String name;
  private final int height;
  private final int width;
  private int spacesNum;
  private int itemsNum;
  private List<Space> spaces = new ArrayList<Space>();

  /**
   * Constructor of the mansion.
   * 
   * @param nameIn   the name
   * @param heightIn the height
   * @param widthIn  the width
   */
  public MansionModel(String nameIn, int heightIn, int widthIn) {
    super();
    this.name = nameIn;
    this.height = heightIn;
    this.width = widthIn;
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
  public void addSpace(int index, String spaceName, String[] points) {
    spaces.add(SpaceModel.getBuilder().index(index).name(spaceName).points(points).build());

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

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

}
