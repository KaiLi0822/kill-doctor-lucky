package killdoctorlucky.controller.command;

import java.io.FileNotFoundException;
import java.io.FileReader;
import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The Parse helper class.
 */
public class Parse implements KillDoctorLuckyCommand {
  private FileReader fileReader;

  /**
   * Constructor the Parse.
   * 
   * @param file the specification file
   * @throws FileNotFoundException if file not found
   */
  public Parse(String file) throws FileNotFoundException {
    try {
      fileReader = new FileReader(file);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("Specification file not found.");
    }
  }

  @Override
  public void execute(KillDoctorLucky m) {
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null.");
    }
    
    try {
      m.initiateGame(fileReader);
    } catch (NumberFormatException e) {
      throw new IllegalStateException("Specification file parse failed.");
    }

  }
}
