/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.fi.MrGlass;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Player extends Entity {
    
    //pelaajan x ja y akseli
    double velX = 0;
    double velY = 0;
    double speed = 2;
    
    public Player ( int x , int y) {
        super(x, y);
        
    }
    //päivittää x ja y coordinaatit
    public void update () {
        x = (int) (x + velX);
        y = (int) (y + velY);
        
        checkCollision();
    }
    public void draw(Graphics2D g2d) {
        g2d.drawImage(getPlayerImg(), x, y, null);
        /*tekee rajat testaukseen
        g2d.draw (getBounds());
                //*/
    }
    
    // hakee iconin kyseisellä metodilla
    public Image getPlayerImg(){
          ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman.png");
        return ic.getImage();
    }
    
    
    //mitä tapahtuu kun nappulaa painetaan
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
            
          
        if (key == KeyEvent.VK_LEFT){
                //märää nopeuden
                if (-velX < speed) {
                    velX =- speed + velX * 0.1;
                }
                else {
                    velX = -speed;
                }
               
            }

            else if (key == KeyEvent.VK_RIGHT){
                velX = speed;
       }
            else if (key == KeyEvent.VK_UP){
                velY = -speed;
            }
            else if (key == KeyEvent.VK_DOWN){
                velY = speed;
            }
    }
   
    //mitä tapahtuu kun nappula vapautetaan
    public void keyReleased(KeyEvent e) {
      int key = e.getKeyCode();
            
            if (key == KeyEvent.VK_LEFT){
                
                //määrää uuden nopeuden
                
                velX = 0;
            }
            else if (key == KeyEvent.VK_RIGHT){
                velX = 0;
       }
            else if (key == KeyEvent.VK_DOWN){
                velY = 0;
            }
            else if (key == KeyEvent.VK_UP) {
                velY = 0;
            }
    }
            public void checkCollision(){
               ArrayList<Spikes> piikit = GameFrame.getSpikesList();
               
               for (int i = 0; i < piikit.size(); i++) {
                Spikes tempSpikes = piikit.get(i);
                if (getBounds().intersects(tempSpikes.getBounds())){
                    System.exit(0);                   
                }
            }
                   ArrayList<Saw> sirkkelit = GameFrame.getSawList();
               
               for (int j = 0; j < sirkkelit.size(); j++) {
                Saw tempSaw = sirkkelit.get(j);
                if (getBounds().intersects(tempSaw.getBounds())){
                    System.exit(0);
                }
          }
                
        }
            public Rectangle getBounds() {
                return new Rectangle(x,y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
            }
}


