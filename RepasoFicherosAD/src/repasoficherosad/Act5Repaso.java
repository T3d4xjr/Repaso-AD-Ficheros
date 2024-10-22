/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act5Repaso {
    public static void main(String[] args) {
         Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce la ruta del fichero de texto:");
        String ruta = entrada.nextLine();
        
        File fichero = new File(ruta);
        
        if (fichero.exists() && fichero.isFile()) {
          
            leerFicheroTexto(fichero);
        } else {
            System.out.println("El archivo no existe o no es un fichero válido.");
        }

        entrada.close(); 
    }

  
    public static void leerFicheroTexto(File fichero) {
        int contadorLineas = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contadorLineas++;
                System.out.println(contadorLineas + ": " + linea);
            }

            System.out.println("\nTotal de líneas: " + contadorLineas);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el fichero: ");
        }
    }
    
}
