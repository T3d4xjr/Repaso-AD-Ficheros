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
import java.util.Scanner;

/**
 *
 * @author DAM1
 */
public class Act13Repaso {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        
        System.out.println("Introduzca la ruta del fichero que deseas dividir : ");
        String archivoOriginal =entrada.nextLine();
        
        File ficheroOriginal =new File(archivoOriginal);
        if(ficheroOriginal.exists() && ficheroOriginal.isFile())
        {
            System.out.println("El fichero existe ");
        }else{
            System.err.println("El fichero no existe o no es un fichero");
        }
        
         try (BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal))) {
            String linea;
            int numCapitulo = 0; // Contador de capítulos
            BufferedWriter bw = null; // Para escribir en los archivos de capítulos

            while ((linea = reader.readLine()) != null) {
                // Verificar si la línea es un marcador de capítulo
                if (linea.startsWith("Capítulo ")) {
                    // Si es el inicio de un nuevo capítulo, cerrar el archivo anterior si está abierto
                    if (bw != null) {
                        bw.close();
                    }
                    // Incrementar el número de capítulo y abrir un nuevo archivo de salida
                    numCapitulo++;
                    String nombreArchivoCapitulo = archivoOriginal.replace(".txt", "_cap" + numCapitulo + ".txt");
                    bw = new BufferedWriter(new FileWriter(nombreArchivoCapitulo));
                    System.out.println("Creando: " + nombreArchivoCapitulo);
                }
                // Si ya hemos detectado un capítulo, escribimos en el archivo actual
                if (bw != null) {
                    bw.write(linea);
                    bw.newLine();
                }
            }

            // Cerrar el último archivo de capítulo si existe
            if (bw != null) {
                bw.close();
            }

            System.out.println("El archivo se ha dividido en " + numCapitulo + " capítulos.");
            
        } catch (Exception e) {
            System.err.println("Error al leer el archivo" +e.getMessage());
        }
    }
}
