package killdoctorlucky.model.killdoctorlucky;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;

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
  public void setUp() {
    killDoctorLucky = new KillDoctorLuckyModel();
  }

  @Test
  public void testParseSuccessfully() {
    FileReader fileReader = null;
    try {
      fileReader = new FileReader("./res/WorldSpecification.txt");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    killDoctorLucky.initiateGame(fileReader);
    assertEquals("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]", killDoctorLucky.getMansion().toString());
  }

}
