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
public class Saw extends Rectangle {
    public Saw (int x, int y) {
        setBounds(x, y, 70, 30);
    }
    
     public void tick(){
     
    }
    public Image getSaw(){
          ImageIcon saw = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\saw.png");
        return saw.getImage();
    }

    public void draw (Graphics g) {
         g.drawImage(getSaw(), (int) x, (int) y, null);
    }
}