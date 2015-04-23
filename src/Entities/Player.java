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
import Objects.Flame;
import Objects.Goal;
import Objects.MovingSaw;
import Objects.Saw;
import Objects.Spike;
import Objects.SpikeTurned;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Nissinen
 */
public class Player extends Applet {

    
    
    FileWriter fw = null;
    FileReader fr = null;
    BufferedWriter bw;
    BufferedReader br;
 
    private MediaTracker mt = new MediaTracker(this);
    private boolean mediachecked = false;
    
    private final Image rightImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassman_right.gif");
    private final Image leftImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassman_left.gif");
    private final Image rightrunningImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassman_right_running.gif");
    private final Image leftrunningImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassman_left_running.gif");
    private final Image rightshatteredImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassmanright_shattered.gif");
    private final Image leftshatteredImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\glassman\\glassmanleft_shattered.gif");
    
    
       
      private final double moveSpeed = 2.5;
      
    // if killed
       private boolean shattered = false;
       private int shatteredtimer = 0;
       private int retryselector = 0;
       private boolean rightshattered;
       private boolean leftshattered;
       
       // Score
       private int startscore;
       private int scoretimer;
       private int currentscore;
       private boolean finished = false;
       
       // Score written
       private boolean scorewritten = false;
       private boolean scoreread = false;
    
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
    
    public Player( int width, int height, int x, int y) {
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
    }
    public void tick(Block[] b, Saw[] s, Spike[] p, SpikeTurned[] pT, Goal[] goal, MovingSaw[] ms, Cannon[] c, CannonBallLeft[] cbl, Flame [] f) {
        int iX = (int)x;
        int iY = (int)y;
        
       
        
        if ( scoreread == false ) {
        try {
        fr = new FileReader("scorecounter.txt");
        br = new BufferedReader(fr);
        startscore = Integer.parseInt(br.readLine());
        br.close();
        } catch (Exception e) {
            System.out.println("Fatal error reading scorefile!");
        }
        scoreread = true;
        }
        
 
         System.out.println(currentscore);

       
        scoretimer++;
        
        //tippuminen rotkoon
        if(y >= 1000){
            shattered = true;
        }
        
        for (int i = 0; i < b.length; i++){
            //ground collision
if ( shattered == false) {
            if (Collision.playerBlock(new Point(iX + width, iY + 2), b[i]) 
                    
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
            if(Collision.playerBlock(new Point(iX + 1, iY - 2), b[i])
                    || Collision.playerBlock(new Point( iX + width - 1, iY - 2), b[i])){
                currentJumpSpeed = 0.3;
            falling = true;
            
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
            }

        /***************************
         * 
        ** Object collision
        * 
        ****************************/
        
        // sahojen collision
        for (int i = 0; i < s.length; i++){
            if (Collision.playerSaw(new Point(iX + width-5, iY - 15 ), s[i]) 
                    //oikeia alakulma
                    || Collision.playerSaw(new Point(iX + width-5, iY + height - 15 ), s[i])) {
                
                System.out.println("SAHA RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerSaw(new Point(iX - 10 , iY -15), s[i])         
                    //vasen alakulma
                    || Collision.playerSaw(new Point(iX +3 , iY + height-15 ),s[i])){
                
                System.out.println("SAHA LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
        }
            if(Collision.playerSaw(new Point(iX +5, iY + height-15), s[i])
                    || Collision.playerSaw(new Point ( iX + width -5, iY + height-15 ), s[i])){
                System.out.println("SAHA TOP");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
            }
        }
        
        //liikkuvien sahojen collision
         for (int i = 0; i < ms.length; i++){
            if (Collision.playerMovingSaw(new Point(iX + width-5, iY - 15 ), ms[i]) 
                    //oikeia alakulma
                    || Collision.playerMovingSaw(new Point(iX + width-5, iY + height - 15 ), ms[i])) {
                
                System.out.println("LIIKKUVASAHA RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerMovingSaw(new Point(iX - 10 , iY -15), ms[i])         
                    //vasen alakulma
                    || Collision.playerMovingSaw(new Point(iX +3 , iY + height-15 ),ms[i])){
                
                System.out.println("LIIKKUVASAHA LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
        }
            if(Collision.playerMovingSaw(new Point(iX +5, iY + height-15), ms[i])
                    || Collision.playerMovingSaw(new Point ( iX + width -5, iY + height-15 ), ms[i])){
                System.out.println("LIIKKUVASAHA TOP");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
            }
        }
        
        //piikkien collision
        for (int i = 0; i < p.length; i++){
            
            if (Collision.playerSpike(new Point(iX + width-5, iY - 15), p[i]) 
                    //oikeia alakulma
                    || Collision.playerSpike(new Point(iX + width-5, iY + height - 15), p[i])) {
                
                System.out.println("Spike RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
              }
           
            //left side collision
            if(Collision.playerSpike(new Point(iX + 5, iY -15 ), p[i])
                    || Collision.playerSpike(new Point(iX + 3 , iY + height -15),p[i])){
                
                System.out.println("Spike LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
        }
             if(Collision.playerSpike(new Point(iX +8, iY + height), p[i])
                    || Collision.playerSpike(new Point ( iX + width - 15, iY + height ), p[i])){
                System.out.println("Spike TOP");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
            }
        }
        
        //käännettyjen piikkien collision
        for (int i = 0; i < pT.length; i++){
            
            if (Collision.playerSpikeTurned(new Point(iX + width-5, iY- 0), pT[i]) 
                    //oikeia alakulma
                    || Collision.playerSpikeTurned(new Point(iX + width-7, iY + height - 0), pT[i])) {
                
                System.out.println("SpikeTurned RIGHTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
              }
           
            //left side collision
            if(Collision.playerSpikeTurned(new Point(iX + 5, iY -0 ), pT[i])
                    || Collision.playerSpikeTurned(new Point(iX + 7 , iY + height -0),pT[i])){
                
                System.out.println("SpikeTurned LEFTII");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                shattered = true;
        }
             if(Collision.playerSpikeTurned(new Point(iX +7, iY), pT[i])
                    || Collision.playerSpikeTurned(new Point( iX + width - 7, iY), pT[i])){
                 System.out.println("SpikeTurned BOT");// tähän mitä tapahtuu kun pelaaja kuolee
                 jumping = true;
                 shattered = true;
             }
        }
        
        //maalin collision
        for (int i = 0; i < goal.length; i++){
            
            if (Collision.playerGoal(new Point(iX + width-10, iY- 15), goal[i])){ 
                    
                
                System.out.println("Maali RIGHTII");// tähän mitä tapahtuu kun pelaaja pääsee maaliin
                finished = true;
                
                    if ( finished && scorewritten == false ) {                     // Pisteiden kirjoitus filuun kun maalissa
                        try {
                            fw = new FileWriter("scorecounter.txt");
                            bw = new BufferedWriter(fw);
                            bw.write(String.valueOf(currentscore));
                            bw.newLine();
                            bw.close();
                        } catch(Exception e){
                            System.out.println("Fatal error writing scorefile!");
                        }
                            scorewritten = true;
                    }
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
                jumping = true;
                shattered = true;
                
             }
             
            //left side collision
            if(Collision.playerCannonBallLeft(new Point(iX+ 15 , iY ), cbl[i])
                    || Collision.playerCannonBallLeft(new Point(iX +15 , iY + height - 0 ),cbl[i]))
                    {
                System.out.println("CANNONBALL LEFT");
                jumping = true;
                shattered = true;
            }
        }
         // FLAME COLLISION
         for (int i = 0; i < f.length; i++){
            if (Collision.playerFlame(new Point(iX + width-5, iY - 15 ), f[i]) 
                    //oikeia alakulma
                    || Collision.playerFlame(new Point(iX + width-5, iY + height - 15 ), f[i])) {
                
                System.out.println("FLAME");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
               // shattered = true;
              }
           
            //left side collision
       //     vasen yläkulma
            if(Collision.playerFlame(new Point(iX - 10 , iY -15), f[i])         
                    //vasen alakulma
                    || Collision.playerFlame(new Point(iX +3 , iY + height-15 ),f[i])){
                
                System.out.println("FLAME");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
               // shattered = true;
        }
            if(Collision.playerFlame(new Point(iX +5, iY + height-15), f[i])
                    || Collision.playerFlame(new Point ( iX + width -5, iY + height-15 ), f[i])){
                System.out.println("FLAMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");// tähän mitä tapahtuu kun pelaaja kuolee
                jumping = true;
                //shattered = true;
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
        if ( mediachecked == false )    MediaTracker();
       // If last moved to right
       if(lastRight && right == false && shattered == false ) {
        g.drawImage(rightImg,(int) x,(int) y, null);
       }
       // If moving to right
       else if ( right == true && shattered == false ) {
           g.drawImage(rightrunningImg, (int) x, (int) y, null);
       }
       // If last moved to left
       else if (lastLeft && left == false && shattered == false ) {
        g.drawImage(leftImg, (int) x, (int) y, null);
       }
       // If moving to left
       else if ( left == true && shattered == false ) {
           g.drawImage(leftrunningImg, (int) x, (int) y, null);
       }
       // If last moved to right and shattered
       else if ( lastRight && shattered && leftshattered == false ) {
           rightshattered = true;
           g.drawImage(rightshatteredImg, (int) x -4, (int) y, null);
       }
       // If last moved to left and shattered
       else if ( lastLeft && shattered && rightshattered == false ) {
           leftshattered = true;
           g.drawImage(leftshatteredImg, (int) x -4, (int) y, null);
       }
    }
    
    
    public void keyPressed(int k) {
        if ( k == KeyEvent.VK_RIGHT) {
            right = true;
            if ( retryselector == 1 ) retryselector = 0;
            else    retryselector = 1;
        }
        if ( k == KeyEvent.VK_LEFT) {
            left = true;
            if (retryselector == 0) retryselector = 1;
            else    retryselector = 0;
        }
        if ( k == KeyEvent.VK_SPACE && !jumping && !falling) jumping = true;
        
        if ( k == KeyEvent.VK_ENTER && shattered ) {
            if ( retryselector == 0 ) {
                rightshatteredImg.flush();      // Nollaa Playerin hajoamisanimaation
                leftshatteredImg.flush();
            } else {
                rightshatteredImg.flush();      // Nollaa Playerin hajoamisanimaation
                leftshatteredImg.flush();
            }
        }
    }
    
    public void keyReleased(int k) {
        if ( k == KeyEvent.VK_RIGHT) right = false;
        if ( k == KeyEvent.VK_LEFT) left = false;
    }
    
    
    public boolean getShatteredBoolean() {
        return shattered;
    }
    
    public boolean getFinishedBoolean() {
        return finished;
    }
    
    public int getRetrySelector() {
        return retryselector;
    }
    
    public int getCurrentScore() {
        if ( shattered == false && finished == false ) {
            currentscore = startscore - (scoretimer / 10);
        } else if ( shattered == false && finished ) {
           // currentscore = currentscore;
        } else {
            currentscore = 0;
        }
        return currentscore;
    }
    
    public int getCurrentX() {
        return (int) x;
    }
 
    public void MediaTracker() {
         
        mt.addImage(rightImg, 0);
        mt.addImage(leftImg, 1);
        mt.addImage(rightrunningImg, 2);
        mt.addImage(leftrunningImg, 3);
        mt.addImage(rightshatteredImg, 4);
        mt.addImage(leftshatteredImg, 5);
        
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.mediachecked = true;
    }
    
         public void ScoreCounterReset() {
                             // Pisteiden kirjoitus filuun kun maalissa
                        try {
                            fw = new FileWriter("scorecounter.txt");
                            bw = new BufferedWriter(fw);
                            bw.write(String.valueOf(10000));
                            bw.newLine();
                            bw.close();
                        } catch(Exception e){
                            System.out.println("Fatal error resetting scorefile!");
                        }
     }
    
}
