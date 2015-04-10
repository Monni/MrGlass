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
public class CannonBallLeft extends Rectangle {
    
 
    private int leftBound;
    private int speed = 4;
    private int StartX;
 
    
    public CannonBallLeft (int x, int y, int leftBound) {
        setBounds(x, y, 15, 15);
        
        this.leftBound = leftBound;
        StartX = x;
    }
    
     public void tick(){
            
            
            if(x <= leftBound ){
                x = StartX;
            }
            
            x-=speed;
    }
    public Image getMovingSaw(){
          ImageIcon saw = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\CannonBall.png");
        return saw.getImage();
    }

    public int getMove(){
        return speed;
    }
    
    public void draw (Graphics g) {
         g.drawImage(getMovingSaw(), (int) x, (int) y, null);
    }
}
