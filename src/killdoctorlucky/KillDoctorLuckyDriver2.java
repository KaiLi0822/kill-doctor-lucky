package killdoctorlucky;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import killdoctorlucky.controller.KillDoctorLuckyConsoleController;
import killdoctorlucky.controller.KillDoctorLuckyController;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;


/**
 * This class represents a Driver class of the KillDoctorLucky.
 */
public class KillDoctorLuckyDriver2 {
  /**
   * Main function of the class.
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    RandomGenerator rg = new RandomGenerator();
    KillDoctorLuckyController killDoctorLuckyController = new KillDoctorLuckyConsoleController(input, output, rg);
    killDoctorLuckyController.playGame(new KillDoctorLuckyModel());
  }
    

}
