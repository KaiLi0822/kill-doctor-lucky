/**
 * 
 */
package killdoctorlucky.controller.command;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.item.ItemModel;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;
import killdoctorlucky.model.space.SpaceModel;

/**
 * 
 */
public class ParseTest {
  private KillDoctorLuckyCommand killDoctorLuckyCommand; 
  private KillDoctorLucky killDoctorLucky;
  
  @Before
  public void setUp() {
    killDoctorLucky = new KillDoctorLuckyModel();
  }


  @Test(expected = FileNotFoundException.class)
  public void fileNotFoundTest() throws FileNotFoundException {
    try {
      killDoctorLuckyCommand = new Parse("./res/123.txt");
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException(e.getMessage());
    }
  }
  
  @Test
  public void parseTest() throws FileNotFoundException {
    killDoctorLuckyCommand = new Parse("./res/WorldSpecification.txt");
    killDoctorLuckyCommand.execute(killDoctorLucky);
      
   
  }

}
