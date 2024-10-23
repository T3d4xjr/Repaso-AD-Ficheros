/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act10Repaso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo binario donde se guardan guardar los nº:");
        String rutaArchivo = scanner.nextLine();
        
        try (DataInputStream dis =new DataInputStream(new FileInputStream(rutaArchivo))){
            boolean loop =true;
            
            while (loop) {
            int numero = dis.readInt();
                System.out.println(numero);
            }
        } catch (Exception e) {
        }
    }
 
}
