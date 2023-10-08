package item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the Item.
 */
public class ItemTest {

  private Item item;

  /**
   * Setup method for all of the tests.
   */
  @Before
  public void setUp() {
    item = it("abc", 2, 5);
  }

  protected Item it(String nameIn, int positionIn, int damageIn) {
    return new Item(nameIn, positionIn, damageIn);
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
  public void testToString() {
    assertEquals("Item [name=abc, position=2, damage=5]", item.toString());
  }

  @Test
  public void testEqualsAndHashcode() {
    assertTrue(item.equals(item));
    assertTrue(item.hashCode() == item.hashCode());
    Item item1 = it("abc", 3, 6);

    assertTrue(item1.equals(item));
    assertTrue(item1.hashCode() == item.hashCode());

  }

}
