- Instruction: 
 
In Mac: Run `java -jar KillDocterLucky.jar <Specification.txt> <maxTurn> <gui/text>` in Terminal  
In Wondows: Run `java -jar KillDocterLucky.jar <Specification.txt> <maxTurn> <gui/text>` in Command Prompt  
The `<Specification.txt>` should be replaced by your file, then enter your order when prompted. 
The `<maxTurn>` is the maximum turns, after reaching the maxTurn and the Doctor is alive, the Doctor would escape.
The `<gui/text>` gui would start game by GUI, text would use the text-based view.


- Assumptions&Limitations

Assumptions: I assume that after each player completes their turn, the doctor will move. This allows the doctor to move to more rooms and makes the game more interesting. I also assume that when a player chooses to "look around," the player information and tool information for each neighboring room will be displayed one by one. If the doctor is also in the room, the health of the doctor will be displayed as well. In m3, A pet was added and it can traverse the mansion by depth-first order.  
Limitations: If players do not follow the prompts for input, the program may also not be able to continue properly. In m3, I set a more proper way to handle wrong input, player can choose again and the wrong input will not be counted as a turn.

- Citations:

Microsoft Excel: To do the test planing.  
Draw.io: To draw the UML class diagram.  
Junit 4: To do the unit test.

- Design Changes:
  
    - KillDoctorLuckyControllerFeature.java: add some methods:   Boolean isGameOver();String getWinner();List<String> robotTurn();
    - KillDoctorLuckyConsoleController.java: add two parameters: KillDoctorLuckyView killDoctorLuckyView, RobotAttributions robotAttributions. 
    - KillDoctorLuckyControllerFeature.java&KillDoctorLuckyViewModel.java split codes from controller and model, to fit GUI view.
	
	
- Git Tag:

The milestone3 code and resources can be seen from the git tag `Milestone-3`
