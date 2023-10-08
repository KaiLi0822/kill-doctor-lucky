package space;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import item.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;



/**
 * Test class for the Space.
 */
public class SpaceTest {

  private Space space;

  /**
   * Setup method for all of the tests.
   */
  @Before
  public void setUp() {
    Item item = new Item("a", 2, 3);
    Space neighbor = Space.getBuilder().name("n1").build();
    List<Item> itemList = new ArrayList<Item>();
    itemList.add(item);
    List<Space> neighbors = new ArrayList<Space>();
    neighbors.add(neighbor);
    String[] arr = new String[]{ "22", "21", "23", "28" };
    space = sp("abc", itemList, arr, neighbors);
  }

  protected Space sp(String name, List<Item> items, String[] points, List<Space> neighbors) {
    return Space.getBuilder().name(name).items(items).points(points).neighbors(neighbors).build();
  }

  @Test
  public void testGetName() {
    assertEquals("abc", space.getName());
  }

  @Test
  public void testGetItems() {
    assertEquals(1, space.getItems().size());
    assertEquals("a", space.getItems().get(0).getName());
    space.addItem(new Item("a", 0, 0));
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
    Space space1 = sp("abc", null, arr1, null);
    space.addNeighbor(space1);
    assertEquals(2, space.getNeighbors().size());
    String[] arr2 = new String[] { "5", "6", "7", "8" };
    Space space2 = sp("abc", null, arr2, null);
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
    Space space1 = sp("abc", null, arr, null);

    assertTrue(space1.equals(space));
    assertTrue(space1.hashCode() == space.hashCode());

  }

}
