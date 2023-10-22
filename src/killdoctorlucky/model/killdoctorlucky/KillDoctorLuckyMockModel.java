package killdoctorlucky.model.killdoctorlucky;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import killdoctorlucky.model.character.Character;
import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.DoctorLuckyModel;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerModel;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.mansion.Mansion;
import killdoctorlucky.model.mansion.MansionModel;
import killdoctorlucky.model.space.Space;

/**
 * The implement class of KillDoctorLuckyMockModel.
 */
public class KillDoctorLuckyMockModel implements KillDoctorLucky {
  private DoctorLucky doctorLucky;
  private Mansion mansion;
  private List<Player> players = new ArrayList<Player>();
  private int maxTurn;
  private Appendable out;
  private int turn;

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
  public Mansion getMansion() {
    return mansion;
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
    mansion.getSpaces().get(spaceIndex).addPlayer(player);
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
      sb.append(mansion.getSpaces().get(player.getCurrentSpaceIndex()).getName());
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
  public Player getPlayerByTurn(int index) {
    try {
      out.append("!!Enter getPlayerByTurn.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return players.get(index % players.size());
  }

  @Override
  public DoctorLucky getDoctorLucky() {
    try {
      out.append("!!Enter getDoctorLucky.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doctorLucky;
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
          if (part.length == 3 && getMansion() == null) {
            setMansion(part[2], Integer.parseInt(part[0]), Integer.parseInt(part[1]));
          }
          // generate target character
          if (part.length == 2) {
            setDoctorLucky(part[1], Integer.parseInt(part[0]));
          }

          // generate spaces
          if (part.length == 1 && getMansion().getSpacesNum() == 0) {
            getMansion().setSpacesNum(Integer.parseInt(part[0]));
          }

          if (part.length == 5) {
            getMansion().addSpace(index++, part[4], Arrays.copyOfRange(part, 0, 4));

          }

          // generate items
          if (part.length == 1 && getMansion().getSpacesNum() != 0) {
            getMansion().setItemsNum(Integer.parseInt(part[0]));
          }

          if (part.length == 3 && getMansion().getItemsNum() != 0) {
            getMansion().getSpaces().get(Integer.parseInt(part[0])).addItem(part[2],
                Integer.parseInt(part[0]), Integer.parseInt(part[1]));

          }
        } catch (NumberFormatException e) {
          throw new NumberFormatException("Specification file format is wrong.");
        }
      }
      scan.close();
    }
    List<Space> spaces = getMansion().getSpaces();
    // set neighbors of each space
    for (int i = 0; i < spaces.size(); i++) {
      for (int j = 0; j < spaces.size(); j++) {
        if (spaces.get(i).getName() != spaces.get(j).getName()) {
          spaces.get(i).addNeighbor(spaces.get(j));
        }
      }
    }

  }

  @Override
  public String outputMap() throws IOException {
    try {
      out.append("!!Enter outputMap.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Create a BufferedImage
    BufferedImage image = new BufferedImage(getMansion().getWidth() * 30 + 6,
        getMansion().getHeight() * 30 + 6, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = image.createGraphics();

    // Set background color
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, getMansion().getWidth() * 30 + 6, getMansion().getHeight() * 30 + 6);

    // Draw rectangles for each room
    g.setColor(Color.BLACK);
    List<Space> spaces = getMansion().getSpaces();
    for (int i = 0; i < spaces.size(); i++) {

      int roomMinCol = spaces.get(i).getPoints()[1];
      int roomMinRow = spaces.get(i).getPoints()[0];
      int roomMaxCol = spaces.get(i).getPoints()[3];
      int roomMaxRow = spaces.get(i).getPoints()[2];
      String roomName = spaces.get(i).getName();

      int width = roomMaxCol - roomMinCol + 1;
      int height = roomMaxRow - roomMinRow + 1;
      int x = roomMinCol;
      int y = roomMinRow;

      g.drawRect(x * 30 + 3, y * 30 + 3, width * 30, height * 30);
      g.drawString(roomName, x * 30 + 5, y * 30 + 15);
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

    for (Player player : players) {
      if (name.equals(player.getName())) {
        sb.append(player.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", currentSpaceName=");
        sb.append(mansion.getSpaces().get(player.getCurrentSpaceIndex()).getName());
        sb.append("]");
        return sb.toString();
      }
    }
    return null;
  }

  @Override
  public Space getCharacterSpace(Character character) {
    try {
      out.append("!!Enter getCharacterSpace.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return mansion.getSpaces().get(character.getCurrentSpaceIndex());
  }

  @Override
  public void movePlayer(Player player, int targetSpace) {
    try {
      out.append("!!Enter movePlayer.\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    mansion.getSpaces().get(player.getCurrentSpaceIndex()).removePlayer(player);
    player.move(targetSpace);
    mansion.getSpaces().get(player.getCurrentSpaceIndex()).addPlayer(player);
    newTurn();

  }

  @Override
  public void pickUpItem(Player player, Item item) {
    newTurn();
    player.pickUpItem(item);
    mansion.getSpaces().get(player.getCurrentSpaceIndex()).removeItem(item);

  }

  @Override
  public String getAroundInfo(Player player) {
    List<Space> neighbors = mansion.getSpaces().get(player.getCurrentSpaceIndex()).getNeighbors();
    StringBuffer stringBuffer = new StringBuffer();
    for (Space space : neighbors) {
      stringBuffer.append(String.format("* %d. %s\n", space.getIndex(), space.getName()));
      stringBuffer.append(space.toString());
      if (space.getIndex() == doctorLucky.getCurrentSpaceIndex()) {
        stringBuffer.setLength(stringBuffer.length() - 1);
        stringBuffer.append(", Doctor Lucky's health=");
        stringBuffer.append(doctorLucky.getHealth());
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

}
