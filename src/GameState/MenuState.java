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
import java.awt.event.KeyEvent;

/**
 *
 * @author Nissinen
 */
public class MenuState extends GameState {

    private String[] options = {"Start", "Credits", "Quit"};
    private int currentSelection = 0;
    
    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    public void init() {
        
    }

    public void tick() {
      
    }

    public void draw(Graphics g) {
        /* taustan värjäys
        g.setColor(new Color(50,101,200));
        g.fillRect(0,0,GamePanel.WIDTH, GamePanel.HEIGHT);
        */
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
    }

    
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_DOWN){
            currentSelection++;
            if (currentSelection >= options.length){
                currentSelection = 0;
            }
        } else if (k == KeyEvent.VK_UP){
            currentSelection--;
            if(currentSelection < 0){
                currentSelection = options.length - 1;
            }
        }
        if (k == KeyEvent.VK_ENTER){
            if(currentSelection == 0 ){
                gsm.states.push(new Level1State(gsm));
               //play
            } else if (currentSelection == 1){
                // credits
            }else if (currentSelection == 2){
                //quit
                System.exit(0);
            }
        }
    }

    
    public void keyReleased(int k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
