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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Miika
 */
public class LevelEndState extends GameState {
    
    private final Image shatteredMenu = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\shattered.png");
    private final Image selectorImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\selector.gif");
    private final Image cabinOFF = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\cabin_OFF.png");
    private final Image cabinON = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\cabin_ON.png");
    
    private Player player;
    private boolean shattered, finished;
    private int retryselector;
    private int currentscore;
    
    private int xloc, yloc;
    private Font font;
    
      
    private Spike[] p;
    private SpikeTurned[] pT;
    private Block[] b;
    private Saw[] s;
    private Goal[] goal;
    private MovingSaw[] ms;
    private Cannon[] c;
    private CannonBallLeft[] cbl;
    private Flame [] f;
    
    
    public LevelEndState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(18,39, 15, 550);
        
        b = new Block[88];
        s = new Saw[0];
        goal = new Goal[0];
        p = new Spike[0];
        pT = new SpikeTurned[0];
        ms = new MovingSaw[0];
        c = new Cannon[0];
        cbl = new CannonBallLeft[0];
        f = new Flame[0];
        
        
        
        // Blocks
        
        // Alemmat maapalat
        b[0] = new Block(-10, 710, 0);
        b[1] = new Block(20, 710, 0);
        b[2] = new Block(50, 710, 0);
        b[3] = new Block(80, 710, 0);
        b[4] = new Block(110, 710, 0);
        b[5] = new Block(140, 710, 0);
        b[6] = new Block(170, 710, 0);
        b[7] = new Block(200, 710, 0);
        b[8] = new Block(230, 710, 0);
        b[9] = new Block(260, 710, 0);
        b[10] = new Block(290, 710, 0);
        b[11] = new Block(320, 710, 0);
        b[12] = new Block(350, 710, 0);
        b[13] = new Block(380, 710, 0);
        b[14] = new Block(410, 710, 0);
        b[15] = new Block(440, 710, 0);
        b[16] = new Block(470, 710, 0);
        b[17] = new Block(500, 710, 0);
        b[18] = new Block(530, 710, 0);
        b[19] = new Block(560, 710, 0);
        b[20] = new Block(590, 710, 0);
        b[21] = new Block(620, 710, 0);
        b[22] = new Block(650, 710, 0);
        b[23] = new Block(680, 710, 0);
        b[24] = new Block(710, 710, 0);
        b[25] = new Block(740, 710, 0);
        b[26] = new Block(770, 710, 0);
        b[27] = new Block(800, 710, 0);
        b[28] = new Block(830, 710, 0);
        b[29] = new Block(860, 710, 0);
        b[30] = new Block(890, 710, 0);
        b[31] = new Block(920, 710, 0);
        b[32] = new Block(950, 710, 0);
        b[33] = new Block(970, 710, 0);
        b[34] = new Block(1000, 710, 0);
        b[35] = new Block(1030, 710, 0);
        b[36] = new Block(1060, 710, 0);
        b[37] = new Block(1090, 710, 0);
        b[38] = new Block(1120, 710, 0);
        b[39] = new Block(1150, 710, 0);
        b[40] = new Block(1180, 710, 0);
        b[41] = new Block(1210, 710, 0);
        b[42] = new Block(1240, 710, 0);
        b[43] = new Block(1270, 710, 0);
        
        // Ylemmät maapalat
        
        b[44] = new Block(20, 680, 0);
        b[45] = new Block(50, 680, 0);
        b[46] = new Block(80, 680, 0);
        b[47] = new Block(110, 680, 0);
        b[48] = new Block(140, 680, 0);
        b[49] = new Block(170, 680, 0);
        b[50] = new Block(200, 680, 0);
        b[51] = new Block(230, 680, 0);
        b[52] = new Block(260, 680, 0);
        b[53] = new Block(290, 680, 0);
        b[54] = new Block(320, 680, 0);
        b[55] = new Block(350, 680, 0);
        b[56] = new Block(380, 680, 0);
        b[57] = new Block(410, 680, 0);
        b[58] = new Block(440, 680, 0);
        b[59] = new Block(470, 680, 0);
        b[60] = new Block(500, 680, 0);
        b[61] = new Block(530, 680, 0);
        b[62] = new Block(560, 680, 0);
        b[63] = new Block(590, 680, 0);
        b[64] = new Block(620, 680, 0);
        b[65] = new Block(650, 680, 0);
        b[66] = new Block(680, 680, 0);
        b[67] = new Block(710, 680, 0);
        b[68] = new Block(740, 680, 0);
        b[69] = new Block(770, 680, 0);
        b[70] = new Block(800, 680, 0);
        b[71] = new Block(830, 680, 0);
        b[72] = new Block(860, 680, 0);
        b[73] = new Block(890, 680, 0);
        b[74] = new Block(920, 680, 0);
        b[75] = new Block(950, 680, 0);
        b[76] = new Block(970, 680, 0);
        b[77] = new Block(1000, 680, 0);
        b[78] = new Block(1030, 680, 0);
        b[79] = new Block(1060, 680, 0);
        b[80] = new Block(1090, 680, 0);
        b[81] = new Block(1120, 680, 0);
        b[82] = new Block(1150, 680, 0);
        b[83] = new Block(1180, 680, 0);
        b[84] = new Block(1210, 680, 0);
        b[85] = new Block(1240, 680, 0);
        b[86] = new Block(1270, 680, 0);
        b[87] = new Block(-10, 680, 0);
        
        
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
        
        // Flame check
        for ( int i = 0; i < f.length; i++ ) {
            f[i].tick();
        }
    
        
      player.tick(b, s, p, pT, goal, ms, c, cbl, f);
      
      
      // Haetaan pelaajan tila, retryn tila, pisteet
      shattered = player.getShatteredBoolean();
      finished = player.getFinishedBoolean();
      retryselector = player.getRetrySelector();
      currentscore = player.getCurrentScore();
      xloc = player.getCurrentX();
      yloc = player.getCurrentY();
      
      
      
      
       // System.out.println(currentscore);
      
      
    }

    public void draw(Graphics g) {
        
       
        
        // taustan piirto
        ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\background\\TaustaMap1.png");
        g.drawImage(ic.getImage(),0,0,null);
        ImageIcon ic2 = new ImageIcon("src\\resources\\background\\TaustaMap2.png");
        g.drawImage(ic2.getImage(), 0, 0, null);
        
        font = new Font ("Fixedsys", Font.PLAIN,18);
      g.setFont(font);
      g.drawString("Score: " + currentscore,1170, 25);
        
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
      
          // Flames
         for ( int i = 0; i < f.length; i++){
            f[i].draw(g);
        }
         
         // Cabin OFF
         g.drawImage(cabinOFF, 700, 591, null);
         
         
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
