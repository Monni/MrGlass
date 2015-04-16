/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Collision.Collision;
import Objects.Block;
import Objects.Cannon;
import Objects.CannonBallLeft;
import Objects.Goal;
import Objects.MovingSaw;
import Objects.Saw;
import Objects.Spike;
import Objects.SpikeTurned;
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
    private double jumpSpeed = 4;
    private double currentJumpSpeed = jumpSpeed;
    
    //fallSpeed
    private double maxFallSpeed = 5;
    private double currentFallSpeed = 0.1;
   
    //movement
    private boolean right = false, left = false, jumping = false, falling = false;
    private boolean topCollision = false;
    
    // Last moved
    private boolean lastLeft = false;
    private boolean lastRight = true;
    
    public Player( int width, int height) {
        x = 550;
       y = 50;
       this.width = width;
       this.height = height;
    }
    public void tick(Block[] b, Saw[] s, Spike[] p, SpikeTurned[] pT, Goal[] goal, MovingSaw[] ms, Cannon[] c, CannonBallLeft[] cbl) {
        int iX = (int)x;
        int iY = (int)y;
        
        
        for (int i = 0; i < b.length; i++){
            //ground collision

            if (Collision.playerBlock(new Point(iX + width, iY - 1), b[i]) 
                    
                    || Collision.playerBlock(new Point(iX + width, iY + height - 2), b[i])) {
                right = false;
                System.out.println("RIGHTII");
              }
           
            //left side collision
            if(Collision.playerBlock(new Point(iX - 1, iY + 2), b[i])
                    || Collision.playerBlock(new Point(iX - 1 , iY + height -2),b[i])){
                left = false;
                System.out.println("LEFTII");
            }
            // Pohja
            if(Collision.playerBlock(new Point(iX + 1, iY), b[i])
                    || Collision.playerBlock(new Point( iX + width - 1, iY), b[i])){
            falling = true;
            jumping = false;
            }
            // kävelypinta / top
            if(Collision.playerBlock(new Point(iX + 1, iY + height +2), b[i])
                    || Collision.playerBlock(new Point ( iX + width - 1, iY + height + 2 ), b[i])){
                 y = b[i].getY() - height;
                falling = false;
                topCollision = true;
            } else {
                if (!topCollision && !jumping) {
                falling = true;
                  }
              }    
            }
        
        // sahojen collision
        for (int i = 0; i < s.length; i++){
            if (Collision.playerSaw(new Point(iX + width-5, iY - 15 ), s[i]) 
                    //oikeia alakulma
                    || Collision.playerSaw(new Point(iX + width-5, iY + height - 15 ), s[i])) {
                
                System.out.println("SAHA RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerSaw(new Point(iX - 10 , iY -15), s[i])         
                    //vasen alakulma
                    || Collision.playerSaw(new Point(iX +3 , iY + height-15 ),s[i])){
                
                System.out.println("SAHA LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
            if(Collision.playerSaw(new Point(iX +5, iY + height-15), s[i])
                    || Collision.playerSaw(new Point ( iX + width -5, iY + height-15 ), s[i])){
                System.out.println("SAHA TOP");// tähän mitä tapahtuu kun pelaaja kuolee
            }
        }
        
        //liikkuvien sahojen collision
         for (int i = 0; i < ms.length; i++){
            if (Collision.playerMovingSaw(new Point(iX + width-5, iY - 15 ), ms[i]) 
                    //oikeia alakulma
                    || Collision.playerMovingSaw(new Point(iX + width-5, iY + height - 15 ), ms[i])) {
                
                System.out.println("LIIKKUVASAHA RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerMovingSaw(new Point(iX - 10 , iY -15), ms[i])         
                    //vasen alakulma
                    || Collision.playerMovingSaw(new Point(iX +3 , iY + height-15 ),ms[i])){
                
                System.out.println("LIIKKUVASAHA LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
            if(Collision.playerMovingSaw(new Point(iX +5, iY + height-15), ms[i])
                    || Collision.playerMovingSaw(new Point ( iX + width -5, iY + height-15 ), ms[i])){
                System.out.println("LIIKKUVASAHA TOP");// tähän mitä tapahtuu kun pelaaja kuolee
            }
        }
        
        //piikkien collision
        for (int i = 0; i < p.length; i++){
            
            if (Collision.playerSpike(new Point(iX + width-5, iY - 15), p[i]) 
                    //oikeia alakulma
                    || Collision.playerSpike(new Point(iX + width-5, iY + height - 15), p[i])) {
                
                System.out.println("Spike RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
            if(Collision.playerSpike(new Point(iX + 5, iY -15 ), p[i])
                    || Collision.playerSpike(new Point(iX + 3 , iY + height -15),p[i])){
                
                System.out.println("Spike LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
             if(Collision.playerSpike(new Point(iX +8, iY + height), p[i])
                    || Collision.playerSpike(new Point ( iX + width - 15, iY + height ), p[i])){
                System.out.println("Spike TOP");// tähän mitä tapahtuu kun pelaaja kuolee
            }
        }
        
        //käännettyjen piikkien collision
        for (int i = 0; i < pT.length; i++){
            
            if (Collision.playerSpikeTurned(new Point(iX + width-5, iY- 0), pT[i]) 
                    //oikeia alakulma
                    || Collision.playerSpikeTurned(new Point(iX + width-7, iY + height - 0), pT[i])) {
                
                System.out.println("SpikeTurned RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
            if(Collision.playerSpikeTurned(new Point(iX + 5, iY -0 ), pT[i])
                    || Collision.playerSpikeTurned(new Point(iX + 7 , iY + height -0),pT[i])){
                
                System.out.println("SpikeTurned LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
             if(Collision.playerSpikeTurned(new Point(iX +7, iY), pT[i])
                    || Collision.playerSpikeTurned(new Point( iX + width - 7, iY), pT[i])){
                 System.out.println("SpikeTurned BOT");// tähän mitä tapahtuu kun pelaaja kuolee
             }
        }
        
        //maalin collision
        for (int i = 0; i < goal.length; i++){
            
            if (Collision.playerGoal(new Point(iX + width-10, iY- 15), goal[i])){ 
                    
                
                System.out.println("Maali RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
        }
        //CANNON COLLISION
         for (int i = 0; i < c.length; i++){

            if (Collision.playerCannon(new Point(iX + width, iY - 1), c[i]) 
                    //oikeia alakulma
                    || Collision.playerCannon(new Point(iX + width, iY + height - 2), c[i])) {
                right = false;
                System.out.println("CannonRIGHTII");
              }
           
            //left side collision
            if(Collision.playerCannon(new Point(iX - 1, iY + 2), c[i])
                    || Collision.playerCannon(new Point(iX - 1 , iY + height -2),c[i])){
                left = false;
                System.out.println("CannonLEFTII");
            }
            // kävelypinta / top
            if(Collision.playerCannon(new Point(iX + 1, iY + height +2), c[i])
                    || Collision.playerCannon(new Point ( iX + width - 1, iY + height + 2 ), c[i])){
                 y = c[i].getY() - height;
                falling = false;
                topCollision = true;
            } else {
                if (!topCollision && !jumping) {
                falling = true;
                  }
              }    
            }
         
         //CANNONBALLLEFT COLLISION
         for (int i = 0; i < cbl.length; i++){

             if (Collision.playerCannonBallLeft(new Point(iX + width - 15, iY + 25), cbl[i]))
                     {
                System.out.println("CANNONBALL RIGHT");
             }
             
            //left side collision
            if(Collision.playerCannonBallLeft(new Point(iX+ 15 , iY ), cbl[i])
                    || Collision.playerCannonBallLeft(new Point(iX +15 , iY + height - 0 ),cbl[i]))
                    {
                System.out.println("CANNONBALL LEFT");
            }
        }
        
        topCollision = false;
        
        if (right) {
            x += moveSpeed;
            lastRight = true;
            lastLeft = false;
        }
        if(left) {
            x -= moveSpeed;
            lastRight = false;
            lastLeft = true;
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
       // If last moved to right
       if(lastRight && right == false) {
        g.drawImage(getPlayerImgRight(),(int) x,(int) y, null);
       }
       // If moving to right
       else if ( right == true ) {
           g.drawImage(getPlayerImgRightRunning(), (int) x, (int) y, null);
       }
       // If last moved to left
       else if (lastLeft && left == false) {
        g.drawImage(getPlayerImgLeft(), (int) x, (int) y, null);
       }
       // If moving to left
       else if ( left == true ) {
           g.drawImage(getPlayerImgLeftRunning(), (int) x, (int) y, null);
       }
       
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
    
        public Image getPlayerImgRight(){
          ImageIcon ic = new ImageIcon("src\\resources\\glassman\\glassman_right.gif");
        return ic.getImage();
    }
    
    public Image getPlayerImgLeft() {
        ImageIcon ic = new ImageIcon("src\\resources\\glassman\\glassman_left.gif");
        return ic.getImage();
    }
    
    public Image getPlayerImgRightRunning() {
        ImageIcon ic = new ImageIcon("src\\resources\\glassman\\glassman_right_running.gif");
        return ic.getImage();
    }
    
    public Image getPlayerImgLeftRunning() {
        ImageIcon ic = new ImageIcon("src\\resources\\glassman\\glassman_left_running.gif");
        return ic.getImage();
    }
    
}
