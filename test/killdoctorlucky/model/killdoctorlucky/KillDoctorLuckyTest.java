package killdoctorlucky.model.killdoctorlucky;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import killdoctorlucky.model.character.PlayerType;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the KillDoctorLucky.
 */
public class KillDoctorLuckyTest {

  private KillDoctorLucky killDoctorLucky;
  private StringBuffer stringBuffer;

  /**
   * Setup method for all of the tests.
   * 
   * @throws FileNotFoundException if file not found throw FileNotFoundException
   * 
   */
  @Before
  public void setUp() {
    killDoctorLucky = new KillDoctorLuckyModel();
    stringBuffer = new StringBuffer();
    FileReader fileReader = null;
    try {
      fileReader = new FileReader("./res/WorldSpecification_testForModel.txt");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    killDoctorLucky.initiateGame(fileReader);
  }

  @Test
  public void testParseSuccessfully() {
    stringBuffer.append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21,")
        .append(" itemsNum=20]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getMansionInfo());
  }

  @Test
  public void testAddPlayer() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 2);
    stringBuffer.append("human [playerType=human, maxItems=2, carriedItems=[],")
        .append(" currentSpaceIndex=0, currentSpaceName=Armory")
        .append(", Doctor Lucky's health=1, pet=Fortune the Cat]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getPlayerInfoByName("human"));
  }

  @Test
  public void testTwoPlayersAndTurns() {
    String humanName = killDoctorLucky.getPlayerNameByTurn(killDoctorLucky.getTurns());
    assertEquals("robot1", humanName);
    killDoctorLucky.movePlayer(humanName, 1);
    String robotName = killDoctorLucky.getPlayerNameByTurn(killDoctorLucky.getTurns());
    assertEquals("human1", robotName);
  }

  @Test
  public void testSpaceIncludePlayer() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 2);
    stringBuffer.append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House")
        .append(", 7.Hedge Maze], items=[Revolver], players=[human]]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getSpaceInfo(0).toString());
  }

  @Test
  public void testPlayerMove() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 2);
    String playerName = killDoctorLucky.getPlayerNameByTurn(4);
    killDoctorLucky.movePlayer(playerName, 1);
    stringBuffer.append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall,")
        .append(" 18.Trophy Room], items=[Billiard Cue], players=[human]]");
    StringBuffer stringBuffer1 = new StringBuffer();
    stringBuffer1.append("Armory [index=0, neighbors=[1.Billiard Room, ")
        .append("6.Green House, 7.Hedge Maze], items=[Revolver], players=[]]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getSpaceInfo(1));
    assertEquals(stringBuffer1.toString(), killDoctorLucky.getSpaceInfo(0));
  }

  @Test
  public void testPickUpItem() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 2);
    String playerName = killDoctorLucky.getPlayerNameByTurn(4);
    stringBuffer.append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House,")
        .append(" 7.Hedge Maze], items=[Revolver], players=[human]]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getSpaceInfo(0));
    String itemName = killDoctorLucky.getItemsBySpaceIndex(0).get(0).getName();
    killDoctorLucky.pickUpItem(playerName, itemName);

    StringBuffer stringBuffer1 = new StringBuffer();
    stringBuffer1.append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House,")
        .append(" 7.Hedge Maze], items=[], players=[human]]");
    StringBuffer stringBuffer2 = new StringBuffer();
    stringBuffer2.append("human [playerType=human, maxItems=2, ")
        .append("carriedItems=[Revolver], currentSpaceIndex=0, currentSpaceName=Armory]");
    assertEquals(stringBuffer1.toString(), killDoctorLucky.getSpaceInfo(0));
    assertEquals(stringBuffer2.toString(), killDoctorLucky.getPlayerInfoByName("human"));
  }

  @Test(expected = IllegalStateException.class)
  public void testReachMaxItem() {
    String playerName = killDoctorLucky.getPlayerNameByTurn(1);
    String itemName = killDoctorLucky.getItemsBySpaceIndex(8).get(0).getName();
    killDoctorLucky.pickUpItem(playerName, itemName);
    String itemName1 = killDoctorLucky.getItemsBySpaceIndex(8).get(0).getName();
    killDoctorLucky.pickUpItem(playerName, itemName1);
  }

  @Test
  public void testLookAround() {
    String player = killDoctorLucky.getPlayerNameByTurn(0);
    String info = killDoctorLucky.getAroundInfo(player);
    stringBuffer.append("** 0. Armory\n").append("This space is invisible.\n")
        .append("** 7. Hedge Maze\n").append("Hedge Maze [index=7, neighbors=[0.Armory, ")
        .append("6.Green House, 15.Piazza], items=[Loud Noise], players=[]]\n");
    assertEquals(stringBuffer.toString(), info);
  }

  @Test
  public void testGetPlayerInfo() {
    String player = killDoctorLucky.getPlayerNameByTurn(1);
    String item = killDoctorLucky.getItemsBySpaceIndex(8).get(0).getName();
    killDoctorLucky.pickUpItem(player, item);
    stringBuffer.append("human1 [playerType=human, maxItems=1,")
        .append(" carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]");
    assertEquals(stringBuffer.toString(), killDoctorLucky.getPlayerInfoByName(player));
  }

  @Test
  public void testDoctorMove() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 8, 1);
    String player = killDoctorLucky.getPlayerNameByTurn(0);
    String item = killDoctorLucky.getItemsBySpaceIndex(8).get(0).getName();
    assertEquals(0, killDoctorLucky.getDoctorLuckyCurrentSpaceIndex());
    killDoctorLucky.pickUpItem(player, item);
    assertEquals(1, killDoctorLucky.getDoctorLuckyCurrentSpaceIndex());
  }

  @Test
  public void testMakeAttempt() {
    String player = killDoctorLucky.getPlayerNameByTurn(0);
    assertEquals(1, killDoctorLucky.getDoctorLuckyHealth());
    killDoctorLucky.makeAttempt(player, "");
    assertEquals(0, killDoctorLucky.getDoctorLuckyHealth());
  }

  @Test
  public void testMakeAttemptFailed() {
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 1);
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "humanNew", 0, 1);
    String player = killDoctorLucky.getPlayerNameByTurn(4);
    killDoctorLucky.makeAttempt(player, "");
    assertEquals(1, killDoctorLucky.getDoctorLuckyCurrentSpaceIndex());
  }

  @Test
  public void testMovePet() {
    assertEquals(0, killDoctorLucky.getPetCurrentSpaceIndex());
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "human", 0, 1);
    killDoctorLucky.addPlayer(PlayerType.HUMAN, "humanNew", 0, 1);
    String player = killDoctorLucky.getPlayerNameByTurn(4);
    killDoctorLucky.makeAttempt(player, "");
    assertEquals(1, killDoctorLucky.getPetCurrentSpaceIndex());
  }

}
