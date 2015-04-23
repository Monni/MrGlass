/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;


import Entities.Player;
import Objects.Block;
import Objects.Cannon;
import Objects.CannonBallLeft;
import Objects.Flame;
import Objects.Goal;
import Objects.MovingSaw;
import Objects.Saw;
import Objects.Spike;
import Objects.SpikeTurned;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Miika
 */
public class Level2State extends GameState {
    

    private final Image shatteredMenu = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\shattered.png");
    private final Image selectorImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\selector.gif");
    
    private Player player;
    private boolean shattered, finished;
    private int retryselector;
    private int currentscore;
    
      
    private Spike[] p;
    private SpikeTurned[] pT;
    private Block[] b;
    private Saw[] s;
    private Goal[] goal;
    private MovingSaw[] ms;
    private Cannon[] c;
    private CannonBallLeft[] cbl;
    private Flame [] f;
    
    
    public Level2State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(18,39, 15, 600);
        
        b = new Block[73];
        s = new Saw[6];
        goal = new Goal[1];
        p = new Spike[0];
        pT = new SpikeTurned[0];
        ms = new MovingSaw[0];
        c = new Cannon[0];
        cbl = new CannonBallLeft[0];
        f = new Flame[0];
        
        
       
        
       
        
        //Goal
        goal[0] = new Goal (1200, 80);
        
     
       
        
        
       
        
        //saws
        s[0] = new Saw (150, 620);
        s[1] = new Saw (370, 310);
        s[2] = new Saw (260, 310);
        s[3] = new Saw (150, 310);
        s[4] = new Saw (1070, 110);
        s[5] = new Saw (1000, 110);
       
       
        // Alun maapalat
        b[0] = new Block (-10, 650, 17);
        b[1] = new Block (-10, 680, 17);
        b[2] = new Block (-10, 710, 17);
        b[3] = new Block (20, 650, 17);
        b[4] = new Block (20, 680, 17);
        b[5] = new Block (20, 710, 17);
        b[6] = new Block (50, 650, 17);
        b[7] = new Block (50, 680, 17);
        b[8] = new Block (50, 710, 17);
        b[9] = new Block (80, 650, 17);
        b[10] = new Block (80, 680, 17);
        b[11] = new Block (80, 710, 17);
        b[12] = new Block (110, 650, 17);
        b[13] = new Block (110, 680, 17);
        b[14] = new Block (110, 710, 17);
        b[15] = new Block (140, 650, 17);
        b[16] = new Block (140, 680, 17);
        b[17] = new Block (140, 710, 17);
        b[18] = new Block (170, 650,17);
        b[19] = new Block (170, 680, 17);
        b[20] = new Block (170, 710, 17);
        
        // Alun ylöspäinhyppely oikea reuna
        b[21] = new Block (140, 620, 17);
        b[22] = new Block (140, 590, 17);
        b[23] = new Block (140, 560, 17);
        b[24] = new Block (140, 530, 17);
        b[25] = new Block (140, 500, 17);
        b[26] = new Block (140, 470, 17);
        b[27] = new Block (140, 440, 17);
        b[28] = new Block (140, 410, 17);
        b[29] = new Block (140, 380, 17);
        b[30] = new Block (140, 350, 17);
        b[31] = new Block (140, 320, 17);
        b[32] = new Block (140, 290, 17);
        b[33] = new Block (140, 260, 17);
        b[34] = new Block (140, 230, 17);
        b[35] = new Block (140, 200, 17);
        b[36] = new Block (140, 170, 17);
        b[37] = new Block (140, 140, 17);
        b[38] = new Block (140, 110, 17);
        b[39] = new Block (140, 80, 17);
        
        b[40] = new Block (170, 620, 17);
        b[41] = new Block (170, 590, 17);
        b[42] = new Block (170, 560, 17);
        b[43] = new Block (170, 530, 17);
        b[44] = new Block (170, 500, 17);
        b[45] = new Block (170, 470, 17);
        b[46] = new Block (170, 440, 17);
        b[47] = new Block (170, 410, 17);
        b[48] = new Block (170, 380, 17);
        b[49] = new Block (170, 350, 17);
        b[50] = new Block (170, 320, 17);
        b[51] = new Block (170, 290, 17);
        b[52] = new Block (170, 260, 17);
        b[53] = new Block (170, 230, 17);
        b[54] = new Block (170, 200, 17);
        b[55] = new Block (170, 170, 17);
        b[56] = new Block (170, 140, 17);
        b[57] = new Block (170, 110, 17);
        b[58] = new Block (170, 80, 17);
        
        // Alun ylöspäinhyppelu vasen reuna
       
        b[59] = new Block (-10, 500, 17);
        b[60] = new Block (-10, 470, 17);
        b[61] = new Block (-10, 440, 17);
        b[62] = new Block (-10, 410, 17);
        b[63] = new Block (-10, 380, 17);
        b[64] = new Block (-10, 350, 17);
        b[65] = new Block (-10, 320, 17);
        b[66] = new Block (-10, 290, 17);
        
        
        // Alun ylöshyppelun putket
        b[67] = new Block (110, 620, 20);
        b[68] = new Block (20, 540, 20);
        b[69] = new Block (110, 460, 20);
        b[70] = new Block (20, 380, 20);
        b[71] = new Block (110, 300, 20);
        b[72] = new Block (20, 220, 20);
        
    }

    public void tick() {
        //palikoiden tsekkaus
        for ( int i = 0; i<b.length; i++) {
            b[i].tick();
        }
        // sahojen tsekkaus
        for ( int i = 0; i<s.length; i++) {
            s[i].tick();
        }
        //maalin tsekkaus
        for ( int i = 0; i < goal.length; i++){
            goal[i].tick();
        }
        //piikkien tsekkaus
        for ( int i = 0; i < p.length; i++){
            p[i].tick();
        }
        //käännettyjen piikkien tsekkaus
        for ( int i = 0; i < pT.length; i++){
            pT[i].tick();
        }
        //moving saw
        for ( int i = 0; i < ms.length; i++){
            ms[i].tick();
        }
        //cannon
        for ( int i = 0; i < c.length; i++){
            c[i].tick();
        }
        //cannonBALL LEFT
        for ( int i = 0; i < cbl.length; i++){
            cbl[i].tick();
        }
      player.tick(b, s, p, pT, goal, ms, c, cbl, f);
      
      
      // Haetaan pelaajan tila, retryn tila, pisteet
      shattered = player.getShatteredBoolean();
      retryselector = player.getRetrySelector();
      currentscore = player.getCurrentScore();
      
      
      
      
       // System.out.println(currentscore);
      
      
    }

    public void draw(Graphics g) {
        
        // taustan piirto
        ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\background\\TaustaMap1.png");
        g.drawImage(ic.getImage(),0,0,null);
        
        //pelaajan piirto
      player.draw(g);  
      
    //palikoiden piirto
      for ( int i = 0; i < b.length; i++) {
          b[i].draw(g);
      }
      
      //sahojen piirto
       for ( int i = 0; i < s.length; i++) {
          s[i].draw(g);
      }
       //maalin piirto
         for ( int i = 0; i < goal.length; i++){
            goal[i].draw(g);
        }
         // piikkien piirto
         for ( int i = 0; i < p.length; i++){
            p[i].draw(g);
            
            // väärinpäin piikkien piirto
        }
         for ( int i = 0; i < pT.length; i++){
            pT[i].draw(g);
         }
         //moving saw
         for ( int i = 0; i < ms.length; i++){
            ms[i].draw(g);
        }
        //cannon
         for ( int i = 0; i < c.length; i++){
            c[i].draw(g);
        }
         //cannonballLEFT
         for ( int i = 0; i < cbl.length; i++){
            cbl[i].draw(g);
        }
         
                     // kuoleman korjatessa
        
        if ( shattered ) {
            g.drawImage(shatteredMenu, 440, 250, this);
            if ( retryselector == 0 )
               g.drawImage(selectorImg, 462, 381, null);
           else if ( retryselector == 1 )
               g.drawImage(selectorImg, 627, 381, null);
        }
         
    }

    public void keyPressed(int k) {
     player.keyPressed(k);
     if ( k == KeyEvent.VK_ENTER && shattered && retryselector == 1 )
         gsm.states.push(new MenuState(gsm));
     else if ( k == KeyEvent.VK_ENTER && shattered && retryselector == 0 ) {
         player.ScoreCounterReset();
         gsm.states.push(new LevelIntroState(gsm));
     }
         
    }

    public void keyReleased(int k) {
       player.keyReleased(k);
    }
    
    
    
}
