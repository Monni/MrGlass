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
 * @author Nissinen
 */
public class LevelIntroState extends GameState {
    

    private final Image shatteredMenu = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\shattered.png");
    private final Image selectorImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\selector.gif");
    private final Image storyImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\story.png");
    private final Image movinginfoImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\infomoving.png");
    private final Image jumpinfoImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\infojump.png");
    
    private Font font;
    private Player player;
    private boolean shattered, finished;
    private int retryselector;
    private int currentscore;
    private int xloc;
    
    
    private int testi = 0;
    
    private Spike[] p;
    private SpikeTurned[] pT;
    private Block[] b;
    private Saw[] s;
    private Goal[] goal;
    private MovingSaw[] ms;
    private Cannon[] c;
    private CannonBallLeft[] cbl;
    private Flame[] f;
    
    
    public LevelIntroState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(20,39, 25, 579);
        
        b = new Block[160];
        s = new Saw[0];
        goal = new Goal[1];
        p = new Spike[0];
        pT = new SpikeTurned[0];
        ms = new MovingSaw[1];
        c = new Cannon[0];
        cbl = new CannonBallLeft[0];
        f = new Flame [0];
        
        
         //moving saw
        ms[0] = new MovingSaw (401 ,590, 400, 700 );

         //Goal
        goal[0] = new Goal (1200, 560);
       
        // Alaosasto vasemmalta oikealle
        b[0] = new Block (-10, 620, 0);
        b[1] = new Block (-10, 650, 1);
        b[2] = new Block (-10, 680, 1);
        b[3] = new Block (-10, 710, 1);
        
       
        b[4] = new Block (20, 620, 0);
        b[5] = new Block (20, 650, 1);
        b[6] = new Block (20, 680, 1);
        b[7] = new Block (20, 710, 1);
        
    
        b[8] = new Block (50, 620, 0);
        b[9] = new Block (50, 650, 1);
        b[10] = new Block (50, 680, 1);
        b[11] = new Block (50, 710, 1);
        
        b[12] = new Block (80, 620, 0);
        b[13] = new Block (80, 650, 1);
        b[14] = new Block (80, 680, 1);
        b[15] = new Block (80, 710, 1);
        
        b[16] = new Block (110, 620, 0);
        b[17] = new Block (110, 650, 1);
        b[18] = new Block (110, 680, 1);
        b[19] = new Block (110, 710, 1);
        
        b[20] = new Block (140, 620, 0);
        b[21] = new Block (140, 650, 1);
        b[22] = new Block (140, 680, 1);
        b[23] = new Block (140, 710, 1);
        
        b[24] = new Block (140, 620, 0);
        b[25] = new Block (140, 650, 1);
        b[26] = new Block (140, 680, 1);
        b[27] = new Block (140, 710, 1);
        
        b[28] = new Block (170, 620, 0);
        b[29] = new Block (170, 650, 1);
        b[30] = new Block (170, 680, 1);
        b[31] = new Block (170, 710, 1);
        
        b[32] = new Block (200, 620, 0);
        b[33] = new Block (200, 650, 1);
        b[34] = new Block (200, 680, 1);
        b[35] = new Block (200, 710, 1);
        
        b[36] = new Block (230, 620, 0);
        b[37] = new Block (230, 650, 1);
        b[38] = new Block (230, 680, 1);
        b[39] = new Block (230, 710, 1);
        
        b[40] = new Block (260, 620, 0);
        b[41] = new Block (260, 650, 1);
        b[42] = new Block (260, 680, 1);
        b[43] = new Block (260, 710, 1);
        
        b[44] = new Block (290, 620, 0);
        b[45] = new Block (290, 650, 1);
        b[46] = new Block (290, 680, 1);
        b[47] = new Block (290, 710, 1);
        
        b[48] = new Block (320, 620, 0);
        b[49] = new Block (320, 650, 1);
        b[50] = new Block (320, 680, 1);
        b[51] = new Block (320, 710, 1);
        
        b[52] = new Block (350, 620, 0);
        b[53] = new Block (350, 650, 1);
        b[54] = new Block (350, 680, 1);
        b[55] = new Block (350, 710, 1);
        
        b[56] = new Block (350, 620, 0);
        b[57] = new Block (350, 650, 1);
        b[58] = new Block (350, 680, 1);
        b[59] = new Block (350, 710, 1);
        
        b[60] = new Block (380, 620, 0);
        b[61] = new Block (380, 650, 1);
        b[62] = new Block (380, 680, 1);
        b[63] = new Block (380, 710, 1);
        
        b[64] = new Block (410, 620, 0);
        b[65] = new Block (410, 650, 1);
        b[66] = new Block (410, 680, 1);
        b[67] = new Block (410, 710, 1);
        
        b[68] = new Block (440, 620, 0);
        b[69] = new Block (440, 650, 1);
        b[70] = new Block (440, 680, 1);
        b[71] = new Block (440, 710, 1);
        
        b[72] = new Block (470, 620, 0);
        b[73] = new Block (470, 650, 1);
        b[74] = new Block (470, 680, 1);
        b[75] = new Block (470, 710, 1);
        
        b[76] = new Block (500, 620, 0);
        b[77] = new Block (500, 650, 1);
        b[78] = new Block (500, 680, 1);
        b[79] = new Block (500, 710, 1);
        
        b[80] = new Block (530, 620, 0);
        b[81] = new Block (530, 650, 1);
        b[82] = new Block (530, 680, 1);
        b[83] = new Block (530, 710, 1);
        
        b[84] = new Block (560, 620, 0);
        b[85] = new Block (560, 650, 1);
        b[86] = new Block (560, 680, 1);
        b[87] = new Block (560, 710, 1);
        
        b[88] = new Block (590, 620, 0);
        b[89] = new Block (590, 650, 1);
        b[90] = new Block (590, 680, 1);
        b[91] = new Block (590, 710, 1);
        
        b[92] = new Block (620, 620, 0);
        b[93] = new Block (620, 650, 1);
        b[94] = new Block (620, 680, 1);
        b[95] = new Block (620, 710, 1);
        
        b[96] = new Block (650, 620, 0);
        b[97] = new Block (650, 650, 1);
        b[98] = new Block (650, 680, 1);
        b[99] = new Block (650, 710, 1);
        
       b[100] = new Block (680, 620, 2);
        b[101] = new Block (680, 650, 12);
        b[102] = new Block (680, 680, 12);
        b[103] = new Block (680, 710, 12);
        
        // Hyppy
        
        b[104] = new Block (860, 620, 3);
        b[105] = new Block (860, 650, 16);
        b[106] = new Block (860, 680, 16);
        b[107] = new Block (860, 710, 16);
        
        b[108] = new Block (890, 620, 0);
        b[109] = new Block (890, 650, 1);
        b[110] = new Block (890, 680, 1);
        b[111] = new Block (890, 710, 1);
        
        b[112] = new Block (920, 620, 0);
        b[113] = new Block (920, 650, 1);
        b[114] = new Block (920, 680, 1);
        b[115] = new Block (920, 710, 1);
        
        b[116] = new Block (950, 620, 0);
        b[117] = new Block (950, 650, 1);
        b[118] = new Block (950, 680, 1);
        b[119] = new Block (950, 710, 1);
        
        b[120] = new Block (980, 620, 0);
        b[121] = new Block (980, 650, 1);
        b[122] = new Block (980, 680, 1);
        b[123] = new Block (980, 710, 1);
        
        b[124] = new Block (1010, 620, 0);
        b[125] = new Block (1010, 650, 1);
        b[126] = new Block (1010, 680, 1);
        b[127] = new Block (1010, 710, 1);
        
        b[128] = new Block (1040, 620, 0);
        b[129] = new Block (1040, 650, 1);
        b[130] = new Block (1040, 680, 1);
        b[131] = new Block (1040, 710, 1);
      
        b[132] = new Block (1070, 620, 0);
        b[133] = new Block (1070, 650, 1);
        b[134] = new Block (1070, 680, 1);
        b[135] = new Block (1070, 710, 1);
        
        b[136] = new Block (1100, 620, 0);
        b[137] = new Block (1100, 650, 1);
        b[138] = new Block (1100, 680, 1);
        b[139] = new Block (1100, 710, 1);
        
        b[140] = new Block (1130, 620, 0);
        b[141] = new Block (1130, 650, 1);
        b[142] = new Block (1130, 680, 1);
        b[143] = new Block (1130, 710, 1);
        
        b[144] = new Block (1160, 620, 0);
        b[145] = new Block (1160, 650, 1);
        b[146] = new Block (1160, 680, 1);
        b[147] = new Block (1160, 710, 1);
        
        b[148] = new Block (1190, 620, 0);
        b[149] = new Block (1190, 650, 1);
        b[150] = new Block (1190, 680, 1);
        b[151] = new Block (1190, 710, 1);
        
        b[152] = new Block (1220, 620, 0);
        b[153] = new Block (1220, 650, 1);
        b[154] = new Block (1220, 680, 1);
        b[155] = new Block (1220, 710, 1);
        
        b[156] = new Block (1250, 620, 0);
        b[157] = new Block (1250, 650, 1);
        b[158] = new Block (1250, 680, 1);
        b[159] = new Block (1250, 710, 1);
    }

    public void tick() {
        //palikoiden tsekkaus
        for ( int i = 0; i<b.length; i++) {
            b[i].tick();
        }
        
        //moving saw
        for ( int i = 0; i < ms.length; i++){
            ms[i].tick();
        }
        
         //maalin tsekkaus
        for ( int i = 0; i < goal.length; i++){
            goal[i].tick();
        }

      player.tick(b, s, p, pT, goal, ms, c, cbl, f);
      
      
      // Haetaan pelaajan tila, retryn tila, pisteet
      shattered = player.getShatteredBoolean();
      finished = player.getFinishedBoolean();
      retryselector = player.getRetrySelector();
      currentscore = player.getCurrentScore();
      xloc = player.getCurrentX();
      
       if ( finished ) gsm.states.push(new Level1State(gsm));
      
      
      
    }

    public void draw(Graphics g) {
        

        
        // taustan piirto
        ImageIcon ic = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\background\\TaustaMap1.png");
        g.drawImage(ic.getImage(),0,0,null);
        
        //pelaajan piirto
      player.draw(g);  
      
              font = new Font ("Fixedsys", Font.PLAIN,18);
      g.setFont(font);
      g.drawString("Score: " + currentscore,1170, 25);
      
    //palikoiden piirto
      for ( int i = 0; i < b.length; i++) {
          b[i].draw(g);
      }

       //maalin piirto
         for ( int i = 0; i < goal.length; i++){
            goal[i].draw(g);
        }

         //moving saw
         for ( int i = 0; i < ms.length; i++){
            ms[i].draw(g);
        }

                     // kuoleman korjatessa
        
         // Story IMG
         g.drawImage(storyImg, 100, 50, null);
         
         if ( xloc > 0 && xloc < 500 ) {
             g.drawImage(movinginfoImg, 25, 430, null);
         }
         if ( xloc > 225 && xloc < 750 ) {
             g.drawImage(jumpinfoImg, 225, 470, null);
         }
         
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
