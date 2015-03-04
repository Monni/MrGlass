/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Collision.Collision;
import Game.GamePanel;
import Objects.Block;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Player {
    
       private double moveSpeed = 2.5;
    
    //bounds
   private double x, y;
   private int width, height;
    
    //jumpSpeed
    private double jumpSpeed = 5;
    private double currentJumpSpeed = jumpSpeed;
    
    //fallSpeed
    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;
   
    //movement
    private boolean right = false, left = false, jumping = false, falling = false;
    private boolean topCollision = false;
    
    public Player( int width, int height) {
        x = GamePanel.WIDTH / 2;
       y = GamePanel.HEIGHT / 2;
       this.width = width;
       this.height = height;
    }
    public void tick(Block[] b) {
        int iX = (int)x;
        int iY = (int)y;
        
        
        for (int i = 0; i < b.length; i++){
            // - ja + luvuilla säädetään ettei hahmo uppoa palikkaan
            //right collision
            if (Collision.playerBlock(new Point(iX + width, iY + 2), b[i]) 
                    || Collision.playerBlock(new Point(iX + width, iY + height - 1), b[i])) {
                right = false;
              }
           
            //left collision
            if(Collision.playerBlock(new Point(iX - 1, iY + 2), b[i])
                    || Collision.playerBlock(new Point(iX - 1 , iY + height -1),b[i])){
                left = false;
            }
            // top collision
            if(Collision.playerBlock(new Point(iX + 1, iY), b[i])
                    || Collision.playerBlock(new Point( iX + width - 1, iY), b[i])){
            falling = true;
            jumping = false;
            }
            // bottom collision
            if(Collision.playerBlock(new Point(iX + 2, iY + height +1), b[i])
                    || Collision.playerBlock(new Point ( iX + width - 1, iY + height + 1 ), b[i])){
                 y = b[i].getY() - height;
                falling = false;
                topCollision = true;
            } else {
                if (!topCollision && !jumping) {
                falling = true;
              }
            }
            
        }
        
        topCollision = false;
        
        if ( right) {
            x += moveSpeed;
        }
        if(left) {
            x -= moveSpeed;
        }
        if (jumping){
            y -= currentJumpSpeed;
            
            currentJumpSpeed -= .1;
            
            if(currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                jumping= false;
                falling= true;
                }
           }
        if(falling){
            y += currentFallSpeed;
            
            if(currentFallSpeed < maxFallSpeed){
                currentFallSpeed += .1;
               }
            }
         if(!falling) {
            currentFallSpeed = .1;
        }
        }
    
    
    public void draw(Graphics g) {
       
       g.drawImage(getPlayerImg(),(int) x,(int) y, null);
        
    }
    
    public Image getPlayerImg(){
          ImageIcon ic = new ImageIcon("C:\\Users\\Nissinen\\Desktop\\Pixel Art\\Tasohyppely\\Glassman.png"); // "src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman_right.png"
        return ic.getImage();
    }
    
    public void keyPressed(int k) {
        if ( k == KeyEvent.VK_RIGHT) right = true;
        if ( k == KeyEvent.VK_LEFT) left = true;
        if ( k == KeyEvent.VK_SPACE && !jumping && !falling) jumping = true;
    }
    
    public void keyReleased(int k) {
        if ( k == KeyEvent.VK_RIGHT) right = false;
        if ( k == KeyEvent.VK_LEFT) left = false;
    }
    
}
