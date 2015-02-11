/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jamk.fi.MrGlass;

import javax.swing.JFrame;

/**
 *
 * @author Nissinen
 */


//Luo ikkunan
public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Super system mk 2000 sweeper deeper 3");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GameFrame());
        frame.setVisible(true);
    }
}
