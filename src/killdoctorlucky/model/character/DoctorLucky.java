package killdoctorlucky.model.character;

/**
 * The DoctorLucky interface.
 */
public interface DoctorLucky extends Character {

  /**
   * Get the health.
   * 
   * @return health the health of doctor
   */
  int getHealth();
  
  /**
   * Deducts the health.
   * @param damage the item damage
   */
  void deductHealth(int damage);

}
