package killdoctorlucky.model.space;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import killdoctorlucky.model.item.ItemModel;
import org.junit.Before;
import org.junit.Test;



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
    String[] arr = new String[] { "22", "21", "23", "28" };
    space = sp("abc", itemList, arr, neighbors);
  }

  protected SpaceModel sp(String name, List<ItemModel> items, String[] points,
      List<SpaceModel> neighbors) {
    return SpaceModel.getBuilder().name(name)
        .points(points).build();
  }

  @Test
  public void testGetName() {
    assertEquals("abc", space.getName());
  }

  @Test
  public void testGetPoints() {
    int[] a = new int[] { 22, 21, 23, 28 };
    assertEquals(Arrays.toString(a), Arrays.toString(space.getPoints()));
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
