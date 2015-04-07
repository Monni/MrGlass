/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collision;

import Objects.Block;
import Objects.Goal;
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
}
