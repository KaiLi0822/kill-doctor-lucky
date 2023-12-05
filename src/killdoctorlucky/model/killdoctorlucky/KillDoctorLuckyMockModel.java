package killdoctorlucky.model.killdoctorlucky;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.DoctorLuckyModel;
import killdoctorlucky.model.character.PetModel;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerModel;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.mansion.Mansion;
import killdoctorlucky.model.mansion.MansionModel;
import killdoctorlucky.model.space.Space;

/**
 * The implement class of KillDoctorLucky.
 */
public class KillDoctorLuckyMockModel implements KillDoctorLucky {
  private DoctorLucky doctorLucky;
  private Mansion mansion;
  private List<Player> players = new ArrayList<Player>();
  private int maxTurn;
  private int turn;
  private PetModel pet;
  private Appendable out;

  /**
   * Constructor of KillDoctorLuckyMockModel.
   * 
   * @param outIn the out
   */
  public KillDoctorLuckyMockModel(Appendable outIn) {
    this.out = outIn;
  }

  @Override
  public void setMansion(String mansionName, int mansionHeight, int mansionWidth) {
    try {
      out.append("!!Enter setMansion.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    mansion = new MansionModel(mansionName, mansionHeight, mansionWidth);
  }

  @Override
  public void setDoctorLucky(String doctorName, int doctorHealth) {
    try {
      out.append("!!Enter setDoctorLucky.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    doctorLucky = new DoctorLuckyModel(doctorName, doctorHealth);
  }

  @Override
  public void setMaxTurn(int maxTurnIn) {
    try {
      out.append("!!Enter setMaxTurn.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    maxTurn = maxTurnIn;

  }

  @Override
  public void addPlayer(PlayerType playerType, String playerName, int spaceIndex, int maxItem) {
    try {
      out.append("!!Enter addPlayer.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    Player player = new PlayerModel(playerType, playerName, spaceIndex, maxItem);
    players.add(player);
    mansion.getSpaceByIndex(spaceIndex).addPlayer(player);

  }

  @Override
  public String getPlayersInfo() {
    try {
      out.append("!!Enter getPlayersInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuffer sb = new StringBuffer();
    for (Player player : players) {
      sb.append(player.toString());
      sb.setLength(sb.length() - 1);
      sb.append(", currentSpaceName=");
      sb.append(mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).getName());
      sb.append("]\n");
    }
    return sb.toString();
  }

  @Override
  public int getMaxTurn() {
    try {
      out.append("!!Enter getMaxTurn.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return maxTurn;
  }

  @Override
  public String getPlayerNameByTurn(int index) {
    try {
      out.append("!!Enter getPlayerNameByTurn.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return players.get(index % players.size()).getName();
  }

  /**
   * split line.
   * 
   * @param line the line
   * @return String[] after split
   */
  private String[] splitLine(String line) {
    List<String> arrList = new ArrayList<>();
    Pattern pattern = Pattern.compile("(\\d+(?:\\s+\\d+)*)\\s+(.+)");
    Matcher matcher = pattern.matcher(line.trim());
    if (matcher.matches()) {
      String[] numbers = matcher.group(1).trim().split("\\s+");
      for (String string : numbers) {
        arrList.add(string);
      }
      String lastPart = matcher.group(2).trim();
      if (lastPart.length() > 0) {
        arrList.add(lastPart);
      }
      return arrList.toArray(new String[arrList.size()]);
    }
    return new String[] { line.trim() };

  }

  /**
   * Starts a new Turn.
   */
  private void newTurn() {
    try {
      out.append("!!Enter newTurn.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    turn++;
    doctorLucky.move((doctorLucky.getCurrentSpaceIndex() + 1) % mansion.getSpacesNum());
    pet.move(pet.nextSpaceIndexInRoute(pet.getCurrentSpaceIndex()));
  }

  @Override
  public void initiateGame(Readable readable) {
    try {
      out.append("!!Enter initiateGame.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (Scanner scan = new Scanner(readable)) {
      int index = 0;
      while (scan.hasNextLine()) {
        String[] part = splitLine(scan.nextLine());
        try {
          // generate mansion
          if (part.length == 3 && mansion == null) {
            setMansion(part[2], Integer.parseInt(part[0]), Integer.parseInt(part[1]));
          }
          // generate target character
          if (part.length == 2) {
            setDoctorLucky(part[1], Integer.parseInt(part[0]));
          }

          // generate spaces
          if (part.length == 1 && pet == null) {
            setPet(part[0]);
            continue;
          }

          // generate spaces
          if (part.length == 1 && mansion.getSpacesNum() == 0) {
            mansion.setSpacesNum(Integer.parseInt(part[0]));
          }

          if (part.length == 5) {
            mansion.addSpace(index++, part[4], Arrays.copyOfRange(part, 0, 4));

          }

          // generate items
          if (part.length == 1 && mansion.getSpacesNum() != 0) {
            mansion.setItemsNum(Integer.parseInt(part[0]));
            continue;
          }

          if (part.length == 3 && mansion.getItemsNum() != 0) {
            mansion.getSpaceByIndex(Integer.parseInt(part[0])).addItem(part[2],
                Integer.parseInt(part[0]), Integer.parseInt(part[1]));

          }
          if (part.length == 4) {

            if (Integer.parseInt(part[0]) == 1) {
              addPlayer(PlayerType.HUMAN, part[3], Integer.parseInt(part[1]),
                  Integer.parseInt(part[2]));
            } else {
              addPlayer(PlayerType.ROBOT, part[3], Integer.parseInt(part[1]),
                  Integer.parseInt(part[2]));
            }
          }
        } catch (NumberFormatException e) {
          throw new NumberFormatException("Specification file format is wrong.");
        }
      }
      scan.close();
    }
    List<Space> spaces = mansion.getSpaces();
    // set neighbors of each space
    for (int i = 0; i < spaces.size(); i++) {
      for (int j = 0; j < spaces.size(); j++) {
        if (spaces.get(i).getName() != spaces.get(j).getName()) {
          spaces.get(i).addNeighbor(spaces.get(j));
        }
      }
    }
    // set route of pet
    pet.createRoute(0, mansion);

  }

  @Override
  public String outputMap() throws IOException {
    try {
      out.append("!!Enter outputMap.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Create a BufferedImage
    BufferedImage image = new BufferedImage(mansion.getWidth() * 30 + 6,
        mansion.getHeight() * 30 + 6, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = image.createGraphics();

    // Set background color
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, mansion.getWidth() * 30 + 6, mansion.getHeight() * 30 + 6);

    // Draw rectangles for each room
    g.setColor(Color.BLACK);
    List<Space> spaces = mansion.getSpaces();
    for (int i = 0; i < spaces.size(); i++) {

      int roomMinCol = spaces.get(i).getPoints()[1];
      int roomMinRow = spaces.get(i).getPoints()[0];
      int roomMaxCol = spaces.get(i).getPoints()[3];
      int roomMaxRow = spaces.get(i).getPoints()[2];
      String roomInfo = String.format("%d.%s", spaces.get(i).getIndex(), spaces.get(i).getName());

      int width = roomMaxCol - roomMinCol + 1;
      int height = roomMaxRow - roomMinRow + 1;
      int x = roomMinCol;
      int y = roomMinRow;

      g.drawRect(x * 30 + 3, y * 30 + 3, width * 30, height * 30);
      g.drawString(roomInfo, x * 30 + 5, y * 30 + 15);
    }

    // Save the image to a file

    File outputFile = new File("WorldMap.png");
    try {
      ImageIO.write(image, "png", outputFile);
    } catch (IOException e) {
      throw new IOException("World Map Generate Failed.");
    }
    String filePath = outputFile.getAbsolutePath();

    g.dispose();
    return filePath;

  }

  @Override
  public String getPlayerInfoByName(String name) {
    try {
      out.append("!!Enter getPlayerInfoByName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuffer sb = new StringBuffer();
    int index = getCurrentSpaceIndexByPlayerName(name);
    for (Player player : players) {
      if (name.equals(player.getName())) {
        sb.append(player.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", currentSpaceName=");
        sb.append(mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).getName());
        sb.append("]");
        if (player.getCurrentSpaceIndex() == doctorLucky.getCurrentSpaceIndex()) {
          sb.setLength(sb.length() - 1);
          sb.append(", Doctor Lucky's health=");
          sb.append(doctorLucky.getHealth());
          sb.append("]");
        }
        if (player.getCurrentSpaceIndex() == pet.getCurrentSpaceIndex()) {
          sb.setLength(sb.length() - 1);
          sb.append(", pet=");
          sb.append(pet.getName());
          sb.append("]");
        }
      }
    }
    List<String> names = new LinkedList<String>();
    if (sb.length() != 0) {
      for (Player player : players) {
        if (index == player.getCurrentSpaceIndex() && !name.equals(player.getName())) {
          names.add(player.getName());
        }
      }
      if (names.size() != 0) {
        sb.setLength(sb.length() - 1);
        sb.append(", players=");
        sb.append(names.toString());
        sb.append("]");
      }
      return sb.toString();
    } else {
      return "";
    }
  }

  @Override
  public void movePlayer(String playerName, int targetSpace) {
    try {
      out.append("!!Enter movePlayer.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    Player player = getPlayerByName(playerName);
    mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).removePlayer(player);
    player.move(targetSpace);
    mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).addPlayer(player);
    newTurn();

  }

  @Override
  public void pickUpItem(String playerName, String itemName) {
    try {
      out.append("!!Enter pickUpItem.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    newTurn();
    Player player = getPlayerByName(playerName);
    Space space = mansion.getSpaceByIndex(player.getCurrentSpaceIndex());
    Item item = space.getItemByname(itemName);
    player.pickUpItem(item);
    space.removeItem(item);

  }

  @Override
  public String getAroundInfo(String playerName) {
    try {
      out.append("!!Enter getAroundInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    List<Space> neighbors = getNeighborsBySpaceIndex(getCurrentSpaceIndexByPlayerName(playerName));
    StringBuffer stringBuffer = new StringBuffer();
    for (Space space : neighbors) {
      stringBuffer.append(String.format("** %d. %s\n", space.getIndex(), space.getName()));
      if (pet.getCurrentSpaceIndex() == space.getIndex()) {
        stringBuffer.append("This space is invisible.\n");
        continue;
      }
      stringBuffer.append(space.toString());
      if (space.getIndex() == doctorLucky.getCurrentSpaceIndex()) {
        stringBuffer.setLength(stringBuffer.length() - 1);
        stringBuffer.append(", Doctor Lucky's health=");
        stringBuffer.append(doctorLucky.getHealth());
        stringBuffer.append("]");
      }
      if (space.getIndex() == pet.getCurrentSpaceIndex()) {
        stringBuffer.setLength(stringBuffer.length() - 1);
        stringBuffer.append(", pet=");
        stringBuffer.append(pet.getName());
        stringBuffer.append("]");
      }
      stringBuffer.append("\n");
    }
    newTurn();
    return stringBuffer.toString();
  }

  @Override
  public int getTurns() {
    try {
      out.append("!!Enter getTurns.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return turn;
  }

  @Override
  public String getMansionInfo() {
    try {
      out.append("!!Enter getMansionInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.toString();
  }

  @Override
  public String getDoctorLuckyInfo() {
    try {
      out.append("!!Enter getDoctorLuckyInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doctorLucky.toString();
  }

  private Player getPlayerByName(String playerName) {
    try {
      out.append("!!Enter getPlayerByName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (Player player : players) {
      if (playerName.equals(player.getName())) {
        return player;
      }
    }
    return null;
  }

  @Override
  public int getCurrentSpaceIndexByPlayerName(String playerName) {
    try {
      out.append("!!Enter getCurrentSpaceIndexByPlayerName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getPlayerByName(playerName).getCurrentSpaceIndex();
  }

  @Override
  public List<Space> getNeighborsBySpaceIndex(int index) {
    try {
      out.append("!!Enter getNeighborsBySpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaceByIndex(index).getNeighbors();
  }

  @Override
  public List<Item> getItemsBySpaceIndex(int index) {
    try {
      out.append("!!Enter getItemsBySpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaceByIndex(index).getItems();
  }

  @Override
  public PlayerType getPlayerTypeByName(String playerName) {
    try {
      out.append("!!Enter gePlayerTypeByName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getPlayerByName(playerName).gePlayerType();
  }

  @Override
  public String getDoctorLuckyName() {
    try {
      out.append("!!Enter getDoctorLuckyName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doctorLucky.getName();
  }

  @Override
  public int getDoctorLuckyCurrentSpaceIndex() {
    try {
      out.append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doctorLucky.getCurrentSpaceIndex();
  }

  @Override
  public int getDoctorLuckyHealth() {
    try {
      out.append("!!Enter getDoctorLuckyHealth.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doctorLucky.getHealth() > 0 ? doctorLucky.getHealth() : 0;
  }

  @Override
  public String getSpaceNameByIndex(int index) {
    try {
      out.append("!!Enter getSpaceNameByIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaceByIndex(index).getName();
  }

  @Override
  public String getSpaceInfo(int index) {
    try {
      out.append("!!Enter getSpaceInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaceByIndex(index).toString();
  }

  @Override
  public void setPet(String petName) {
    try {
      out.append("!!Enter setPet.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    pet = new PetModel(petName);
  }

  @Override
  public String getPetName() {
    try {
      out.append("!!Enter getPetName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pet.getName();
  }

  @Override
  public int getPetCurrentSpaceIndex() {
    try {
      out.append("!!Enter getPetCurrentSpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pet.getCurrentSpaceIndex();
  }

  @Override
  public int getSpaceNumFromMansion() {
    try {
      out.append("!!Enter getSpaceNumFromMansion.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpacesNum();
  }

  @Override
  public void movePet(int index) {
    try {
      out.append("!!Enter movePet.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    pet.move(index);
    pet.createRoute(index, mansion);
    newTurn();

  }

  @Override
  public List<Item> getItemsByPlayerName(String playerName) {
    try {
      out.append("!!Enter getItemsByPlayerName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getPlayerByName(playerName).getItems();
  }

  @Override
  public String getMostDamageItemNameByPlayerName(String playerName) {
    try {
      out.append("!!Enter getMostDamageItemNameByPlayerName.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return getPlayerByName(playerName).getItemNameWithMaxDamage();
  }

  @Override
  public Boolean makeAttempt(String playerName, String itemName) {
    try {
      out.append("!!Enter makeAttempt.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

    int playerSpaceIndex = getPlayerByName(playerName).getCurrentSpaceIndex();
    for (Player player : players) {
      if (playerSpaceIndex == player.getCurrentSpaceIndex()
          && !playerName.equals(player.getName())) {
        newTurn();
        return false;
      }
    }
    if (playerSpaceIndex != pet.getCurrentSpaceIndex()) {
      for (Space space : getNeighborsBySpaceIndex(playerSpaceIndex)) {
        if (space.getPlayers().size() != 0) {
          newTurn();
          return false;
        }
      }
    }
    if ("".equals(itemName)) {
      doctorLucky.deductHealth(1);
    } else {
      int damage = getPlayerByName(playerName).removeItemByName(itemName);
      doctorLucky.deductHealth(damage);
    }
    newTurn();
    return true;
  }

  @Override
  public String getPetInfo() {
    try {
      out.append("!!Enter getPetInfo.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return pet.toString();
  }

  @Override
  public String getNeighborsInfoBySpaceIndex(int spaceIndex) {
    try {
      out.append("!!Enter getNeighborsInfoBySpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuffer sb = new StringBuffer();
    for (Space space : getNeighborsBySpaceIndex(spaceIndex)) {
      sb.append(space.getIndex());
      sb.append(".");
      sb.append(space.getName());
      sb.append("; ");
    }
    return sb.toString();
  }

  @Override
  public String getItemsInfoBySpaceIndex(int spaceIndex) {
    try {
      out.append("!!Enter getItemsInfoBySpaceIndex.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuffer sb = new StringBuffer();
    for (Item item : getItemsBySpaceIndex(spaceIndex)) {
      sb.append(item.getName());
      sb.append(":");
      sb.append(item.getDamage());
      sb.append("; ");
    }
    return sb.toString();
  }

  @Override
  public int getWidthFromMansion() {
    try {
      out.append("!!Enter getWidthFromMansion.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getWidth();
  }

  @Override
  public int getHeightFromMansion() {
    try {
      out.append("!!Enter getHeightFromMansion.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getHeight();
  }

  @Override
  public List<Space> getSpacesFromMansion() {
    try {
      out.append("!!Enter getSpacesFromMansion.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaces();
  }

  @Override
  public List<Player> getPlayers() {
    try {
      out.append("!!Enter getPlayers.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.unmodifiableList(players);
  }

}
