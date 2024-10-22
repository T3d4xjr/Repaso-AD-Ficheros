/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act6Repaso {
    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce la ruta del fichero donde deseas escribir:");
        String ruta = entrada.nextLine();

        File fichero = new File(ruta);

        // Verificar si el fichero ya existe
        if (fichero.exists()) {
            System.out.println("El fichero ya existe. ¿Deseas sobrescribirlo (s) o añadir al final (a)?");
            String opcion = entrada.nextLine();

            if (opcion.equalsIgnoreCase("s")) {
                escribirEnFichero(fichero, false); // Sobrescribir
            } else if (opcion.equalsIgnoreCase("a")) {
                escribirEnFichero(fichero, true); // Añadir al final
            } else {
                System.out.println("Opción no válida. Finalizando programa.");
            }
        } else {
            // Si el fichero no existe, se creará y se escribirá el contenido
            escribirEnFichero(fichero, false);
        }

        entrada.close(); // Cerrar el escáner
    }

    // Método para escribir en el fichero usando BufferedWriter
    public static void escribirEnFichero(File fichero, boolean añadir) {
        Scanner entrada = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, añadir))) {
            System.out.println("Introduce las líneas de texto (escribe 'salir' para terminar):");
            String linea;
            boolean loop=true;
            // Leer múltiples líneas hasta que el usuario escriba "salir"
            while (loop) {
                linea = entrada.nextLine();
                if (linea.equalsIgnoreCase("salir")) {
                    break;
                }
                bw.write(linea); 
                bw.newLine();    
                bw.flush();
            }

            System.out.println("El contenido ha sido guardado en el fichero: " + fichero.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero: ");
        }
    } 
}

