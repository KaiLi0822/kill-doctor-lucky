package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The MovePet helper class.
 */
public class MovePet implements KillDoctorLuckyCommand {

  private int spaceIndex;

  /**
   * Constructor of MovePet.
   * 
   * @param spaceIndexIn the spaceIndex
   */
  public MovePet(int spaceIndexIn) {
    super();
    this.spaceIndex = spaceIndexIn;
  }

  @Override
  public void execute(KillDoctorLucky m) {
    m.movePet(spaceIndex);

  }

}
