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
public class Goal extends Rectangle {
    public Goal (int x, int y) {
        setBounds(x, y, 50, 60);
    }
    
     public void tick(){
     
    }
    public Image getGoal(){
          ImageIcon goal = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\goal\\maali.png");
        return goal.getImage();
    }
     
    public void draw (Graphics g) {
         g.drawImage(getGoal(), (int) x, (int) y, null);
    }

}
