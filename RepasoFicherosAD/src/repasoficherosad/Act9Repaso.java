/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act9Repaso {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo binario donde deseas guardar los números:");
        String rutaArchivo = scanner.nextLine();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {
            System.out.println("Introduce los números enteros (escribe 'fin' para terminar):");
            boolean loop =true;
            
            while (loop) {
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("fin")) {
                    break; 
                }

                try {
                    int numero = Integer.parseInt(entrada); 
                    dos.writeInt(numero); 
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduce un número entero válido o 'fin' para terminar.");
                }
            }

            System.out.println("Los números han sido guardados correctamente en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    } 
}
