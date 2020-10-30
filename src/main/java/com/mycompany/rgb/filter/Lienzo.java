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

    private BufferedImage image = null;

    public Lienzo() {
        try {
            this.image = ImageIO.read(new URL("https://www.fonditos3d.com/1024x768/canicas-de-colores-3d.jpg"));
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
        
        /*g.drawImage(UtilsPractica5.seleccionarComponentes(this.image, 
                                                          true, true, true), 
                    0, 0, null);*/
        g.drawImage(image, 0, 0, null);
    }
    
}
