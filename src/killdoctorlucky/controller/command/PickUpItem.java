package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The PickUpItem helper class.
 */
public class PickUpItem implements KillDoctorLuckyCommand {
  
  private String playerName;
  private String itemName;

  /**
   * Constructor of PickUpItem.
   * @param playerNameIn the player 
   * @param itemNameIn the item
   */
  public PickUpItem(String playerNameIn, String itemNameIn) {
    super();
    this.playerName = playerNameIn;
    this.itemName = itemNameIn;
  }

  @Override
  public void execute(KillDoctorLucky m) {
    m.pickUpItem(playerName, itemName);
    
  }

}
