/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.fi.MrGlass;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Spikes extends Entity {

    public Spikes(int x, int y) {
        super(x, y);
    }
    public void update() {
        
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getSpikesImg(), x, y, null);
        
        /* testaa tällä osuvatko collision rajat testauksessa
        g2d.draw (getBounds());
        */
    }
        // hakee iconin kyseisellä metodilla
    public Image getSpikesImg(){
          ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\objects\\spike.png");
        return ic.getImage();
    }
    public Rectangle getBounds() {
                return new Rectangle(x,y, getSpikesImg().getWidth(null), getSpikesImg().getHeight(null));
            }
}
