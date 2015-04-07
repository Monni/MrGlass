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
public class Spike extends Rectangle {
    public Spike (int x, int y) {
        setBounds(x, y, 40, 30);
    }
    
     public void tick(){
     
    }
    public Image getSpike(){
          ImageIcon spike = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\spike.png");
        return spike.getImage();
    }

    public void draw (Graphics g) {
         g.drawImage(getSpike(), (int) x, (int) y, null);
    }
}