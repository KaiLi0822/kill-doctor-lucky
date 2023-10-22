/**
 * 
 */
package killdoctorlucky.controller;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import killdoctorlucky.controller.command.Parse;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyMockModel;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyModel;

/**
 * Test for KillDoctorLuckyConsoleController.
 */
public class KillDoctorLuckyConsoleControllerTest {

  private KillDoctorLucky killDoctorLucky;
  private StringReader input;
  private StringBuffer output;
  private RandomGenerator rg;

  @Before
  public void setUp() {
    output = new StringBuffer();
    rg = new RandomGenerator();
    killDoctorLucky = new KillDoctorLuckyMockModel(output);
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
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecificationError.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\nSpecification file parse failed.\n");
  }

  @Test
  public void testQuit() {
    input = new StringReader("q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n" + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n" + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n" + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n" + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n" + "2. Start game.\n" + "Game Quit.");
  }

  @Test
  public void testAddPlayer() {
    input = new StringReader("2 1 1 1 human 1 1 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n" + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n" + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n" + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n" + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n" + "2. Start game.\n" + "\n"
        + "***********************************\n" + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n" + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n" + "1.human\n" + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n" + "-----Players Information-----\n" + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "\n" + "***********************************\n" + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n" + "\n" + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n" + "3. Look around\n" + "Game Quit.");
  }

  @Test
  public void testAddTwoPlayer() {
    input = new StringReader("2 2 2 1 human 1 1 1 robot 2 2 q");
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n" + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n" + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n" + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n" + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n" + "2. Start game.\n" + "\n"
        + "***********************************\n" + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n" + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n" + "1.human\n" + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "** Genarating Player 2:\n" + "Please choose the player type:\n" + "1.human\n"
        + "2.robot\n" + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n" + "-----Players Information-----\n" + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "robot [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=2, currentSpaceName=Carriage House]\n"
        + "\n" + "***********************************\n" + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n" + "\n" + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n" + "3. Look around\n" + "Game Quit.");
  }
  
  @Test
  public void testAddPlayerAndMove() {
    input = new StringReader("2 1 1 1 human 1 1 1 0 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "\n"
        + "***********************************\n"
        + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n"
        + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n"
        + "3. Look around\n"
        + "human chose the option 1\n"
        + "** Choose a space to enter, input the index of space:\n"
        + "0. Armory\n"
        + "3. Dining Hall\n"
        + "18. Trophy Room\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 1.Billiard Room\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "Game Over! You have reached the maximum number of turns.\n");
  }
  
  @Test
  public void testAddPlayerAndPick() {
    input = new StringReader("2 1 1 1 human 1 1 2 1 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "\n"
        + "***********************************\n"
        + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n"
        + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n"
        + "3. Look around\n"
        + "human chose the option 2\n"
        + "** Choose an item to pick up, input the index of item:\n"
        + "1. Billiard Cue\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 1.Billiard Room\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "Game Over! You have reached the maximum number of turns.\n");
  }
  
  @Test
  public void testSpaceRemoveItem() {
    input = new StringReader("2 2 1 1 human 1 1 2 1 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "\n"
        + "***********************************\n"
        + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n"
        + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n"
        + "3. Look around\n"
        + "human chose the option 2\n"
        + "** Choose an item to pick up, input the index of item:\n"
        + "1. Billiard Cue\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 1.Billiard Room\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.2 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Billiard Cue], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: no item can be picked.\n"
        + "3. Look around\n"
        + "Game Quit.");
  }
  
  
  @Test
  public void testPickAndReachMaxItems() {
    input = new StringReader("2 3 1 1 human 8 1 2 1 2 1 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "\n"
        + "***********************************\n"
        + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n"
        + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n"
        + "2. Pick up an item: Crepe Pan, Sharp Knife\n"
        + "3. Look around\n"
        + "human chose the option 2\n"
        + "** Choose an item to pick up, input the index of item:\n"
        + "1. Crepe Pan\n"
        + "2. Sharp Knife\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 1.Billiard Room\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.2 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n"
        + "2. Pick up an item: Sharp Knife\n"
        + "3. Look around\n"
        + "human chose the option 2\n"
        + "Can not pick up more items.\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 2.Carriage House\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.3 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[Crepe Pan], currentSpaceIndex=8, currentSpaceName=Kitchen]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Dining Hall, Parlor, Wine Cellar\n"
        + "2. Pick up an item: Sharp Knife\n"
        + "3. Look around\n"
        + "human chose the option 1\n"
        + "** Choose a space to enter, input the index of space:\n"
        + "3. Dining Hall\n"
        + "14. Parlor\n"
        + "19. Wine Cellar\n"
        + "Game Quit.");
  }
  
  @Test
  public void testAddPlayerAndLook() {
    input = new StringReader("2 1 1 1 human 1 1 3 q");
    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLucky.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "***********************************\n"
        + "Menu(Input 'q'/'Q' to quit):\n"
        + "1. Create world map.\n"
        + "2. Start game.\n"
        + "\n"
        + "***********************************\n"
        + "Game Start!\n"
        + "* Please provide the maximum of turns: !!Enter setMaxTurn.\n"
        + "* Generate Player\n"
        + "Please provide the number of players:** Genarating Player 1:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a human player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter setPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getPlayerByTurn.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "* Choose action:\n"
        + "1. Move to a neighboring space: Armory, Dining Hall, Trophy Room\n"
        + "2. Pick up an item: Billiard Cue\n"
        + "3. Look around\n"
        + "human chose the option 3\n"
        + "* 0. Armory\n"
        + "Armory [index=0, neighbors=[1.Billiard Room, 6.Green House, 7.Hedge Maze], items=[Revolver], players=[], Doctor Lucky's health=50]\n"
        + "* 3. Dining Hall\n"
        + "Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n"
        + "* 18. Trophy Room\n"
        + "Trophy Room [index=18, neighbors=[1.Billiard Room, 10.Library], items=[Duck Decoy, Monkey Hand], players=[]]\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "!!Enter getCharacterSpace.\n"
        + "Doctor Lucky's current space is 1.Billiard Room\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "Game Over! You have reached the maximum number of turns.\n");
  }
  
  @Test
  public void testSpaceIncludePlayer() {
    input = new StringReader("2 3 2 1 human 1 1 2 robot 0 0 3 q");
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), "");
  }
  
  
  
//  
//  @Test
//  public void testAddPlayerAndMove() {
//    input = new StringReader("2 1 1 1 human 1 1 1 0 q");
//    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
//        .playGame(killDoctorLucky);
//    assertEquals(output.toString(), "");
//  }
//  
//  @Test
//  public void testAddPlayerAndMove() {
//    input = new StringReader("2 1 1 1 human 1 1 1 0 q");
//    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
//        .playGame(killDoctorLucky);
//    assertEquals(output.toString(), "");
//  }
//  
//  @Test
//  public void testAddPlayerAndMove() {
//    input = new StringReader("2 1 1 1 human 1 1 1 0 q");
//    new KillDoctorLuckyConsoleController(input, output, null, "./res/WorldSpecification.txt")
//        .playGame(killDoctorLucky);
//    assertEquals(output.toString(), "");
//  }

}
