/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Collision.Collision;
import Objects.Block;
import Objects.Goal;
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
        x = 50;
       y = 500;
       this.width = width;
       this.height = height;
    }
    public void tick(Block[] b, Saw[] s, Spike[] p, SpikeTurned[] pT, Goal[] goal) {
        int iX = (int)x;
        int iY = (int)y;
        
        
        for (int i = 0; i < b.length; i++){
            //ground collsion
            // - ja + luvuilla säädetään ettei hahmo uppoa palikkaan
            //right side collision
            // oikea yläkulma
            if (Collision.playerBlock(new Point(iX + width, iY - 1), b[i]) 
                    //oikeia alakulma
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
        for (int j = 0; j < s.length; j++){
            if (Collision.playerSaw(new Point(iX + width-5, iY - 15 ), s[j]) 
                    //oikeia alakulma
                    || Collision.playerSaw(new Point(iX + width-5, iY + height - 15 ), s[j])) {
                
                System.out.println("SAHA RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerSaw(new Point(iX - 10 , iY -15), s[j])         
                    //vasen alakulma
                    || Collision.playerSaw(new Point(iX +3 , iY + height-15 ),s[j])){
                
                System.out.println("SAHA LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
            if(Collision.playerSaw(new Point(iX +5, iY + height-15), s[j])
                    || Collision.playerSaw(new Point ( iX + width -5, iY + height-15 ), s[j])){
                System.out.println("SAHA TOP");// tähän mitä tapahtuu kun pelaaja kuolee
            }
        }
        
        //piikkien collision
        for (int n = 0; n < p.length; n++){
            
            if (Collision.playerSpike(new Point(iX + width-5, iY - 15), p[n]) 
                    //oikeia alakulma
                    || Collision.playerSpike(new Point(iX + width-5, iY + height - 15), p[n])) {
                
                System.out.println("Spike RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
            if(Collision.playerSpike(new Point(iX + 5, iY -15 ), p[n])
                    || Collision.playerSpike(new Point(iX + 3 , iY + height -15),p[n])){
                
                System.out.println("Spike LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
             if(Collision.playerSpike(new Point(iX +8, iY + height), p[n])
                    || Collision.playerSpike(new Point ( iX + width - 15, iY + height ), p[n])){
                System.out.println("Spike TOP");// tähän mitä tapahtuu kun pelaaja kuolee
            }
        }
        
        //käännettyjen piikkien collision
        for (int t = 0; t < pT.length; t++){
            
            if (Collision.playerSpikeTurned(new Point(iX + width-5, iY- 0), pT[t]) 
                    //oikeia alakulma
                    || Collision.playerSpikeTurned(new Point(iX + width-7, iY + height - 0), pT[t])) {
                
                System.out.println("SpikeTurned RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
              }
           
            //left side collision
            if(Collision.playerSpikeTurned(new Point(iX + 5, iY -0 ), pT[t])
                    || Collision.playerSpikeTurned(new Point(iX + 7 , iY + height -0),pT[t])){
                
                System.out.println("SpikeTurned LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
        }
             if(Collision.playerSpikeTurned(new Point(iX +7, iY), pT[t])
                    || Collision.playerSpikeTurned(new Point( iX + width - 7, iY), pT[t])){
                 System.out.println("SpikeTurned BOT");// tähän mitä tapahtuu kun pelaaja kuolee
             }
        }
        
        //maalin collision
        for (int h = 0; h < goal.length; h++){
            
            if (Collision.playerGoal(new Point(iX + width-10, iY- 15), goal[h])){ 
                    
                
                System.out.println("Maali RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
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
       // If moving or last moved to right
       if(lastRight) {
        g.drawImage(getPlayerImgRight(),(int) x,(int) y, null);
       }
       
       // If moving or last moved to left
       else if (lastLeft) {
        g.drawImage(getPlayerImgLeft(), (int) x, (int) y, null);
       }
       
    }
    
    public Image getPlayerImgRight(){
          ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman_right.png");
        return ic.getImage();
    }
    
    public Image getPlayerImgLeft() {
        ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\glassman\\glassman_left.png");
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
