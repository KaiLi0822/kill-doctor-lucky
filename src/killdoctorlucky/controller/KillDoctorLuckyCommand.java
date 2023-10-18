package killdoctorlucky.controller;

import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * Represents a Controller Command for KillDoctorLucky.
 */
public interface KillDoctorLuckyCommand {

  /**
   * Starting point for the controller command.
   * 
   * @param m the model to use
   */
  void execute(KillDoctorLucky m);

}
