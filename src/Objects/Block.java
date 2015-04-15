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
public class Block extends Rectangle {
    
    private int style;
    
    private static final long serialVersionUID = 1L;
    
    public static final int blockSize = 30;
    
    public Block (int x, int y, int style) {
        
        setBounds(x, y, blockSize, blockSize);
        this.style = style;
    }

    public Image getBlockStyle() {
         if(style == 1){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\Keskipala.png");
        return blockStyle.getImage();
        }
         
         else {
        ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\suora.png");
        return blockStyle.getImage();
         }
    
}
    
    public void tick () {
    }
    
  
    public void draw (Graphics g) {
        g.drawImage(getBlockStyle(), (int) x, (int) y, null);
    }
    
}
