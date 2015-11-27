/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fameg.domain;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan
 */
public class GravadorDeImagem {
    
    public static void gravarPNG(List<String> texto){
                BufferedImage img = new BufferedImage(800, 800, 1);
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.drawImage(img, 0, 0, null);
        int x=50;
        int y=20;
        for(String linha:texto){
        g2d.drawString(linha, x, y);
        y+=20;
        }
        g2d.dispose();

        try {
            File file = new File("cruzadinha.png");
            ImageIO.write(bufferedImage, "png", file);

        } catch (IOException e) {
        }

    }
    
    public static void saveComponentAsJPEG(Component myComponent,String filename) {
       Dimension size = myComponent.getSize();
       BufferedImage myImage = 
         new BufferedImage(size.width, size.height,
         BufferedImage.TYPE_INT_RGB);
        
       Graphics2D g2 = myImage.createGraphics();
       myComponent.paint(g2);
       
       try {
         OutputStream out = new FileOutputStream(filename+".jpeg");
         JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
         encoder.encode(myImage);
         out.close();
           JOptionPane.showMessageDialog(myComponent, "imagem salva como "+filename+".jpeg");
       } catch (Exception e) {
         System.out.println(e); 
       }
     } 
}
