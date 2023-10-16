package model.killdoctorlucky;

import model.Nameable;
import model.character.DoctorLucky;
import model.character.DoctorLuckyModel;
import model.character.Player;
import model.character.PlayerModel;
import model.item.ItemModel;
import model.mansion.Mansion;
import model.mansion.MansionModel;
import model.space.SpaceModel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

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
  public void setPlayer(String playerName, int spaceIndex, int maxItem) {
    players.add(new PlayerModel(playerName, spaceIndex, maxItem));
    
  }

  @Override
  public String getMansionInfo() {
    return mansion.toString();
  }

  @Override
  public String getDoctorLuckyInfo() {
    return doctorLucky.toString();
  }

  @Override
  public String getPlayersInfo() {
    StringBuffer sb = new StringBuffer();
    for (Player player : players) {
      sb.append(player.toString());
      sb.append("\n");
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
  
  







  

  
  
  


  /**
   * Constructs the KillDoctorLuckyImpl.
   * 
   * @param mansionFilePath the mansion file
   * @throws FileNotFoundException if file not found throw FileNotFoundException
   */
//  public KillDoctorLuckyModel(String mansionFilePath, int maxTurnIn) throws FileNotFoundException, IOException {
//    FileReader fileReader;
//    try {
//      fileReader = new FileReader(mansionFilePath);
//    } catch (FileNotFoundException e) {
//      throw new FileNotFoundException();
//    }
//
//    BufferedReader br = new BufferedReader(fileReader);
//    String line;
//
//    try {
//      while ((line = br.readLine()) != null) {
//        String[] part = line.split("\t");
//        // generate mansion
//        if (part.length == 3 && mansionName == null) {
//          mansionHeight = Integer.parseInt(part[0]);
//          mansionWidth = Integer.parseInt(part[1]);
//          mansionName = part[2];
//        }
//
//        // generate target character
//        if (part.length == 2) {
//          doctorLucky = new DoctorLuckyModel(Integer.parseInt(part[0]), part[1]);
//        }
//
//        // generate spaces
//        if (part.length == 1 && spacesNum == 0) {
//          spacesNum = Integer.parseInt(part[0]);
//        }
//        if (part.length == 5) {
//          spaces
//              .add(SpaceModel.getBuilder().name(part[4]).points(Arrays.copyOfRange(part, 0, 4)).build());
//
//        }
//
//        // generate items
//        if (part.length == 1 && itemsNum == 0) {
//          itemsNum = Integer.parseInt(part[0]);
//        }
//        if (part.length == 3 && itemsNum != 0) {
//          int position = Integer.parseInt(part[0]);
//          int damage = Integer.parseInt(part[1]);
//          ItemModel item = new ItemModel(part[2], position, damage);
//          spaces.get(position).addItem(item);
//        }
//
//      }
//    } catch (IOException e) {
//      throw new IOException();
//    }
//    br.close();
//    // set neighbors of each space
//    for (int i = 0; i < spaces.size(); i++) {
//      for (int j = 0; j < spaces.size(); j++) {
//        if (spaces.get(i).getName() != spaces.get(j).getName()) {
//          spaces.get(i).addNeighbor(spaces.get(j));
//        }
//      }
//    }
//    
//    maxTurn = maxTurnIn;
//
//  }
//
//  @Override
//  public String outputMap(String filePathIn) throws IOException {
//    String filePath = "";
//    // Create a BufferedImage
//    BufferedImage image = new BufferedImage(mansionWidth * 30 + 6, mansionHeight * 30 + 6,
//        BufferedImage.TYPE_INT_RGB);
//    Graphics2D g = image.createGraphics();
//
//    // Set background color
//    g.setColor(Color.WHITE);
//    g.fillRect(0, 0, mansionWidth * 30 + 6, mansionHeight * 30 + 6);
//
//    // Draw rectangles for each room
//    g.setColor(Color.BLACK);
//    for (int i = 0; i < spaces.size(); i++) {
//
//      int roomMinCol = spaces.get(i).getPoints()[1];
//      int roomMinRow = spaces.get(i).getPoints()[0];
//      int roomMaxCol = spaces.get(i).getPoints()[3];
//      int roomMaxRow = spaces.get(i).getPoints()[2];
//      String roomName = spaces.get(i).getName();
//
//      int width = roomMaxCol - roomMinCol + 1;
//      int height = roomMaxRow - roomMinRow + 1;
//      int x = roomMinCol;
//      int y = roomMinRow;
//
//      g.drawRect(x * 30 + 3, y * 30 + 3, width * 30, height * 30);
//      g.drawString(roomName, x * 30 + 5, y * 30 + 15);
//    }
//
//    // Save the image to a file
//    try {
//      File outputFile = new File(filePathIn + "WorldMap.png");
//      ImageIO.write(image, "png", outputFile);
//      filePath = outputFile.getAbsolutePath();
//
//    } catch (IOException e) {
//      throw new IOException();
//    }
//    g.dispose();
//    return filePath;
//
//  }
//
//  @Override
//  public String getTargetName() {
//    return doctorLucky.getName();
//  }
//
//  @Override
//  public int moveTargetCharacter() {
//    return doctorLucky.move() % spacesNum;
//
//  }
//
//  @Override
//  public int getTargetCurrentSpaceIndex() {
//    return doctorLucky.getCurrentSpaceIndex();
//  }
//
//  private <T extends Nameable> String joinNames(List<T> objectList) {
//    if (objectList.size() != 0) {
//      List<String> names = new ArrayList<>();
//      for (T obj : objectList) {
//        names.add(obj.getName());
//      }
//      // Join names into a single string
//      return String.join(", ", names);
//
//    }
//    return "";
//
//  }
//
//  @Override
//  public String getSpaceNameByIndex(int index) {
//    return spaces.get(index).getName();
//  }
//
//  @Override
//  public String getItemsBySpaceIndex(int index) {
//    return joinNames(spaces.get(index).getItems());
//  }
//
//  @Override
//  public String getNeighborsBySpaceIndex(int index) {
//    return joinNames(spaces.get(index).getNeighbors());
//
//  }
//
//  @Override
//  public String getMansionName() {
//    return mansionName;
//  }
//
//  @Override
//  public int getSpacesNum() {
//    return spacesNum;
//  }
  
  

}
