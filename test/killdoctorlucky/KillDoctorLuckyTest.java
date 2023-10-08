package killdoctorlucky;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the KillDoctorLucky.
 */
public class KillDoctorLuckyTest {

  private KillDoctorLucky killDoctorLucky;

  /**
   * Setup method for all of the tests.
   * @throws FileNotFoundException if file not found throw FileNotFoundException
   * 
   */
  @Before
  public void setUp() throws FileNotFoundException, IOException {
    killDoctorLucky = ki("./res/WorldSpecification.txt");
  }

  protected KillDoctorLucky ki(String path) throws FileNotFoundException, IOException {
    return new KillDoctorLuckyImpl(path);
  }

  @Test(expected = FileNotFoundException.class)
  public void testIfFileIsInvalid() throws FileNotFoundException, IOException {
    ki("./res/WorldSpecification1.txt");
  }

  @Test
  public void testGetMansionName() {
    assertEquals("Doctor Lucky's Mansion", killDoctorLucky.getMansionName());
  }
  
  @Test
  public void testGetSpacesNum() {
    assertEquals(21, killDoctorLucky.getSpacesNum());
  }

  @Test
  public void testGetTargetName() {
    assertEquals("Doctor Lucky", killDoctorLucky.getTargetName());
  }

  @Test
  public void testMoveTargetCharacter() {
    assertEquals(1, killDoctorLucky.moveTargetCharacter());
    assertEquals(2, killDoctorLucky.moveTargetCharacter());
    assertEquals(3, killDoctorLucky.moveTargetCharacter());
  }

  @Test
  public void testGetSpaceNameByIndex() {
    assertEquals("Armory", killDoctorLucky.getSpaceNameByIndex(0));
    assertEquals("Billiard Room", killDoctorLucky.getSpaceNameByIndex(1));
  }

  @Test
  public void testGetItemsBySpaceIndex() {
    assertEquals("Revolver", killDoctorLucky.getItemsBySpaceIndex(0));
  }

  @Test
  public void testGetNeighborsBySpaceIndex() {
    assertEquals("Billiard Room, Green House, Hedge Maze",
        killDoctorLucky.getNeighborsBySpaceIndex(0));
  }

}
