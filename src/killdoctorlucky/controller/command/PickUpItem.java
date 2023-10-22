package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.item.Item;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The PickUpItem helper class.
 */
public class PickUpItem implements KillDoctorLuckyCommand {
  
  private Player player;
  private Item item;

  /**
   * Constructor of PickUpItem.
   * @param playerIn the player 
   * @param itemIn the item
   */
  public PickUpItem(Player playerIn, Item itemIn) {
    super();
    this.player = playerIn;
    this.item = itemIn;
  }

  @Override
  public void execute(KillDoctorLucky m) {
    m.pickUpItem(player, item);
    
  }

}
