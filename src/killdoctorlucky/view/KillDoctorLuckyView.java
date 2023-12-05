package killdoctorlucky.view;

import killdoctorlucky.controller.KillDoctorLuckyControllerFeature;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyViewModel;

/**
 * The view interface.
 */
public interface KillDoctorLuckyView {
  /**
   * Get the set of feature callbacks that the view can use.
   * 
   * @param f the set of feature callbacks as a KillDoctorLuckyControllerFeature object
   */
  void setFeatures(KillDoctorLuckyControllerFeature f);
  
  /**
   * Sets the model used by view.
   * @param m the model
   */
  void setModel(KillDoctorLuckyViewModel m);
  
  /**
   * Starts the game.
   */
  void startGame();
  
}
