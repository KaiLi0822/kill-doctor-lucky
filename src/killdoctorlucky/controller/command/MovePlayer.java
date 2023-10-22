package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.character.Player;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The MovePlayer helper class.
 */
public class MovePlayer implements KillDoctorLuckyCommand {
  
  private Player player;
  private int targetSpace;

  /**
   * Constructor of MovePlayer.
   * @param playerIn the player
   * @param targetSpaceIn the target space
   */
  public MovePlayer(Player playerIn, int targetSpaceIn) {
    super();
    this.player = playerIn;
    this.targetSpace = targetSpaceIn;
  }

  @Override
  public void execute(KillDoctorLucky m) {
    m.movePlayer(player, targetSpace);
    
  }

}
