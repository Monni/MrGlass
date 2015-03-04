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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JLabel;

/**
 *
 * @author h4211
 */
public class Mainmenu extends JPanel {

    private Window window;
    
    public Mainmenu(Window window) {
        this.window = window;
    
    // Layout pois, että omat sijainnit toimivat
    setLayout(null);
     
    
    // Valikon kuvien lataus
    ImageIcon titleImage = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\mainmenu\\title.png");    
    ImageIcon startImage = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\mainmenu\\startgame.png");
    ImageIcon scoreImage = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\mainmenu\\highscores.png");
    ImageIcon creditsImage = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\mainmenu\\credits.png");
    ImageIcon quitImage = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\mainmenu\\quitgame.png");
    
    // Titlen ja nappien luominen
    JLabel title = new JLabel(titleImage);
    JButton startButton = new JButton(startImage);
    JButton scoreButton = new JButton(scoreImage);
    JButton creditsButton = new JButton (creditsImage);
    JButton quitButton = new JButton (quitImage);

    // Sijainnin ja koon määritys
    title.setBounds(130, 50, titleImage.getIconWidth(), titleImage.getIconHeight());
    startButton.setBounds(780, 260, startImage.getIconWidth(), startImage.getIconHeight());
    scoreButton.setBounds(780, 360, scoreImage.getIconWidth(), scoreImage.getIconHeight());
    creditsButton.setBounds(780, 460, creditsImage.getIconWidth(), creditsImage.getIconHeight());
    quitButton.setBounds(780, 560, quitImage.getIconWidth(), quitImage.getIconHeight());
 
    // Reunojen ja fillin poisto
    startButton.setBorderPainted(false);
    startButton.setContentAreaFilled(false);
    scoreButton.setBorderPainted(false);
    scoreButton.setContentAreaFilled(false);
    creditsButton.setBorderPainted(false);
    creditsButton.setContentAreaFilled(false);
    quitButton.setBorderPainted(false);
    quitButton.setContentAreaFilled(false);
 
    // Lisätään JPaneliin
    add(title);
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
 


    

