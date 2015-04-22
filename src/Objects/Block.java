/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Nissinen
 */
public class Block extends Rectangle {
    
    private int style;
    
    
    
    private static final int blockSize = 30;
    
    public Block (int x, int y, int style) {
        
        setBounds(x, y, blockSize, blockSize);
        this.style = style;
    }

    public Image getBlockStyle() {
        //tyhjä keskipala
         if(style == 1){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\Keskipala.png");
        return blockStyle.getImage();
        }
         
         //oikea kulma
        if(style == 2){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\oikeakulma.png");
        return blockStyle.getImage();
        }
        
         //vasen kulma         
        if(style == 3){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\vasenkulma.png");
        return blockStyle.getImage();
        }
        
        // AlaSuora
        if(style == 4){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\AlaSuora.png");
        return blockStyle.getImage();
        }
                
        //kumpu
        if(style == 5){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\kumpu.png");
        return blockStyle.getImage();
        }
        
        //kummun korotuspala
        if(style == 6){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\kummunkorotus.png");
        return blockStyle.getImage();
        }
        
        // neliön oikea yläpala
        if(style == 7){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\nelioOikeaYlaKulma.png");
        return blockStyle.getImage();
        }
        
        //neliön oikea alapala
        if(style == 8){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\nelioOikeaAlaKulma.png");
        return blockStyle.getImage();
        }
        
        // neliön vasen yläpala
        if(style == 9){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\nelioVasenYlaKulma.png");
        return blockStyle.getImage();
        }
        
        // neliön vasen alapala
        if(style == 10){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\nelioVasenAlaKulma.png");
        return blockStyle.getImage();
        }
        
        //montunpohja
        if(style == 11){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\monttu.png");
        return blockStyle.getImage();
        }
        
        //vasen reuna
        if(style == 12){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\vasenReuna.png");
        return blockStyle.getImage();
        }

        //vasen pystyseinä
        if(style == 13){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\pystysuoravasen.png");
        return blockStyle.getImage();
        }
        
        //oikea pystyseinä
        if(style == 14){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\pystysuoraoikea.png");
        return blockStyle.getImage();
        }
        
        //vasen liitospala
        if(style == 15){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\Pienkulma.png");
        return blockStyle.getImage();
        }
        
        //oikea reuna
        if(style == 16){
          ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\oikeaReuna.png");
        return blockStyle.getImage();
        }
        
        
        /////////////////
        // METAL WORLD
        /////////////////
        //metalli yleis
        if(style == 17) {
        ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\metalworld\\Metalli.png");
        return blockStyle.getImage();
        }
        //metalli vasen reuna
        if(style == 18) {
        ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\metalworld\\MetalliVasen.png");
        return blockStyle.getImage();
        }
        //metalli oikea reuna
        if(style == 19) {
            ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\metalworld\\MetalliOikea.png");
        return blockStyle.getImage();
        }
        // nollalla suora 
         else {
        ImageIcon blockStyle = new ImageIcon("src\\jamk\\fi\\MrGlass\\images\\grassworld\\suora.png");
        return blockStyle.getImage();
         }
    
}
    
    public void tick () {
    }
    
  
    public void draw (Graphics g) {
        g.drawImage(getBlockStyle(), (int) x, (int) y, null);
    }
    
}
