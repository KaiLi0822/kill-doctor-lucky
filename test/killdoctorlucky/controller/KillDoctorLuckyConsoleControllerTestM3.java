package killdoctorlucky.controller;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyMockModel;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for KillDoctorLuckyConsoleController.
 */
public class KillDoctorLuckyConsoleControllerTestM3 {

  private KillDoctorLucky killDoctorLucky;
  private StringReader input;
  private StringBuffer output;
  private RandomGenerator rg;
  private StringBuffer stringBuffer;

  /**
   * Setup method for all of the tests.
   * 
   */
  @Before
  public void setUp() {
    output = new StringBuffer();
    killDoctorLucky = new KillDoctorLuckyMockModel(output);
    stringBuffer = new StringBuffer();
  }
  
  @Test
  public void testWrongMove() {
    input = new StringReader("2 3 1 1 human 1 1 1 1 q");
    stringBuffer.append("");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testWrongPickUp() {
    input = new StringReader("2 3 1 1 human 1 1 2 3 q");
    stringBuffer.append("");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

}
