- Instruction: 
 
In Mac: Run `java -jar KillDocterLucky.jar <Specification.txt>` in Terminal  
In Wondows: Run `java -jar KillDocterLucky.jar <Specification.txt>` in Command Prompt  
The `<Specification.txt>` should be replaced by your file, then enter your order when prompted. 

 
- Testing Results List: 

	- CreateMap.txt: the console log of creating a mansion map picture.


- Assumptions&Limitations

Assumptions: I assume that after each player completes their turn, the doctor will move. This allows the doctor to move to more rooms and makes the game more interesting. I also assume that when a player chooses to "look around," the player information and tool information for each neighboring room will be displayed one by one. If the doctor is also in the room, the health of the doctor will be displayed as well.  
Limitations: If players do not follow the prompts for input, the program may also not be able to continue properly.

- Citations:

Microsoft Excel: To do the test planing.  
Draw.io: To draw the UML class diagram.  
Junit 4: To do the unit test.

- Design Changes:

    - KillDoctorLuckyConsoleController.java: add a filePath field.  
    - KillDoctorLucky.java: add four methods, getPlayerInfoByName(name: String): String, initiateGame(readable: Readable)
	, outputMap(): String, getCharacterSpace(character: Character): Space  
    - PlayerType.java: add a new enumeration class  
    - Mansion.java: add getHeight(): int and getWidth(): int  
    - Player.java: add getPlayerType(): PlayerType and getMaxItems(): int  
    - Space.java add getItemByname(name: String): Item and removeItem(item: Item)
	
	
- Git Tag:

The milestone1 code and resources can be seen from the git tag `Milestone-1`
