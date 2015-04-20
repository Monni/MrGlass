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
 * @author Nissinen
 */
public class Level1State extends GameState {
    

    private final Image shatteredMenu = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\shattered.png");
    private final Image selectorImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\selector.gif");
    
    private Player player;
    private boolean shattered;
    private int retryselector;
    private int currentscore;
    
    private int testi = 0;
    
    private Spike[] p;
    private SpikeTurned[] pT;
    private Block[] b;
    private Saw[] s;
    private Goal[] goal;
    private MovingSaw[] ms;
    private Cannon[] c;
    private CannonBallLeft[] cbl;
    
    
    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(18,39);
        
        b = new Block[213];
        s = new Saw[6];
        goal = new Goal[1];
        p = new Spike[2];
        pT = new SpikeTurned[5];
        ms = new MovingSaw[2];
        c = new Cannon[1];
        cbl = new CannonBallLeft[1];
        
        
        //Cannon
        c[0] = new Cannon (745, 95);
        
        //Cannonballs
        cbl[0] = new CannonBallLeft (735, 95, -50 );
        
        //Goal
        goal[0] = new Goal (1200, 80);
        
        //moving saw
        ms[0] = new MovingSaw (150,620, 80, 230 );
        ms[1] = new MovingSaw (170, 310, 150, 470 );
        
        //spikes upside down
        pT[0] = new SpikeTurned(1000, 390);
        pT[1] = new SpikeTurned(220, 400);
        pT[2] = new SpikeTurned(320, 400);
        pT[3] = new SpikeTurned(640, 400);
        pT[4] = new SpikeTurned(550, 180);
        
        
        //spikes
        
        p[0] = new Spike (260, 690);
        p[1] = new Spike (550, 560);
        
        //saws
        s[0] = new Saw (150, 620);
        s[1] = new Saw (370, 310);
        s[2] = new Saw (260, 310);
        s[3] = new Saw (150, 310);
        s[4] = new Saw (1070, 110);
        s[5] = new Saw (1000, 110);
        // Alaosasto vasemmalta oikealle
        b[0] = new Block (-10, 560, 0);
        b[1] = new Block (-10, 590, 1);
        b[2] = new Block (-10, 620, 1);
        b[3] = new Block (-10, 650, 1);
        b[4] = new Block (-10, 680, 1);
        b[5] = new Block (-10, 710, 1);
        
        b[6] = new Block (20, 560, 0);
        b[7] = new Block (20, 590, 1);
        b[8] = new Block (20, 620, 1);
        b[9] = new Block (20, 650, 1);
        b[10] = new Block (20, 680, 1);
        b[11] = new Block (20, 710, 1);
        
        b[12] = new Block (50, 560, 7);
        b[13] = new Block (50, 590, 14);
        b[14] = new Block (50, 620, 14);
        b[15] = new Block (50, 650, 15);
        b[16] = new Block (50, 680, 1);
        b[17] = new Block (50, 710, 1);
        
        b[18] = new Block (80, 650, 0);
        b[19] = new Block (80, 680, 1);
        b[20] = new Block (80, 710, 1);
        
        b[21] = new Block (110, 650, 0);
        b[22] = new Block (110, 680, 1);
        b[23] = new Block (110, 710, 1);
        
        b[24] = new Block (140, 650, 0);
        b[25] = new Block (140, 680, 1);
        b[26] = new Block (140, 710, 1);
        
        b[27] = new Block (170, 650, 0);
        b[28] = new Block (170, 680, 1);
        b[29] = new Block (170, 710, 1);
        
        b[30] = new Block (200, 650, 0);
        b[31] = new Block (200, 680, 1);
        b[32] = new Block (200, 710, 1);
        
        b[33] = new Block (230, 620, 5);
        b[34] = new Block (230, 650, 2);
        b[35] = new Block (230, 680, 12);
        b[36] = new Block (230, 710, 12);
        
        //piikki kuilu
        b[37] = new Block (265, 720, 1); // ulkona näytöltä
        
        b[38] = new Block (300, 620, 5);
        b[39] = new Block (300, 650, 3);
        b[40] = new Block (300, 680, 16);
        b[41] = new Block (300, 710, 16);
        
        b[42] = new Block (330, 650, 0);
        b[43] = new Block (330, 680, 1);
        b[44] = new Block (330, 710, 1);
        
        b[45] = new Block (360, 650, 2);
        b[46] = new Block (360, 680, 12);
        b[47] = new Block (360, 710, 12);
        
        //ensimmoisen rotkon kohta ( sirkkeli päällä) mallissa
        
        b[48] = new Block (500, 590, 3);
        b[49] = new Block (500, 620, 16);
        b[50] = new Block (500, 650, 16);
        b[51] = new Block (500, 680, 16);
        b[52] = new Block (500, 710, 16);
        
        b[53] = new Block (530, 590, 0);
        b[54] = new Block (530, 620, 1);
        b[55] = new Block (530, 650, 1);
        b[56] = new Block (530, 680, 1);
        b[57] = new Block (530, 710, 1);
        
        b[58] = new Block (560, 590, 2);
        b[59] = new Block (560, 620, 12);
        b[60] = new Block (560, 650, 12);
        b[61] = new Block (560, 680, 12);
        b[62] = new Block (560, 710, 12);
        
        // rappusten alotuis alusta
        
        b[63] = new Block (660, 650, 3);
        b[64] = new Block (660, 680, 16);       
        b[65] = new Block (660, 710, 16);
        
        b[66] = new Block (690, 650, 2);
        b[67] = new Block (690, 680, 12);
        b[68] = new Block (690, 710, 12);
        
        // rappuset
        
        b[69] = new Block (820, 650, 5);
        b[70] = new Block (820, 680, 6);
        b[71] = new Block (820, 710, 6);
        
        b[72] = new Block (920, 590, 5);
        b[73] = new Block (920, 620, 6);    
        b[74] = new Block (920, 650, 6);
        b[75] = new Block (920, 680, 6);
        b[76] = new Block (920, 710, 6);
        
        
        b[77] = new Block (1020, 530, 5);
        b[78] = new Block (1020, 560, 6);
        b[79] = new Block (1020, 590, 6);
        b[80] = new Block (1020, 620, 6);
        b[81] = new Block (1020, 650, 6);
        b[82] = new Block (1020, 680, 6);
        b[83] = new Block (1020, 710, 6);
        
        b[84] = new Block (1150, 470, 5);
        b[85] = new Block (1150, 500, 6);
        b[86] = new Block (1150, 530, 6);
        b[87] = new Block (1150, 560, 6);
        b[88] = new Block (1150, 590, 6);
        b[89] = new Block (1150, 620, 6);
        b[90] = new Block (1150, 650, 6);
        b[91] = new Block (1150, 680, 6);
        b[92] = new Block (1150, 710, 6);
       
        b[93] = new Block (1180, 470, 6);
        b[94] = new Block (1180, 500, 6);
        b[95] = new Block (1180, 530, 6);
        b[96] = new Block (1180, 560, 6);
        b[97] = new Block (1180, 590, 6);
        b[98] = new Block (1180, 620, 6);
        b[99] = new Block (1180, 650, 6);
        b[100] = new Block (1180, 680, 6);
        b[101] = new Block (1180, 710, 6);
        
        b[102] = new Block (1210, 470, 6);
        b[103] = new Block (1210, 500, 6);
        b[104] = new Block (1210, 530, 6);
        b[105] = new Block (1210, 560, 6);
        b[106] = new Block (1210, 590, 6);
        b[107] = new Block (1210, 620, 6);
        b[108] = new Block (1210, 650, 6);
        b[109] = new Block (1210, 680, 6);
        b[110] = new Block (1210, 710, 6);
      
        b[111] = new Block (1180, 440, 5);
        
        b[112] = new Block (1210, 380, 5);
        b[113] = new Block (1210, 410, 6);
        b[114] = new Block (1210, 440, 6);
        
        //palikat ilmassa oikealta vasemmalle
        
        b[115] = new Block (990, 330, 9);
        b[116] = new Block (990, 360, 10);
        b[117] = new Block (1020, 330, 7);
        b[118] = new Block (1020, 360, 8);
        
        b[119] = new Block (810, 340, 9);
        b[120] = new Block (810, 370, 10);
        b[121] = new Block (840, 340, 7);
        b[122] = new Block (840, 370, 8);
        
        b[123] = new Block (630, 340, 9);
        b[124] = new Block (630, 370, 10);
        b[125] = new Block (660, 340, 7);
        b[126] = new Block (660, 370, 8);
        
        //kolmen sirkkelina alusta oikealta vasemmalle
        
        b[127] = new Block (450, 340, 7);
        b[128] = new Block (450, 370, 8);
        b[129] = new Block (420, 340, 0);
        b[130] = new Block (420, 370, 4);
        b[131] = new Block (390, 340, 0);
        b[132] = new Block (390, 370, 4);
        b[133] = new Block (360, 340, 0);
        b[134] = new Block (360, 370, 4);
        b[135] = new Block (330, 340, 0);
        b[136] = new Block (330, 370, 4);
        b[137] = new Block (300, 340, 0);
        b[138] = new Block (300, 370, 4);
        b[139] = new Block (270, 340, 0);
        b[140] = new Block (270, 370, 4);
        b[141] = new Block (240, 340, 0);
        b[142] = new Block (240, 370, 4);
        b[143] = new Block (210, 340, 0);
        b[144] = new Block (210, 370, 4);
        b[145] = new Block (180, 340, 0);
        b[146] = new Block (180, 370, 4);
        b[147] = new Block (150, 340, 0);
        b[148] = new Block (150, 370, 4);
        
        //koroke
        
        b[149] = new Block (120, 280, 7);
        b[150] = new Block (120, 310, 14);
        b[151] = new Block (120, 340, 15);
        b[152] = new Block (120, 370, 4);
        b[153] = new Block (90, 280, 0);
        b[154] = new Block (90, 310, 1);
        b[155] = new Block (90, 340, 1);
        b[156] = new Block (90, 370, 4);
        b[157] = new Block (60, 280, 0);
        b[158] = new Block (60, 310, 1);
        b[159] = new Block (60, 340, 1);
        b[160] = new Block (60, 370, 4);
        b[161] = new Block (30, 280, 0);
        b[162] = new Block (30, 310, 1);
        b[163] = new Block (30, 340, 1);
        b[164] = new Block (30, 370, 4);
        b[165] = new Block (0, 280, 0);
        b[166] = new Block (0, 310, 1);
        b[167] = new Block (0, 340, 1);
        b[168] = new Block (0, 370, 4);
        
        b[169] = new Block (30, 250, 5);
        
        b[170] = new Block (0, 190, 5);
        b[171] = new Block (0, 220, 6);
        b[172] = new Block (0, 250, 6);
        
        // ylimmät neliöpalikat vasemmalta oikealle
        
        b[173] = new Block (210, 140, 7);
        b[174] = new Block (180, 140, 9);
        b[175] = new Block (210, 170, 8);
        b[176] = new Block (180, 170, 10);
        
        b[177] = new Block (390, 140, 7);
        b[178] = new Block (360, 140, 9);
        b[179] = new Block (390, 170, 8);
        b[180] = new Block (360, 170, 10);
        
        b[181] = new Block (570, 120, 7);
        b[182] = new Block (540, 120, 9);
        b[183] = new Block (570, 150, 8);
        b[184] = new Block (540, 150, 10);
        
        b[185] = new Block (750, 120, 7);
        b[186] = new Block (720, 120, 9);
        b[187] = new Block (750, 150, 8);
        b[188] = new Block (720, 150, 10);
        
        // maalialusta
        
        b[189] = new Block (930, 140, 9);
        b[190] = new Block (930, 170, 10);
        b[191] = new Block (960, 140, 0);
        b[192] = new Block (960, 170, 4);
        b[193] = new Block (990, 140, 0);
        b[194] = new Block (990, 170, 4);
        b[195] = new Block (1020, 140, 0);
        b[196] = new Block (1020, 170, 4);
        b[197] = new Block (1050, 140, 0);
        b[198] = new Block (1050, 170, 4);
        b[199] = new Block (1080, 140, 0);
        b[200] = new Block (1080, 170, 4);
        b[201] = new Block (1110, 140, 0);
        b[202] = new Block (1110, 170, 4);
        b[203] = new Block (1140, 140, 0);
        b[204] = new Block (1140, 170, 4);
        b[205] = new Block (1170, 140, 0);
        b[206] = new Block (1170, 170, 4);
        b[207] = new Block (1200, 140, 0);
        b[208] = new Block (1200, 170, 4);
        b[209] = new Block (1230, 140, 0);
        b[210] = new Block (1230, 170, 4);
        b[211] = new Block (1260, 140, 0);
        b[212] = new Block (1260, 170, 4);
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
      player.tick(b, s, p, pT, goal, ms, c, cbl);
      
      
      // Haetaan pelaajan tila, retryn tila, pisteet
      shattered = player.getShatteredBoolean();
      retryselector = player.getRetrySelector();
      currentscore = player.getCurrentScore();
      
      
      
      
        System.out.println(currentscore);
      
      
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
     else if ( k == KeyEvent.VK_ENTER && shattered && retryselector == 0 )
         gsm.states.push(new Level1State(gsm));
    }

    public void keyReleased(int k) {
       player.keyReleased(k);
    }
    
    
    
}
