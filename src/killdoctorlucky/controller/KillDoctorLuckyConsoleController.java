/**
 * 
 */
package killdoctorlucky.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import killdoctorlucky.controller.command.CreatePlayer;
import killdoctorlucky.controller.command.MaxTurn;
import killdoctorlucky.controller.command.Parse;
import killdoctorlucky.model.Nameable;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;
import killdoctorlucky.model.space.Space;

/**
 * 
 */
public class KillDoctorLuckyConsoleController implements KillDoctorLuckyController {

  private final Appendable out;
  private final Scanner scan;
  private final RandomGenerator rg;
  private KillDoctorLuckyCommand killDoctorLuckyCommand;
  private int turnNum;

  public KillDoctorLuckyConsoleController(Readable in, Appendable outIn, RandomGenerator rgIn) {
    if (in == null || outIn == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = outIn;
    this.rg = rgIn;
    scan = new Scanner(in);
  }

  /**
   * Append command method.
   * 
   * @param str the str appended
   * @throws IOException if the IOException occured, throw IllegalStateException
   */
  private void appendCommand(String str) throws IllegalStateException {
    try {
      out.append(str);
    } catch (IOException e) {
      throw new IllegalStateException("Append failed", e);
    }
  }

  private <T extends Nameable> String joinNames(List<T> objectList) {
    if (objectList.size() != 0) {
      List<String> names = new ArrayList<>();
      for (T obj : objectList) {
        names.add(obj.getName());
      }
      // Join names into a single string
      return String.join(", ", names);
    }
    return "";
  }

  @Override
  public void playGame(KillDoctorLucky m) {
    // parse the specification file
    appendCommand("Please provide the path of specification file(using \\t as field "
        + "delimiter, \\n as row delimiter):\n");
    String file = scan.nextLine();
    boolean fileExists = true;
    do {
      try {
        killDoctorLuckyCommand = new Parse(file);
        fileExists = true;
      } catch (FileNotFoundException e) {
        fileExists = false;
        appendCommand("File does not exist. Please provide the path of specification file:\n");
        file = scan.nextLine();
      }
    } while (!fileExists);
    killDoctorLuckyCommand.execute(m);
    
    // TODO offer two options: start game or draw map
    appendCommand("\n***********************************\n");
    appendCommand("Mansion created successfully, the information is as follows:");
    appendCommand("\n-----Mansion Information-----\n");
    appendCommand(m.getMansion().toString());
    appendCommand("\n-----Main Character Information-----\n");
    appendCommand(m.getDoctorLucky().toString());
    
    appendCommand("\n***********************************\n");
    appendCommand("Menu:\n");
    appendCommand("1. Create world map.\n");
    appendCommand("2. Start game.\n");
    
    int option = scan.nextInt();
    if (option == 1) {
      try {
        appendCommand(String.format("Map created successfully, image path: %s",
            m.outputMap()));
      } catch (IOException e) {
        appendCommand("Map creation failed");
      }   
    }

    appendCommand("\n***********************************\n");
    appendCommand("Game Start!\n");
    // set max turns
    appendCommand("* Please provide the maximum of turns: ");
    int maxTurn = scan.nextInt();
    killDoctorLuckyCommand = new MaxTurn(maxTurn);
    killDoctorLuckyCommand.execute(m);
    appendCommand("\n-----Maximum turns-----\n");
    appendCommand(String.valueOf(m.getMaxTurn()));
   

    // generate auto-player
//    killDoctorLuckyCommand = new CreatePlayer(rg);
//    killDoctorLuckyCommand.execute(m);

    // generate player
    appendCommand("* Generate Player\n");
    appendCommand("Please provide the name: ");
    String playerName = scan.next();
    appendCommand("Please provide the space index: ");
    int playerSpaceIndex = scan.nextInt();
    appendCommand("Please provide the maximum number of items carried: ");
    int maxItems = scan.nextInt();
    killDoctorLuckyCommand = new CreatePlayer(playerName, playerSpaceIndex, maxItems);
    killDoctorLuckyCommand.execute(m);
    appendCommand("\n-----Players Information-----\n");
    appendCommand(m.getPlayersInfo());



    while (turnNum++ <= m.getMaxTurn()) {
      Player player = m.getPlayerByTurn(turnNum);
      appendCommand(String.format("\n-----%s's turn-----\n", player.getName()));
      
      // TODO add description about the player
      // space 
      // items
      // Number of items that can be carried

      appendCommand(String.format("1. Move to a neighboring space: %s\n",
          joinNames(m.getMansion().getSpaces().get(player.getCurrentSpaceIndex()).getNeighbors())));
      appendCommand(String.format("2. Pick up an item: %s\n",
          joinNames(m.getMansion().getSpaces().get(player.getCurrentSpaceIndex()).getItems())));
      appendCommand("3. Look around\n");
      appendCommand("Choose action:\n");
      int choice;
      if (player.getName() == "Auto-Player") {
        choice = rg.nextInt(3) + 1;
      } else {
        choice = scan.nextInt();
      }
      appendCommand(String.format("%s chose %d\n", player.getName(), choice));
      switch (choice) {
        case 1:
          appendCommand("Choose a space to enter, input the index of space:\n");
          List<Space> spaces = m.getMansion().getSpaces().get(player.getCurrentSpaceIndex())
              .getNeighbors();
          List<Integer> intList = new ArrayList<Integer>();
          for (Space space : spaces) {
            appendCommand(String.format("%d. %s\n", space.getIndex(), space.getName()));
            intList.add(space.getIndex());
          }
          int spaceIndex;
          if (player.getName() == "Auto-Player") {
            spaceIndex = intList.get(rg.nextInt(intList.size()));
          } else {
            spaceIndex = scan.nextInt();
          }
          player.move(spaceIndex);
          appendCommand(String.format("%s's current space is %d.%s\n", player.getName(),
              player.getCurrentSpaceIndex(),
              m.getMansion().getSpaces().get(player.getCurrentSpaceIndex()).getName()));
          DoctorLucky doctorLucky = m.getDoctorLucky();
          doctorLucky
              .move((doctorLucky.getCurrentSpaceIndex() + 1) % m.getMansion().getSpacesNum());
          appendCommand(String.format("%s's current space is %d.%s\n", doctorLucky.getName(),
              doctorLucky.getCurrentSpaceIndex(),
              m.getMansion().getSpaces().get(doctorLucky.getCurrentSpaceIndex()).getName()));
          break;
        case 2:

          break;
        case 3:

          break;

        default:
          appendCommand("Invalid choice. Please choose a valid option.");
          break;

      }

    }

  }

}
