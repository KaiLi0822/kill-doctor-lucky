package killdoctorlucky.model.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.model.item.ItemModel;

/**
 * Test class for the Item.
 */
public class ItemTest {

  private ItemModel item;

  /**
   * Setup method for all of the tests.
   */
  @Before
  public void setUp() {
    item = it("abc", 2, 5);
  }

  protected ItemModel it(String nameIn, int positionIn, int damageIn) {
    return new ItemModel(nameIn, positionIn, damageIn);
  }

  @Test
  public void testGetName() {
    assertEquals("abc", item.getName());
  }

  @Test
  public void testGetPosition() {
    assertEquals(2, item.getPosition());
  }

  @Test
  public void testGetDamage() {
    assertEquals(5, item.getDamage());
  }


  @Test
  public void testEqualsAndHashcode() {
    assertTrue(item.equals(item));
    assertTrue(item.hashCode() == item.hashCode());
    ItemModel item1 = it("abc", 3, 6);

    assertTrue(item1.equals(item));
    assertTrue(item1.hashCode() == item.hashCode());

  }

}
