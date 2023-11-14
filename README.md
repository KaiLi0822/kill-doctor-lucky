- Instruction: 
 
In Mac: Run `java -jar KillDocterLucky.jar <Specification.txt>` in Terminal  
In Wondows: Run `java -jar KillDocterLucky.jar <Specification.txt>` in Command Prompt  
The `<Specification.txt>` should be replaced by your file, then enter your order when prompted. 

 
- Testing Results List: 

    - AddingComputerPlayer.txt  
    - AddingHumanPlayer.txt  
    - CreatingAndSavingMap.txt  
    - DisplayingInformationAboutASpace.txt  
    - DisplayingTheDescriptionOfPlayer.txt  
    - GameEndingAfterReachingtheMaximumNumberOfTurns.txt  
    - PlayerLookAround.txt  
    - PlayerMovingAround.txt  
    - PlayerPickUpAnItem.txt  
    - TakingTurnsBetweenPlayers.txt  


- Assumptions&Limitations

Assumptions: I assume that after each player completes their turn, the doctor will move. This allows the doctor to move to more rooms and makes the game more interesting. I also assume that when a player chooses to "look around," the player information and tool information for each neighboring room will be displayed one by one. If the doctor is also in the room, the health of the doctor will be displayed as well. In m3, A pet was added and it can traverse the mansion by depth-first order.  
Limitations: If players do not follow the prompts for input, the program may also not be able to continue properly. In m3, I set a more proper way to handle wrong input, player can choose again and the wrong input will not be counted as a turn.

- Citations:

Microsoft Excel: To do the test planing.  
Draw.io: To draw the UML class diagram.  
Junit 4: To do the unit test.

- Design Changes:
  
    - KillDoctorLucky.java: add some methods: Boolean makeAttempt(String playerName, String itemName);String getPetInfo();String getNeighborsInfoBySpaceIndex(int spaceIndex);String getItemsInfoBySpaceIndex(int spaceIndex);
    - Pet.java: add two methods: void createRoute(int index, Mansion mansion);int nextSpaceIndexInRoute(int currentSpaceIndex); 
    - PetModel.java: add attributions: List<Integer> route; Set<Integer> visited; add method: void dfs(int index, Mansion mansion)
    - DoctorLucky.java: add method: void deductHealth(int damage);
	
	
- Git Tag:

The milestone2 code and resources can be seen from the git tag `Milestone-2`
