/**
 * 
 */
package killdoctorlucky.controller;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.controller.command.Parse;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyMockModel;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;

/**
 * Test for KillDoctorLuckyConsoleController.
 */
public class KillDoctorLuckyConsoleControllerTest {

  private KillDoctorLuckyCommand killDoctorLuckyCommand; 
  private KillDoctorLucky killDoctorLucky;
  private KillDoctorLuckyController killDoctorLuckyController;
  private StringReader input;
  private StringBuffer output;
  
  @Before
  public void setUp() {
    output = new StringBuffer();
    killDoctorLucky = new KillDoctorLuckyMockModel(output);
  }

  @Test
  public void fileNotFoundTest() {
    input = new StringReader("test");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/123.txt").playGame(killDoctorLucky);
    assertEquals(output.toString(),"Specification file not found.\n");
  }

  @Test
  public void fileParseFailedTest() {
    input = new StringReader("test");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecificationParseFailedMock.txt").playGame(killDoctorLucky);
    assertEquals(output.toString(),"Enter initiateGame.\nSpecification file parse failed.\n");
  }
  
  @Test
  public void fileParseSuccessfullyTest() {
    input = new StringReader("q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt").playGame(killDoctorLucky);
    assertEquals(output.toString(),"Enter initiateGame.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:"
        + "\n-----Mansion Information-----\nMansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]"
        + "\n-----Main Character Information-----\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "Game Quit.");
  }
  
  @Test
  public void WrongWorldDescriptionTest() {
    input = new StringReader("test");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecificationWrongWorldDescriptionMock.txt").playGame(killDoctorLucky);
    assertEquals(output.toString(),"Enter initiateGame.\nSpecification file parse failed.\n");
  }
  
  @Test
  public void WrongSpaceTest() {
    input = new StringReader("test");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecificationWrongSpaceMock.txt").playGame(killDoctorLucky);
    assertEquals(output.toString(),"Enter initiateGame.\nSpecification file parse failed.\n");
  }
  
  
  

}
