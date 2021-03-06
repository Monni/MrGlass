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
public class MovingSaw extends Rectangle {
    
    private int leftBound, rightBound;
    private int speed = 2;

    
    public MovingSaw (int x, int y, int leftBound, int rightBound) {
        setBounds(x, y, 70, 30);
        

        this.rightBound = rightBound;
        this.leftBound = leftBound;
    }
    
     public void tick(){
            if (x + width >= rightBound && speed !=-1){
                speed *= -1;
            }
            
            if(x <= leftBound && speed != 1 ){
                speed *= -1;
            }
            
            x+=speed;
    }
    public Image getMovingSawRight(){
          ImageIcon saw = new ImageIcon("src\\resources\\objects\\saw.gif");
        return saw.getImage();
    }
    
    public Image getMovingSawLeft() {
        ImageIcon saw = new ImageIcon("src\\resources\\objects\\sawleft.gif");
        return saw.getImage();
    }
    
    public void draw (Graphics g) {
        if (speed <= 0) {
         g.drawImage(getMovingSawLeft(), (int) x, (int) y, null);
    } else {
            g.drawImage(getMovingSawRight(), (int) x, (int) y, null);
        }
    }
}
