/**
 * 
 */
package killdoctorlucky.controller;

import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * 
 */
public interface KillDoctorLuckyCommand {
  
  /**
   * Starting point for the controller.
   * 
   * @param m the model to use
   */
  void execute(KillDoctorLucky m);

}
