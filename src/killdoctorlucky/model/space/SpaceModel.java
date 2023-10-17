package killdoctorlucky.model.space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import killdoctorlucky.model.Nameable;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.item.ItemModel;

/**
 * This class represents a Space.
 */
public class SpaceModel implements Space {

  private final int index;
  private final String name;
  private final List<Item> items;
  private final int[] points;
  private final List<Space> neighbors;
  private final List<Player> players;

  /**
   * Constructs the space.
   * 
   * @param indexIn      the index of space
   * @param nameIn      the name of space
   * @param itemsIn     the items included in the space
   * @param pointsIn    the points of space
   * @param neighborsIn the neighbors of space
   * @param playersIn the players of space
   */
  private SpaceModel(int indexIn, String nameIn, List<Item> itemsIn, int[] pointsIn, List<Space> neighborsIn, List<Player> playersIn) {
    super();
    this.index = indexIn;
    this.name = nameIn;
    this.items = itemsIn;
    this.points = pointsIn;
    this.neighbors = neighborsIn;
    this.players = playersIn;
  }

  /**
   * The builder of space.
   * 
   * @return the spaceBuilder
   */
  public static SpaceBuilder getBuilder() {
    return new SpaceBuilder();
  }

  /**
   * A builder class for building new Spaces.
   */
  public static class SpaceBuilder {

    private int index;
    private String name;
    private List<Item> items;
    private int[] points;
    private List<Space> neighbors;
    private List<Player> players;

    /**
     * Making this constructor private forces the client of this class to use the
     * static getBuilder method.
     */
    private SpaceBuilder() {
      // assign default values to all the fields as above
      index = 0;
      name = "";
      items = new ArrayList<Item>();
      points = new int[4];
      neighbors = new ArrayList<Space>();
      players = new ArrayList<Player>();
    }
    
    /**
     * Use this for setting the Space's index.
     * 
     * @param indexIn the index.
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder index(int indexIn) {
      this.index = indexIn;
      return this;
    }

    /**
     * Use this for setting the Space's name.
     * 
     * @param nameIn the name.
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder name(String nameIn) {
      this.name = nameIn;
      return this;
    }

    /**
     * Use this for setting the Space's items.
     * 
     * @param itemsIn the items
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder items(List<Item> itemsIn) {
      this.items = itemsIn;
      return this;
    }

    /**
     * Use this for setting the Space's points.
     * 
     * @param pointsIn the points
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder points(String[] pointsIn) {
      int[] pointsInt = new int[pointsIn.length];
      for (int i = 0; i < pointsIn.length; i++) {
        pointsInt[i] = Integer.parseInt(pointsIn[i]);
      }
      this.points = pointsInt;
      return this;
    }

    /**
     * Use this for setting the Space's neighbors.
     * 
     * @param neighborsIn the neighbors
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder neighbors(List<Space> neighborsIn) {
      this.neighbors = neighborsIn;
      return this;
    }
    
    /**
     * Use this for setting the Space's players.
     * 
     * @param neighborsIn the neighbors
     * @return this builder so that other methods can be called
     */
    public SpaceBuilder players(List<Player> playersIn) {
      this.players = playersIn;
      return this;
    }

    /**
     * Build method called once all of the necessary data has been provided.
     * 
     * @return the space
     */
    public SpaceModel build() {
      // use the currently set values to create the space object
      return new SpaceModel(index, name, items, points, neighbors, players);
    }
  }
  
  
  /**
   * If space is the neighbor.
   * 
   * @param points the points of the space
   * @return true if it is a neighbor else false
   */
  private boolean isNeighbor(int[] pointsIn) {
    boolean up = (this.points[0] == (pointsIn[2] + 1))
        && ((pointsIn[3] >= this.points[1] && pointsIn[3] <= this.points[3])
            || (pointsIn[1] >= this.points[1] && pointsIn[1] <= this.points[3]));

    boolean down = (this.points[2] == (pointsIn[0] - 1))
        && ((pointsIn[3] >= this.points[1] && pointsIn[3] <= this.points[3])
            || (pointsIn[1] >= this.points[1] && pointsIn[1] <= this.points[3]));

    boolean right = this.points[3] == pointsIn[1] - 1
        && ((pointsIn[2] >= this.points[0] && pointsIn[2] <= this.points[2])
            || (pointsIn[0] >= this.points[0] && pointsIn[0] <= this.points[2]));

    boolean left = this.points[1] == pointsIn[3] + 1
        && ((pointsIn[2] >= this.points[0] && pointsIn[2] <= this.points[2])
            || (pointsIn[0] >= this.points[0] && pointsIn[0] <= this.points[2]));
    return left || right || up || down;

  }


  @Override
  public String getName() {
    return name;
  }

  @Override
  public List<Item> getItems() {
    return Collections.unmodifiableList(items);
  }

  @Override
  public int[] getPoints() {
    return points.clone();
  }
  


  @Override
  public List<Space> getNeighbors() {
    return Collections.unmodifiableList(neighbors);
  }

  @Override
  public void addItem(String name, int position, int damage) {
    items.add(new ItemModel(name, position, damage));
    
  }

  @Override
  public void addNeighbor(Space newSpace) {
    if (isNeighbor(newSpace.getPoints())) {
      neighbors.add(newSpace);
    }
    
  }

  @Override
  public void addPlayer(Player player) {
    players.add(player); 
    
  }


  @Override
  public String toString() {
    return "SpaceModel [name=" + name + ", items=" + items + ", points=" + Arrays.toString(points)
        + ", neighbors=" + neighbors + ", players=" + players + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(points);
    result = prime * result + Objects.hash(name);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SpaceModel other = (SpaceModel) obj;
    return Objects.equals(name, other.name) && Arrays.equals(points, other.points);
  }

  @Override
  public int getIndex() {
    return index;
  }



}
