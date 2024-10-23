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
public class Actividad1Repaso {
    public static void main(String[] args) {
         Scanner entrada =new  Scanner(System.in);
        
        System.out.println("Dame una ruta");
        String ruta =entrada.nextLine();
        
        
        
        File file = new File(ruta);
        
        if(file.exists())
        {
            System.out.println("La archivo existe"+"\n");
        }if (file.isFile())
            
        {
            System.err.println("El archivo es un fichero");
            
           if(file.canRead())
            {
                System.out.println(" EL archivo "+file+" se puede leer ");
            }else
            {
                System.out.println(" EL archivo "+file+" no se puede leer ");
            }
            if(file.canExecute())
            {
               System.out.println(" EL archivo "+file+" se puede ejecutar ");
            }else
            {
                System.out.println(" EL archivo "+file+" no se puede ejecutar ");
            }
            if(file.canWrite())
            {
                System.out.println(" EL archivo "+file+" se puede escribir ");
            }else
            {
                System.out.println(" EL archivo "+file+" no se puede escribir ");
            } 
        
        }if(file.isDirectory())
        {
            System.out.println("El archivo es un directorio");
          File[] files =file.listFiles();
            for (File f : files) {
           if(f.canRead())
            {
                System.out.println(" EL archivo "+f+" se puede leer ");
            }else
            {
                System.out.println(" EL archivo "+f+" no se puede leer ");
            }
            if(f.canExecute())
            {
               System.out.println(" EL archivo "+f+" se puede ejecutar ");
            }else
            {
                System.out.println(" EL archivo "+f+" no se puede ejecutar ");
            }
            if(f.canWrite())
            {
                System.out.println(" EL archivo "+f+" se puede escribir ");
            }else
            {
                System.out.println(" EL archivo "+f+" no se puede escribir ");
            } 
        }  
        }else
        {
            System.out.println("El archivo no es un fichero ni un directorio");
        }
       
        
        
        
        
    }
   
}
