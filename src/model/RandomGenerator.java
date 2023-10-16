package model;

import java.util.Random;

/**
 * The RandomGenerator which include real random and mock random generator.
 */
public class RandomGenerator {
  private Random random;
  private int[] mockedValues;
  private int currentIndex;

  
  /**
   * 
   */
  public RandomGenerator() {
    random = new Random();
    mockedValues = null;
    currentIndex = -1;
  }

  /**
   * 
   * @param values
   */
  public RandomGenerator(int... values) {
    random = null;
    mockedValues = values;
    currentIndex = -1;
  }

  
  /**
   * 
   * @param bound
   * @return
   */
  public int nextInt(int bound){
    if (mockedValues != null) {
      if (currentIndex < mockedValues.length) {
        return mockedValues[currentIndex++] % bound;
      } else {
        throw new IllegalStateException("No more mocked values available.");
      }
    } else {
      return random.nextInt(bound);
    }
  }

}
