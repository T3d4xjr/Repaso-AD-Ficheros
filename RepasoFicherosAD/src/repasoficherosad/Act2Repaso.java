/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act2Repaso {
    public static void main(String[] args) {
        Scanner entrada =new  Scanner(System.in);
        System.out.println("Dime la ruta del directorio:");
        String ruta =entrada.nextLine();
        File archivoRuta =new File(ruta);
        
        if (archivoRuta.exists() && archivoRuta.isDirectory()) {
            System.out.println("Listando archivos y directorios de : " +ruta);
            listarArchivos(archivoRuta);
        }else
        {
            System.out.println("La ruta dada no existe o es un directorio no valido");
        }
    }
    public  static void listarArchivos(File files)
    {
        File[] archivos =files.listFiles();
        
        if(archivos !=null)
        {
            for (File archivo : archivos) {
               if(archivo.isDirectory())
               {
                   System.out.println("Directorio : " +archivo.getAbsolutePath());
                   listarArchivos(archivo);
               }else
               {
                   System.out.println("Archivo : " +archivo.getAbsolutePath());
               }
                
            }
        }
    }
}
