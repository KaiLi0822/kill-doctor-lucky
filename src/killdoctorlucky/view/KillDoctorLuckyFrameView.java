package killdoctorlucky.view;

import javax.swing.*;

import killdoctorlucky.controller.KillDoctorLuckyControllerFeature;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyViewModel;
import killdoctorlucky.model.space.Space;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KillDoctorLuckyFrameView extends JFrame implements KillDoctorLuckyView {
  private static final long serialVersionUID = -2179965453492637485L;
  private KillDoctorLuckyViewModel model;
  private KillDoctorLuckyControllerFeature controller;

  private JMenuItem startGameItem;
  private JMenuItem quitGameItem;
  private JMenuItem newMapItem;

  private JLabel turnLabel;
  private JLayeredPane layeredPane;
  private JPanel topPanel;

  private JLabel doctor;
  private JLabel pet;
  private Map<String, JLabel> playersLabelMap;
  private Map<String, int[]> playersLocationMap;
  private Set<Character> pressKeySet;

  private JLabel information;
  private JTextArea messageArea;
  private JPanel mainPanel;

  private List<Item> items;

  /**
   * Constructor.
   * 
   * @param caption the caption to use
   */
  public KillDoctorLuckyFrameView(String caption) {
    super(caption);
    this.setSize(1200, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    // add menu
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Mune");
    // Start Game option
    startGameItem = new JMenuItem("Start Game");
    // Quit Game option
    quitGameItem = new JMenuItem("Quit Game");
    // New Map option
    newMapItem = new JMenuItem("New Map");
    // Add menu items to the File menu
    menu.add(startGameItem);
    menu.add(quitGameItem);
    menu.add(newMapItem);
    // Add the File menu to the menu bar
    menuBar.add(menu);
    // Set the menu bar for the frame
    setJMenuBar(menuBar);

    // top
    topPanel = new JPanel();
    turnLabel = new JLabel(
        "<html>Welcome!<br><br>Developer: Kai Li<br>View: Swing<br>Test: JUnit 4</html>",
        SwingConstants.CENTER);
    topPanel.add(turnLabel);
    add(topPanel, BorderLayout.NORTH);

    // center
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 1100));
    JScrollPane jScrollPane = new JScrollPane(layeredPane);
    add(jScrollPane, BorderLayout.CENTER);

    this.setVisible(true);
  }
  
  private String getCurrentPlayerName() {
    return model.getPlayerNameByTurn(model.getTurns());
    
  }
  
  @Override
  public void setFeatures(KillDoctorLuckyControllerFeature controllerIn) {
    
    this.controller = controllerIn;
    // action for menu
    startGameItem.addActionListener(l -> controller.startGame());
    quitGameItem.addActionListener(l -> System.exit(0));
    newMapItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(turnLabel);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();

          controller.startGame(selectedFile.getAbsolutePath());
        }
      }
    });

    
  }

  @Override
  public void startGame() {
    showTurnInfo();
    showLeft();
    showRight();
    showMansion();
    showDoctor();
    showPet();
    showPlayers();
    loadItems();
    pressKeySet = new HashSet<Character>();
    this.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'l') {
          addLog(String.format("%s looks around.\n", getCurrentPlayerName()));
          String aroundInfoStr = model.getAroundInfo(getCurrentPlayerName());
          information.setText(convertToHtml(aroundInfoStr));
        }
        newTurn();

      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p') {
          pressKeySet.add(e.getKeyChar());
          StringBuffer sb = new StringBuffer();
          sb.append("<html>Press a number key to choose an item:<br>"); 
          if (items.size() == 0) {
            sb.append("There is no items to pick.");
          }else {
            int itemIndex = 1;
            for (Item item : items) {
              sb.append(String.format("%d. %s; damage: %d<br>", itemIndex++, item.getName(), item.getDamage()));
            }
          }
          
          sb.append("</html>");
          information.setText(sb.toString());
        }
        if (pressKeySet.contains('p') && Character.isDigit(e.getKeyChar())) {
          pressKeySet.add(e.getKeyChar());
          if (items != null) {
            int itemNum = Character.getNumericValue(e.getKeyChar());
            if (itemNum <= items.size()) {
              String itemName = items.get(itemNum - 1).getName();
              String playerName = getCurrentPlayerName();
              addLog(String.format("%s picked up %d. %s.\n", playerName, itemNum, itemName)); 
              controller.pickUpItem(playerName, itemName);
              String playerInfoStr = model.getPlayerInfoByName(playerName);
              information.setText(convertToHtml(playerInfoStr));
              newTurn();
               
            }else {
              information.setText("Invalid choice, please choose a valid item number.");
            }
            
          }
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        if (pressKeySet.size() == 1) {
          information.setText(convertToHtml(model.getPlayerInfoByName(getCurrentPlayerName())));
          
        }
        if (pressKeySet.size() > 1) {
          if (pressKeySet.contains('p')) {
            
            
          }
        }
        pressKeySet.clear();
      }
    });
  }
  
  private void showTurnInfo() {
    topPanel.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Player Turn")));
    StringBuffer sb = new StringBuffer();
    String playerName = getCurrentPlayerName();
    sb.append("<html>").append(playerName).append("'s Turn<br>")
        .append(model.getPlayerInfoByName(playerName)).append("</html>");
    turnLabel.setText(sb.toString());
  }
  
  private void showLeft() {
    JPanel leftPanel = new JPanel(new BorderLayout());
    this.add(leftPanel, BorderLayout.WEST);
    JPanel leftPanelCenter = new JPanel(new BorderLayout());
    leftPanelCenter.setBorder(BorderFactory.createTitledBorder("Options"));
    leftPanelCenter.setPreferredSize(new Dimension(330, this.getHeight() - 400));
    leftPanel.add(leftPanelCenter, BorderLayout.CENTER);

    JPanel leftPanelBottom = new JPanel(new BorderLayout());
    leftPanelBottom.setBorder(
        BorderFactory.createTitledBorder(BorderFactory.createTitledBorder("Information")));
    leftPanelBottom.setPreferredSize(new Dimension(330, 400));
    leftPanel.add(leftPanelBottom, BorderLayout.SOUTH);

    JLabel left = new JLabel(
        "<html>Choose Your Action:<br><br>* Press 'l' to look around<br>* Click a room to enter<br>* Press and hold 'p' to pick up an item<br>* Press and hold 'm' to move pet<br>* Press and hold 'a' to make an attempt<br><br><br>You can click the player to get information.</html>");
    leftPanelCenter.add(left, BorderLayout.CENTER);

    String playerInfoStr = model.getPlayerInfoByName(getCurrentPlayerName());
    information = new JLabel();
    information.setText(convertToHtml(playerInfoStr));
    leftPanelBottom.add(information, BorderLayout.CENTER);
  }
  
  private void showRight() {
    // right
    JPanel rightPanel = new JPanel(new BorderLayout());
    add(rightPanel, BorderLayout.EAST);
    messageArea = new JTextArea();
    messageArea.setBorder(BorderFactory.createTitledBorder("Logs"));
    messageArea.setEditable(false); // Set to read-only
    JScrollPane scrollPane = new JScrollPane(messageArea);
    rightPanel.add(scrollPane, BorderLayout.CENTER);
  }
  
  private void showMansion() {
    mainPanel = new JPanel() {
      private static final long serialVersionUID = 1L;

      @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, model.getWidthFromMansion() * 30 + 6,
            model.getHeightFromMansion() * 30 + 6);

        // Draw rectangles for each room
        g.setColor(Color.BLACK);
        List<Space> spaces = model.getSpacesFromMansion();
        for (int i = 0; i < spaces.size(); i++) {

          int roomMinCol = spaces.get(i).getPoints()[1];
          int roomMinRow = spaces.get(i).getPoints()[0];
          int roomMaxCol = spaces.get(i).getPoints()[3];
          int roomMaxRow = spaces.get(i).getPoints()[2];
          String roomInfo = String.format("%d.%s", spaces.get(i).getIndex(),
              spaces.get(i).getName());

          int width = roomMaxCol - roomMinCol + 1;
          int height = roomMaxRow - roomMinRow + 1;
          int x = roomMinCol;
          int y = roomMinRow;

          g.drawRect(x * 30 + 3, y * 30 + 3, width * 30, height * 30);
          g.drawString(roomInfo, x * 30 + 5, y * 30 + 15);
        }
      }
    };
    mainPanel.setSize(1200, 1100);
    mainPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = e.getY();
        int col = e.getX();
        int spaceIndex = getSpaceIndex(row, col);
        if (spaceIndex == -1) {
          information.setText("Invalid click, please click again.");
          return;
        }
        
        String playerName = getCurrentPlayerName();
        int[] arr = controller.movePlayer(playerName, spaceIndex);
        
        int x = arr[0];
        int y = arr[1];
        if (x != -1) {
          // move player
          playersLabelMap.get(playerName).setLocation(
              x * 30 + playersLocationMap.get(playerName)[0],
              y * 30 + playersLocationMap.get(playerName)[1]);
          // add information
          String playerInfoStr = model.getPlayerInfoByName(playerName);
          information.setText(convertToHtml(playerInfoStr));
          // add log
          addLog(String.format("%s move to NO.%d space.\n", playerName, spaceIndex));
          newTurn();
        } else {
          information.setText("Invalid click, please choose a neighboring space.");
        }
      }
    });
    layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
  }
  
  private void showDoctor() {
    doctor = new JLabel(model.getDoctorLuckyName());
    doctor.setSize(100, 25);
    int[] points = model.getSpacesFromMansion().get(model.getDoctorLuckyCurrentSpaceIndex())
        .getPoints();
    int x = points[1];
    int y = points[0];
    doctor.setLocation(x * 30 + 3, y * 30 + 10);
    layeredPane.add(doctor, JLayeredPane.PALETTE_LAYER);
  }
  
  private void showPet() {
    pet = new JLabel(model.getPetName());
    pet.setSize(100, 25);
    int[] points = model.getSpacesFromMansion().get(model.getPetCurrentSpaceIndex()).getPoints();
    int x = points[1];
    int y = points[0];
    pet.setLocation(x * 30 + 3, y * 30 + 20);
    layeredPane.add(pet, JLayeredPane.PALETTE_LAYER);
  }
  
  private void showPlayers() {
    playersLabelMap = new HashMap<String, JLabel>();
    playersLocationMap = new HashMap<String, int[]>();
    int index = 0;
    for (Player player : model.getPlayers()) {
      JLabel playerLabel = new JLabel(player.getName());
      playerLabel.setSize(100, 25);
      playerLabel.addMouseListener(new PlayerClickListener(player));
      int[] points = model.getSpacesFromMansion().get(player.getCurrentSpaceIndex()).getPoints();
      int x = points[1];
      int y = points[0];
      playerLabel.setLocation(x * 30 + 3, y * 30 + 20 * index + 10);
      int[] intArr = new int[] { 3, 20 * index + 10 };
      layeredPane.add(playerLabel, JLayeredPane.PALETTE_LAYER);
      playersLabelMap.put(player.getName(), playerLabel);
      playersLocationMap.put(player.getName(), intArr);
      index += 1;
    }
  }
  
  
  private void addLog(String message) {
    messageArea.append(message + "\n");
  }

  @Override
  public void setModel(KillDoctorLuckyViewModel m) {
    this.model = m;
  }


  private String convertToHtml(String in) {
    return String.format("<html>%s</html>",
        in.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>"));
  }

  private class PlayerClickListener extends MouseAdapter {
    private Player player;

    public PlayerClickListener(Player player) {
      this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      // Handle the click event for the specific player
      String playerInfoStr = model.getPlayerInfoByName(player.getName());
      information.setText(convertToHtml(playerInfoStr));

    }
  }
  
  private void changeDoctor() {
    int[] points = model.getSpacesFromMansion().get(model.getDoctorLuckyCurrentSpaceIndex())
        .getPoints();
    int x = points[1];
    int y = points[0];
    doctor.setLocation(x * 30 + 3, y * 30 + 10);
  }


  
  private void changePet() {
    int[] points = model.getSpacesFromMansion().get(model.getPetCurrentSpaceIndex()).getPoints();
    int x = points[1];
    int y = points[0];
    pet.setLocation(x * 30 + 3, y * 30 + 20);
    
  }

  private int getSpaceIndex(int yIn, int xIn) {
    List<Space> spaces = model.getSpacesFromMansion();
    for (Space space : spaces) {

      int roomMinCol = space.getPoints()[1];
      int roomMinRow = space.getPoints()[0];
      int roomMaxCol = space.getPoints()[3];
      int roomMaxRow = space.getPoints()[2];

      int minX = roomMinCol * 30 + 3;
      int minY = roomMinRow * 30 + 3;
      int maxX = roomMaxCol * 30 + 33;
      int maxY = roomMaxRow * 30 + 33;

      if (minX <= xIn && maxX >= xIn && minY <= yIn && maxY >= yIn) {
        return space.getIndex();
      }
    }
    return -1;

  }

  
  private void newTurn() {
    changeTurnInfo();
    changeDoctor();
    changePet();
    loadItems();
  }
  
  private void loadItems() {
    items = model.getItemsBySpaceIndex(model.getCurrentSpaceIndexByPlayerName(getCurrentPlayerName()));
    
  }
  
  private void changeTurnInfo() {
    StringBuffer sb = new StringBuffer();
    String playerName = getCurrentPlayerName();
    sb.append("<html>").append(playerName).append("'s Turn<br>")
        .append(model.getPlayerInfoByName(playerName)).append("</html>");
    turnLabel.setText(sb.toString());
  }



}
