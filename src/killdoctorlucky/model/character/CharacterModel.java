package killdoctorlucky.model.character;


/**
 * 
 */
public abstract class CharacterModel implements Character{
  private final String name;
  private int currentSpaceIndex;
  
  
  /**
   * 
   * @param nameIn
   * @param currentSpaceIndexIn
   */
  public CharacterModel(String nameIn, int currentSpaceIndexIn) {
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
