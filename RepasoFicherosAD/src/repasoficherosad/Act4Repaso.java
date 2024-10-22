/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act4Repaso {
    static List<String> extensiones = new ArrayList<>();
    static List<Integer> contadores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Introduce la ruta del directorio:");
        String ruta = entrada.nextLine();
        
        File directorio = new File(ruta);
        
        if (directorio.exists() && directorio.isDirectory()) {
            
            contarArchivosPorExtension(directorio);
            
            
            System.out.println("\nResultados:");
            for (int i = 0; i < extensiones.size(); i++) {
                System.out.println(extensiones.get(i) + ": " + contadores.get(i) + " archivos");
            }
        } else {
            System.out.println("La ruta proporcionada no es un directorio válido o no existe.");
        }

        entrada.close();
    }

    
    public static void contarArchivosPorExtension(File directorio) {
        File[] archivos = directorio.listFiles(); 
        
        if (archivos != null) { 
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    
                    contarArchivosPorExtension(archivo);
                } else if (archivo.isFile()) {
                    
                    String extension = obtenerExtension(archivo.getName());
                    if (!extension.isEmpty()) {
                        agregarContador(extension);
                    }
                }
            }
        }
    }

    
    public static void agregarContador(String extension) {
        int index = extensiones.indexOf(extension);
        if (index != -1) {
            
            contadores.set(index, contadores.get(index) + 1);
        } else {
            
            extensiones.add(extension);
            contadores.add(1);
        }
    }

    
    public static String obtenerExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0 && i < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(i + 1).toLowerCase(); // 
        }
        return ""; 
    }
}
