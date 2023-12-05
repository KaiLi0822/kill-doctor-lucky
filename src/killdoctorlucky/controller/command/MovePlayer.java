package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The MovePlayer helper class.
 */
public class MovePlayer implements KillDoctorLuckyCommand {

  private String playerName;
  private int targetSpace;

  /**
   * Constructor of MovePlayer.
   * 
   * @param playerNameIn  the player name
   * @param targetSpaceIn the target space
   */
  public MovePlayer(String playerNameIn, int targetSpaceIn) {
    super();
    this.playerName = playerNameIn;
    this.targetSpace = targetSpaceIn;
  }

  @Override
  public void execute(KillDoctorLucky m) {
    m.movePlayer(playerName, targetSpace);

  }

}
