package killdoctorlucky.model.character;

import java.util.Objects;

/**
 * This class represents the DoctorLucky.
 */
public class DoctorLuckyModel extends CharacterModel implements DoctorLucky {

  private int health;

  /**
   * Constructs a DoctorLucky object.
   * 
   * @param healthIn the health
   * @param nameIn   the name
   * @throws IllegalArgumentException if health is illegal, throw an
   *                                  IllegalArgumentException
   */
  public DoctorLuckyModel(String nameIn, int healthIn) throws IllegalArgumentException {
    super(nameIn, 0);
    if (healthIn < 0) {
      throw new IllegalArgumentException();
    }
    this.health = healthIn;
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append(name).append(" [health=").append(health).append(", currentSpaceIndex=")
        .append(currentSpaceIndex).append("]");
    return sb.toString();

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
    DoctorLuckyModel other = (DoctorLuckyModel) obj;
    return Objects.equals(name, other.name);
  }

  @Override
  public void deductHealth(int damage) {
    health = health - damage;
  }

}
