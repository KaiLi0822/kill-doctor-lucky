package killdoctorlucky.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import killdoctorlucky.controller.command.CreatePlayer;
import killdoctorlucky.controller.command.MaxTurn;
import killdoctorlucky.controller.command.MovePlayer;
import killdoctorlucky.controller.command.Parse;
import killdoctorlucky.controller.command.PickUpItem;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.space.Space;
import killdoctorlucky.view.KillDoctorLuckyView;

/**
 * Implement a console controller.
 */
public class KillDoctorLuckyConsoleController implements KillDoctorLuckyController {

//  private final Appendable out;
//  private final Scanner scan;
  private final RandomGenerator rg;
  private String filePath;
  private final String maxTurn;
  private KillDoctorLuckyCommand killDoctorLuckyCommand;
  private KillDoctorLucky model;
  private KillDoctorLuckyView view;

  /**
   * Constructor for the controller.
   * 
   * @param in         the source to read from
   * @param outIn      the target to print to
   * @param rgIn       the random object
   * @param filePathIn the filePath
   */
  public KillDoctorLuckyConsoleController(RandomGenerator rgIn, String filePathIn,
      String maxTurnIn) {
    this.rg = rgIn;
    this.filePath = filePathIn;
    this.maxTurn = maxTurnIn;

  }
//
//  /**
//   * Append command method.
//   * 
//   * @param str the str appended
//   * @throws IOException if the IOException occured, throw IllegalStateException
//   */
//  private void appendCommand(String str) throws IllegalStateException {
////    try {
////      out.append(str);
////    } catch (IOException e) {
////      throw new IllegalStateException("Append failed", e);
////    }
//  }
//
//  /**
//   * Checks if quit.
//   * 
//   * @param input the input
//   * @return if q or Q return true
//   */
//  private Boolean checkQuit(String input) {
//    if ("q".equals(input) || "Q".equals(input)) {
//      appendCommand("Game Quit.");
//      return true;
//    }
//    return false;
//  }
//
//  /**
//   * Checks if int.
//   * 
//   * @param input the input
//   * @return if int return true
//   */
//  private Boolean checkInt(String input) {
//    try {
//      Integer.parseInt(input);
//    } catch (NumberFormatException e) {
//      appendCommand("Please input valid number.");
//      return false;
//    }
//    return true;
//  }
//
//  @Override
//  public void playGame(KillDoctorLucky m) {
// 
//
//    appendCommand("***********************************\n");
//    appendCommand("Mansion created successfully, the information is as follows:");
//    appendCommand("\n-----Mansion Information-----\n");
//    appendCommand(m.getMansionInfo());
//    appendCommand("\n-----Main Character Information-----\n");
//    appendCommand(m.getDoctorLuckyInfo());
//    appendCommand("\n-----Pet Information-----\n");
//    appendCommand(m.getPetInfo());
//
//    appendCommand("\n***********************************\n");
//    appendCommand("Menu(Input 'q'/'Q' to quit):\n");
//    appendCommand("1. Create world map.\n");
//    appendCommand("2. Start game.\n");
//
//    String input = scan.next();
//    if (checkQuit(input) || !checkInt(input)) {
//      return;
//    }
//    int option = Integer.parseInt(input);
//    if (option == 1) {
//      try {
//        appendCommand(String.format("Map created successfully: %s", m.outputMap()));
//      } catch (IOException e) {
//        appendCommand("Map creation failed");
//      }
//    }
//
//    appendCommand("\n***********************************\n");
//    appendCommand("Game Start!\n");
//    // set max turns
//    appendCommand("* Please provide the maximum of turns: ");
//    String maxTurnStr = scan.next();
//    if (checkQuit(maxTurnStr) || !checkInt(maxTurnStr)) {
//      return;
//    }
//    int maxTurn = Integer.parseInt(maxTurnStr);
//    killDoctorLuckyCommand = new MaxTurn(maxTurn);
//
//    killDoctorLuckyCommand.execute(m);
//
//    // generate player
//    appendCommand("* Generate Player\n");
//    appendCommand("Please provide the number of players:");
//    String playersNumStr = scan.next();
//    if (checkQuit(playersNumStr) || !checkInt(playersNumStr)) {
//      return;
//    }
//    int playersNum = Integer.parseInt(playersNumStr);
//    for (int i = 0; i < playersNum; i++) {
//      appendCommand(String.format("** Genarating Player %d:\n", i + 1));
//      appendCommand("Please choose the player type:\n");
//      appendCommand("1.human\n");
//      appendCommand("2.robot\n");
//      String playTypeOptionStr = scan.next();
//      if (checkQuit(playTypeOptionStr) || !checkInt(playTypeOptionStr)) {
//        return;
//      }
//      int playTypeOption = Integer.parseInt(playTypeOptionStr);
//      if (playTypeOption == 1) {
//        appendCommand("Creating a human player...\n");
//      } else {
//        appendCommand("Creating a robot player...\n");
//      }
//      appendCommand("Please provide the name: ");
//      String playerName = scan.next();
//      if (checkQuit(playerName)) {
//        return;
//      }
//      appendCommand("Please provide the space index: ");
//      String playerSpaceIndexStr = scan.next();
//      if (checkQuit(playerSpaceIndexStr) || !checkInt(playerSpaceIndexStr)) {
//        return;
//      }
//      int playerSpaceIndex = Integer.parseInt(playerSpaceIndexStr);
//      appendCommand("Please provide the maximum number of items carried: ");
//      String maxItemsStr = scan.next();
//      if (checkQuit(maxItemsStr) || !checkInt(maxItemsStr)) {
//        return;
//      }
//      int maxItems = Integer.parseInt(maxItemsStr);
//      if (playTypeOption == 1) {
//        killDoctorLuckyCommand = new CreatePlayer(playerName, playerSpaceIndex, maxItems);
//      } else {
//        killDoctorLuckyCommand = new CreatePlayer(rg, playerName, playerSpaceIndex, maxItems);
//      }
//
//      killDoctorLuckyCommand.execute(m);
//
//    }
//
//    appendCommand("\n-----Players Information-----\n");
//    appendCommand(m.getPlayersInfo());
//
//    appendCommand("\n***********************************\n");
//
//    while (m.getTurns() < m.getMaxTurn() && m.getDoctorLuckyHealth() != 0) {
//
//      String playerName = m.getPlayerNameByTurn(m.getTurns());
//
//      appendCommand(
//          String.format("\n-----%s's turn, No.%d turn-----\n", playerName, m.getTurns() + 1));
//      appendCommand("* Before:\n");
//      appendCommand(String.format("%s\n", m.getPlayerInfoByName(playerName)));
//      appendCommand("* Choose action:\n");
//
//      int currentSpaceIndex = m.getCurrentSpaceIndexByPlayerName(playerName);
//      List<Space> neighbors = m.getNeighborsBySpaceIndex(currentSpaceIndex);
//      List<Item> items = m.getItemsBySpaceIndex(currentSpaceIndex);
//
//      appendCommand(String.format("1. Move to a neighboring space: %s\n", 
//          m.getNeighborsInfoBySpaceIndex(currentSpaceIndex)));
//      if (items.size() > 0) {
//        appendCommand(String.format("2. Pick up an item: %s\n", 
//            m.getItemsInfoBySpaceIndex(currentSpaceIndex)));
//      } else {
//        appendCommand("2. Pick up an item: no item can be picked.\n");
//      }
//      appendCommand("3. Look around\n");
//      appendCommand("4. Move the pet\n");
//      if (currentSpaceIndex == m.getDoctorLuckyCurrentSpaceIndex()) {
//        appendCommand("5. Make an attempt\n");
//      }
//
//      int choice;
//      if (m.gePlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
//        if (currentSpaceIndex == m.getDoctorLuckyCurrentSpaceIndex()) {
//          choice = 5;
//        } else {
//          choice = rg.nextInt(4) + 1;
//        }
//        if (items.size() <= 0) {
//          while (choice == 2) {
//            choice = rg.nextInt(4) + 1;
//          }
//        }
//
//      } else {
//        String choiceStr = scan.next();
//        if (checkQuit(choiceStr) || !checkInt(choiceStr)) {
//          return;
//        }
//        choice = Integer.parseInt(choiceStr);
//      }
//      appendCommand(String.format("%s chose the option %d\n", playerName, choice));
//
//      switch (choice) {
//        case 1:
//          appendCommand("** Choose a space to enter, input the index of space:\n");
//          List<Integer> spaceIndexList = new ArrayList<Integer>();
//          for (Space space : neighbors) {
//            appendCommand(String.format("%d. %s\n", space.getIndex(), space.getName()));
//            spaceIndexList.add(space.getIndex());
//          }
//          int spaceIndex;
//          if (m.gePlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
//            int option1 = rg.nextInt(spaceIndexList.size());
//            spaceIndex = spaceIndexList.get(option1);
//            appendCommand(String.format("%s chose the No.%d space.\n", playerName, spaceIndex));
//          } else {
//            String spaceIndexStr = scan.next();
//            if (checkQuit(spaceIndexStr) || !checkInt(spaceIndexStr)) {
//              return;
//            }
//            spaceIndex = Integer.parseInt(spaceIndexStr);
//          }
//          if (spaceIndexList.indexOf(spaceIndex) == -1) {
//            appendCommand("Invalid choice, choose again.\n");
//            continue;
//          }
//
//          killDoctorLuckyCommand = new MovePlayer(playerName, spaceIndex);
//          killDoctorLuckyCommand.execute(m);
//
//          break;
//        case 2:
//          int itemIndex = 1;
//          appendCommand("** Choose an item to pick up, input the index of item:\n");
//          List<String> itemNameList = new ArrayList<String>();
//          for (Item item : items) {
//            appendCommand(String.format("%d. %s\n", itemIndex++, item.getName()));
//            itemNameList.add(item.getName());
//          }
//          int itemChoice;
//          if (m.gePlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
//            int rdInt = rg.nextInt(itemNameList.size());
//            itemChoice = rdInt + 1;
//            String itemName = itemNameList.get(rdInt);
//            appendCommand(String.format("%s chose the %d.%s.\n", playerName, itemChoice, itemName));
//          } else {
//            String itemChoiceStr = scan.next();
//            if (checkQuit(itemChoiceStr) || !checkInt(itemChoiceStr)) {
//              return;
//            }
//            itemChoice = Integer.parseInt(itemChoiceStr);
//          }
//          String itemName;
//          try {
//            itemName = itemNameList.get(itemChoice - 1);
//          } catch (IndexOutOfBoundsException e) {
//            appendCommand("Invalid choice, choose again.\n");
//            continue;
//          }
//          try {
//            killDoctorLuckyCommand = new PickUpItem(playerName, itemName);
//            killDoctorLuckyCommand.execute(m);
//          } catch (IllegalStateException e) {
//            appendCommand(String.format("%s\n", e.getMessage()));
//          }
//          break;
//        case 3:
//          appendCommand(m.getAroundInfo(playerName));
//          break;
//        case 4:
//          appendCommand(
//              String.format("** Choose a space index[0-%d]:\n", m.getSpaceNumFromMansion() - 1));
//          int spaceChoice;
//          if (m.gePlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
//            spaceChoice = rg.nextInt(m.getSpaceNumFromMansion());
//            appendCommand(String.format("%s chose the No.%d space.\n", playerName, spaceChoice));
//          } else {
//            String spaceIndexStr = scan.next();
//            if (checkQuit(spaceIndexStr) || !checkInt(spaceIndexStr)) {
//              return;
//            }
//            spaceChoice = Integer.parseInt(spaceIndexStr);
//          }
//          if (spaceChoice < 0 || spaceChoice > 20) {
//            appendCommand("Invalid choice, choose again.\n");
//            continue;
//          }
//          appendCommand(
//              String.format("The pet has been moved into %d.%s\n", 
//                  spaceChoice, m.getSpaceNameByIndex(spaceChoice)));
//          m.movePet(spaceChoice);
//          break;
//        case 5:
//          boolean res = false;
//          String itemNameUse = "";
//          if (m.getItemsByPlayerName(playerName).size() == 0) {
//            res = m.makeAttempt(playerName, "");
//          } else {   
//            appendCommand("** Choose an item to use, input the index of item:\n");
//            int itemIndexInt = 1;
//            List<String> itemNameLi = new ArrayList<String>();
//            for (Item item : m.getItemsByPlayerName(playerName)) {
//              appendCommand(String.format("%d. %s; damage:%d\n", itemIndexInt++, item.getName(),
//                  item.getDamage()));
//              itemNameLi.add(item.getName());
//            }
//            if (m.gePlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
//              itemNameUse = m.getMostDamageItemNameByPlayerName(playerName);
//              appendCommand(String.format("%s chose the %s.\n", playerName, itemNameUse));
//            } else {
//              String itemChoiceStr = scan.next();
//              if (checkQuit(itemChoiceStr) || !checkInt(itemChoiceStr)) {
//                return;
//              }
//              try {
//                itemNameUse = itemNameLi.get(Integer.parseInt(itemChoiceStr) - 1);
//              } catch (NumberFormatException e) {
//                appendCommand("Invalid choice, choose again.\n");
//                continue;
//              } catch (IndexOutOfBoundsException e) {
//                appendCommand("Invalid choice, choose again.\n");
//                continue;
//              }
//            }
//            res = m.makeAttempt(playerName, itemNameUse);
//          }
//          if (res) {
//            if ("".equals(itemNameUse)) {
//              appendCommand("Poke doctor's eyes, attack Successfully!\n");
//            } else {
//              appendCommand(String.format("Use %s, attack Successfully!\n", itemNameUse));
//            }
//          } else {
//            appendCommand("Attack Failed! You are seen by another player!\n");
//          }
//          break;
//
//        default:
//          appendCommand("Invalid choice. Please choose a valid option.\n");
//          break;
//
//      }
//      appendCommand("* After:\n");
//      appendCommand(String.format("%s\n", m.getPlayerInfoByName(playerName)));
//      appendCommand(String.format("%s's current space is %d.%s; health is %d\n",
//          m.getDoctorLuckyName(), m.getDoctorLuckyCurrentSpaceIndex(),
//          m.getSpaceNameByIndex(m.getDoctorLuckyCurrentSpaceIndex()), m.getDoctorLuckyHealth()));
//      appendCommand(String.format("%s's current space is %d.%s\n", m.getPetName(),
//          m.getPetCurrentSpaceIndex(), m.getSpaceNameByIndex(m.getPetCurrentSpaceIndex())));
//    }
//    appendCommand("\n***********************************\n");
//    if (m.getDoctorLuckyHealth() == 0) {
//      appendCommand(String.format("Game Over! Doctor Lucky has been killed, Winner is %s\n",
//          m.getPlayerNameByTurn(m.getTurns())));
//    } else {
//      appendCommand("Game Over! You have reached the maximum number of turns,"
//          + " Docotr has escaped.\n");
//    }
//    
//
//  }

  @Override
  public void setModelView(KillDoctorLucky m, KillDoctorLuckyView v) {
    model = m;
    view = v;
    view.setFeatures(this);
    view.setModel(model);

  }

  @Override
  public void startGame() {
    try {
      killDoctorLuckyCommand = new Parse(this.filePath);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    killDoctorLuckyCommand.execute(model);
    view.startGame();

  }

  @Override
  public void startGame(String mansionFile) {

    this.filePath = mansionFile;
    startGame();

  }

  @Override
  public int[] movePlayer(String playerName, int spaceIndex) {
    for (Space space : model.getNeighborsBySpaceIndex(model.getCurrentSpaceIndexByPlayerName(playerName))) {
      if (space.getIndex() == spaceIndex) {
        killDoctorLuckyCommand = new MovePlayer(playerName, spaceIndex);
        killDoctorLuckyCommand.execute(model);
        return new int[] {space.getPoints()[1], space.getPoints()[0]};
        
      } 
    }
    return new int[] {-1, -1};
  }

  @Override
  public void pickUpItem(String playerName, String itemName) {
    model.pickUpItem(playerName, itemName); 
  }

}
