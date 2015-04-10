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
public class Cannon extends Rectangle {
    
   public Cannon (int x, int y) {
        setBounds(x, y, 35, 25);
    }
    
     public void tick(){
     
    }
    public Image getSaw(){
          ImageIcon saw = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\Cannon.png");
        return saw.getImage();
    }

    public void draw (Graphics g) {
         g.drawImage(getSaw(), (int) x, (int) y, null);
    }
}