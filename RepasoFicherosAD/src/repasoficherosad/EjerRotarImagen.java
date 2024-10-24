/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author tedax
 */
public class EjerRotarImagen {
     public static void main(String[] args) throws IOException {
        BufferedImage bi = ImageIO.read(new File("Foto.jpg"));
        int ancho = bi.getWidth();
        int alto = bi.getHeight();
        BufferedImage biw = new BufferedImage(ancho, alto, bi.getType());

        for(int i = 0; i < alto; i++) {
            for(int j = 0; j < ancho; j++) {
                // Corregimos el acceso para evitar "out of bounds"
                biw.setRGB(ancho -j -1, alto - i - 1, bi.getRGB(j, i));
            }
        }
        ImageIO.write(biw, "jpg", new File("FotoRotada.jpg"));
    }
}
