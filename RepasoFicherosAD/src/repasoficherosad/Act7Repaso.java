/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act7Repaso {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        
        System.out.println("Digame una ruta de fichero");
        String ruta =entrada.nextLine();
        
        File archivoRuta=new File(ruta);
        
        if(archivoRuta.exists() && archivoRuta.isFile()){
        
            System.out.println("Introduzca la palabra a buscar: ");
            String palabraBuscar =entrada.nextLine();
            int contador =0;
            
            try {
                contador =leerFichero(archivoRuta, palabraBuscar);
                System.out.println("La palabra : "+palabraBuscar+" aparece : " +contador +" en la ruta " +ruta);
            } catch (Exception e) {
                
                System.err.println("Error al leer el archivo" +e.getMessage());
            }
            
        } else{
            System.err.println("No se a podido encontrar un fichero valido");
        }
    }
    
    
    public static int leerFichero(File archivoRuta, String palabraBuscar) throws FileNotFoundException, IOException
    {
        BufferedReader br= new BufferedReader(new FileReader(archivoRuta));
        String linea;
        int contador =0;
        
        while ((linea =br.readLine()) !=null) {
        String[] palabras =linea.split(" ");
            for (String palabra : palabras) {
                if (palabra.equalsIgnoreCase(palabraBuscar)) {
                    contador++;
                }
            }
            
        }
        br.close();
        return contador;
    }
}
