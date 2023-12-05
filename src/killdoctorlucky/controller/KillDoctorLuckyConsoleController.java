package killdoctorlucky.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import killdoctorlucky.controller.command.MovePet;
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

  private Appendable out;
  private Scanner scan;
  private final RandomGenerator rg;
  private String filePath;
  private final int maxTurn;

  private KillDoctorLuckyCommand killDoctorLuckyCommand;
  private KillDoctorLucky model;
  private KillDoctorLuckyView view;

  private RobotAttributions robotAttributions;

  /**
   * Constructor for the controller.
   * 
   * @param rgIn       the random object
   * @param maxTurnIn  the max turn
   * @param filePathIn the filePath
   */
  public KillDoctorLuckyConsoleController(RandomGenerator rgIn, String filePathIn,
      String maxTurnIn) {
    this.rg = rgIn;
    this.filePath = filePathIn;
    this.maxTurn = Integer.parseInt(maxTurnIn);
  }

  /**
   * Constructor for the controller.
   * 
   * @param in         the source to read from
   * @param outIn      the target to print to
   * @param rgIn       the random object
   * @param maxTurnIn  the max turn
   * @param filePathIn the filePath
   */
  public KillDoctorLuckyConsoleController(Readable in, Appendable outIn, RandomGenerator rgIn,
      String filePathIn, String maxTurnIn) {
    if (in == null || outIn == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    scan = new Scanner(in);
    this.out = outIn;
    this.rg = rgIn;
    this.filePath = filePathIn;
    this.maxTurn = Integer.parseInt(maxTurnIn);
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
   * Checks if quit.
   * 
   * @param input the input
   * @return if q or Q return true
   */
  private Boolean checkQuit(String input) {
    if ("q".equals(input) || "Q".equals(input)) {
      appendCommand("Game Quit.");
      return true;
    }
    return false;
  }

  /**
   * Checks if int.
   * 
   * @param input the input
   * @return if int return true
   */
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
  public void playGame() {

    try {
      killDoctorLuckyCommand = new Parse(filePath, maxTurn);
    } catch (FileNotFoundException e) {
      appendCommand(String.format("%s\n", e.getMessage()));
      return;
    }

    try {
      killDoctorLuckyCommand.execute(model);
    } catch (IllegalStateException e) {
      appendCommand(String.format("%s\n", e.getMessage()));
      return;
    }

    appendCommand("***********************************\n");
    appendCommand("Mansion created successfully, the information is as follows:");
    appendCommand("\n-----Mansion Information-----\n");
    appendCommand(model.getMansionInfo());
    appendCommand("\n-----Main Character Information-----\n");
    appendCommand(model.getDoctorLuckyInfo());
    appendCommand("\n-----Pet Information-----\n");
    appendCommand(model.getPetInfo());

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
        appendCommand(String.format("Map created successfully: %s", model.outputMap()));
      } catch (IOException e) {
        appendCommand("Map creation failed");
      }
    }

    appendCommand("\n***********************************\n");
    appendCommand("Game Start!\n");

    appendCommand("\n-----Players Information-----\n");
    appendCommand(model.getPlayersInfo());

    appendCommand("\n***********************************\n");

    while (model.getTurns() < model.getMaxTurn() && model.getDoctorLuckyHealth() != 0) {

      String playerName = model.getPlayerNameByTurn(model.getTurns());

      appendCommand(
          String.format("\n-----%s's turn, No.%d turn-----\n", playerName, model.getTurns() + 1));
      appendCommand("* Before:\n");
      appendCommand(String.format("%s\n", model.getPlayerInfoByName(playerName)));
      appendCommand("* Choose action:\n");

      int currentSpaceIndex = model.getCurrentSpaceIndexByPlayerName(playerName);
      List<Space> neighbors = model.getNeighborsBySpaceIndex(currentSpaceIndex);
      List<Item> items = model.getItemsBySpaceIndex(currentSpaceIndex);

      appendCommand(String.format("1. Move to a neighboring space: %s\n",
          model.getNeighborsInfoBySpaceIndex(currentSpaceIndex)));
      if (items.size() > 0) {
        appendCommand(String.format("2. Pick up an item: %s\n",
            model.getItemsInfoBySpaceIndex(currentSpaceIndex)));
      } else {
        appendCommand("2. Pick up an item: no item can be picked.\n");
      }
      appendCommand("3. Look around\n");
      appendCommand("4. Move the pet\n");
      if (currentSpaceIndex == model.getDoctorLuckyCurrentSpaceIndex()) {
        appendCommand("5. Make an attempt\n");
      }

      int choice;
      if (model.getPlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
        robotAttributions = new RobotAttributions();
        choice = robotAttributions.getFirstChoice();
      } else {
        String choiceStr = scan.next();
        if (checkQuit(choiceStr) || !checkInt(choiceStr)) {
          return;
        }
        choice = Integer.parseInt(choiceStr);
      }
      appendCommand(String.format("%s chose the option %d\n", playerName, choice));

      switch (choice) {
        case 1:
          appendCommand("** Choose a space to enter, input the index of space:\n");
          List<Integer> spaceIndexList = new ArrayList<Integer>();
          for (Space space : neighbors) {
            appendCommand(String.format("%d. %s\n", space.getIndex(), space.getName()));
            spaceIndexList.add(space.getIndex());
          }
          int spaceIndex;
          if (model.getPlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
            spaceIndex = robotAttributions.getMoveSpaceIndex();
            appendCommand(String.format("%s chose the No.%d space.\n", playerName, spaceIndex));
          } else {
            String spaceIndexStr = scan.next();
            if (checkQuit(spaceIndexStr) || !checkInt(spaceIndexStr)) {
              return;
            }
            spaceIndex = Integer.parseInt(spaceIndexStr);
          }
          int[] arr = movePlayer(playerName, spaceIndex);
          int x = arr[0];
          if (x == -1) {
            appendCommand("Invalid choice, choose again.\n");
            continue;
          }

          break;
        case 2:
          int itemIndex = 1;
          appendCommand("** Choose an item to pick up, input the index of item:\n");
          List<String> itemNameList = new ArrayList<String>();
          for (Item item : items) {
            appendCommand(String.format("%d. %s\n", itemIndex++, item.getName()));
            itemNameList.add(item.getName());
          }
          String itemName;
          if (model.getPlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
            itemName = robotAttributions.getItemName();
            appendCommand(String.format("%s chose the %s.\n", playerName, itemName));
          } else {
            String itemChoiceStr = scan.next();
            if (checkQuit(itemChoiceStr) || !checkInt(itemChoiceStr)) {
              return;
            }
            int itemChoice = Integer.parseInt(itemChoiceStr);
            try {
              itemName = itemNameList.get(itemChoice - 1);
            } catch (IndexOutOfBoundsException e) {
              appendCommand("Invalid choice, choose again.\n");
              continue;
            }
          }
          Boolean pickRes = pickUpItem(playerName, itemName);
          if (!pickRes) {
            appendCommand("Can not pick up more items.\n");
          }

          break;
        case 3:
          appendCommand(model.getAroundInfo(playerName));
          break;
        case 4:
          appendCommand(String.format("** Choose a space index[0-%d]:\n",
              model.getSpaceNumFromMansion() - 1));
          int spaceChoice;
          if (model.getPlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
            spaceChoice = robotAttributions.getMovePetSpaceIndex();
            appendCommand(String.format("%s chose the No.%d space.\n", playerName, spaceChoice));
          } else {
            String spaceIndexStr = scan.next();
            if (checkQuit(spaceIndexStr) || !checkInt(spaceIndexStr)) {
              return;
            }
            spaceChoice = Integer.parseInt(spaceIndexStr);
          }

          if (spaceChoice < 0 || spaceChoice > 20) {
            appendCommand("Invalid choice, choose again.\n");
            continue;
          }
          appendCommand(String.format("The pet has been moved into %d.%s\n", spaceChoice,
              model.getSpaceNameByIndex(spaceChoice)));
          movePet(spaceChoice);
          break;
        case 5:
          boolean res = false;
          String itemNameUse = "";
          if (model.getItemsByPlayerName(playerName).size() == 0) {
            res = makeAttempt(playerName, "");
          } else {
            appendCommand("** Choose an item to use, input the index of item:\n");
            int itemIndexInt = 1;
            List<String> itemNameLi = new ArrayList<String>();
            for (Item item : model.getItemsByPlayerName(playerName)) {
              appendCommand(String.format("%d. %s; damage:%d\n", itemIndexInt++, item.getName(),
                  item.getDamage()));
              itemNameLi.add(item.getName());
            }
            if (model.getPlayerTypeByName(playerName).equals(PlayerType.ROBOT)) {
              itemNameUse = robotAttributions.getMostDamageItemName();
              appendCommand(String.format("%s chose the %s.\n", playerName, itemNameUse));
            } else {
              String itemChoiceStr = scan.next();
              if (checkQuit(itemChoiceStr) || !checkInt(itemChoiceStr)) {
                return;
              }
              try {
                itemNameUse = itemNameLi.get(Integer.parseInt(itemChoiceStr) - 1);
              } catch (NumberFormatException e) {
                appendCommand("Invalid choice, choose again.\n");
                continue;
              } catch (IndexOutOfBoundsException e) {
                appendCommand("Invalid choice, choose again.\n");
                continue;
              }
            }

            res = makeAttempt(playerName, itemNameUse);
          }
          if (res) {
            if ("".equals(itemNameUse)) {
              appendCommand("Poke doctor's eyes, attack Successfully!\n");
            } else {
              appendCommand(String.format("Use %s, attack Successfully!\n", itemNameUse));
            }
          } else {
            appendCommand("Attack Failed! You are seen by another player!\n");
          }
          break;

        default:
          appendCommand("Invalid choice. Please choose a valid option.\n");
          break;

      }
      appendCommand("* After:\n");
      appendCommand(String.format("%s\n", model.getPlayerInfoByName(playerName)));
      appendCommand(String.format("%s's current space is %d.%s; health is %d\n",
          model.getDoctorLuckyName(), model.getDoctorLuckyCurrentSpaceIndex(),
          model.getSpaceNameByIndex(model.getDoctorLuckyCurrentSpaceIndex()),
          model.getDoctorLuckyHealth()));
      appendCommand(String.format("%s's current space is %d.%s\n", model.getPetName(),
          model.getPetCurrentSpaceIndex(),
          model.getSpaceNameByIndex(model.getPetCurrentSpaceIndex())));
    }
    appendCommand("\n***********************************\n");
    if (model.getDoctorLuckyHealth() == 0) {
      appendCommand(String.format("Game Over! Doctor Lucky has been killed, Winner is %s\n",
          model.getPlayerNameByTurn(model.getTurns() - 1)));
    } else {
      appendCommand(
          "Game Over! You have reached the maximum number of turns," + " Docotr has escaped.\n");
    }

  }

  private class RobotAttributions {
    private String playerName;
    private int currentSpaceIndex;
    private List<Item> spaceItems;
    private List<Space> neighbors;

    public RobotAttributions() {
      this.playerName = model.getPlayerNameByTurn(model.getTurns());
      this.currentSpaceIndex = model.getCurrentSpaceIndexByPlayerName(playerName);
      this.spaceItems = model.getItemsBySpaceIndex(currentSpaceIndex);
      this.neighbors = model.getNeighborsBySpaceIndex(currentSpaceIndex);
    }

    int getFirstChoice() {
      int choice;
      if (currentSpaceIndex == model.getDoctorLuckyCurrentSpaceIndex()) {
        choice = 5;
      } else {
        choice = rg.nextInt(4) + 1;
      }
      if (spaceItems.size() <= 0) {
        while (choice == 2) {
          choice = rg.nextInt(4) + 1;
        }
      }
      return choice;
    }

    int getMoveSpaceIndex() {
      int option = rg.nextInt(neighbors.size());
      return neighbors.get(option).getIndex();
    }

    String getItemName() {
      int option = rg.nextInt(spaceItems.size());
      return spaceItems.get(option).getName();
    }

    int getMovePetSpaceIndex() {
      int option = rg.nextInt(model.getSpaceNumFromMansion());
      return option;
    }

    String getMostDamageItemName() {
      return model.getMostDamageItemNameByPlayerName(playerName);
    }
  }

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
      killDoctorLuckyCommand = new Parse(this.filePath, this.maxTurn);
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
    for (Space space : model
        .getNeighborsBySpaceIndex(model.getCurrentSpaceIndexByPlayerName(playerName))) {
      if (space.getIndex() == spaceIndex) {
        killDoctorLuckyCommand = new MovePlayer(playerName, spaceIndex);
        killDoctorLuckyCommand.execute(model);
        return new int[] { space.getPoints()[1], space.getPoints()[0] };
      }
    }
    return new int[] { -1, -1 };
  }

  @Override
  public Boolean pickUpItem(String playerName, String itemName) {
    try {
      killDoctorLuckyCommand = new PickUpItem(playerName, itemName);
      killDoctorLuckyCommand.execute(model);
    } catch (IllegalStateException e) {
      return false;
    }
    return true;
  }

  @Override
  public void movePet(int spaceIndex) {
    killDoctorLuckyCommand = new MovePet(spaceIndex);
    killDoctorLuckyCommand.execute(model);

  }

  @Override
  public Boolean makeAttempt(String playerName, String itemName) {
    return model.makeAttempt(playerName, itemName);
  }

  @Override
  public Boolean isGameOver() {
    if (model.getTurns() >= model.getMaxTurn() || model.getDoctorLuckyHealth() <= 0) {
      return true;
    }
    return false;
  }

  @Override
  public String getWinner() {
    if (isGameOver() && model.getDoctorLuckyHealth() <= 0) {
      return model.getPlayerNameByTurn(model.getTurns() - 1);
    }
    return "";
  }

  @Override
  public List<String> robotTurn() {
    robotAttributions = new RobotAttributions();
    List<String> strs = new LinkedList<String>();
    int choice = robotAttributions.getFirstChoice();
    String playerName = robotAttributions.playerName;
    switch (choice) {
      case 1:
        strs.add("s");
        strs.add(playerName);
        // Each time call the function, get a new random value
        String moveSpaceIndex = String.valueOf(robotAttributions.getMoveSpaceIndex());
        strs.add(moveSpaceIndex);
        int[] arr = movePlayer(playerName, Integer.parseInt(moveSpaceIndex));
        strs.add(String.valueOf(arr[0]));
        strs.add(String.valueOf(arr[1]));
        break;
      case 2:
        strs.add("p");
        String itemName = robotAttributions.getItemName();
        Boolean res = pickUpItem(playerName, itemName);
        strs.add(String.valueOf(res));
        strs.add(playerName);
        strs.add(itemName);
        break;
      case 3:
        strs.add("l");
        break;
      case 4:
        strs.add("m");
        int spaceIndex = robotAttributions.getMovePetSpaceIndex();
        movePet(spaceIndex);
        strs.add(playerName);
        strs.add(String.valueOf(spaceIndex));
        break;
      case 5:
        strs.add("a");
        String itemNameUse = robotAttributions.getMostDamageItemName();
        Boolean resAttempt = makeAttempt(playerName, itemNameUse);
        strs.add(String.valueOf(resAttempt));
        strs.add(playerName);
        strs.add(itemNameUse);
        break;

      default:
        break;
    }
    return strs;
  }

  @Override
  public void setModel(KillDoctorLucky m) {
    model = m;

  }

}
