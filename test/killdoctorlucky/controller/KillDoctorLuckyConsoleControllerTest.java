package killdoctorlucky.controller;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyMockModel;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for KillDoctorLuckyConsoleController.
 */
public class KillDoctorLuckyConsoleControllerTest {

  private KillDoctorLucky killDoctorLucky;
  private StringReader input;
  private StringBuffer output;
  private RandomGenerator rg;
  private StringBuffer stringBuffer;

  /**
   * Setup method for all of the tests.
   * 
   */
  @Before
  public void setUp() {
    output = new StringBuffer();
    killDoctorLucky = new KillDoctorLuckyMockModel(output);
    stringBuffer = new StringBuffer();
  }

  @Test
  public void testFileNotFound() {
    input = new StringReader("q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification1.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "Specification file not found.\n");
  }

  @Test
  public void testParseFileFailed() {
    input = new StringReader("q");
    stringBuffer.append("!!Enter initiateGame.\n!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\nSpecification file parse failed.\n");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecificationError.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testQuit() {
    input = new StringReader("q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n").append("Mansion [name=Doctor Lucky's Mansion, ")
        .append("height=36, width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddPlayer() {
    input = new StringReader("2 1 1 1 human 1 1 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n").append("Mansion [name=Doctor Lucky's Mansion, ")
        .append("height=36, width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n").append("Please provide the name: Please provide ")
        .append("the space index: Please provide the maximum ")
        .append("number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddTwoPlayer() {
    input = new StringReader("2 2 2 1 human 1 1 1 robot 2 2 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n").append("Mansion [name=Doctor Lucky's Mansion, ")
        .append("height=36, width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please provide ")
        .append("the maximum number of items carried: !!Enter addPlayer.\n")
        .append("** Genarating Player 2:\n").append("Please choose the player type:\n")
        .append("1.human\n").append("2.robot\n").append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please provide ")
        .append("the maximum number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("robot [playerType=human, maxItems=2, carriedItems=[], ")
        .append("currentSpaceIndex=2, currentSpaceName=Carriage House]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddPlayerAndMove() {
    input = new StringReader("2 1 1 1 human 1 1 1 0 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n").append("Mansion [name=Doctor Lucky's Mansion,")
        .append(" height=36, width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 1\n")
        .append("** Choose a space to enter, input the index of space:\n").append("0. Armory\n")
        .append("3. Dining Hall\n").append("18. Trophy Room\n")
        .append("!!Enter movePlayer.\n!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("\n").append("***********************************\n")
        .append("Game Over! You have reached the maximum number of turns.\n");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddPlayerAndPick() {
    input = new StringReader("2 1 1 1 human 1 1 2 1 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n").append("Mansion [name=Doctor Lucky's Mansion, ")
        .append("height=36, width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please ")
        .append("provide the maximum number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 2\n")
        .append("** Choose an item to pick up, input the index of item:\n")
        .append("1. Billiard Cue\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("\n").append("***********************************\n")
        .append("Game Over! You have reached the maximum number of turns.\n");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testSpaceRemoveItem() {
    input = new StringReader("2 2 1 1 human 1 1 2 1 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36")
        .append(", width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 2\n")
        .append("** Choose an item to pick up, input the index of item:\n")
        .append("1. Billiard Cue\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: no item can be picked.\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testPickAndReachMaxItems() {
    input = new StringReader("2 3 1 1 human 8 1 2 1 2 1 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36")
        .append(", width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please ")
        .append("provide the maximum number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=8, currentSpaceName=Kitchen]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=8, currentSpaceName=Kitchen]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n")
        .append("2. Pick up an item: Crepe Pan, Sharp Knife\n").append("3. Look around\n")
        .append("human chose the option 2\n")
        .append("** Choose an item to pick up, input the index of item:\n").append("1. Crepe Pan\n")
        .append("2. Sharp Knife\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[Crepe Pan], ")
        .append("currentSpaceIndex=8, currentSpaceName=Kitchen]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, ")
        .append("carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n")
        .append("2. Pick up an item: Sharp Knife\n").append("3. Look around\n")
        .append("human chose the option 2\n")
        .append("** Choose an item to pick up, input the index of item:\n")
        .append("1. Sharp Knife\n").append("Can not pick up more items.\n")
        .append("!!Enter getPlayerInfoByName.\n").append("human [playerType=human, maxItems=1, ")
        .append("carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 2.Carriage House\n")
        .append("!!Enter getMaxTurn.\n").append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.3 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, ")
        .append("carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n")
        .append("2. Pick up an item: Sharp Knife\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddPlayerAndLook() {
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36")
        .append(", width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 3\n").append("* 0. Armory\n")
        .append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House, ")
        .append("7.Hedge Maze], items=[Revolver], players=[], Doctor Lucky's health=50]\n")
        .append("* 3. Dining Hall\n").append("Dining Hall [index=3, neighbors=[1.Billiard Room, ")
        .append("4.Drawing Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
        .append("* 18. Trophy Room\n").append("Trophy Room [index=18, neighbors=[1.Billiard Room, ")
        .append("10.Library], items=[Duck Decoy, Monkey Hand], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("\n").append("***********************************\n")
        .append("Game Over! You have reached the maximum number of turns.\n");
    input = new StringReader("2 1 1 1 human 1 1 3 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testSpaceIncludePlayer() {
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36")
        .append(", width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("** Genarating Player 2:\n").append("Please choose the player type:\n")
        .append("1.human\n").append("2.robot\n").append("Creating a robot player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 3\n").append("* 0. Armory\n")
        .append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House,")
        .append(" 7.Hedge Maze], items=[Revolver], players=[robot], Doctor Lucky's health=50]\n")
        .append("* 3. Dining Hall\n")
        .append("Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing ")
        .append("Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
        .append("* 18. Trophy Room\n")
        .append("Trophy Room [index=18, neighbors=[1.Billiard Room, 10.Library],")
        .append(" items=[Duck Decoy, Monkey Hand], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall, ")
        .append(
            "18.Trophy Room], items=[Billiard Cue], players=[human], Doctor Lucky's health=50]\n")
        .append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze], ")
        .append("items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, ")
        .append("15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 2.Carriage House\n")
        .append("!!Enter getMaxTurn.\n").append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.3 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    input = new StringReader("2 3 2 1 human 1 1 2 robot 0 0 3 q");
    rg = new RandomGenerator(2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testSpaceIncludeDoctor() {
    input = new StringReader("2 3 1 1 human 1 1 3 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36, ")
        .append("width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 3\n").append("* 0. Armory\n")
        .append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House, ")
        .append("7.Hedge Maze], items=[Revolver], players=[], Doctor Lucky's health=50]\n")
        .append("* 3. Dining Hall\n")
        .append("Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing ")
        .append("Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
        .append("* 18. Trophy Room\n").append("Trophy Room [index=18, neighbors=[1.Billiard Room, ")
        .append("10.Library], items=[Duck Decoy, Monkey Hand], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[],")
        .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[],")
        .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddTwoPlayersAndTurns() {
    input = new StringReader("2 3 2 1 human 1 1 2 robot 0 0 3 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36, ")
        .append("width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please ")
        .append("provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("** Genarating Player 2:\n").append("Please choose the player type:\n")
        .append("1.human\n").append("2.robot\n").append("Creating a robot player...\n")
        .append("Please provide the name: Please provide the space index: Please ")
        .append("provide the maximum number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 3\n").append("* 0. Armory\n")
        .append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House, ")
        .append("7.Hedge Maze], items=[Revolver], players=[robot], Doctor Lucky's health=50]\n")
        .append("* 3. Dining Hall\n").append("Dining Hall [index=3, neighbors=[1.Billiard Room, ")
        .append("4.Drawing Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
        .append("* 18. Trophy Room\n").append("Trophy Room [index=18, neighbors=[1.Billiard Room, ")
        .append("10.Library], items=[Duck Decoy, Monkey Hand], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[],")
        .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall,")
        .append(
            " 18.Trophy Room], items=[Billiard Cue], players=[human], Doctor Lucky's health=50]\n")
        .append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze],")
        .append(" items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House,")
        .append(" 15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 2.Carriage House\n")
        .append("!!Enter getMaxTurn.\n").append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.3 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    rg = new RandomGenerator(2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testAddComputerPlayers() {
    input = new StringReader("2 2 1 2 robot 0 0 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36, ")
        .append("width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a robot player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall, ")
        .append("18.Trophy Room], items=[Billiard Cue], players=[]]\n").append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze], ")
        .append("items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, ")
        .append("15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall, ")
        .append("18.Trophy Room], items=[Billiard Cue], players=[], Doctor Lucky's health=50]\n")
        .append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze], ")
        .append("items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, ")
        .append("15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[],")
        .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 2.Carriage House\n")
        .append("!!Enter getMaxTurn.\n").append("\n")
        .append("***********************************\n")
        .append("Game Over! You have reached the maximum number of turns.\n");
    rg = new RandomGenerator(2, 2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testReachMaxTurns() {
    input = new StringReader("2 2 1 2 robot 0 0 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36,")
        .append(" width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a robot player...\n")
        .append("Please provide the name: Please provide the space index: Please provide ")
        .append("the maximum number of items carried: !!Enter addPlayer.\n").append("\n")
        .append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[],")
        .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall, ")
        .append("18.Trophy Room], items=[Billiard Cue], players=[]]\n").append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze],")
        .append(" items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, ")
        .append("15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----robot's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[],")
        .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n").append("* Choose action:\n")
        .append("1. Move to a neighboring space: Billiard Room, Green House, Hedge Maze\n")
        .append("2. Pick up an item: Revolver\n").append("3. Look around\n")
        .append("robot chose the option 3\n").append("* 1. Billiard Room\n")
        .append("Billiard Room [index=1, neighbors=[0.Armory, 3.Dining Hall,")
        .append(" 18.Trophy Room], items=[Billiard Cue], players=[], Doctor Lucky's health=50]\n")
        .append("* 6. Green House\n")
        .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze],")
        .append(" items=[Trowel, Pinking Shears], players=[]]\n").append("* 7. Hedge Maze\n")
        .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, ")
        .append("15.Piazza], items=[Loud Noise], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("robot [playerType=robot, maxItems=0, carriedItems=[], ")
        .append("currentSpaceIndex=0, currentSpaceName=Armory]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 2.Carriage House\n")
        .append("!!Enter getMaxTurn.\n").append("\n")
        .append("***********************************\n")
        .append("Game Over! You have reached the maximum number of turns.\n");
    rg = new RandomGenerator(2, 2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testDoctorMove() {
    input = new StringReader("2 3 1 1 human 1 1 3 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36,")
        .append(" width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n").append("1.human\n").append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: ")
        .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n").append("-----Players Information-----\n").append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n").append("\n")
        .append("***********************************\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.1 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[],")
        .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("human chose the option 3\n").append("* 0. Armory\n")
        .append("Armory [index=0, neighbors=[1.Billiard Room, 6.Green House,")
        .append(" 7.Hedge Maze], items=[Revolver], players=[], Doctor Lucky's health=50]\n")
        .append("* 3. Dining Hall\n")
        .append("Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing ")
        .append("Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
        .append("* 18. Trophy Room\n")
        .append("Trophy Room [index=18, neighbors=[1.Billiard Room, 10.Library], ")
        .append("items=[Duck Decoy, Monkey Hand], players=[]]\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[],")
        .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("!!Enter getCharacterSpace.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room\n").append("!!Enter getMaxTurn.\n")
        .append("!!Enter getPlayerByTurn.\n").append("\n")
        .append("-----human's turn, No.2 turn-----\n").append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], ")
        .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n")
        .append("2. Pick up an item: Billiard Cue\n").append("3. Look around\n")
        .append("Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

  @Test
  public void testGenerateMap() {
    input = new StringReader("1 q");
    stringBuffer.append("!!Enter initiateGame.\n").append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n").append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36,")
        .append(" width=30, spacesNum=21, itemsNum=20]\n")
        .append("-----Main Character Information-----\n").append("!!Enter getDoctorLucky.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("***********************************\n").append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n").append("2. Start game.\n").append("!!Enter outputMap.\n")
        .append("Map created successfully: ")
        .append("/Users/likai/eclipse-workspace/kill-doctor-lucky/WorldMap.png\n")
        .append("***********************************\n").append("Game Start!\n")
        .append("* Please provide the maximum of turns: Game Quit.");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }

}
