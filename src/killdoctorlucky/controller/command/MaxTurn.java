package killdoctorlucky.controller.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import killdoctorlucky.model.character.DoctorLuckyModel;
import killdoctorlucky.model.item.ItemModel;
import killdoctorlucky.model.killdoctorlucky.KillDoctorLucky;
import killdoctorlucky.model.space.Space;
import killdoctorlucky.model.space.SpaceModel;


public class MaxTurn implements KillDoctorLuckyCommand {
  private int maxTurn;

  /**
   * Constructor.
   * 
   * @param maxTurnIn the maxTurn.
   */
  public MaxTurn(int maxTurnIn){
    maxTurn = maxTurnIn;

  }


  @Override
  public void execute(KillDoctorLucky m){
    if (m == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
 
    m.setMaxTurn(maxTurn);
    
  }
}
