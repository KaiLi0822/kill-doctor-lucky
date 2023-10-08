package killdoctorlucky;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide the path of world file(using \\t as field "
        + "delimiter, \\n as row delimiter):");
    KillDoctorLucky killDoctorLucky = null;
    String file = scanner.nextLine();
    boolean fileExists = true;
    do {
      try {
        killDoctorLucky = new KillDoctorLuckyImpl(file);
        fileExists = true;
      } catch (FileNotFoundException e) {
        fileExists = false;
        System.out.println("File does not exist. Please provide the path of world file:");
        file = scanner.nextLine();
      } catch (IOException e) {
        System.out.println("World creation failed");
      }
    } while (!fileExists);
    System.out.println("Mansion created successfully.");
    System.out.println(String.format("Mansion name: %s.", killDoctorLucky.getMansionName()));
    System.out
        .println(String.format("Target character name: %s.", killDoctorLucky.getTargetName()));
    System.out
        .println(String.format("The number of spaces is: %s.", killDoctorLucky.getSpacesNum()));

    while (true) {
      // Display the menu options
      System.out.println("---------------------------------------");
      System.out.println("Menu:");
      System.out.println("1. move target character");
      System.out.println("2. describe target's current space");
      System.out.println("3. describe neighbors of current space");
      System.out.println("4. describe space by index ");
      System.out.println("5. describe neighbors by index ");
      System.out.println("6. out map ");
      System.out.println("7. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          System.out.print(String.format("Move successfully, current space index is: %s.\n",
              killDoctorLucky.moveTargetCharacter()));
          break;
        case 2:
          System.out.print(String.format("Current space index is: %d.\n",
              killDoctorLucky.getTargetCurrentSpaceIndex()));
          System.out.print(String.format("Current space name is: %s.\n",
              killDoctorLucky.getSpaceNameByIndex(killDoctorLucky.getTargetCurrentSpaceIndex())));
          if (killDoctorLucky.getItemsBySpaceIndex(killDoctorLucky.getTargetCurrentSpaceIndex())
              .length() != 0) {
            System.out.print(String.format("Current space's items are: %s.\n", killDoctorLucky
                .getItemsBySpaceIndex(killDoctorLucky.getTargetCurrentSpaceIndex())));
          } else {
            System.out.println("There is no item in current space.");
          }
          break;
        case 3:
          if (killDoctorLucky.getNeighborsBySpaceIndex(killDoctorLucky.getTargetCurrentSpaceIndex())
              .length() != 0) {
            System.out.print(String.format("Current space's neighbors are: %s.\n", killDoctorLucky
                .getNeighborsBySpaceIndex(killDoctorLucky.getTargetCurrentSpaceIndex())));
          } else {
            System.out.println("There is no neighbor to current space.");
          }
          break;
        case 4:
          System.out.print("Input the index of space:\n");
          int indexSpace = scanner.nextInt();
          scanner.nextLine();
          while (indexSpace > killDoctorLucky.getSpacesNum() - 1) {
            System.out.print(String.format("The index should not be greater than %d.\n",
                killDoctorLucky.getSpacesNum() - 1));
            System.out.print("Input the index of space:\n");
            indexSpace = scanner.nextInt(); 
            scanner.nextLine();
          }
          System.out.print(String.format("The index of space is: %d.\n", indexSpace));
          System.out.print(String.format("The name of space is: %s.\n",
              killDoctorLucky.getSpaceNameByIndex(indexSpace)));
          if (killDoctorLucky.getItemsBySpaceIndex(indexSpace).length() != 0) {
            System.out.print(String.format("The space's items are: %s.\n",
                killDoctorLucky.getItemsBySpaceIndex(indexSpace)));
          } else {
            System.out.println("There is no item in the space.");
          }
          break;
        case 5:
          System.out.print("Input the index of space:\n");
          int indexSpace1 = scanner.nextInt();
          scanner.nextLine();
          while (indexSpace1 > killDoctorLucky.getSpacesNum() - 1) {
            System.out.print(String.format("The index should not be greater than %d.\n",
                killDoctorLucky.getSpacesNum() - 1));
            System.out.print("Input the index of space:\n");
            indexSpace1 = scanner.nextInt(); 
            scanner.nextLine();
          }
          if (killDoctorLucky.getNeighborsBySpaceIndex(indexSpace1).length() != 0) {
            System.out.print(String.format("This space's neighbors are: %s.\n",
                killDoctorLucky.getNeighborsBySpaceIndex(indexSpace1)));
          } else {
            System.out.println("There is no neighbor to current space.");
          }
          break;
        case 6:
          try {
            boolean pathExists;
            System.out.println("Please input a path to store the image:");
            String filePath = scanner.nextLine();
            // Convert the path string to a Path object
            Path path = Paths.get(filePath);
            // Check if the path exists
            pathExists = Files.exists(path);
            while (!pathExists) {
              System.out.println("Invalid path, Please input a valid path:");
              filePath = scanner.nextLine();
              path = Paths.get(filePath);
              // Check if the path exists
              pathExists = Files.exists(path);
            }
            System.out.print(String.format("Map created successfully, image path: %s\n",
                killDoctorLucky.outputMap(filePath)));
          } catch (IOException e) {
            System.out.print("Map creation failed");
          }
          break;
        case 7:
          // Exit the program
          System.out.println("Program exited.");
          scanner.close(); // Close the scanner before exiting
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please choose a valid option.");
          break;
      }
    }

  }

}
