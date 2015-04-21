package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Cannon extends Rectangle {
    
    private int suunta;
     
   public Cannon (int x, int y, int suunta) {
       
        setBounds(x, y, 35, 25);
        this.suunta = suunta;
    }
    
     public void tick(){
     
    }
    public Image getCannon(){
        
        //cannon vasemmalle
        if(suunta == 1){
        ImageIcon cannonStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\CannonOikea.png");
        return cannonStyle.getImage();
        }
         
        //cannon oikealle
        else{
        ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\Cannon.png");
        return blockStyle.getImage();
        }
    }

    public void draw (Graphics g) {
         g.drawImage(getCannon(), (int) x, (int) y, null);
    }
}