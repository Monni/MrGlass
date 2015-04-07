/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameState;

import Game.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Nissinen
 */
public class MenuState extends GameState {

    private String[] options = {"Start", "Credits", "Quit"};
    private int currentSelection = 0;
    private int quitSelection = 0;
    private int selected;
      
    
    
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        
    }

    public void tick() {
      
    }

    public void draw(Graphics g) {
        
        // Valikon staattisten kuvien lataus
        Image menubackground = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\menubackground.png");
        g.drawImage(menubackground, 0, 0, null);
        Image titleImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\title.png");
        g.drawImage(titleImg, 130, 50, null);
        Image startImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\startgame.png");
        g.drawImage(startImg, 780, 280, null);
        Image scoreImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\highscores.png");
        g.drawImage(scoreImg, 780, 380, null);
        Image creditsImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\credits.png");
        g.drawImage(creditsImg, 780, 480, null);
        Image quitImg = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\quitgame.png");
        g.drawImage(quitImg, 780, 580, null);
        
        Image startSelected = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\startgame_selected.png");
        Image scoreSelected = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\highscores_selected.png");
        Image creditsSelected = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\credits_selected.png");
        Image quitSelected = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\quitgame_selected.png");
        
        Image blurredbackground = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\creditsblurredbackground.png");
        Image authors = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\authors.png");
        Image quitquestion = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\quitquestion.png");
        Image quitselector = Toolkit.getDefaultToolkit().getImage("src\\resources\\mainmenu\\quitselector.gif");
        
               // Start valittu
       if(currentSelection == 0) {
        g.drawImage(getSelecterImg(), 650, 300, null);
        g.drawImage(getSelecterFlames(), 715, 296, null);
        g.drawImage(startSelected, 780, 280, null);
        
       }       // High scores valittu
       else if(currentSelection == 1) {
           g.drawImage(getSelecterImg(), 650, 400, null);
           g.drawImage(getSelecterFlames(), 715, 396, null);
           g.drawImage(scoreSelected, 780, 380, null);
       }       // Credits valittu
       else if(currentSelection == 2) {
           g.drawImage(getSelecterImg(), 650, 500, null);
           g.drawImage(getSelecterFlames(), 715, 496, null);
           g.drawImage(creditsSelected, 780, 480, null);
       }       // Quit valittu
       else if(currentSelection == 3) {
           g.drawImage(getSelecterImg(), 650, 600, null);
           g.drawImage(getSelecterFlames(), 715, 596, null);
           g.drawImage(quitSelected, 780, 580, null);
       }       
       
      if ( selected == 2 ) {
          g.drawImage(blurredbackground, 0, 0, null);
          g.drawImage(authors, 440, 250, null);
      } else if ( selected == 3 ) {
          g.drawImage(blurredbackground, 0, 0, null);
          g.drawImage(quitquestion, 440, 250, null);
          if ( quitSelection == 0 )
              g.drawImage(quitselector, 520, 370, null);
          else if ( quitSelection == 1 )
              g.drawImage(quitselector, 665, 370, null);
      }
       
        /* taustan värjäys
        g.setColor(new Color(50,101,200));
        g.fillRect(0,0,GamePanel.WIDTH, GamePanel.HEIGHT);
        */
       /*
        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                g.setColor(Color.RED);                
            }
            else {
                g.setColor(Color.BLACK);
            }
            
        // keskikohdan tsekkaus    g.drawLine(GamePanel.WIDTH / 2, 0, GamePanel.WIDTH / 2 , GamePanel.HEIGHT );
            g.setFont(new Font("Arial", Font.PLAIN, 72));
            // asettelee valikon tekstit
            g.drawString(options[i], GamePanel.WIDTH / 2 - 100, 230 + i * 150);
        }
               */
    }

    
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN && selected == 0 ){
            if(currentSelection < 3) currentSelection++;
            else currentSelection = 0;
            
        } else if (k == KeyEvent.VK_UP && selected == 0 ){
            currentSelection--;
            if(currentSelection < 0){
                currentSelection = 4 - 1;
            }
        } else if (k == KeyEvent.VK_LEFT && selected == 3 ) {
            if (quitSelection == 0) 
                quitSelection = 1;
            else
                quitSelection = 0;
        } else if (k == KeyEvent.VK_RIGHT && selected == 3 ) {
            if (quitSelection == 1)
                quitSelection = 0;
            else
                quitSelection = 1;
        }
        
 
                        
        if (k == KeyEvent.VK_ENTER){
            if (selected == 3 && quitSelection == 0) {
                System.exit(0);
            } else if (selected == 3 && quitSelection == 1) {
                selected = 0;
            }else if(currentSelection == 0 ){
                gsm.states.push(new Level1State(gsm));
               // Start Game
            } else if (currentSelection == 1){
               // selected = 1;
                // High Scores
            }else if (currentSelection == 2){
                selected = 2;
                // Credits
            }else if (currentSelection == 3) {
                selected = 3;
            }
        }
        

                
                
        if (k == KeyEvent.VK_ESCAPE) {
            if ( selected == 0 ) {
                selected = 3;
            } else
            selected = 0;
        }
        

        
        
    }

    
    public void keyReleased(int k) {
        // Nothing..
    }
    
     public Image getSelecterImg(){
          ImageIcon ic = new ImageIcon("src\\resources\\mainmenu\\selector.png");
        return ic.getImage();
    }
     public Image getSelecterFlames() {
         ImageIcon ic = new ImageIcon("src\\resources\\mainmenu\\flames.gif");
         return ic.getImage();
     }
     
}
