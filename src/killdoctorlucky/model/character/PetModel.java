package killdoctorlucky.model.character;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import killdoctorlucky.model.mansion.Mansion;
import killdoctorlucky.model.space.Space;

/**
 * Pet class.
 */
public class PetModel extends CharacterModel implements Pet {

  List<Integer> route;
  Set<Integer> visited;
  
  /**
   * The constructor of PetModel.
   * @param nameIn the name
   */
  public PetModel(String nameIn) {
    super(nameIn, 0);
  }
  
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(name).append(" [currentSpaceIndex=")
        .append(currentSpaceIndex).append("]");
    return sb.toString();

  }

  @Override
  public void createRoute(int index, Mansion mansion) {
    route = new LinkedList<Integer>();
    visited = new HashSet<Integer>();
    dfs(index, mansion);
  }

  /**
   * Get the space order by depth-first algorithm.
   * @param index the start index
   * @param mansion the mansion world
   */
  private void dfs(int index, Mansion mansion) {
    route.add(index);
    visited.add(index);
    for (Space space : mansion.getSpaceByIndex(index).getNeighbors()) {
      if (!visited.contains(space.getIndex())) {
        dfs(space.getIndex(), mansion);
      }
    } 
  }

  @Override
  public int nextSpaceIndexInRoute(int currentSpaceIndex) {
    return route.get(route.indexOf(currentSpaceIndex) + 1);
  }
  

  

}
