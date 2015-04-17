/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameState.GameStateManager;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Nissinen
 */
public class GamePanel extends JPanel implements Runnable, KeyListener {
   
    
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    
    private Thread thread;
    private boolean isRunning = false;
    
    private int FPS = 60;
    private  long targetTime = 1000 / FPS;
    
    private GameStateManager gsm;
    
    public GamePanel(){
        setPreferredSize (new Dimension(WIDTH,HEIGHT));
        
        addKeyListener(this);
        setFocusable(true);
        
        start();
    }
    
    private void start(){
        isRunning = true;
        thread = new Thread (this);
        thread.start();
    }
    
    public void run() {
        long start, elapsed, wait;
        
        gsm = new GameStateManager();
        
        while(isRunning) {
            start = System.nanoTime();
            
            tick();
            repaint();
            
            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;
            
            if(wait <= 0){
                wait = 5;
            }
            
            try{
                Thread.sleep(wait);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //päivittäjä updater
    public void tick(){
        
       //kutsuu GameStateManagerin ticks metodia
        gsm.tick();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // putsaa ruudun ennen seuraavan kerroksen piirtämistä
        g.clearRect(0,0,WIDTH,HEIGHT);
        
        //kutsuu GameStateManagerin draw metodia
        gsm.draw(g);
    }
    
    public void keyPressed(KeyEvent e) {
        
        gsm.keyPressed(e.getKeyCode());
        
    }
    
    public void keyReleased(KeyEvent e) {
        
        gsm.keyReleased(e.getKeyCode());
        
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
}
