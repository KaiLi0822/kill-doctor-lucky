package killdoctorlucky.model.space;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.model.item.ItemModel;
import killdoctorlucky.model.space.SpaceModel;



/**
 * Test class for the Space.
 */
public class SpaceTest {

  private SpaceModel space;

  /**
   * Setup method for all of the tests.
   */
  @Before
  public void setUp() {
    ItemModel item = new ItemModel("a", 2, 3);
    SpaceModel neighbor = SpaceModel.getBuilder().name("n1").build();
    List<ItemModel> itemList = new ArrayList<ItemModel>();
    itemList.add(item);
    List<SpaceModel> neighbors = new ArrayList<SpaceModel>();
    neighbors.add(neighbor);
    String[] arr = new String[]{ "22", "21", "23", "28" };
    space = sp("abc", itemList, arr, neighbors);
  }

  protected SpaceModel sp(String name, List<ItemModel> items, String[] points, List<SpaceModel> neighbors) {
    return SpaceModel.getBuilder().name(name).items(items).points(points).neighbors(neighbors).build();
  }

  @Test
  public void testGetName() {
    assertEquals("abc", space.getName());
  }

  @Test
  public void testGetItems() {
    assertEquals(1, space.getItems().size());
    assertEquals("a", space.getItems().get(0).getName());
    space.addItem(new ItemModel("a", 0, 0));
    assertEquals(2, space.getItems().size());
  }

  @Test
  public void testGetPoints() {
    int[] a = new int[] { 22, 21, 23, 28 };
    assertEquals(Arrays.toString(a), Arrays.toString(space.getPoints()));
  }

  @Test
  public void testGetNeighbor() {
    assertEquals(1, space.getNeighbors().size());
    assertEquals("n1", space.getNeighbors().get(0).getName());
  }

  @Test
  public void testAddNeighbor() {
    String[] arr1 = new String[] { "16", "21", "21", "28" };
    SpaceModel space1 = sp("abc", null, arr1, null);
    space.addNeighbor(space1);
    assertEquals(2, space.getNeighbors().size());
    String[] arr2 = new String[] { "5", "6", "7", "8" };
    SpaceModel space2 = sp("abc", null, arr2, null);
    space.addNeighbor(space2);
    assertEquals(2, space.getNeighbors().size());

  }

  @Test
  public void testToString() {
    assertEquals("Space [name=abc, points=[22, 21, 23, 28]]", space.toString());
  }

  @Test
  public void testEqualsAndHashcode() {
    assertTrue(space.equals(space));
    assertTrue(space.hashCode() == space.hashCode());

    String[] arr = new String[] { "22", "21", "23", "28" };
    SpaceModel space1 = sp("abc", null, arr, null);

    assertTrue(space1.equals(space));
    assertTrue(space1.hashCode() == space.hashCode());

  }

}
