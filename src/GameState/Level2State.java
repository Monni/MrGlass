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
public class Level2State extends GameState {
    

    private final Image shatteredMenu = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\shattered.png");
    private final Image selectorImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\selector.gif");
    private final Image fakecabinImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\fakecabin.png");
    private final Image fakecabinInfo = Toolkit.getDefaultToolkit().getImage("src\\resources\\objects\\fakecabininfo.png");
    
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
    
    
    public Level2State(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        player = new Player(18,39, 240, 0); // 15, 600
        
        b = new Block[302];
        s = new Saw[2];
        goal = new Goal[1];
        p = new Spike[8];
        pT = new SpikeTurned[0];
        ms = new MovingSaw[2];
        c = new Cannon[7];
        cbl = new CannonBallLeft[7];
        f = new Flame[0];
        
        
       
        
       
        
        //Goal
        goal[0] = new Goal (1220, 650);
        
     // Spikes
        p[0] = new Spike(200, 350);
        p[1] = new Spike(557, 350);
        
        p[2] = new Spike(969, 370);
        p[3] = new Spike(820, 490);
        
        p[4] = new Spike (890, 370);
         
        p[5] = new Spike (1037, 400);
        p[6] = new Spike (1005, 400);
        p[7] = new Spike (1066, 400);
                 
       
        
       // Cannon
        c[0] = new Cannon(200, 415, 1);
        c[1] = new Cannon(200, 475, 1);
        c[2] = new Cannon(200, 535, 1);
        c[3] = new Cannon(200, 595, 1);
        c[4] = new Cannon(200, 655, 1);
        
        c[5] = new Cannon(1245, 110, 0);
        
        c[6] = new Cannon(770, 590, 1);
                
        // Cannonball
        cbl[0] = new CannonBallLeft(232, 415, 563, 1);
        cbl[1] = new CannonBallLeft(232, 475, 563, 1);
        cbl[2] = new CannonBallLeft(232, 535, 563, 1);
        cbl[3] = new CannonBallLeft(232, 595, 563, 1);
        cbl[4] = new CannonBallLeft(232, 655, 653, 1);
        
        cbl[5] = new CannonBallLeft(1245, 110, 825, 0);
        
        cbl[6] = new CannonBallLeft(797, 590, 1310, 1);
        
       
        
        //saws
        s[0] = new Saw (860, 680);
        s[1] = new Saw (930, 680);
      
        
        // Moving saw
        ms[0] = new MovingSaw(386, 170, 385, 1010);
        ms[1] = new MovingSaw (939, 170, 385, 1010 );
       
       
       
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
        b[67] = new Block (-10, 260, 17);
        b[68] = new Block (-10, 230, 17);
        b[69] = new Block (-10, 200, 17);
        b[70] = new Block (-10, 170, 17);
        b[71] = new Block (-10, 140, 17);
        b[72] = new Block (-10, 110, 17);
        b[73] = new Block (-10, 80, 17);
        
        // Ylöshyppelyn jälkeinen alashyppy
        b[74] = new Block (290, 80, 17);
        b[75] = new Block (290, 110, 17);
        b[76] = new Block (290, 140, 17);
        b[77] = new Block (290, 170, 17);
        b[78] = new Block (290, 200, 17);
        b[79] = new Block (290, 230, 17);
        b[80] = new Block (290, 260, 17);
        
        
        // Pudotuksen jälkeen tasaista
        b[81] = new Block (200, 380, 17);
        b[82] = new Block (230, 380, 17);
        b[83] = new Block (260, 380, 17);
        b[84] = new Block (290, 380, 17);
        b[85] = new Block (320, 380, 17);
        b[86] = new Block (350, 380, 17);
        
        // Alaspäin portaat ja tykkivälit
        
        b[87] = new Block (200, 440, 17);
        b[88] = new Block (230, 440, 17);
        b[89] = new Block (260, 440, 17);
        b[90] = new Block (290, 440, 17);
        b[91] = new Block (320, 440, 17);
        b[92] = new Block (350, 440, 17);
        b[93] = new Block (380, 440, 17);
        
        b[94] = new Block (200, 500, 17);
        b[95] = new Block (230, 500, 17);
        b[96] = new Block (260, 500, 17);
        b[97] = new Block (290, 500, 17);
        b[98] = new Block (320, 500, 17);
        b[99] = new Block (350, 500, 17);
        b[100] = new Block (380, 500, 17);
        b[101] = new Block (410, 500, 17);
        
        b[102] = new Block (200, 560, 17);
        b[103] = new Block (230, 560, 17);
        b[104] = new Block (260, 560, 17);
        b[105] = new Block (290, 560, 17);
        b[106] = new Block (320, 560, 17);
        b[107] = new Block (350, 560, 17);
        b[108] = new Block (380, 560, 17);
        b[109] = new Block (410, 560, 17);
        b[110] = new Block (440, 560, 17);
        
        b[111] = new Block (200, 620, 17);
        b[112] = new Block (230, 620, 17);
        b[113] = new Block (260, 620, 17);
        b[114] = new Block (290, 620, 17);
        b[115] = new Block (320, 620, 17);
        b[116] = new Block (350, 620, 17);
        b[117] = new Block (380, 620, 17);
        b[118] = new Block (410, 620, 17);
        b[119] = new Block (440, 620, 17);
        b[120] = new Block (470, 620, 17);
        
        b[121] = new Block (200, 680, 17);
        b[122] = new Block (230, 680, 17);
        b[123] = new Block (260, 680, 17);
        b[124] = new Block (290, 680, 17);
        b[125] = new Block (320, 680, 17);
        b[126] = new Block (350, 680, 17);
        b[127] = new Block (380, 680, 17);
        b[128] = new Block (410, 680, 17);
        b[129] = new Block (440, 680, 17);
        b[130] = new Block (470, 680, 17);
        b[131] = new Block (500, 680, 17);
        
        // Alamaa
        b[132] = new Block (200, 710, 17);
        b[133] = new Block (230, 710, 17);
        b[134] = new Block (260, 710, 17);
        b[135] = new Block (290, 710, 17);
        b[136] = new Block (320, 710, 17);
        b[137] = new Block (350, 710, 17);
        b[138] = new Block (380, 710, 17);
        b[139] = new Block (410, 710, 17);
        b[140] = new Block (440, 710, 17);
        b[141] = new Block (470, 710, 17);
        b[142] = new Block (500, 710, 17);
        b[143] = new Block (530, 710, 17);
        b[144] = new Block (560, 710, 17);
        b[145] = new Block (590, 710, 17);
        b[146] = new Block (620, 710, 17);
        b[147] = new Block (650, 710, 17);
        b[148] = new Block (680, 710, 17);
        b[149] = new Block (710, 710, 17);
        b[150] = new Block (740, 710, 17);
        b[151] = new Block (770, 710, 17);
        b[152] = new Block (800, 710, 17);
        b[153] = new Block (830, 710, 17);
        b[154] = new Block (860, 710, 17);
        b[155] = new Block (890, 710, 17);
        b[156] = new Block (920, 710, 17);
        b[157] = new Block (950, 710, 17);
        b[158] = new Block (980, 710, 17);
        b[159] = new Block (1010, 710, 17);
        b[160] = new Block (1040, 710, 17);
        b[161] = new Block (1070, 710, 17);
        b[162] = new Block (1100, 710, 17);
        b[163] = new Block (1130, 710, 17);
        b[164] = new Block (1160, 710, 17);
        b[165] = new Block (1190, 710, 17);
        b[163] = new Block (1220, 710, 17);
        b[164] = new Block (1250, 710, 17);

        // Nousun jälkeiseen pari lisäpalaa
        b[165] = new Block (290, 50, 17);
        b[166] = new Block (290, 20, 17);
        b[167] = new Block (290, -10, 17);
        
        // Alashyppelyä vastaava seinä
        b[168] = new Block (590, 590, 17);
        b[169] = new Block (590, 560, 17);
        b[170] = new Block (590, 530, 17);
        b[171] = new Block (590, 500, 17);
        b[172] = new Block (590, 470, 17);
        b[173] = new Block (590, 440, 17);
        b[174] = new Block (590, 410, 17);
        b[175] = new Block (560, 380, 17);
        b[176] = new Block (530, 350, 17);
        b[177] = new Block (530, 320, 17);
        b[178] = new Block (500, 290, 17);
        b[179] = new Block (470, 290, 17);
        b[180] = new Block (440, 290, 17);
        b[181] = new Block (410, 290, 17);
        b[182] = new Block (380, 290, 17);
        b[183] = new Block (350, 290, 17);
        b[184] = new Block (320, 290, 17);
        b[185] = new Block (290, 290, 17);
        
        
        // Takas ylös
        b[186] = new Block (680, 680, 17);
        b[187] = new Block (680, 650, 17);
        
        b[188] = new Block (620, 590, 17);
        b[189] = new Block (710, 560, 17);
        b[190] = new Block (710, 530, 17);
        
        b[191] = new Block (620, 470, 17);
        b[192] = new Block (710, 410, 17);
        b[193] = new Block (590, 380, 17);
        
        // Ylösnousun vasemmanpuoleinen seinä
        b[194] = new Block (740, 680, 17);
        b[195] = new Block (740, 650, 17);
        b[196] = new Block (740, 620, 17);
        b[197] = new Block (740, 590, 17);
        b[198] = new Block (740, 560, 17);
        b[199] = new Block (740, 530, 17);
        b[200] = new Block (740, 500, 17);
        b[201] = new Block (740, 470, 17);
        b[202] = new Block (740, 440, 17);
        b[203] = new Block (740, 410, 17);
        b[204] = new Block (740, 380, 17);
        b[205] = new Block (740, 350, 17);
        b[206] = new Block (740, 320, 17);
        b[207] = new Block (740, 290, 17);
        
        b[208] = new Block (710, 260, 17);
        b[209] = new Block (680, 230, 17);
        b[210] = new Block (650, 200, 17);
        b[211] = new Block (620, 200, 17);
        b[212] = new Block (590, 200, 17);
        b[213] = new Block (560, 200, 17);
        b[214] = new Block (530, 200, 17);
        b[215] = new Block (500, 200, 17);
        b[216] = new Block (470, 200, 17);
        b[217] = new Block (440, 200, 17);
        b[218] = new Block (410, 200, 17);
        b[219] = new Block (380, 200, 17);
        
        // Seinän suoristumisen jälkeen lähtee vielä oikealle
        b[220] = new Block (680, 200, 17);
        b[221] = new Block (710, 200, 17);
        b[222] = new Block (740, 200, 17);
        b[223] = new Block (770, 200, 17);
        b[224] = new Block (800, 200, 17);
        b[225] = new Block (830, 200, 17);
        b[226] = new Block (860, 200, 17);
        b[227] = new Block (890, 200, 17);
        b[228] = new Block (920, 200, 17);
        b[229] = new Block (950, 200, 17);
        b[230] = new Block (980, 200, 17);
        b[231] = new Block (1010, 200, 17);
        
        // Suoran ylläoleva katto
        b[232] = new Block (650, 100, 17);
        b[233] = new Block (620, 100, 17);
        b[234] = new Block (590, 100, 17);
        b[235] = new Block (560, 100, 17);
        b[236] = new Block (530, 100, 17);
        b[237] = new Block (500, 100, 17);
        b[238] = new Block (470, 100, 17);
        b[239] = new Block (440, 100, 17);
        b[240] = new Block (410, 100, 17);
        b[241] = new Block (380, 100, 17);
        b[242] = new Block (680, 100, 17);
        b[243] = new Block (710, 100, 17);
        b[244] = new Block (740, 100, 17);
        b[245] = new Block (770, 100, 17);
        b[246] = new Block (800, 100, 17);

        b[247] = new Block (890, 135, 17);
        b[248] = new Block (920, 135, 17);
        b[249] = new Block (950, 135, 17);
        b[250] = new Block (980, 135, 17);
        b[251] = new Block (1010, 135, 17);
        b[252] = new Block (1010, 165, 17);
        b[253] = new Block (1010, 170, 17);
        
        // Katon jatke
        b[254] = new Block (350, 100, 17);
        b[255] = new Block (320, 100, 17);
        b[256] = new Block (290, 100, 17);
        
        b[257] = new Block (1130, 135, 17);
        b[258] = new Block (1160, 135, 17);
        b[259] = new Block (1190, 135, 17);
        b[260] = new Block (1220, 135, 17);
        b[261] = new Block (1250, 135, 17);
        
        // Oikean yläreunan tykiltä alaspäin
        b[262] = new Block (1130, 160, 17);
        b[263] = new Block (1130, 190, 17);
        b[264] = new Block (1130, 220, 17);
        b[265] = new Block (1130, 250, 17);
        b[266] = new Block (1130, 280, 17);
        b[267] = new Block (1130, 310, 17);
        b[268] = new Block (1130, 340, 17);
        b[269] = new Block (1130, 370, 17);
        b[270] = new Block (1130, 400, 17);
        b[271] = new Block (1130, 430, 17);
        b[272] = new Block (1130, 460, 17);
        
        // Hyppelyä
        
        b[273] = new Block (1100, 340, 17);
        b[274] = new Block (1100, 370, 17);
       
        b[275] = new Block (980, 400, 17);
        b[276] = new Block (950, 400, 17);
        b[277] = new Block (920, 400, 17);
        b[278] = new Block (890, 400, 17);

        
        b[279] = new Block (980, 430, 17);
        b[280] = new Block (950, 430, 17);
        b[281] = new Block (920, 430, 17);
        
        b[282] = new Block (830, 520, 17);
        b[283] = new Block (800, 520, 17);
        b[284] = new Block (770, 520, 17);
        b[285] = new Block (800, 550, 17);
        b[286] = new Block (770, 550, 17);
        
        b[287] = new Block (890, 430, 17);
        b[288] = new Block (1010, 430, 17);
        b[289] = new Block (1040, 430, 17);
        b[290] = new Block (1070, 430, 17);
        b[291] = new Block (1100, 430, 17);
        b[292] = new Block (1100, 400, 17);
        
        // Loppuportaat
        b[293] = new Block (1100, 680, 17);
        b[294] = new Block (1100, 650, 17);
        b[295] = new Block (1100, 620, 17);
        b[296] = new Block (1070, 680, 17);
        b[297] = new Block (1070, 650, 17);
        b[298] = new Block (1040, 680, 17);
        
        // Lopputykin alle
        b[299] = new Block (770, 615, 17);
        
        
        
        // Hyppypalikka aiemmille suorille
       b[300] = new Block (320, 230, 17);
       b[301] = new Block (320, 260, 17);
        
        // Oikean päässä seinä
        /*
        b[232] = new Block (1010, 170, 17);
        b[233] = new Block (1010, 140, 17);
        b[234] = new Block (1010, 110, 17);
        b[235] = new Block (1010, 80, 17);
        b[236] = new Block (1010, 50, 17);
        b[237] = new Block (1010, 20, 17);
        */
        
        
        // Alun ylöshyppelun putket
        /*
        b[190] = new Block (110, 620, 20);
        b[191] = new Block (20, 540, 20);
        b[192] = new Block (110, 460, 20);
        b[193] = new Block (20, 380, 20);
        b[194] = new Block (110, 300, 20);
        b[195] = new Block (20, 220, 20);
        b[196] = new Block (110, 160, 20);
        */
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
         
         // Fake cabin
         g.drawImage(fakecabinImg, 375, 9, null);
         if ( xloc > 300 && xloc < 660 && yloc < 70 ) {
             g.drawImage(fakecabinInfo, 530, 20, null);
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
