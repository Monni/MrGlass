/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jamk.fi.MrGlass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author h4211
 */
public class Mainmenu extends JPanel {

    private Window window;
    
    public Mainmenu(Window window) {
        this.window = window;
    
    //JPanel menu = new JPanel();
    //setSize(1280, 720);
    //setVisible(true);
      
                 
    ImageIcon startImage = new ImageIcon("F:/mario.png");
    ImageIcon scoreImage = new ImageIcon("F:/mario.png");
    ImageIcon creditsImage = new ImageIcon("F:/mario.png");
    ImageIcon quitImage = new ImageIcon("F:/mario.png");
         
    JButton startButton = new JButton("Start game", startImage);
    JButton scoreButton = new JButton("High Scores", scoreImage);
    JButton creditsButton = new JButton ("Credits", creditsImage);
    JButton quitButton = new JButton ("Quit game", quitImage);

    
    startButton.setBounds(900, 200, 250, 70);
    scoreButton.setBounds(900, 300, 250, 70);
    creditsButton.setBounds(900, 400, 250, 70);
    quitButton.setBounds(900, 500, 250, 70);
    
    
 
    add(startButton);
    add(scoreButton);
    add(creditsButton);
    add(quitButton);
    repaint();
    
    startButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //setVisible(false);
            window.start();
            
            
        }
    });
    }
    }
 


    

