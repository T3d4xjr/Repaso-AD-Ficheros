/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author tedax
 */
public class Ejerc8Teoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del archivo de imagen
        System.out.print("Introduce el nombre de la imagen (con extensión, por ejemplo imagen.jpg): ");
        String nombreArchivo = scanner.nextLine();

        try {
            // Cargar la imagen
            File archivoImagen = new File(nombreArchivo);
            BufferedImage imagen = ImageIO.read(archivoImagen);

            // Obtener ancho, alto y número de píxeles
            int ancho = imagen.getWidth();
            int alto = imagen.getHeight();
            int numeroPixeles = ancho * alto;

            // Mostrar información de la imagen
            System.out.println("Ancho: " + ancho + " píxeles");
            System.out.println("Alto: " + alto + " píxeles");
            System.out.println("Número total de píxeles: " + numeroPixeles);

            // Pedir el nuevo nombre y formato
            System.out.print("Introduce el nuevo nombre (sin extensión, por ejemplo nueva_imagen): ");
            String nuevoNombre = scanner.nextLine();

            // Guardar la imagen en el nuevo formato
            File nuevoArchivo = new File(nuevoNombre + "." + "jpg");
            ImageIO.write(imagen, "jpg", nuevoArchivo);

            System.out.println("Imagen guardada como: " + nuevoArchivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al procesar la imagen: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
