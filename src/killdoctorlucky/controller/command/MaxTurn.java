package killdoctorlucky.controller.command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import killdoctorlucky.controller.KillDoctorLuckyCommand;
import model.character.DoctorLuckyModel;
import model.item.ItemModel;
import model.killdoctorlucky.KillDoctorLucky;
import model.space.Space;
import model.space.SpaceModel;


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
