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
import static javax.swing.Spring.width;

/**
 *
 * @author Nissinen
 */
public class CannonBallRight extends Rectangle {
    
 
    private int rightBound;
    private int speed = 4;
    private int StartX;
 
    
    public CannonBallRight (int x, int y, int rightBound) {
        setBounds(x, y, 15, 15);
        
 
        this.rightBound = rightBound;
        StartX = x;
    }
    
     public void tick(){
            
            
            if( x + width >= rightBound && speed !=-1 ){
                x = StartX;
            }
            
            x+=speed;
    }
    public Image getMovingCannonBallRight(){
        ImageIcon can = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\CannonBall.png");
        return can.getImage();
    }

    public int getMove(){
        return speed;
    }
    
    public void draw (Graphics g) {
         g.drawImage(getMovingCannonBallRight(), (int) x, (int) y, null);
    }
}
