/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jamk.fi.MrGlass;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author h4211
 */
public class Window extends JFrame {

 // Ladataan Mainmenu() uuteen paneeliin menu
 JPanel menu = new Mainmenu(this);

    public Window() {
      
        setTitle("Super whooperdooper <9000                    (Eli Mr Glass)");
        setPreferredSize(new Dimension(1280, 720));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
 
        
        // menu näkyväksi
        menu.setVisible(true);
        // Lisätään menu JFrameen 
        add(menu);
        
        
        setVisible(true); 
       
    }
    
    
    // Pelin käynnistys, kun start-nappia painetaan Mainmenu();ssa
    void start() {
        
        getContentPane().add(new GameFrame(),BorderLayout.CENTER);
        
        // Piilotetaan aiemmin ladattu JPanel
        menu.setVisible(false);
        
        setVisible(true); 
    }
    
         
     
    public static void main(String args[]) {
        new Window();
    }
}
