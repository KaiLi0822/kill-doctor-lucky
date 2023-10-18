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
import javax.imageio.ImageIO;
import killdoctorlucky.model.character.Character;
import killdoctorlucky.model.character.DoctorLucky;
import killdoctorlucky.model.character.DoctorLuckyModel;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerModel;
import killdoctorlucky.model.character.PlayerType;
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

  @Override
  public void setMansion(String mansionName, int mansionHeight, int mansionWidth) {
    mansion = new MansionModel(mansionName, mansionHeight, mansionWidth);
  }

  @Override
  public Mansion getMansion() {
    return mansion;
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
  public void setPlayer(PlayerType playerType, String playerName, int spaceIndex, int maxItem) {
    players.add(new PlayerModel(playerType, playerName, spaceIndex, maxItem));

  }

  @Override
  public String getPlayersInfo() {
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
    return maxTurn;
  }

  @Override
  public Player getPlayerByTurn(int index) {
    return players.get(index % players.size());
  }

  @Override
  public DoctorLucky getDoctorLucky() {
    return doctorLucky;
  }

  @Override
  public void initiateGame(Readable readable) {
    Scanner scan = new Scanner(readable);
    int index = 0;
    while (scan.hasNextLine()) {
      String[] part = scan.nextLine().split("\t");
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
    }
    scan.close();

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
    return mansion.getSpaces().get(character.getCurrentSpaceIndex());
  }

}