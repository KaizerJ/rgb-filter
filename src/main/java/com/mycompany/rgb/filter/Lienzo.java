package com.mycompany.rgb.filter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Lienzo extends JPanel{

    enum LogoPos {
        UPPER_LEFT(0, 0), 
        UPPER_RIGHT(890, 0), 
        LOWER_LEFT(0, 640), 
        LOWER_RIGHT(890, 640);
        
        private final int posx;
        private final int posy;
        
        LogoPos(int posx, int posy){
            this.posx = posx;
            this.posy = posy;
        }

        public int getPosx() {
            return posx;
        }

        public int getPosy() {
            return posy;
        }
    }
    
    private BufferedImage image = null;
    private boolean red = true;
    private boolean green = true;
    private boolean blue = true;
    private BufferedImage logo;
    private LogoPos logoPos = LogoPos.UPPER_RIGHT;

    public Lienzo() {
        try {
            this.image = ImageIO.read(new URL("https://www.fonditos3d.com/1024x768/canicas-de-colores-3d.jpg"));
            this.logo = ImageIO.read(Lienzo.class.getResourceAsStream("/images/105756_triangle_512x512.png"));
            this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(UtilsPractica5.seleccionarComponentes(this.image, 
                                                          red, green, blue), 
                    0, 0, null);
        g.drawImage(logo, this.logoPos.posx, this.logoPos.posy, null);
    }
    
    public void setRedState(boolean active){
        this.red = active;
    }
    
    public void setGreenState(boolean active){
        this.green = active;
    }
    
    public void setBlueState(boolean active){
        this.blue = active;
    }
    
    public void setLogoPos(LogoPos logopos){
        this.logoPos = logopos;
    }
    
}
