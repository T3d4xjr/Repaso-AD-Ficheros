/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RotarImagen {
     public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("introduce el nombre de la imagen original");
        String imagenOriginal = scanner.nextLine();
        File ficheroOriginal = new File(imagenOriginal);
        BufferedImage originalImage = ImageIO.read(ficheroOriginal);
        try {

            // Calcular las dimensiones de la nueva imagen
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();
            BufferedImage rotatedImage = new BufferedImage(height, width, originalImage.getType());

            // Crear un objeto Graphics2D para la rotación
            Graphics2D g2d = rotatedImage.createGraphics();

            // Rotar la imagen 90 grados
            g2d.rotate(Math.toRadians(90), height / 2.0, height / 2.0); //2.0 para que la rotacion se rote desde el centro
            g2d.drawImage(originalImage, (height - width) / 2, (width - height) / 2, null);
            g2d.dispose();

            // Guardar la imagen girada
            String nombreficheroImagenRotada = "imagenRotada.jpg";
            File ficheroRotado = new File(nombreficheroImagenRotada);
            ImageIO.write(rotatedImage, "jpg", ficheroRotado);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
