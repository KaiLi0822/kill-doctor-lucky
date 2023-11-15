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
public class KillDoctorLuckyConsoleControllerTestM3 {

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
  public void testWrongMove() {
    input = new StringReader("2 3 1 1 human 1 1 1 1 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, ")
    .append("spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: ")
    .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], ")
    .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human chose the option 1\n")
    .append("** Choose a space to enter, input the index of space:\n")
    .append("0. Armory\n")
    .append("3. Dining Hall\n")
    .append("18. Trophy Room\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Invalid choice, choose again.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testWrongPickUp() {
    input = new StringReader("2 3 1 1 human 1 1 3 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: ")
    .append("Please provide the maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], ")
    .append("currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 0. Armory\n")
    .append("This space is invisible.\n")
    .append("** 3. Dining Hall\n")
    .append("Dining Hall [index=3, neighbors=[1.Billiard Room, ")
    .append("4.Drawing Room, 8.Kitchen, 17.Tennessee Room], items=[], players=[]]\n")
    .append("** 18. Trophy Room\n")
    .append("Trophy Room [index=18, neighbors=[1.Billiard Room, 10.Library],")
    .append(" items=[Duck Decoy, Monkey Hand], players=[]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], ")
    .append("currentSpaceIndex=1, currentSpaceName=Billiard Room, Doctor Lucky's health=50,")
    .append(" pet=Fortune the Cat]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], ")
    .append("currentSpaceIndex=1, currentSpaceName=Billiard Room, Doctor Lucky's health=50")
    .append(", pet=Fortune the Cat]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("5. Make an attempt\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testLookAroundWithPet() {
    input = new StringReader("2 3 1 1 human 1 1 2 3 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
    .append(" currentSpaceName=Billiard Room]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
    .append(" currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human chose the option 2\n")
    .append("** Choose an item to pick up, input the index of item:\n")
    .append("1. Billiard Cue\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Invalid choice, choose again.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
    .append(" currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testLookAroundSeeTarget() {
    input = new StringReader("2 4 3 1 human1 19 2 1 human2 4 3 1 human3 20 3 3 3 3 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21,")
    .append(" itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 2:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 3:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4,")
    .append(" currentSpaceName=Drawing Room]\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=20,")
    .append(" currentSpaceName=Winter Garden]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human1's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 8.Kitchen; 20.Winter Garden; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Rat Poison:2; Piece of Rope:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human1 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 2. Carriage House\n")
    .append("Carriage House [index=2, neighbors=[19.Wine Cellar, 20.Winter Garden], ")
    .append("items=[Chain Saw, Big Red Hammer], players=[]]\n")
    .append("** 8. Kitchen\n")
    .append("Kitchen [index=8, neighbors=[3.Dining Hall, 14.Parlor, 19.Wine Cellar], ")
    .append("items=[Crepe Pan, Sharp Knife], players=[]]\n")
    .append("** 20. Winter Garden\n")
    .append("Winter Garden [index=20, neighbors=[2.Carriage House, 15.Piazza, 19.Wine Cellar],")
    .append(" items=[], players=[human3]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human2's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4, ")
    .append("currentSpaceName=Drawing Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 3.Dining Hall; 5.Foyer; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Letter Opener:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human2 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 3. Dining Hall\n")
    .append("Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing Room, 8.Kitchen, ")
    .append("17.Tennessee Room], items=[], players=[]]\n")
    .append("** 5. Foyer\n")
    .append("Foyer [index=5, neighbors=[4.Drawing Room, 15.Piazza], items=[], players=[]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4, ")
    .append("currentSpaceName=Drawing Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 2.Carriage House; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 3.Dining Hall\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human3's turn, No.3 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=20,")
    .append(" currentSpaceName=Winter Garden]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 15.Piazza; 19.Wine Cellar; \n")
    .append("2. Pick up an item: no item can be picked.\n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human3 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 2. Carriage House\n")
    .append("Carriage House [index=2, neighbors=[19.Wine Cellar, ")
    .append("20.Winter Garden], items=[Chain Saw, Big Red Hammer], ")
    .append("players=[], Doctor Lucky's health=50]\n")
    .append("** 15. Piazza\n")
    .append("Piazza [index=15, neighbors=[5.Foyer, 7.Hedge Maze, ")
    .append("20.Winter Garden], items=[Civil War Cannon], players=[]]\n")
    .append("** 19. Wine Cellar\n")
    .append("Wine Cellar [index=19, neighbors=[2.Carriage House, 8.Kitchen, ")
    .append("20.Winter Garden], items=[Rat Poison, Piece of Rope], players=[human1]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], ")
    .append("currentSpaceIndex=20, currentSpaceName=Winter Garden]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 3.Dining Hall; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 4.Drawing Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human1's turn, No.4 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], ")
    .append("currentSpaceIndex=19, currentSpaceName=Wine Cellar]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 8.Kitchen; 20.Winter Garden; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Rat Poison:2; Piece of Rope:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testLookAroundSeePlayer() {
    input = new StringReader("2 4 3 1 human1 19 2 1 human2 4 3 1 human3 20 3 3 3 3 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21,")
    .append(" itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 2:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 3:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4,")
    .append(" currentSpaceName=Drawing Room]\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=20,")
    .append(" currentSpaceName=Winter Garden]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human1's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 8.Kitchen; 20.Winter Garden; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Rat Poison:2; Piece of Rope:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human1 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 2. Carriage House\n")
    .append("Carriage House [index=2, neighbors=[19.Wine Cellar, 20.Winter Garden], ")
    .append("items=[Chain Saw, Big Red Hammer], players=[]]\n")
    .append("** 8. Kitchen\n")
    .append("Kitchen [index=8, neighbors=[3.Dining Hall, 14.Parlor, 19.Wine Cellar], ")
    .append("items=[Crepe Pan, Sharp Knife], players=[]]\n")
    .append("** 20. Winter Garden\n")
    .append("Winter Garden [index=20, neighbors=[2.Carriage House, 15.Piazza, 19.Wine Cellar],")
    .append(" items=[], players=[human3]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=19,")
    .append(" currentSpaceName=Wine Cellar]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human2's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4, ")
    .append("currentSpaceName=Drawing Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 3.Dining Hall; 5.Foyer; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Letter Opener:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human2 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 3. Dining Hall\n")
    .append("Dining Hall [index=3, neighbors=[1.Billiard Room, 4.Drawing Room, 8.Kitchen, ")
    .append("17.Tennessee Room], items=[], players=[]]\n")
    .append("** 5. Foyer\n")
    .append("Foyer [index=5, neighbors=[4.Drawing Room, 15.Piazza], items=[], players=[]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human2 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=4, ")
    .append("currentSpaceName=Drawing Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 2.Carriage House; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 3.Dining Hall\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human3's turn, No.3 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], currentSpaceIndex=20,")
    .append(" currentSpaceName=Winter Garden]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 15.Piazza; 19.Wine Cellar; \n")
    .append("2. Pick up an item: no item can be picked.\n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human3 chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 2. Carriage House\n")
    .append("Carriage House [index=2, neighbors=[19.Wine Cellar, ")
    .append("20.Winter Garden], items=[Chain Saw, Big Red Hammer], ")
    .append("players=[], Doctor Lucky's health=50]\n")
    .append("** 15. Piazza\n")
    .append("Piazza [index=15, neighbors=[5.Foyer, 7.Hedge Maze, ")
    .append("20.Winter Garden], items=[Civil War Cannon], players=[]]\n")
    .append("** 19. Wine Cellar\n")
    .append("Wine Cellar [index=19, neighbors=[2.Carriage House, 8.Kitchen, ")
    .append("20.Winter Garden], items=[Rat Poison, Piece of Rope], players=[human1]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human3 [playerType=human, maxItems=3, carriedItems=[], ")
    .append("currentSpaceIndex=20, currentSpaceName=Winter Garden]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 3.Dining Hall; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 4.Drawing Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human1's turn, No.4 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human1 [playerType=human, maxItems=2, carriedItems=[], ")
    .append("currentSpaceIndex=19, currentSpaceName=Wine Cellar]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 2.Carriage House; 8.Kitchen; 20.Winter Garden; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Rat Poison:2; Piece of Rope:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testSameSpaceWithPet() {
    input = new StringReader("2 3 2 1 human 0 2 2 robot 0 2 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 2:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a robot player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,")
    .append(" currentSpaceName=Armory]\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0,")
    .append(" currentSpaceName=Armory]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,")
    .append(" currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("5. Make an attempt\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testSameSpaceWithPlayer() {
    input = new StringReader("2 3 2 1 human 0 2 2 robot 0 2 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index: Please provide ")
    .append("the maximum number of items carried: !!Enter addPlayer.\n")
    .append("** Genarating Player 2:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a robot player...\n")
    .append("Please provide the name: Please provide the space index: Please provide ")
    .append("the maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0, ")
    .append("currentSpaceName=Armory]\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0, ")
    .append("currentSpaceName=Armory]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0, ")
    .append("currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("5. Make an attempt\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testMovePet() {
    input = new StringReader("2 2 1 1 human 1 1 4 2 q");
    stringBuffer.append("!!Enter initiateGame.\n")
        .append("!!Enter setMansion.\n")
        .append("!!Enter setDoctorLucky.\n")
        .append("!!Enter setPet.\n")
        .append("***********************************\n")
        .append("Mansion created successfully, the information is as follows:\n")
        .append("-----Mansion Information-----\n")
        .append("!!Enter getMansionInfo.\n")
        .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21,")
        .append(" itemsNum=20]\n")
        .append("-----Main Character Information-----\n")
        .append("!!Enter getDoctorLuckyInfo.\n")
        .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
        .append("-----Pet Information-----\n")
        .append("!!Enter getPetInfo.\n")
        .append("Fortune the Cat [currentSpaceIndex=0]\n")
        .append("***********************************\n")
        .append("Menu(Input 'q'/'Q' to quit):\n")
        .append("1. Create world map.\n")
        .append("2. Start game.\n")
        .append("\n")
        .append("***********************************\n")
        .append("Game Start!\n")
        .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
        .append("* Generate Player\n")
        .append("Please provide the number of players:** Genarating Player 1:\n")
        .append("Please choose the player type:\n")
        .append("1.human\n")
        .append("2.robot\n")
        .append("Creating a human player...\n")
        .append("Please provide the name: Please provide the space index: Please provide")
        .append(" the maximum number of items carried: !!Enter addPlayer.\n")
        .append("\n")
        .append("-----Players Information-----\n")
        .append("!!Enter getPlayersInfo.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room]\n")
        .append("\n")
        .append("***********************************\n")
        .append("!!Enter getTurns.\n")
        .append("!!Enter getMaxTurn.\n")
        .append("!!Enter getDoctorLuckyHealth.\n")
        .append("!!Enter getTurns.\n")
        .append("!!Enter getPlayerNameByTurn.\n")
        .append("!!Enter getTurns.\n")
        .append("\n")
        .append("-----human's turn, No.1 turn-----\n")
        .append("* Before:\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room]\n")
        .append("* Choose action:\n")
        .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
        .append("!!Enter getPlayerByName.\n")
        .append("!!Enter getNeighborsBySpaceIndex.\n")
        .append("!!Enter getItemsBySpaceIndex.\n")
        .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
        .append("!!Enter getNeighborsBySpaceIndex.\n")
        .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
        .append("!!Enter getItemsInfoBySpaceIndex.\n")
        .append("!!Enter getItemsBySpaceIndex.\n")
        .append("2. Pick up an item: Billiard Cue:2; \n")
        .append("3. Look around\n")
        .append("4. Move the pet\n")
        .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
        .append("!!Enter gePlayerTypeByName.\n")
        .append("!!Enter getPlayerByName.\n")
        .append("human chose the option 4\n")
        .append("!!Enter getSpaceNumFromMansion.\n")
        .append("** Choose a space index[0-20]:\n")
        .append("!!Enter gePlayerTypeByName.\n")
        .append("!!Enter getPlayerByName.\n")
        .append("!!Enter getSpaceNameByIndex.\n")
        .append("The pet has been moved into 2.Carriage House\n")
        .append("!!Enter movePet.\n")
        .append("!!Enter newTurn.\n")
        .append("* After:\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room, Doctor Lucky's health=50]\n")
        .append("!!Enter getDoctorLuckyName.\n")
        .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
        .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
        .append("!!Enter getSpaceNameByIndex.\n")
        .append("!!Enter getDoctorLuckyHealth.\n")
        .append("Doctor Lucky's current space is 1.Billiard Room; health is 50\n")
        .append("!!Enter getPetName.\n")
        .append("!!Enter getPetCurrentSpaceIndex.\n")
        .append("!!Enter getPetCurrentSpaceIndex.\n")
        .append("!!Enter getSpaceNameByIndex.\n")
        .append("Fortune the Cat's current space is 19.Wine Cellar\n")
        .append("!!Enter getTurns.\n")
        .append("!!Enter getMaxTurn.\n")
        .append("!!Enter getDoctorLuckyHealth.\n")
        .append("!!Enter getTurns.\n")
        .append("!!Enter getPlayerNameByTurn.\n")
        .append("!!Enter getTurns.\n")
        .append("\n")
        .append("-----human's turn, No.2 turn-----\n")
        .append("* Before:\n")
        .append("!!Enter getPlayerInfoByName.\n")
        .append("human [playerType=human, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
        .append(" currentSpaceName=Billiard Room, Doctor Lucky's health=50]\n")
        .append("* Choose action:\n")
        .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
        .append("!!Enter getPlayerByName.\n")
        .append("!!Enter getNeighborsBySpaceIndex.\n")
        .append("!!Enter getItemsBySpaceIndex.\n")
        .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
        .append("!!Enter getNeighborsBySpaceIndex.\n")
        .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
        .append("!!Enter getItemsInfoBySpaceIndex.\n")
        .append("!!Enter getItemsBySpaceIndex.\n")
        .append("2. Pick up an item: Billiard Cue:2; \n")
        .append("3. Look around\n")
        .append("4. Move the pet\n")
        .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
        .append("5. Make an attempt\n")
        .append("!!Enter gePlayerTypeByName.\n")
        .append("!!Enter getPlayerByName.\n")
        .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testMovePetWrongChoice() {
    input = new StringReader("2 2 1 1 human 1 1 4 21 q");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30,")
    .append(" spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a human player...\n")
    .append("Please provide the name: Please provide the space index:")
    .append(" Please provide the maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("human chose the option 4\n")
    .append("!!Enter getSpaceNumFromMansion.\n")
    .append("** Choose a space index[0-20]:\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Invalid choice, choose again.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----human's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("human [playerType=human, maxItems=1, carriedItems=[],")
    .append(" currentSpaceIndex=1, currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPetMove() {
    input = new StringReader("2 5 1 2 robot 1 1");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a robot player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the ")
    .append("maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
    .append(" currentSpaceName=Billiard Room]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=1,")
    .append(" currentSpaceName=Billiard Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 0.Armory; 3.Dining Hall; 18.Trophy Room; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Billiard Cue:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 1\n")
    .append("** Choose a space to enter, input the index of space:\n")
    .append("0. Armory\n")
    .append("3. Dining Hall\n")
    .append("18. Trophy Room\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("robot chose the No.18 space.\n")
    .append("!!Enter movePlayer.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter newTurn.\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=18,")
    .append(" currentSpaceName=Trophy Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=18,")
    .append(" currentSpaceName=Trophy Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 10.Library; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Duck Decoy:3; Monkey Hand:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 1. Billiard Room\n")
    .append("This space is invisible.\n")
    .append("** 10. Library\n")
    .append("Library [index=10, neighbors=[12.Master Suite, 13.Nursery, ")
    .append("18.Trophy Room], items=[], players=[]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=18,")
    .append(" currentSpaceName=Trophy Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 2.Carriage House; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 3.Dining Hall\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.3 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=18,")
    .append(" currentSpaceName=Trophy Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 10.Library; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Duck Decoy:3; Monkey Hand:2; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 2\n")
    .append("** Choose an item to pick up, input the index of item:\n")
    .append("1. Duck Decoy\n")
    .append("2. Monkey Hand\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("robot chose the 2.Monkey Hand.\n")
    .append("!!Enter pickUpItem.\n")
    .append("!!Enter newTurn.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[Monkey Hand], ")
    .append("currentSpaceIndex=18, currentSpaceName=Trophy Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 3.Dining Hall; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 4.Drawing Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.4 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[Monkey Hand], ")
    .append("currentSpaceIndex=18, currentSpaceName=Trophy Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 10.Library; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Duck Decoy:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 4\n")
    .append("!!Enter getSpaceNumFromMansion.\n")
    .append("** Choose a space index[0-20]:\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getSpaceNumFromMansion.\n")
    .append("robot chose the No.20 space.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("The pet has been moved into 20.Winter Garden\n")
    .append("!!Enter movePet.\n")
    .append("!!Enter newTurn.\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[Monkey Hand], ")
    .append("currentSpaceIndex=18, currentSpaceName=Trophy Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 4.Drawing Room; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 2.Carriage House\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.5 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[Monkey Hand], ")
    .append("currentSpaceIndex=18, currentSpaceName=Trophy Room]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 10.Library; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Duck Decoy:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 2\n")
    .append("** Choose an item to pick up, input the index of item:\n")
    .append("1. Duck Decoy\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("robot chose the 1.Duck Decoy.\n")
    .append("!!Enter pickUpItem.\n")
    .append("!!Enter newTurn.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("Can not pick up more items.\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=1, carriedItems=[Monkey Hand], ")
    .append("currentSpaceIndex=18, currentSpaceName=Trophy Room]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 5.Foyer; health is 50\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 19.Wine Cellar\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Game Over! You have reached the maximum number of turns, Docotr has escaped.\n");
    rg = new RandomGenerator(0, 17, 2, 1, 1, 3, 20, 1, 1);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testComputerMakeAttemptSuccessfully() {
    input = new StringReader("2 2 1 2 robot 0 2");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a robot player...\n")
    .append("Please provide the name: Please provide the space index: Please provide the")
    .append(" maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0")
    .append(", currentSpaceName=Armory]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0,")
    .append(" currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("5. Make an attempt\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 5\n")
    .append("!!Enter getItemsByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter makeAttempt.\n")
    .append("!!Enter newTurn.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("Poke doctor's eyes, attack Successfully!\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0")
    .append(", currentSpaceName=Armory]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 49\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0")
    .append(", currentSpaceName=Armory]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 4\n")
    .append("!!Enter getSpaceNumFromMansion.\n")
    .append("** Choose a space index[0-20]:\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getSpaceNumFromMansion.\n")
    .append("robot chose the No.13 space.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("The pet has been moved into 13.Nursery\n")
    .append("!!Enter movePet.\n")
    .append("!!Enter newTurn.\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0")
    .append(", currentSpaceName=Armory]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 2.Carriage House; health is 49\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 10.Library\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Game Over! You have reached the maximum number of turns, Docotr has escaped.\n");
    rg = new RandomGenerator(3, 13);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testComputerMakeAttemptFailed() {
    input = new StringReader("2 2 2 2 robot1 0 2 2 robot2 0 1");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "** Genarating Player 2:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot1's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot1 chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot2's turn, No.2 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot2 chose the option 1\n"
        + "** Choose a space to enter, input the index of space:\n"
        + "1. Billiard Room\n"
        + "6. Green House\n"
        + "7. Hedge Maze\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "robot2 chose the No.1 space.\n"
        + "!!Enter movePlayer.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter newTurn.\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=1, currentSpaceName=Billiard Room]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 2.Carriage House; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 3.Dining Hall\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Game Over! You have reached the maximum number of turns, Docotr has escaped.\n");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPokeEyesSuccessfully() {
    input = new StringReader("2 2 1 2 robot 0 2");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: "
        + "Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory, Doctor Lucky's health=50"
        + ", pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot's turn, No.2 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot chose the option 4\n"
        + "!!Enter getSpaceNumFromMansion.\n"
        + "** Choose a space index[0-20]:\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getSpaceNumFromMansion.\n"
        + "robot chose the No.2 space.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "The pet has been moved into 2.Carriage House\n"
        + "!!Enter movePet.\n"
        + "!!Enter newTurn.\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 2.Carriage House; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 19.Wine Cellar\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Game Over! You have reached the maximum number of turns, Docotr has escaped.\n"
        + "");
    rg = new RandomGenerator(3, 2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPokeEyesFailed() {
    input = new StringReader("2 2 2 2 robot1 0 2 2 robot2 0 1");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, "
        + "spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: "
        + "Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "** Genarating Player 2:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: "
        + "Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot1's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot1 chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot1 [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot2's turn, No.2 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[],"
        + " currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot2 chose the option 2\n"
        + "** Choose an item to pick up, input the index of item:\n"
        + "1. Revolver\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "robot2 chose the 1.Revolver.\n"
        + "!!Enter pickUpItem.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot2 [playerType=robot, maxItems=1, carriedItems=[Revolver],"
        + " currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 2.Carriage House; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 3.Dining Hall\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Game Over! You have reached the maximum number of turns, Docotr has escaped.\n"
        + "");
    rg = new RandomGenerator(1, 0);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPlayerMakeAttemptSuccessfully() {
    input = new StringReader("2 2 1 1 human 0 2 5 q");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Please provide the name: Please provide the space index: Please provide "
        + "the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "human chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----human's turn, No.2 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "Game Quit.");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPlayerMakeAttemptFailed() {
    input = new StringReader("2 2 2 1 human 0 2 2 robot 0 1 5");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=50, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Please provide the name: Please provide the space index: Please provide "
        + "the maximum number of items carried: !!Enter addPlayer.\n"
        + "** Genarating Player 2:\n"
        + "Please choose the player type:\n"
        + "1.human\n"
        + "2.robot\n"
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: Please provide "
        + "the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory, Doctor Lucky's health=50, pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "human chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot's turn, No.2 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot chose the option 3\n"
        + "!!Enter getAroundInfo.\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter newTurn.\n"
        + "** 1. Billiard Room\n"
        + "This space is invisible.\n"
        + "** 6. Green House\n"
        + "Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze], items=[Trowel, Pinking Shears], players=[]]\n"
        + "** 7. Hedge Maze\n"
        + "Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House, 15.Piazza], items=[Loud Noise], players=[]]\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=1, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 2.Carriage House; health is 49\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 3.Dining Hall\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Game Over! You have reached the maximum number of turns, Docotr has escaped.\n"
        + "");
    rg = new RandomGenerator(2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testPlayerWin() {
    input = new StringReader("2 2 1 1 human 0 2 5");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=1, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Please provide the name: Please provide the space index: "
        + "Please provide the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----human's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory, Doctor Lucky's health=1,"
        + " pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "human chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "human [playerType=human, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 0\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "Game Over! Doctor Lucky has been killed, Winner is human\n"
        + "");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg,
        "./res/WorldSpecification_lowhealth.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testComputerWin() {
    input = new StringReader("2 2 1 2 robot 0 2");
    stringBuffer.append("!!Enter initiateGame.\n"
        + "!!Enter setMansion.\n"
        + "!!Enter setDoctorLucky.\n"
        + "!!Enter setPet.\n"
        + "***********************************\n"
        + "Mansion created successfully, the information is as follows:\n"
        + "-----Mansion Information-----\n"
        + "!!Enter getMansionInfo.\n"
        + "Mansion [name=Doctor Lucky's Mansion, height=36, width=30,"
        + " spacesNum=21, itemsNum=20]\n"
        + "-----Main Character Information-----\n"
        + "!!Enter getDoctorLuckyInfo.\n"
        + "Doctor Lucky [health=1, currentSpaceIndex=0]\n"
        + "-----Pet Information-----\n"
        + "!!Enter getPetInfo.\n"
        + "Fortune the Cat [currentSpaceIndex=0]\n"
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
        + "Creating a robot player...\n"
        + "Please provide the name: Please provide the space index: Please provide"
        + " the maximum number of items carried: !!Enter addPlayer.\n"
        + "\n"
        + "-----Players Information-----\n"
        + "!!Enter getPlayersInfo.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0,"
        + " currentSpaceName=Armory]\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "!!Enter getTurns.\n"
        + "\n"
        + "-----robot's turn, No.1 turn-----\n"
        + "* Before:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], "
        + "currentSpaceIndex=0, currentSpaceName=Armory, Doctor Lucky's health=1,"
        + " pet=Fortune the Cat]\n"
        + "* Choose action:\n"
        + "!!Enter getCurrentSpaceIndexByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "!!Enter getNeighborsInfoBySpaceIndex.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n"
        + "!!Enter getItemsInfoBySpaceIndex.\n"
        + "!!Enter getItemsBySpaceIndex.\n"
        + "2. Pick up an item: Revolver:3; \n"
        + "3. Look around\n"
        + "4. Move the pet\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "5. Make an attempt\n"
        + "!!Enter gePlayerTypeByName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "robot chose the option 5\n"
        + "!!Enter getItemsByPlayerName.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter makeAttempt.\n"
        + "!!Enter newTurn.\n"
        + "!!Enter getPlayerByName.\n"
        + "!!Enter getNeighborsBySpaceIndex.\n"
        + "Poke doctor's eyes, attack Successfully!\n"
        + "* After:\n"
        + "!!Enter getPlayerInfoByName.\n"
        + "robot [playerType=robot, maxItems=2, carriedItems=[], currentSpaceIndex=0"
        + ", currentSpaceName=Armory]\n"
        + "!!Enter getDoctorLuckyName.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getDoctorLuckyCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "Doctor Lucky's current space is 1.Billiard Room; health is 0\n"
        + "!!Enter getPetName.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getPetCurrentSpaceIndex.\n"
        + "!!Enter getSpaceNameByIndex.\n"
        + "Fortune the Cat's current space is 1.Billiard Room\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getMaxTurn.\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "\n"
        + "***********************************\n"
        + "!!Enter getDoctorLuckyHealth.\n"
        + "!!Enter getTurns.\n"
        + "!!Enter getPlayerNameByTurn.\n"
        + "Game Over! Doctor Lucky has been killed, Winner is robot\n"
        + "");
    rg = new RandomGenerator();
    new KillDoctorLuckyConsoleController(input, output, rg,
        "./res/WorldSpecification_lowhealth.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  @Test
  public void testDoctorEscape() {
    input = new StringReader("2 2 1 2 robot 0 2");
    stringBuffer.append("!!Enter initiateGame.\n")
    .append("!!Enter setMansion.\n")
    .append("!!Enter setDoctorLucky.\n")
    .append("!!Enter setPet.\n")
    .append("***********************************\n")
    .append("Mansion created successfully, the information is as follows:\n")
    .append("-----Mansion Information-----\n")
    .append("!!Enter getMansionInfo.\n")
    .append("Mansion [name=Doctor Lucky's Mansion, height=36, width=30, spacesNum=21,")
        .append(" itemsNum=20]\n")
    .append("-----Main Character Information-----\n")
    .append("!!Enter getDoctorLuckyInfo.\n")
    .append("Doctor Lucky [health=50, currentSpaceIndex=0]\n")
    .append("-----Pet Information-----\n")
    .append("!!Enter getPetInfo.\n")
    .append("Fortune the Cat [currentSpaceIndex=0]\n")
    .append("***********************************\n")
    .append("Menu(Input 'q'/'Q' to quit):\n")
    .append("1. Create world map.\n")
    .append("2. Start game.\n")
    .append("\n")
    .append("***********************************\n")
    .append("Game Start!\n")
    .append("* Please provide the maximum of turns: !!Enter setMaxTurn.\n")
    .append("* Generate Player\n")
    .append("Please provide the number of players:** Genarating Player 1:\n")
    .append("Please choose the player type:\n")
    .append("1.human\n")
    .append("2.robot\n")
    .append("Creating a robot player...\n")
    .append("Please provide the name: Please provide the space index:")
    .append(" Please provide the maximum number of items carried: !!Enter addPlayer.\n")
    .append("\n")
    .append("-----Players Information-----\n")
    .append("!!Enter getPlayersInfo.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[],")
    .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.1 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[],")
    .append(" currentSpaceIndex=0, currentSpaceName=Armory, ")
        .append("Doctor Lucky's health=50, pet=Fortune the Cat]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("5. Make an attempt\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 5\n")
    .append("!!Enter getItemsByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter makeAttempt.\n")
    .append("!!Enter newTurn.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("Poke doctor's eyes, attack Successfully!\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[],")
    .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 1.Billiard Room; health is 49\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 1.Billiard Room\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getPlayerNameByTurn.\n")
    .append("!!Enter getTurns.\n")
    .append("\n")
    .append("-----robot's turn, No.2 turn-----\n")
    .append("* Before:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[],")
    .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n")
    .append("* Choose action:\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("!!Enter getNeighborsInfoBySpaceIndex.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("1. Move to a neighboring space: 1.Billiard Room; 6.Green House; 7.Hedge Maze; \n")
    .append("!!Enter getItemsInfoBySpaceIndex.\n")
    .append("!!Enter getItemsBySpaceIndex.\n")
    .append("2. Pick up an item: Revolver:3; \n")
    .append("3. Look around\n")
    .append("4. Move the pet\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter gePlayerTypeByName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("robot chose the option 3\n")
    .append("!!Enter getAroundInfo.\n")
    .append("!!Enter getCurrentSpaceIndexByPlayerName.\n")
    .append("!!Enter getPlayerByName.\n")
    .append("!!Enter getNeighborsBySpaceIndex.\n")
    .append("!!Enter newTurn.\n")
    .append("** 1. Billiard Room\n")
    .append("This space is invisible.\n")
    .append("** 6. Green House\n")
    .append("Green House [index=6, neighbors=[0.Armory, 7.Hedge Maze],")
    .append(" items=[Trowel, Pinking Shears], players=[]]\n")
    .append("** 7. Hedge Maze\n")
    .append("Hedge Maze [index=7, neighbors=[0.Armory, 6.Green House,")
    .append(" 15.Piazza], items=[Loud Noise], players=[]]\n")
    .append("* After:\n")
    .append("!!Enter getPlayerInfoByName.\n")
    .append("robot [playerType=robot, maxItems=2, carriedItems=[],")
    .append(" currentSpaceIndex=0, currentSpaceName=Armory]\n")
    .append("!!Enter getDoctorLuckyName.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getDoctorLuckyCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Doctor Lucky's current space is 2.Carriage House; health is 49\n")
    .append("!!Enter getPetName.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getPetCurrentSpaceIndex.\n")
    .append("!!Enter getSpaceNameByIndex.\n")
    .append("Fortune the Cat's current space is 3.Dining Hall\n")
    .append("!!Enter getTurns.\n")
    .append("!!Enter getMaxTurn.\n")
    .append("\n")
    .append("***********************************\n")
    .append("!!Enter getDoctorLuckyHealth.\n")
    .append("Game Over! You have reached the maximum number of turns, Docotr has escaped.\n");
    rg = new RandomGenerator(2);
    new KillDoctorLuckyConsoleController(input, output, rg, "./res/WorldSpecification.txt")
        .playGame(killDoctorLucky);
    assertEquals(output.toString(), stringBuffer.toString());
  }
  
  
  

}
