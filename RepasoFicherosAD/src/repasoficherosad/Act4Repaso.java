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
        
        // Verificar si el directorio es válido
        if (directorio.exists() && directorio.isDirectory()) {
            // Llamar al método recursivo para contar archivos
            contarArchivosPorExtension(directorio);
            
            // Mostrar los resultados
            System.out.println("\nResultados:");
            for (int i = 0; i < extensiones.size(); i++) {
                System.out.println(extensiones.get(i) + ": " + contadores.get(i) + " archivos");
            }
        } else {
            System.out.println("La ruta proporcionada no es un directorio válido o no existe.");
        }

        entrada.close(); // Cerrar el escáner
    }

    // Método recursivo para contar archivos por extensión
    public static void contarArchivosPorExtension(File directorio) {
        File[] archivos = directorio.listFiles(); // Obtener los archivos en el directorio

        if (archivos != null) { // Comprobar que la lista no es nula
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    // Llamada recursiva para subdirectorios
                    contarArchivosPorExtension(archivo);
                } else if (archivo.isFile()) {
                    // Obtener la extensión del archivo
                    String extension = obtenerExtension(archivo.getName());
                    if (!extension.isEmpty()) {
                        agregarContador(extension);
                    }
                }
            }
        }
    }

    // Método para agregar o incrementar el contador para una extensión
    public static void agregarContador(String extension) {
        int index = extensiones.indexOf(extension);
        if (index != -1) {
            // Si la extensión ya existe en la lista, incrementamos su contador
            contadores.set(index, contadores.get(index) + 1);
        } else {
            // Si la extensión no existe, la añadimos a la lista
            extensiones.add(extension);
            contadores.add(1);
        }
    }

    // Método para obtener la extensión del archivo
    public static String obtenerExtension(String nombreArchivo) {
        int i = nombreArchivo.lastIndexOf('.');
        if (i > 0 && i < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(i + 1).toLowerCase(); // Devolver la extensión en minúsculas
        }
        return ""; // Si no tiene extensión
    }
}
