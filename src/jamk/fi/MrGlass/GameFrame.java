/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.fi.MrGlass;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Nissinen
 */
public class GameFrame extends JPanel implements ActionListener{
    
    Timer mainTimer;
   Player MRglass;
    //luodaan taulukko piikeille
   static ArrayList <Saw> sirkkelit = new ArrayList<Saw>(); 
   static ArrayList<Spikes> piikit = new ArrayList<Spikes>();
   
    public GameFrame() {
        setFocusable(true);
        
        MRglass = new Player(50,630);
        
        addKeyListener(new KeyAdapt(MRglass));
       
        //lisätään olioita taulukkoon
        mainTimer = new Timer(10, this);
        mainTimer.start();
        piikit.add(new Spikes(200,550));
        piikit.add(new Spikes(400,300));
        //piikki lista
        
        sirkkelit.add(new Saw(400,630));
        sirkkelit.add(new Saw(200,250));

        
    }
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        MRglass.draw(g2d);
        
        //tulostetaan piikit ja piirretään näytölle
        for (int i = 0; i < piikit.size(); i++) {
            Spikes tempSpikes = piikit.get(i);
            tempSpikes.draw(g2d);
        }
        for (int i = 0; i < sirkkelit.size(); i++) {
            Saw tempSaw = sirkkelit.get(i);
            tempSaw.draw(g2d);
        }
       
    }
    
    public void actionPerformed(ActionEvent arg0) {
        repaint();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent ae) {
       repaint();
       MRglass.update();
    }
    public void addSpikes(Spikes piikki) {
        piikit.add(piikki);
    }
    public void addSaw(Saw sirkkeli) {
        sirkkelit.add(sirkkeli);
    }
    //static myös taulukkoon!
    public static ArrayList<Spikes> getSpikesList(){
        return piikit;
    }
    public static ArrayList<Saw> getSawList(){
        return sirkkelit;
    }
    
}

