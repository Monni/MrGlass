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
import javax.swing.Timer;

/**
 *
 * @author Nissinen
 */
public class Player extends Entity {
    
      // Pysähtyessä hahmo jää osoittamaan viimeksi liikuttuun suuntaan
      boolean lastLeft;
      boolean lastRight = true;
    
      boolean isJumping = false;
      double t0;
      float y0;
      float speed0;
      double speed0y;
      
    
    //pelaajan x ja y akseli
    double velX = 0;
    double velY = 0;
    double speed = 2;
    double speedJump = -8;
    
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
        
        // Liikkuessa vasemmalle, kuva mrglass_left
        if (velX <= 0 && lastLeft) {
            g2d.drawImage(getPlayerImgLeft(), x, y, null);
        }
        // Liikkuessa oikealle, kuva mrglass_right
        else if (velX >= 0 && lastRight) {
        g2d.drawImage(getPlayerImgRight(), x, y, null);
        }
        /*tekee rajat testaukseen
        g2d.draw (getBounds());
                //*/
    }
    
    
    // hakee iconin kyseisellä metodilla
    public Image getPlayerImgRight(){
          ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman_right.png");
        return ic.getImage();
    }
    
    public Image getPlayerImgLeft() {
        ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman_left.png");
        return ic.getImage();
    }
    
    
    
    //mitä tapahtuu kun nappulaa painetaan
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
            
          
        if (key == KeyEvent.VK_LEFT){
            
            if (velX == 0) {
                velX = -0.1;
                                lastLeft = true;
                lastRight = false;
                
                
                
            }   
            //määrää nopeuden
            
                if (-velX < speed) {
                    velX = velX * speed;
                }
                else {
                    velX = -speed;
                }
          
               
            }

            else if (key == KeyEvent.VK_RIGHT){
                velX = speed;
                                lastLeft = false;
                lastRight = true;
                
       }
            
            
            
            
            else if (key == KeyEvent.VK_UP) {
                
                if (!isJumping) {
                t0 = System.currentTimeMillis() / 1000;
                velY = speedJump;
                isJumping = true;
                }
               
                
                /*if (!isJumping) // Hyppää vain jos ei jo hyppäämässä
                {
                    t0 = System.currentTimeMillis();
                    speed0 = (float) speed;
                    y0 = y;
                    speed0y -= speedJump;
                    
                     isJumping = true;
                }
            
            if (isJumping) {
                double t1 = System.currentTimeMillis();
                double tjump = (t1 - t0) / 1000;
                
                if (tjump <= 1) {
                velY = speed0y+tjump;
                }
                System.out.println(tjump);
                }
            */    
            
            }
            //else if (key == KeyEvent.VK_UP){
           //     velY = -speed;
           // }
            
            
            
            
            
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
                double t1 = System.currentTimeMillis() / 1000;
                double tjump = (t1 - t0) / 1000;
                
                do {
                    double t2 = System.currentTimeMillis() / 1000;
                    velY = (speedJump - tjump) + 9.82 * (t2 - t1); 
                    update();
                    System.out.println(t2 / 1000);
                    System.out.println(t1 / 1000);
                    System.out.println(velY);
                    System.out.println("");
                } while (velY < 5);
                if (velY > 5)
                    velY = 5;
                
              
                isJumping = false;
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
                return new Rectangle(x,y, getPlayerImgRight().getWidth(null), getPlayerImgRight().getHeight(null));
            }              
}


