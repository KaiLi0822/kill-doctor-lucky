package killdoctorlucky;

import java.io.InputStreamReader;
import killdoctorlucky.controller.KillDoctorLuckyConsoleController;
import killdoctorlucky.controller.KillDoctorLuckyController;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;

/**
 * This class represents a Driver class of the KillDoctorLucky.
 */
public class KillDoctorLuckyDriver {
  /**
   * Main function of the class.
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    RandomGenerator rg = new RandomGenerator();
    KillDoctorLuckyController killDoctorLuckyController = new KillDoctorLuckyConsoleController(
        input, output, rg);
    killDoctorLuckyController.playGame(new KillDoctorLuckyModel());
  }

}
