/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import GameState.GameState;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Nissinen
 */
public class Block extends Rectangle {
    
    private static final long serialVersionUID = 1L;
    
    public static final int blockSize = 30;
    
    public Block (int x, int y) {
        setBounds(x, y, blockSize, blockSize);
    }
    
    public void tick(){
     
    }
    
    public void draw (Graphics g) {
        g.fillRect (x , y , width, height);
    }
    
}
