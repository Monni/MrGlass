/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;


import Entities.Player;
import Objects.Block;
import Objects.Goal;
import Objects.Saw;
import Objects.Spike;
import Objects.SpikeTurned;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Level1State extends GameState {

    private Player player;
    
    
    private Spike[] p;
    private SpikeTurned[] pT;
    private Block[] b;
    private Saw[] s;
    private Goal[] goal;
    
    
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
        
        //Goal
        goal[0] = new Goal (1200, 80);
        
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
        b[0] = new Block (-10, 560);
        b[1] = new Block (-10, 590);
        b[2] = new Block (-10, 620);
        b[3] = new Block (-10, 650);
        b[4] = new Block (-10, 680);
        b[5] = new Block (-10, 710);
        
        b[6] = new Block (20, 560);
        b[7] = new Block (20, 590);
        b[8] = new Block (20, 620);
        b[9] = new Block (20, 650);
        b[10] = new Block (20, 680);
        b[11] = new Block (20, 710);
        
        b[12] = new Block (50, 560);
        b[13] = new Block (50, 590);
        b[14] = new Block (50, 620);
        b[15] = new Block (50, 650);
        b[16] = new Block (50, 680);
        b[17] = new Block (50, 710);
        
        b[18] = new Block (80, 650);
        b[19] = new Block (80, 680);
        b[20] = new Block (80, 710);
        
        b[21] = new Block (110, 650);
        b[22] = new Block (110, 680);
        b[23] = new Block (110, 710);
        
        b[24] = new Block (140, 650);
        b[25] = new Block (140, 680);
        b[26] = new Block (140, 710);
        
        b[27] = new Block (170, 650);
        b[28] = new Block (170, 680);
        b[29] = new Block (170, 710);
        
        b[30] = new Block (200, 650);
        b[31] = new Block (200, 680);
        b[32] = new Block (200, 710);
        
        b[33] = new Block (230, 620);
        b[34] = new Block (230, 650);
        b[35] = new Block (230, 680);
        b[36] = new Block (230, 710);
        
        //piikki kuilu
        b[37] = new Block (265, 720); // ulkona näytöltä
        
        b[38] = new Block (300, 620);
        b[39] = new Block (300, 650);
        b[40] = new Block (300, 680);
        b[41] = new Block (300, 710);
        
        b[42] = new Block (330, 650);
        b[43] = new Block (330, 680);
        b[44] = new Block (330, 710);
        
        b[45] = new Block (360, 650);
        b[46] = new Block (360, 680);
        b[47] = new Block (360, 710);
        
        //ensimmoisen rotkon kohta ( sirkkeli päällä) mallissa
        
        b[48] = new Block (500, 590);
        b[49] = new Block (500, 620);
        b[50] = new Block (500, 650);
        b[51] = new Block (500, 680);
        b[52] = new Block (500, 710);
        
        b[53] = new Block (530, 590);
        b[54] = new Block (530, 620);
        b[55] = new Block (530, 650);
        b[56] = new Block (530, 680);
        b[57] = new Block (530, 710);
        
        b[58] = new Block (560, 590);
        b[59] = new Block (560, 620);
        b[60] = new Block (560, 650);
        b[61] = new Block (560, 680);
        b[62] = new Block (560, 710);
        
        // rappusten alotuis alusta
        
        b[63] = new Block (660, 650);
        b[64] = new Block (660, 680);       
        b[65] = new Block (660, 710);
        
        b[66] = new Block (690, 650);
        b[67] = new Block (690, 680);
        b[68] = new Block (690, 710);
        
        // rappuset
        
        b[69] = new Block (820, 650);
        b[70] = new Block (820, 680);
        b[71] = new Block (820, 710);
        
        b[72] = new Block (920, 590);
        b[73] = new Block (920, 620);    
        b[74] = new Block (920, 650);
        b[75] = new Block (920, 680);
        b[76] = new Block (920, 710);
        
        
        b[77] = new Block (1020, 530);
        b[78] = new Block (1020, 560);
        b[79] = new Block (1020, 590);
        b[80] = new Block (1020, 620);
        b[81] = new Block (1020, 650);
        b[82] = new Block (1020, 680);
        b[83] = new Block (1020, 710);
        
        b[84] = new Block (1150, 470);
        b[85] = new Block (1150, 500);
        b[86] = new Block (1150, 530);
        b[87] = new Block (1150, 560);
        b[88] = new Block (1150, 590);
        b[89] = new Block (1150, 620);
        b[90] = new Block (1150, 650);
        b[91] = new Block (1150, 680);
        b[92] = new Block (1150, 710);
       
        b[93] = new Block (1180, 470);
        b[94] = new Block (1180, 500);
        b[95] = new Block (1180, 530);
        b[96] = new Block (1180, 560);
        b[97] = new Block (1180, 590);
        b[98] = new Block (1180, 620);
        b[99] = new Block (1180, 650);
        b[100] = new Block (1180, 680);
        b[101] = new Block (1180, 710);
        
        b[102] = new Block (1210, 470);
        b[103] = new Block (1210, 500);
        b[104] = new Block (1210, 530);
        b[105] = new Block (1210, 560);
        b[106] = new Block (1210, 590);
        b[107] = new Block (1210, 620);
        b[108] = new Block (1210, 650);
        b[109] = new Block (1210, 680);
        b[110] = new Block (1210, 710);
       
        b[111] = new Block (1180, 440);
        
        b[112] = new Block (1210, 380);
        b[113] = new Block (1210, 410);
        b[114] = new Block (1210, 440);
        
        //palikat ilmassa oikealta vasemmalle
        
        b[115] = new Block (990, 330);
        b[116] = new Block (990, 360);
        b[117] = new Block (1020, 330);
        b[118] = new Block (1020, 360);
        
        b[119] = new Block (810, 340);
        b[120] = new Block (810, 370);
        b[121] = new Block (840, 340);
        b[122] = new Block (840, 370);
        
        b[123] = new Block (630, 340);
        b[124] = new Block (630, 370);
        b[125] = new Block (660, 340);
        b[126] = new Block (660, 370);
        
        //kolmen sirkkelina alusta oikealta vasemmalle
        
        b[127] = new Block (450, 340);
        b[128] = new Block (450, 370);
        b[129] = new Block (420, 340);
        b[130] = new Block (420, 370);
        b[131] = new Block (390, 340);
        b[132] = new Block (390, 370);
        b[133] = new Block (360, 340);
        b[134] = new Block (360, 370);
        b[135] = new Block (330, 340);
        b[136] = new Block (330, 370);
        b[137] = new Block (300, 340);
        b[138] = new Block (300, 370);
        b[139] = new Block (270, 340);
        b[140] = new Block (270, 370);
        b[141] = new Block (240, 340);
        b[142] = new Block (240, 370);
        b[143] = new Block (210, 340);
        b[144] = new Block (210, 370);
        b[145] = new Block (180, 340);
        b[146] = new Block (180, 370);
        b[147] = new Block (150, 340);
        b[148] = new Block (150, 370);
        
        //koroke
        
        b[149] = new Block (120, 280);
        b[150] = new Block (120, 310);
        b[151] = new Block (120, 340);
        b[152] = new Block (120, 370);
        b[153] = new Block (90, 280);
        b[154] = new Block (90, 310);
        b[155] = new Block (90, 340);
        b[156] = new Block (90, 370);
        b[157] = new Block (60, 280);
        b[158] = new Block (60, 310);
        b[159] = new Block (60, 340);
        b[160] = new Block (60, 370);
        b[161] = new Block (30, 280);
        b[162] = new Block (30, 310);
        b[163] = new Block (30, 340);
        b[164] = new Block (30, 370);
        b[165] = new Block (0, 280);
        b[166] = new Block (0, 310);
        b[167] = new Block (0, 340);
        b[168] = new Block (0, 370);
        
        b[169] = new Block (30, 250);
        
        b[170] = new Block (0, 190);
        b[171] = new Block (0, 220);
        b[172] = new Block (0, 250);
        
        // ylimmät neliöpalikat vasemmalta oikealle
        
        b[173] = new Block (210, 140);
        b[174] = new Block (180, 140);
        b[175] = new Block (210, 170);
        b[176] = new Block (180, 170);
        
        b[177] = new Block (390, 140);
        b[178] = new Block (360, 140);
        b[179] = new Block (390, 170);
        b[180] = new Block (360, 170);
        
        b[181] = new Block (570, 120);
        b[182] = new Block (540, 120);
        b[183] = new Block (570, 150);
        b[184] = new Block (540, 150);
        
        b[185] = new Block (750, 120);
        b[186] = new Block (720, 120);
        b[187] = new Block (750, 150);
        b[188] = new Block (720, 150);
        
        // maalialusta
        
        b[189] = new Block (930, 140);
        b[190] = new Block (930, 170);
        b[191] = new Block (960, 140);
        b[192] = new Block (960, 170);
        b[193] = new Block (990, 140);
        b[194] = new Block (990, 170);
        b[195] = new Block (1020, 140);
        b[196] = new Block (1020, 170);
        b[197] = new Block (1050, 140);
        b[198] = new Block (1050, 170);
        b[199] = new Block (1080, 140);
        b[200] = new Block (1080, 170);
        b[201] = new Block (1110, 140);
        b[202] = new Block (1110, 170);
        b[203] = new Block (1140, 140);
        b[204] = new Block (1140, 170);
        b[205] = new Block (1170, 140);
        b[206] = new Block (1170, 170);
        b[207] = new Block (1200, 140);
        b[208] = new Block (1200, 170);
        b[209] = new Block (1230, 140);
        b[210] = new Block (1230, 170);
        b[211] = new Block (1260, 140);
        b[212] = new Block (1260, 170);
    }

    public void tick() {
        //palikoiden tsekkaus
        for ( int i = 0; i<b.length; i++) {
            b[i].tick();
        }
        // sahojen tsekkaus
        for ( int j = 0; j<s.length; j++) {
            s[j].tick();
        }
        //maalin tsekkaus
        for ( int m = 0; m < goal.length; m++){
            goal[m].tick();
        }
        //piikkien tsekkaus
        for ( int n = 0; n < p.length; n++){
            p[n].tick();
        }
        //käännettyjen piikkien tsekkaus
        for ( int vp = 0; vp < pT.length; vp++){
            pT[vp].tick();
        }
        
      player.tick(b, s, p, pT, goal);
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
       for ( int j = 0; j < s.length; j++) {
          s[j].draw(g);
      }
       //maalin piirto
         for ( int m = 0; m < goal.length; m++){
            goal[m].draw(g);
        }
         // piikkien piirto
         for ( int n = 0; n < p.length; n++){
            p[n].draw(g);
            
            // väärinpäin piikkien piirto
        }
         for ( int vp = 0; vp < pT.length; vp++){
            pT[vp].draw(g);
         }
    }

    public void keyPressed(int k) {
     player.keyPressed(k);
    }

    public void keyReleased(int k) {
       player.keyReleased(k);
    }
    
    
    
}
