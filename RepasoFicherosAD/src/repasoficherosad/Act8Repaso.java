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
import java.util.Scanner;


/**
 *
 * @author tedax
 */
public class Act8Repaso {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Introduce la ruta del archivo de texto:");
        String rutaEntrada = scanner.nextLine();

       
        File archivoEntrada = new File(rutaEntrada);
        if (!archivoEntrada.exists() || !archivoEntrada.isFile()) {
            System.out.println("El archivo no existe o no es un archivo válido.");
            return;
        }

     
        System.out.println("Introduce la palabra que deseas reemplazar:");
        String palabraOriginal = scanner.nextLine();
        System.out.println("Introduce la nueva palabra:");
        String nuevaPalabra = scanner.nextLine();

     
        System.out.println("Introduce la ruta del archivo de salida:");
        String rutaSalida = scanner.nextLine();

     
        try {
            reemplazarPalabras(archivoEntrada, rutaSalida, palabraOriginal, nuevaPalabra);
            System.out.println("Las palabras han sido reemplazadas y guardadas en el archivo: " + rutaSalida);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }

        scanner.close();
    }

  
    public static void reemplazarPalabras(File archivoEntrada, String rutaSalida, String palabraOriginal, String nuevaPalabra) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida));
        String linea;

        
        while ((linea = br.readLine()) != null) {
       
            String lineaModificada = linea.replaceAll("\\b" + palabraOriginal + "\\b", nuevaPalabra);
          
            bw.write(lineaModificada);
            bw.newLine();
            bw.flush();
        }

        
        br.close();
        bw.close();
    }
}


