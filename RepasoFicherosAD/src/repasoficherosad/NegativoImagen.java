/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

/**
 *
 * @author tedax
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class NegativoImagen {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*Crea un programa que cree el negativo de una imagen, para ello debe pedir al usuario el nombre de una imagen y el nombre de salida.
        Si el fichero de salida ya existe se notificará al usuario para que pueda cambiarlo o sobreescribir el fichero. 
        Para crear el negativo de una imagen invertiremos el valor de cada color de un pixel, para ello haremos la siguiente operación por cada color:
        nuevoColor = 255 - valorColor
        Con esto si un color es negro (0,0,0) lo cambiaremos a blanco (255, 255, 255)
         */

        //Pedir al usuario el nombre de la imagen de entrada y salida
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre de la imagen");
        String nombreImagen = scanner.nextLine();
        File ficheroImagenEntrada = new File(nombreImagen);
        System.out.println("Introduce el nombre de la imagen de salida");
        String nombreImagenSalida = scanner.nextLine();
        File ficheroImagenSalida = new File(nombreImagenSalida);

        if (ficheroImagenEntrada.exists()) {
            System.out.println("¿Quieres sobreescribirlo (S/N)?");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("s")) {

            } else if (entrada.equalsIgnoreCase("n")) {

            } else {
                System.out.println("No es una entrada correcta");
            }
        } else {
            System.out.println("El fichero no existe");
        }

        BufferedImage image = ImageIO.read(ficheroImagenEntrada);
        //Obtenemos el ancho y el alto para recorrer la imagen
        int alto = image.getHeight();
        int ancho = image.getWidth();

        //Recorrer la imagen para coger los colores y el negativo   
        for (int x = 0; x < ancho; x++) {
            for (int y = 0; y < alto; y++) {
                int colorImagen = image.getRGB(x, y);
                Color color = new Color(colorImagen);

                //Obtener el RGB
                int rojo = color.getRed();
                int verde = color.getGreen();
                int azul = color.getBlue();

                //Invertir los colores
                int nuevoRojo = 255 - rojo;
                int nuevoVerde = 255 - verde;
                int nuevoAzul = 255 - azul;

                Color nuevoColor = new Color(nuevoRojo, nuevoVerde, nuevoAzul);

                //Establecer el nuevo color de la imagen
                image.setRGB(x, y, nuevoColor.getRGB());

            }
        }
        ImageIO.write(image, "jpg", ficheroImagenSalida);
        System.out.println("Imagen guardada con el nombre: " + nombreImagenSalida);

    }
}


