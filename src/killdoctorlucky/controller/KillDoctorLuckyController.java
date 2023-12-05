package killdoctorlucky.controller;

import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.view.KillDoctorLuckyView;

/**
 * Represents a Controller for KillDoctorLucky.
 */
public interface KillDoctorLuckyController extends KillDoctorLuckyControllerFeature {

  /**
   * Execute a single game of KillDoctorLucky.
   */
  void playGame();

  /**
   * Add the model to the controller.
   * 
   * @param m the model
   */
  void setModel(KillDoctorLucky m);

  /**
   * Add the model and the view to controller.
   * 
   * @param m the model
   * @param v the view
   */
  void setModelView(KillDoctorLucky m, KillDoctorLuckyView v);
}
