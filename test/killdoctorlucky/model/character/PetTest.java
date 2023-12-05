package killdoctorlucky.model.character;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * The pet test.
 */
public class PetTest {

  private PetModel pet;

  @Before
  public void setUp() {
    pet = new PetModel("Cat");
  }

  @Test
  public void testCurrentSpace() {
    assertEquals(0, pet.getCurrentSpaceIndex());
    assertEquals(1, pet.move(pet.getCurrentSpaceIndex() + 1));
  }

}
