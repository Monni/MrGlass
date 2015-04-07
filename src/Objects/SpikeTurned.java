/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class SpikeTurned extends Rectangle {
    public SpikeTurned (int x, int y) {
        setBounds(x, y, 40, 30);
    }
    
     public void tick(){
     
    }
    public Image getSpikeTurned(){
          ImageIcon spikeTurned = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\spikeTurned.png");
        return spikeTurned.getImage();
    }

    public void draw (Graphics g) {
         g.drawImage(getSpikeTurned(), (int) x, (int) y, null);
    }
}