package killdoctorlucky.model.character;

/**
 * CharacterModel the superclass of player and doctor.
 */
public abstract class CharacterModel implements Character {
  protected final String name;
  protected int currentSpaceIndex;

  /**
   * Constructor of the CharacterModel.
   * 
   * @param nameIn the name 
   * @param currentSpaceIndexIn the currentSpaceIndex
   */
  protected CharacterModel(String nameIn, int currentSpaceIndexIn) {
    super();
    this.name = nameIn;
    this.currentSpaceIndex = currentSpaceIndexIn;
  }

  @Override
  public int getCurrentSpaceIndex() {
    return currentSpaceIndex;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int move(int spaceIndex) {
    this.currentSpaceIndex = spaceIndex;
    return currentSpaceIndex;
  }

}
