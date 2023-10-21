package killdoctorlucky.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.space.Space;

/**
 * Implement a console controller.
 */
public class KillDoctorLuckyConsoleController implements KillDoctorLuckyController {

  private final Appendable out;
  private final Scanner scan;
  private final RandomGenerator rg;
  private final String filePath;
  private KillDoctorLuckyCommand killDoctorLuckyCommand;
  private int turnNum;

  /**
   * Constructor for the controller.
   * 
   * @param in         the source to read from
   * @param outIn      the target to print to
   * @param rgIn       the random object
   * @param filePathIn the filePath
   */
  public KillDoctorLuckyConsoleController(Readable in, Appendable outIn, RandomGenerator rgIn,
      String filePathIn) {
    if (in == null || outIn == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = outIn;
    this.rg = rgIn;
    this.filePath = filePathIn;
    scan = new Scanner(in).useDelimiter("\n");
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

  /**
   * Joins names of the object list.
   * 
   * @param <T>        the type of object
   * @param objectList the list of objects
   * @return the string generated by objects
   */
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

  private Boolean checkQuit(String input) {
    if ("q".equals(input) || "Q".equals(input)) {
      appendCommand("Game Quit.");
      return true;
    }
    return false;
  }
  
  private Boolean checkInt(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      appendCommand("Please input valid number.");
      return false;
    }
    return true;
  }
  
  @Override
  public void playGame(KillDoctorLucky m) {
    // parse the specification file
    try {
      killDoctorLuckyCommand = new Parse(filePath);
    } catch (FileNotFoundException e) {
      appendCommand(String.format("%s\n", e.getMessage()));
      return;
    }

    try {
      killDoctorLuckyCommand.execute(m);
    } catch (IllegalStateException e) {
      appendCommand(String.format("%s\n", e.getMessage()));
      return;
    }

    appendCommand("***********************************\n");
    appendCommand("Mansion created successfully, the information is as follows:");
    appendCommand("\n-----Mansion Information-----\n");
    appendCommand(m.getMansion().toString());
    appendCommand("\n-----Main Character Information-----\n");
    DoctorLucky doctorLucky = m.getDoctorLucky();
    appendCommand(doctorLucky.toString());

    appendCommand("\n***********************************\n");
    appendCommand("Menu(Input 'q'/'Q' to quit):\n");
    appendCommand("1. Create world map.\n");
    appendCommand("2. Start game.\n");

    String input = scan.next();
    if (checkQuit(input) || !checkInt(input)) {
      return;  
    }
    int option = Integer.parseInt(input);
    if (option == 1) {
      try {
        appendCommand(String.format("Map created successfully: %s", m.outputMap()));
      } catch (IOException e) {
        appendCommand("Map creation failed");
      }
    }

    appendCommand("\n***********************************\n");
    appendCommand("Game Start!\n");
    // set max turns
    appendCommand("* Please provide the maximum of turns: ");
    String maxTurnStr = scan.next();
    if (checkQuit(maxTurnStr) || !checkInt(maxTurnStr)) {
      return;  
    }
    int maxTurn = Integer.parseInt(maxTurnStr);
    killDoctorLuckyCommand = new MaxTurn(maxTurn);

    killDoctorLuckyCommand.execute(m);

    // generate player
    appendCommand("* Generate Player\n");
    appendCommand("Please provide the number of players:");
    String playersNumStr = scan.next();
    if (checkQuit(playersNumStr) || !checkInt(playersNumStr)) {
      return;  
    }
    int playersNum = Integer.parseInt(playersNumStr);
    for (int i = 0; i < playersNum; i++) {
      appendCommand(String.format("** Genarating Player %d:\n", i + 1));
      appendCommand("Please choose the player type:\n");
      appendCommand("1.human\n");
      appendCommand("2.robot\n");
      String playTypeOptionStr = scan.next();
      if (checkQuit(playTypeOptionStr) || !checkInt(playTypeOptionStr)) {
        return;  
      }
      int playTypeOption = Integer.parseInt(playTypeOptionStr);
      if (playTypeOption == 1) {
        appendCommand("Creating a human player...\n");
      } else {
        appendCommand("Creating a robot player...\n");
      }
      appendCommand("Please provide the name: ");
      String playerName = scan.next();
      if (checkQuit(playerName)) {
        return;  
      }
      appendCommand("Please provide the space index: ");
      String playerSpaceIndexStr = scan.next();
      if (checkQuit(playerSpaceIndexStr) || !checkInt(playerSpaceIndexStr)) {
        return;  
      }
      int playerSpaceIndex = Integer.parseInt(playerSpaceIndexStr);
      appendCommand("Please provide the maximum number of items carried: ");
      String maxItemsStr = scan.next();
      if (checkQuit(maxItemsStr) || !checkInt(maxItemsStr)) {
        return;  
      }
      int maxItems = Integer.parseInt(maxItemsStr);
      if (playTypeOption == 1) {
        killDoctorLuckyCommand = new CreatePlayer(playerName, playerSpaceIndex, maxItems);
      } else {
        killDoctorLuckyCommand = new CreatePlayer(rg, playerName, playerSpaceIndex, maxItems);
      }

      killDoctorLuckyCommand.execute(m);

    }

    appendCommand("\n-----Players Information-----\n");
    appendCommand(m.getPlayersInfo());

    appendCommand("\n***********************************\n");

    while (turnNum < m.getMaxTurn()) {

      Player player = m.getPlayerByTurn(turnNum);

      appendCommand(
          String.format("\n-----%s's turn, No.%d turn-----\n", player.getName(), turnNum + 1));
      appendCommand(String.format("%s\n", m.getPlayerInfoByName(player.getName())));
      appendCommand("* Choose action:\n");
      Space currentSpace = m.getMansion().getSpaces().get(player.getCurrentSpaceIndex());
      List<Space> neighbors = currentSpace.getNeighbors();
      appendCommand(String.format("1. Move to a neighboring space: %s\n", joinNames(neighbors)));
      List<Item> items = currentSpace.getItems();
      if (items.size() > 0) {
        appendCommand(String.format("2. Pick up an item: %s\n", joinNames(items)));
      } else {
        appendCommand("2. Pick up an item: no item can be picked.\n");
      }
      appendCommand("3. Look around\n");

      int choice;
      if (player.gePlayerType().equals(PlayerType.ROBOT)) {
        choice = rg.nextInt(3) + 1;
      } else {
        String choiceStr = scan.next();
        if (checkQuit(choiceStr) || !checkInt(choiceStr)) {
          return;  
        }
        choice = Integer.parseInt(choiceStr);
      }
      appendCommand(String.format("%s chose the option %d\n", player.getName(), choice));

      switch (choice) {
        case 1:
          appendCommand("** Choose a space to enter, input the index of space:\n");
          List<Integer> spaceIndexList = new ArrayList<Integer>();
          for (Space space : neighbors) {
            appendCommand(String.format("%d. %s\n", space.getIndex(), space.getName()));
            spaceIndexList.add(space.getIndex());
          }
          int spaceIndex;
          if (player.gePlayerType().equals(PlayerType.ROBOT)) {
            int option1 = rg.nextInt(spaceIndexList.size());
            spaceIndex = spaceIndexList.get(option1);
            appendCommand(
                String.format("%s chose the No.%d space.\n", player.getName(), spaceIndex));
          } else {
            String spaceIndexStr = scan.next();
            if (checkQuit(spaceIndexStr) || !checkInt(spaceIndexStr)) {
              return;  
            }
            spaceIndex = Integer.parseInt(spaceIndexStr);
          }
          player.move(spaceIndex);

          break;
        case 2:
          if (player.getItems().size() < player.getMaxItems()) {
            appendCommand("** Choose an item to pick up, input the name of item:\n");
            List<String> itemNameList = new ArrayList<String>();
            for (Item item : items) {
              itemNameList.add(item.getName());
            }
            String itemName;
            if (player.gePlayerType().equals(PlayerType.ROBOT)) {
              itemName = itemNameList.get(rg.nextInt(itemNameList.size()));
              appendCommand(String.format("%s chose the %s.\n", player.getName(), itemName));
            } else {
              itemName = scan.next();
              if (checkQuit(itemName)) {
                return;  
              }
            }
            Item item = currentSpace.getItemByname(itemName);
            if (item != null) {
              try {
                player.pickUpItem(item);
                currentSpace.removeItem(item);
              } catch (IllegalStateException e) {
                appendCommand(String.format("%s\n", e.getMessage()));
              }
            }

          } else {
            appendCommand("Can not pick up more items.\n");
          }

          break;
        case 3:

          for (Space space : neighbors) {
            StringBuffer stringBuffer = new StringBuffer();
            appendCommand(String.format("* %d. %s\n", space.getIndex(), space.getName()));
            stringBuffer.append(space.toString());

            if (space.getIndex() == doctorLucky.getCurrentSpaceIndex()) {
              stringBuffer.setLength(stringBuffer.length() - 1);
              stringBuffer.append(", Doctor Lucky's health=");
              stringBuffer.append(doctorLucky.getHealth());
              stringBuffer.append("]");

            }
            stringBuffer.append("\n");
            appendCommand(stringBuffer.toString());

          }

          break;

        default:
          appendCommand("Invalid choice. Please choose a valid option.");
          break;

      }
      appendCommand(String.format("%s\n", m.getPlayerInfoByName(player.getName())));
      doctorLucky.move((doctorLucky.getCurrentSpaceIndex() + 1) % m.getMansion().getSpacesNum());
      appendCommand(String.format("%s's current space is %d.%s\n", doctorLucky.getName(),
          doctorLucky.getCurrentSpaceIndex(), m.getCharacterSpace(doctorLucky).getName()));
      turnNum++;
    }
    appendCommand("\n***********************************\n");
    appendCommand("Game Over! You have reached the maximum number of turns.\n");

  }

}
