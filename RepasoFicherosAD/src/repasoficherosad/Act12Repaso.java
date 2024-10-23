/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act12Repaso {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        
        
        List<String> nombreArchivos = new ArrayList<>();
        System.out.println("Introduce los nombres de los ficheros de texto a combinar (escribe 'fin' para terminar):");
        boolean loop =true;
        while (loop) {
            String archivoNombre = entrada.nextLine();
            if (archivoNombre.equalsIgnoreCase("fin")) {
                break;
            }
            nombreArchivos.add(archivoNombre);
        }
        System.out.println("Nombre del archivo para combinar los otros ficheros :");
        String ficheroCombinado =entrada.nextLine();

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroCombinado))) {
            for (String nombreArchivo : nombreArchivos) {
                File archivoEntrada = new File(nombreArchivo);
                if (archivoEntrada.exists() && archivoEntrada.isFile()) {
                    
                    bw.write("Contenido de: " + nombreArchivo);
                    bw.newLine();
                    bw.flush();

                    
                    try (BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada))) {
                        String linea;
                        while ((linea = reader.readLine()) != null) {
                            bw.write(linea);
                            bw.newLine();
                            bw.flush();
                        }
                    }
                    
                    bw.newLine();
                } else {
                    System.out.println("El fichero " + nombreArchivo + " no existe o no es un fichero válido.");
                }
            }
            System.out.println("Ficheros combinados en: " + ficheroCombinado);
        } catch (IOException e) {
            System.err.println("Error al combinar los ficheros: " + e.getMessage());
        } 
    }
}
