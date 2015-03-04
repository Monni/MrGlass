/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;


import Entities.Player;
import Objects.Block;
import java.awt.Graphics;

/**
 *
 * @author Nissinen
 */
public class Level1State extends GameState {

    private Player player;
    
    private Block[] b;
    
    
    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(20,39);
        
        b = new Block[21];
        
        b[0] = new Block (570, 380);
        b[1] = new Block (540, 380);
        b[2] = new Block (600, 380);
        b[3] = new Block (630, 380);
        b[4] = new Block (660, 380);
        b[5] = new Block (690, 380);
        b[6] = new Block (720, 380);
        b[7] = new Block (720, 350);
        b[8] = new Block (720, 320);
        b[9] = new Block (750, 350);
        b[10] = new Block (780, 380);
        b[11] = new Block (810, 410);
        b[12] = new Block (840, 440);
        b[13] = new Block (870, 410);
        b[14] = new Block (900, 380);
        b[15] = new Block (1000, 380);
        b[16] = new Block (1050, 300);
        b[17] = new Block (1100, 220);
        b[18] = new Block (1000, 100);
        b[19] = new Block (400, 380);
        b[20] = new Block (200, 380);
        
    }

    public void tick() {
        
        for ( int i = 0; i<b.length; i++) {
            b[i].tick();
        }
        
      player.tick(b);
    }

    public void draw(Graphics g) {
      player.draw(g);  
    
      for ( int i = 0; i < b.length; i++) {
          b[i].draw(g);
      }
    }

    public void keyPressed(int k) {
     player.keyPressed(k);
    }

    public void keyReleased(int k) {
       player.keyReleased(k);
    }
    
    
    
}
