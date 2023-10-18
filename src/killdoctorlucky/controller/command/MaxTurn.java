package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The MaxTurn helper class.
 */
public class MaxTurn implements KillDoctorLuckyCommand {
  private int maxTurn;

  /**
   * Constructor.
   * 
   * @param maxTurnIn the maxTurn.
   */
  public MaxTurn(int maxTurnIn) {
    maxTurn = maxTurnIn;

  }

  @Override
  public void execute(KillDoctorLucky m) {
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null");
    }

    m.setMaxTurn(maxTurn);

  }
}
