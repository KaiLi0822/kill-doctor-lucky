package killdoctorlucky;

import java.io.InputStreamReader;
import killdoctorlucky.controller.KillDoctorLuckyConsoleController;
import killdoctorlucky.controller.KillDoctorLuckyController;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;
import killdoctorlucky.view.KillDoctorLuckyGraphicView;
import killdoctorlucky.view.KillDoctorLuckyView;

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

    // Create random generator
    RandomGenerator rg = new RandomGenerator();
    // Create the model
    KillDoctorLucky model = new KillDoctorLuckyModel();

    if ("gui".equals(args[2])) {
      // Create the controller with the model
      KillDoctorLuckyController controller = new KillDoctorLuckyConsoleController(rg, args[0],
          args[1]);
      // Create the view
      KillDoctorLuckyView view = new KillDoctorLuckyGraphicView("Kill Doctor Lucky");
      // Set the view in the controller
      controller.setModelView(model, view);

    } else if ("text".equals(args[2])) {

      Readable input = new InputStreamReader(System.in);
      Appendable output = System.out;
      KillDoctorLuckyController killDoctorLuckyController = new KillDoctorLuckyConsoleController(
          input, output, rg, args[0], args[1]);
      killDoctorLuckyController.setModel(model);
      killDoctorLuckyController.playGame();

    }

  }

}