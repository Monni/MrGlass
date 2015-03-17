/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import Entities.Player;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



/**
 *
 * @author h4211
 */
public class Sprites {

    
    BufferedImage cropImage;
    BufferedImage img;
    private int x,y,width,height;
    public static BufferedImage glassRight;


public Sprites(){
        try {
            this.img = ImageIO.read(new File("src\\resources\\glassman\\glassman_sheet.png"));
        } catch (IOException ex) {
            Logger.getLogger(Sprites.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        this.glassRight = cropImage(img,0,0,20,39);

 
     
        
    
}

     
        
    
    private BufferedImage cropImage(BufferedImage img,int x,int y,int  width,int height)
    {
        
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        return this.img;
        
        
    }
   
}


