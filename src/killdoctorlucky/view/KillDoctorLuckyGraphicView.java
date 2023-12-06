package killdoctorlucky.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import killdoctorlucky.controller.KillDoctorLuckyControllerFeature;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyViewModel;
import killdoctorlucky.model.space.Space;


/**
 * The Graphic view.
 */
public class KillDoctorLuckyGraphicView extends JFrame implements KillDoctorLuckyView {
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
  private Map<String, JLabel> playersLabelMap;
  private Map<String, int[]> playersLocationMap;
  private Set<Character> pressKeySet;

  private JLabel information;
  private JTextArea messageArea;
  private JPanel mainPanel;

  private List<Item> spaceItems;
  private List<Item> playerItems;

  /**
   * Constructor.
   * 
   * @param caption the caption to use
   */
  public KillDoctorLuckyGraphicView(String caption) {
    super(caption);
    this.setSize(1200, 800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    // add menu
 
    
    // Start Game option
    startGameItem = new JMenuItem("Start Game");
    // Quit Game option
    quitGameItem = new JMenuItem("Quit Game");
    // New Map option
    newMapItem = new JMenuItem("New Map");
    // Add menu items to the File menu
    JMenu menu = new JMenu("Menu");
    menu.add(startGameItem);
    menu.add(quitGameItem);
    menu.add(newMapItem);
    // Add the File menu to the menu bar
    JMenuBar menuBar = new JMenuBar();
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
    JScrollPane jscrollPane = new JScrollPane(layeredPane);
    add(jscrollPane, BorderLayout.CENTER);

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

  private void showPickUpInfo(Boolean res, String playerName, String itemName) {
    if (res) {
      addLog(String.format("%s picked up %s.\n", playerName, itemName));
    } else {
      addLog(String.format("%s has reached the maximum items, pick up failed.\n", playerName));
    }
    String playerInfoStr = model.getPlayerInfoByName(playerName);

    information.setText(convertToHtml(playerInfoStr));

  }

  private void showAroundInfo() {
    addLog(String.format("%s looks around.\n", getCurrentPlayerName()));
    String aroundInfoStr = model.getAroundInfo(getCurrentPlayerName());
    information.setText(convertToHtml(aroundInfoStr));
  }

  private void showMoveSpaceInfo(String playerName, int spaceIndex, int[] arr) {
    // add information
    String playerInfoStr = model.getPlayerInfoByName(playerName);
    information.setText(convertToHtml(playerInfoStr));
    // add log
    addLog(String.format("%s has moved to NO.%d space.\n", playerName, spaceIndex));
    // move player
    playersLabelMap.get(playerName).setLocation(arr[0] * 30 + playersLocationMap.get(playerName)[0],
        arr[1] * 30 + playersLocationMap.get(playerName)[1]);
  }

  private void showMakeAttemptInfo(Boolean res, String playerName, String itemName) {

    String attemptRes = "Attack Failed! You are seen by another player!\nThe health of doctor is ";
    String log = "Attack Failed!";
    if (res) {
      attemptRes = "Attack Successfully!\nThe health of doctor is ";
      log = "Attack Successfully!";
    }
    addLog(String.format("%s used %s, %s\n", playerName,
        "".equals(itemName) ? "Poke eyes" : itemName, log));
    information.setText(
        convertToHtml(String.format("%s\n%d\n", attemptRes, model.getDoctorLuckyHealth())));

  }

  @Override
  public void startGame() {
    showTurnInfo();
    showLeft();
    showRight();
    showMansion();
    showDoctor();
    showPlayers();
    loadSpaceItems();
    loadPlayerItems();
    pressKeySet = new HashSet<Character>();
    this.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'l') {
          showAroundInfo();
          newTurn();
        }

      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p') {
          pressKeySet.add(e.getKeyChar());
          StringBuffer sb = new StringBuffer();
          sb.append("<html>Press a number key to choose an item:<br>");
          if (spaceItems.size() == 0) {
            sb.append("There is no items to pick.");
          } else {
            int itemIndex = 1;
            for (Item item : spaceItems) {
              sb.append(String.format("%d. %s; damage: %d<br>", itemIndex++, item.getName(),
                  item.getDamage()));
            }
          }

          sb.append("</html>");
          information.setText(sb.toString());
        } else if (e.getKeyChar() == 'm') {
          pressKeySet.add(e.getKeyChar());
          information.setText("<html>Click a target space to move the pet into.</html>");
        } else if (e.getKeyChar() == 'a') {
          pressKeySet.add(e.getKeyChar());
          if (model.getCurrentSpaceIndexByPlayerName(getCurrentPlayerName()) == model
              .getDoctorLuckyCurrentSpaceIndex()) {
            StringBuffer sb = new StringBuffer();
            sb.append("<html>Press a number key to choose an item:<br>");
            if (playerItems.size() == 0) {
              sb.append("1.Poke eyes.");
            } else {
              int itemIndex = 1;
              for (Item item : playerItems) {
                sb.append(String.format("%d. %s; damage: %d<br>", itemIndex++, item.getName(),
                    item.getDamage()));
              }
            }
            sb.append("</html>");
            information.setText(sb.toString());
          } else {
            information.setText(
                "<html>Invalid choice, the player is not in the same space with doctor.</html>");
          }

        }

        if (pressKeySet.contains('p') && Character.isDigit(e.getKeyChar())) {
          pressKeySet.add(e.getKeyChar());
          if (spaceItems != null) {
            int itemNum = Character.getNumericValue(e.getKeyChar());
            if (itemNum != 0 && itemNum <= spaceItems.size()) {
              String itemName = spaceItems.get(itemNum - 1).getName();
              String playerName = getCurrentPlayerName();
              Boolean res = controller.pickUpItem(playerName, itemName);
              showPickUpInfo(res, playerName, itemName);
              newTurn();
            } else {
              information.setText("Invalid choice, please choose a valid item number.");
            }

          }
        }
        if (pressKeySet.contains('a') && Character.isDigit(e.getKeyChar())) {
          pressKeySet.add(e.getKeyChar());
          int itemNum = Character.getNumericValue(e.getKeyChar());
          if (itemNum != 0 && (itemNum <= playerItems.size() || itemNum == 1)) {
            String itemName = "";
            if (playerItems.size() != 0) {
              itemName = playerItems.get(itemNum - 1).getName();
            }
            String playerName = getCurrentPlayerName();

            Boolean res = controller.makeAttempt(playerName, itemName);

            showMakeAttemptInfo(res, playerName, itemName);

            newTurn();
          } else {
            information.setText("Invalid choice, please choose a valid item number.");
          }

        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        if (pressKeySet.size() == 1) {
          information.setText(convertToHtml(model.getPlayerInfoByName(getCurrentPlayerName())));

        }
        pressKeySet.clear();
      }
    });
    // if the first player is Robot, go to newTurn
    if (model.getPlayerTypeByName(getCurrentPlayerName()).equals(PlayerType.ROBOT)) {
      robotTurn();
    }
    
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

    JLabel left = new JLabel(String.format("%s%s%s%s",
        "<html>Choose Your Action:<br><br>* Press 'l' to look around<br>* ",
        "Click a room to enter<br>* Press and hold 'p' to pick up an item<br>* ",
        "Press and hold 'm' to move pet<br>* Press and hold 'a' to make an attempt",
        "<br><br><br>You can click the player to get information.</html>"));
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
        String playerName = getCurrentPlayerName();
        if (pressKeySet.contains('m')) {
          controller.movePet(spaceIndex);
          addLog(String.format("%s has moved pet to NO.%d space.\n", playerName, spaceIndex));
          newTurn();
        } else {
          if (spaceIndex == -1) {
            information.setText("Invalid click, please click again.");
            return;
          }

          int[] arr = controller.movePlayer(playerName, spaceIndex);
          if (arr[0] != -1) {

            showMoveSpaceInfo(playerName, spaceIndex, arr);

            newTurn();
          } else {
            information.setText("Invalid click, please choose a neighboring space.");
          }
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
    doctor.setLocation(x * 30 + 63, y * 30 + 10);
    doctor.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        information.setText(convertToHtml(model.getDoctorLuckyInfo()));

      }
    });
    layeredPane.add(doctor, JLayeredPane.PALETTE_LAYER);
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
      playerLabel.setLocation(x * 30 + 3, y * 30 + 15 * index + 10);
      int[] intArr = new int[] { 3, 15 * index + 10 };
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

    public PlayerClickListener(Player playerIn) {
      this.player = playerIn;
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
    doctor.setLocation(x * 30 + 63, y * 30 + 10);
  }


  private int getSpaceIndex(int yaxisIn, int xaxisIn) {
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

      if (minX <= xaxisIn && maxX >= xaxisIn && minY <= yaxisIn && maxY >= yaxisIn) {
        return space.getIndex();
      }
    }
    return -1;

  }
  
  private void robotTurn() {
    List<String> strs = controller.robotTurn();
    String option = strs.get(0);
    switch (option) {
      case "l":
        showAroundInfo();
        break;
      case "s":
        int[] arr = new int[] { Integer.parseInt(strs.get(3)), Integer.parseInt(strs.get(4)) };
        showMoveSpaceInfo(strs.get(1), Integer.parseInt(strs.get(2)), arr);
        break;
      case "p":
        showPickUpInfo(Boolean.valueOf(strs.get(1)), strs.get(2), strs.get(3));
        break;
      case "m":
        addLog(String.format("%s has moved pet to NO.%d space.\n", strs.get(1),
            Integer.parseInt(strs.get(2))));
        break;
      case "a":
        showMakeAttemptInfo(Boolean.valueOf(strs.get(1)), strs.get(2), strs.get(3));
        break;
      default:
        break;
    }
    newTurn();
  }

  private void newTurn() {
    if (controller.isGameOver()) {
      String winner = controller.getWinner();
      if ("".equals(winner)) {
        JOptionPane.showMessageDialog(null,
            "Game Over! You have reached the maximum number of turns, the docotr has escaped.");
      } else {
        JOptionPane.showMessageDialog(null,
            String.format("Game Over! Doctor Lucky has been killed, winner is %s!", winner));
      }
      System.exit(0);
    } else {
      changeTurnInfo();
      changeDoctor();
      loadSpaceItems();
      loadPlayerItems();
      if (model.getPlayerTypeByName(getCurrentPlayerName()).equals(PlayerType.ROBOT)) {
        robotTurn();
      }

    }

  }

  private void loadSpaceItems() {
    spaceItems = model
        .getItemsBySpaceIndex(model.getCurrentSpaceIndexByPlayerName(getCurrentPlayerName()));
  }

  private void loadPlayerItems() {
    playerItems = model.getItemsByPlayerName(getCurrentPlayerName());
  }

  private void changeTurnInfo() {
    StringBuffer sb = new StringBuffer();
    String playerName = getCurrentPlayerName();
    sb.append("<html>").append(playerName).append("'s Turn<br>")
        .append(model.getPlayerInfoByName(playerName)).append("</html>");
    turnLabel.setText(sb.toString());
  }

}
