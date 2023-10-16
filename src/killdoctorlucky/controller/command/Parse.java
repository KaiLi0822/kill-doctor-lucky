package killdoctorlucky.controller.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import model.character.DoctorLuckyModel;
import model.item.ItemModel;
import model.killdoctorlucky.KillDoctorLucky;
import model.space.Space;
import model.space.SpaceModel;


public class Parse implements KillDoctorLuckyCommand {
  private FileReader fileReader;

  /**
   * Constructor.
   * 
   * @param file the specification file.
   */
  public Parse(String file) throws FileNotFoundException{
    try {
      fileReader = new FileReader(file);
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("Specification file not found.");
    }
  }


  @Override
  public void execute(KillDoctorLucky m){
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
    

    BufferedReader br = new BufferedReader(fileReader);
    String line;

  
    try {
      int index = 0;
      while ((line = br.readLine()) != null) {
        String[] part = line.split("\t");
        // generate mansion
        if (part.length == 3 && m.getMansion() == null) {
          m.setMansion(part[2], Integer.parseInt(part[0]), Integer.parseInt(part[1]));
        }
        // generate target character
        if (part.length == 2) {
          m.setDoctorLucky(part[1], Integer.parseInt(part[0]));
        }

        // generate spaces
        if (part.length == 1 && m.getMansion().getSpacesNum() == 0) {
          m.getMansion().setSpacesNum(Integer.parseInt(part[0]));
        }
        
        if (part.length == 5) {
          m.getMansion().addSpace(index++, part[4], Arrays.copyOfRange(part, 0, 4));
         
        }

        // generate items
        if (part.length == 1 && m.getMansion().getItemsNum() == 0) {
          m.getMansion().setItemsNum(Integer.parseInt(part[0]));
        }
        
        if (part.length == 3 && m.getMansion().getItemsNum() != 0) {
          m.getMansion().getSpaces().get(Integer.parseInt(part[0])).addItem(part[2], Integer.parseInt(part[0]), Integer.parseInt(part[1]));
                 
        }
      }
      br.close();
    } catch (NumberFormatException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
     
    
    List<Space> spaces = m.getMansion().getSpaces();
    // set neighbors of each space
    for (int i = 0; i < spaces.size(); i++) {
      for (int j = 0; j < spaces.size(); j++) {
        if (spaces.get(i).getName() != spaces.get(j).getName()) {
          spaces.get(i).addNeighbor(spaces.get(j));
        }
      }
    }
    
  }
}
