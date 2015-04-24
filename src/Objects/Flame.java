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
public class Flame extends Rectangle {
    
    private int suunta;
    private int flamecounter = 0;
    
    public Flame (int x, int y, int suunta) {
        setBounds(x, y, 60, 32);
        
        this.suunta = suunta;
    }
    
     public void tick(){
         flamecounter++;
         if ( flamecounter > 360 ) {
             flamecounter = 0;
         }
     
    }
    public Image getFlame(){
        
        // oikealle
        if(suunta == 1) {
          ImageIcon flame = new ImageIcon("src\\resources\\objects\\levelflameright.gif");
        return flame.getImage();
        }
        // vasemmalle
        else {
                      ImageIcon flame = new ImageIcon("src\\resources\\objects\\levelflameleft.gif");
        return flame.getImage();
        }
    }

    public void draw (Graphics g) {
       if ( flamecounter < 180 ) {
         g.drawImage(getFlame(), (int) x, (int) y, null);
        }
    }
    
    public int getFlameCounter() {
        return flamecounter;
    }
}