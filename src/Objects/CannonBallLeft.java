/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.Spring.width;

/**
 *
 * @author Nissinen
 */
public class CannonBallLeft extends Rectangle {
    
  
    private int Bound;
    private int speed = 4;
    private int StartX;
    private int suunta;
    
    public CannonBallLeft (int x, int y, int Bound, int suunta) {
        setBounds(x, y, 15, 15);
        
       
        this.Bound = Bound;
        this.suunta = suunta;
        StartX = x;
    }
    
     public void tick(){
         // vasen
            if (suunta == 0 ){
            x-=speed;
            }
         //oikea
            if (suunta == 1){
                x+=speed;
            }
    
            if(x <= Bound && suunta == 0 ){
                x = StartX;
            }
            
            if(x >= Bound + width && suunta == 1){
                x = StartX;
            }
            
            
    }
    public Image getMovingCannonBall(){
        ImageIcon can = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\CannonBall.png");
        return can.getImage();
    }
    
    public void draw (Graphics g) {
         g.drawImage(getMovingCannonBall(), (int) x, (int) y, null);
    }
}