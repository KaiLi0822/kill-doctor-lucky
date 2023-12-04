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
public class KillDoctorLuckyModel implements KillDoctorLucky {
  private DoctorLucky doctorLucky;
  private Mansion mansion;
  private List<Player> players = new ArrayList<Player>();
  private int maxTurn;
  private int turn;
  private PetModel pet;

  @Override
  public void setMansion(String mansionName, int mansionHeight, int mansionWidth) {
    mansion = new MansionModel(mansionName, mansionHeight, mansionWidth);
  }

  @Override
  public void setDoctorLucky(String doctorName, int doctorHealth) {
    doctorLucky = new DoctorLuckyModel(doctorName, doctorHealth);
  }

  @Override
  public void setMaxTurn(int maxTurnIn) {
    maxTurn = maxTurnIn;

  }

  @Override
  public void addPlayer(PlayerType playerType, String playerName, int spaceIndex, int maxItem) {
    Player player = new PlayerModel(playerType, playerName, spaceIndex, maxItem);
    players.add(player);
    mansion.getSpaceByIndex(spaceIndex).addPlayer(player);

  }

  @Override
  public String getPlayersInfo() {
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
    return maxTurn;
  }

  @Override
  public String getPlayerNameByTurn(int index) {
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
    turn++;
    doctorLucky.move((doctorLucky.getCurrentSpaceIndex() + 1) % mansion.getSpacesNum());
    pet.move(pet.nextSpaceIndexInRoute(pet.getCurrentSpaceIndex()));
  }

  @Override
  public void initiateGame(Readable readable) {

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
            continue;
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
              addPlayer(PlayerType.HUMAN, part[3], Integer.parseInt(part[1]), Integer.parseInt(part[2]));
            }else { 
              addPlayer(PlayerType.ROBOT, part[3], Integer.parseInt(part[1]), Integer.parseInt(part[2]));
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
    Player player = getPlayerByName(playerName);
    mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).removePlayer(player);
    player.move(targetSpace);
    mansion.getSpaceByIndex(player.getCurrentSpaceIndex()).addPlayer(player);
    newTurn();

  }

  @Override
  public void pickUpItem(String playerName, String itemName) {
    newTurn();
    Player player = getPlayerByName(playerName);
    Space space = mansion.getSpaceByIndex(player.getCurrentSpaceIndex());
    Item item = space.getItemByname(itemName);
    player.pickUpItem(item);
    space.removeItem(item);

  }

  @Override
  public String getAroundInfo(String playerName) {
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
    return turn;
  }

  @Override
  public String getMansionInfo() {
    return mansion.toString();
  }

  @Override
  public String getDoctorLuckyInfo() {
    return doctorLucky.toString();
  }

  private Player getPlayerByName(String playerName) {
    for (Player player : players) {
      if (playerName.equals(player.getName())) {
        return player;
      }
    }
    return null;
  }

  @Override
  public int getCurrentSpaceIndexByPlayerName(String playerName) {
    return getPlayerByName(playerName).getCurrentSpaceIndex();
  }

  @Override
  public List<Space> getNeighborsBySpaceIndex(int index) {
    return mansion.getSpaceByIndex(index).getNeighbors();
  }

  @Override
  public List<Item> getItemsBySpaceIndex(int index) {
    return mansion.getSpaceByIndex(index).getItems();
  }

  @Override
  public PlayerType getPlayerTypeByName(String playerName) {
    return getPlayerByName(playerName).gePlayerType();
  }

  @Override
  public String getDoctorLuckyName() {
    return doctorLucky.getName();
  }

  @Override
  public int getDoctorLuckyCurrentSpaceIndex() {
    return doctorLucky.getCurrentSpaceIndex();
  }

  @Override
  public int getDoctorLuckyHealth() {
    return doctorLucky.getHealth() > 0 ? doctorLucky.getHealth() : 0;
  }

  @Override
  public String getSpaceNameByIndex(int index) {

    return mansion.getSpaceByIndex(index).getName();
  }

  @Override
  public String getSpaceInfo(int index) {
    return mansion.getSpaceByIndex(index).toString();
  }

  @Override
  public void setPet(String petName) {
    pet = new PetModel(petName);
  }

  @Override
  public String getPetName() {
    return pet.getName();
  }

  @Override
  public int getPetCurrentSpaceIndex() {
    return pet.getCurrentSpaceIndex();
  }

  @Override
  public int getSpaceNumFromMansion() {
    return mansion.getSpacesNum();
  }

  @Override
  public void movePet(int index) {
    pet.move(index);
    pet.createRoute(index, mansion);
    newTurn();
    
  }

  @Override
  public List<Item> getItemsByPlayerName(String playerName) {
    return getPlayerByName(playerName).getItems();
  }

  @Override
  public String getMostDamageItemNameByPlayerName(String playerName) {
    return getPlayerByName(playerName).getItemNameWithMaxDamage();
  }

  @Override
  public Boolean makeAttempt(String playerName, String itemName) { 
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
    return pet.toString();
  }


  @Override
  public String getNeighborsInfoBySpaceIndex(int spaceIndex) {
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
    
    return mansion.getWidth();
  }

  @Override
  public int getHeightFromMansion() {
    return mansion.getHeight();
  }

  @Override
  public List<Space> getSpacesFromMansion() {
    return mansion.getSpaces();
  }

  @Override
  public List<Player> getPlayers() {
    // TODO Auto-generated method stub
    return Collections.unmodifiableList(players);
  }


}
