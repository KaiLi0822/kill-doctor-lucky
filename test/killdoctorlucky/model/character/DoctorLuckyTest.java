package killdoctorlucky.model.character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 * Test class for the DoctorLucky.
 */
public class DoctorLuckyTest {
  
  private DoctorLuckyModel doc;

  /**
   * Setup method for all of the tests.
   */
  @Before
  public void setUp() {
    doc = doc(20, "doc");
  }
  
  protected DoctorLuckyModel doc(int healthIn, String nameIn) {
    return new DoctorLuckyModel(nameIn, healthIn);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfNegativeHealthIsInvalid() {
    doc(-2, "doc");
  }

  @Test
  public void testGetHealth() {
    assertEquals(20, doc.getHealth());
  }
  
  @Test
  public void testGetName() {
    assertEquals("doc", doc.getName());
  }
  
  @Test
  public void testMove() {
    assertEquals(doc.getCurrentSpaceIndex() + 1, doc.move(doc.getCurrentSpaceIndex() + 1));
    assertEquals(doc.getCurrentSpaceIndex() + 1, doc.move(doc.getCurrentSpaceIndex() + 1));
    assertEquals(doc.getCurrentSpaceIndex() + 1, doc.move(doc.getCurrentSpaceIndex() + 1));
  }
  
  

  @Test
  public void testEqualsAndHashcode() {
    assertTrue(doc.equals(doc));
    assertTrue(doc.hashCode() == doc.hashCode());
    DoctorLuckyModel doc1 = doc(1, "doc");
   
    assertTrue(doc1.equals(doc));
    assertTrue(doc1.hashCode() == doc.hashCode());

  }

}
