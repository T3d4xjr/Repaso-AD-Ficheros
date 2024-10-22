/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repasoficherosad;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Actividad1Transparencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada =new  Scanner(System.in);
        
        System.out.println("Dame una ruta");
        String ruta =entrada.nextLine();
        
        
        File file = new File(ruta);
        if(file.isFile())
        {
            System.out.println("Esta ruta es un fichero");
        }else if(file.isDirectory())
        {
             System.out.println("Esta es una ruta que contiene");
             File[] files =file.listFiles();
             if(files != null)
             {
                 for (File f : files) {
                     if (f.isFile()) {
                         System.out.println("_ " +f.getName());
                     }if(f.isDirectory())
                     {
                         System.out.println("d "+f.getName());
                         
                     }else
                     {
                         System.out.println("? "+f.getName());
                     }
                     
                 }
             }
        }
    }
    
}
