package doctorlucky;

import java.util.Objects;

/**
 * This class represents the DoctorLucky.
 */
public class DoctorLucky {

  private int health;
  private final String name;
  private int currentSpaceIndex;

  /**
   * Constructs a DoctorLucky object.
   * 
   * @param healthIn the health
   * @param nameIn   the name
   * @throws IllegalArgumentException if health is illegal, throw an
   *                                  IllegalArgumentException
   */
  public DoctorLucky(int healthIn, String nameIn) throws IllegalArgumentException {
    super();
    if (healthIn < 0) {
      throw new IllegalArgumentException();
    }
    this.health = healthIn;
    this.name = nameIn;
    this.currentSpaceIndex = 0;
  }

  /**
   * Gets the health.
   * 
   * @return the health
   */
  public int getHealth() {
    return health;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the currentSpaceIndex.
   * 
   * @return the currentSpaceIndex
   */
  public int getCurrentSpaceIndex() {
    return currentSpaceIndex;
  }

  /**
   * Gets the currentSpaceIndex.
   * 
   * @param currentSpaceIndexIn the currentSpaceIndex to set
   */
  public void setCurrentSpaceIndex(int currentSpaceIndexIn) {
    this.currentSpaceIndex = currentSpaceIndexIn;
  }

  /**
   * Moves the character.
   * 
   * @return currentSpaceIndex the currentSpaceIndex of character
   */
  public int move() {
    setCurrentSpaceIndex(currentSpaceIndex + 1);
    return currentSpaceIndex;

  }

  @Override
  public String toString() {
    return "DoctorLucky [health=" + health + ", name=" + name + ", currentSpaceIndex="
        + currentSpaceIndex + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    DoctorLucky other = (DoctorLucky) obj;
    return Objects.equals(name, other.name);
  }

}
