package killdoctorlucky.controller.command;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.RandomGenerator;
import killdoctorlucky.model.character.PlayerType;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * The CreatePlayer helper class.
 */
public class CreatePlayer implements KillDoctorLuckyCommand {

  private String name;
  private int currentSpaceIndex;
  private int maxItems;
  private RandomGenerator rg;

  /**
   * Constructor for the CreatePlayer.
   * 
   * @param rgIn the random object
   * @param nameIn the name
   * @param currentSpaceIndexIn the currentSpaceIndex
   * @param maxItemsIn the maxItems
   */
  public CreatePlayer(RandomGenerator rgIn, String nameIn, int currentSpaceIndexIn,
      int maxItemsIn) {
    this(nameIn, currentSpaceIndexIn, maxItemsIn);
    this.rg = rgIn;
  }

  /**
   * Constructor for the CreatePlayer.
   * 
   * @param nameIn the name
   * @param currentSpaceIndexIn the currentSpaceIndex
   * @param maxItemsIn the maxItems
   */
  public CreatePlayer(String nameIn, int currentSpaceIndexIn, int maxItemsIn) {
    this.name = nameIn;
    this.currentSpaceIndex = currentSpaceIndexIn;
    this.maxItems = maxItemsIn;

  }

  @Override
  public void execute(KillDoctorLucky m) {
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
    if (rg != null) {
      m.addPlayer(PlayerType.ROBOT, name, currentSpaceIndex, maxItems);
    } else {
      m.addPlayer(PlayerType.HUMAN, name, currentSpaceIndex, maxItems);
    }

  }

}
