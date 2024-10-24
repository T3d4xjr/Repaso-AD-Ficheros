/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        
        try {
            BufferedReader br =new BufferedReader(new FileReader(ficheroOriginal));
            String linea;
            
            while((linea =br.readLine()) !=null)
            {
            
            }
            
        } catch (Exception e) {
            System.err.println("Error al leer el archivo" +e.getMessage());
        }
    }
}
