/**
 * 
 */
package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import model.RandomGenerator;
import model.killdoctorlucky.KillDoctorLucky;

/**
 * 
 */
public class CreatePlayer implements KillDoctorLuckyCommand{
  
  
  private String name;
  private int currentSpaceIndex;
  private int maxItems;
  private RandomGenerator rg;
  
  
  
  

  public CreatePlayer(RandomGenerator rgIn) {
    super();
    this.rg = rgIn;
  }




  public CreatePlayer(String nameIn, int currentSpaceIndexIn, int maxItemsIn) {
    super();
    this.name = nameIn;
    this.currentSpaceIndex = currentSpaceIndexIn;
    this.maxItems = maxItemsIn;
    
  }




  @Override
  public void execute(KillDoctorLucky m) {
    if (name == null) {
      m.setPlayer("Auto-Player", rg.nextInt(m.getMansion().getSpacesNum()),
          rg.nextInt(m.getMansion().getItemsNum())+1);
    }else {
      m.setPlayer(name, currentSpaceIndex, maxItems);
    }
    
  }

}
