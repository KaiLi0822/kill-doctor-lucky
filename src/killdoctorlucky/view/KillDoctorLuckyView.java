/**
 * 
 */
package killdoctorlucky.view;

import killdoctorlucky.controller.KillDoctorLuckyControllerFeature;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLuckyViewModel;

/**
 * 
 */
public interface KillDoctorLuckyView {
  /**
   * Get the set of feature callbacks that the view can use.
   * 
   * @param f the set of feature callbacks as a KillDoctorLuckyControllerFeature object
   */
  void setFeatures(KillDoctorLuckyControllerFeature f);
  
  void setModel(KillDoctorLuckyViewModel m);
  
  void startGame();
  
}
