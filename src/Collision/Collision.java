/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collision;

import Objects.Block;
import Objects.Cannon;
import Objects.CannonBallLeft;
import Objects.Goal;
import Objects.MovingSaw;
import Objects.Saw;
import Objects.Spike;
import Objects.SpikeTurned;
import java.awt.Point;

/**
 *
 * @author Nissinen
 */
public class Collision {

    public static boolean playerBlock(Point p, Block b) {
        return b.contains(p);
    }
    
    public static boolean playerSaw(Point p, Saw s){
            return s.contains(p);
    }
    
     public static boolean playerSpike(Point p, Spike po){
            return po.contains(p);
    }
     
     public static boolean playerSpikeTurned(Point p, SpikeTurned pT){
            return pT.contains(p);
    }
     
      public static boolean playerGoal(Point p, Goal goal){
            return goal.contains(p);
    }
      public static boolean playerMovingSaw(Point p, MovingSaw ms){
            return ms.contains(p);
    }
      public static boolean playerCannon(Point p, Cannon c){
          return c.contains(p);
      }
      public static boolean playerCannonBallLeft(Point p, CannonBallLeft cbl){
          return cbl.contains(p);
      }
}
