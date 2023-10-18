package killdoctorlucky.model.character;

/**
 * Represents a player type.
 */
public enum PlayerType {
  HUMAN("human"), ROBOT("robot");

  private final String disp;

  /**
   * Assign the value to disp.
   * 
   * @param dispIn the disp
   */
  private PlayerType(String dispIn) {
    this.disp = dispIn;
  }

  @Override
  public String toString() {
    return disp;
  }

}
