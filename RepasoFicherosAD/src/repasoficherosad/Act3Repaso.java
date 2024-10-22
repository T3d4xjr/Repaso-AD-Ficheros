/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act3Repaso {
    public static void main(String[] args) {
        Scanner entrada =new  Scanner(System.in);
        System.out.println("Dime la ruta del directorio para ver informacion de sus ficheros:");
        String ruta =entrada.nextLine();
        File archivoRuta =new File(ruta);
        
        if(archivoRuta.exists() && archivoRuta.isFile())
        {
            System.out.println("Mostrar las propiedad detalladas de los ficheros en esta ruta : " +ruta);
            
                System.out.println(archivoRuta.getName());
                System.out.println(archivoRuta.length());
                Date fecha = new Date(archivoRuta.lastModified());
                System.out.println(fecha);
                SimpleDateFormat sdf = new SimpleDateFormat("d M y");
                System.out.println(sdf.format(fecha));
                
                 if(archivoRuta.canRead())
                {
                    System.out.println(" EL archivo "+archivoRuta+" se puede leer ");
                }else
                {
                    System.out.println(" EL archivo "+archivoRuta+" no se puede leer ");
                }
                if(archivoRuta.canExecute())
                {
                   System.out.println(" EL archivo "+archivoRuta+" se puede ejecutar ");
                }else
                {
                    System.out.println(" EL archivo "+archivoRuta+" no se puede ejecutar ");
                }
                if(archivoRuta.canWrite())
                {
                    System.out.println(" EL archivo "+archivoRuta+" se puede escribir ");
                }else
                {
                    System.out.println(" EL archivo "+archivoRuta+" no se puede escribir ");
                }
                if(archivoRuta.isHidden())
                {
                    System.out.println("El archivo " +archivoRuta+ " es oculto");
                }else
                {
                    System.out.println("El archivo " +archivoRuta+ " no es oculto");
                }
            
            
        }
    }
}
