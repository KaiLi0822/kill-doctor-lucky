package killdoctorlucky.controller;

import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;

/**
 * Represents a Controller for KillDoctorLucky.
 */
public interface KillDoctorLuckyController {

  /**
   * Execute a single game of KillDoctorLucky given a KillDoctorLucky Model. When
   * the game is over, the playGame method ends.
   *
   * @param m a non-null KillDoctorLucky Model
   */
  void playGame(KillDoctorLucky m);
}
