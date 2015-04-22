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
    
    public Flame (int x, int y, int suunta) {
        setBounds(x, y, 60, 32);
        
        this.suunta = suunta;
    }
    
     public void tick(){
     
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
         g.drawImage(getFlame(), (int) x, (int) y, null);
    }
}