/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DAM1
 */
public class Act11Repaso {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dime el nombre del fichero");
        String nombreFichero =entrada.nextLine();

        try {
            
            List<Integer> numeros = leerBinarioFichero(nombreFichero);

            
            List<Integer> positivos = new ArrayList<>();
            List<Integer> negativos = new ArrayList<>();
            for (Integer numero : numeros) {
                if (numero >= 0) {
                    positivos.add(numero);
                } else {
                    negativos.add(numero);
                }
            }

           
            System.out.println("Números positivos: " + positivos.size());
            System.out.println("Números negativos: " + negativos.size());
            
            
            System.out.print("¿Quieres guardar el fichero de positivos (p), negativos (n), o ambos (a)? ");
            String opcion = entrada.nextLine().toLowerCase();
            
            
            
            File archivoTemporalPositivos = File.createTempFile("temp_positivos_", ".dat");
            File archivoTemporalNegativos = File.createTempFile("temp_negativos_", ".dat");

            // Guardar los números filtrados en archivos temporales
            guardarBinarioFichero(archivoTemporalPositivos.getAbsolutePath(), positivos);
            guardarBinarioFichero(archivoTemporalNegativos.getAbsolutePath(), negativos);
            
            switch (opcion) {
                case "p":
                    System.out.print("Introduce el nombre para guardar el fichero de positivos: ");
                    String nombrePositivos = entrada.nextLine();
                    guardarBinarioFichero(nombrePositivos, positivos);
                    // A la hora de eliminar el archivo hay dos formas eliminando el temporal o llamado a una funcion.
                    archivoTemporalNegativos.delete();
                    eliminarFichero(archivoTemporalNegativos.getAbsolutePath());
                    break;
                case "n":
                    System.out.print("Introduce el nombre para guardar el fichero de negativos: ");
                    String nombreNegativos = entrada.nextLine();
                    guardarBinarioFichero(nombreNegativos, negativos);
                    break;
                case "a":
                    System.out.print("Introduce el nombre para guardar el fichero de positivos: ");
                    nombrePositivos = entrada.nextLine();
                    guardarBinarioFichero(nombrePositivos, positivos);
                    System.out.print("Introduce el nombre para guardar el fichero de negativos: ");
                    nombreNegativos = entrada.nextLine();
                    guardarBinarioFichero(nombreNegativos, negativos);
                    break;
                default:
                    System.out.println("Opción no válida. No se guardará ningún fichero.");
                    break;
            }

            System.out.println("Operación completada.");
            entrada.close(); 

        } catch (IOException e) {
            System.err.println("Error al procesar el fichero: " + e.getMessage());
        }
    }

     private static List<Integer> leerBinarioFichero(String nombreFichero) throws IOException {
        List<Integer> numeros = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(nombreFichero))) {
            while (dis.available() > 0) {
                numeros.add(dis.readInt());
            }
        }
        return numeros;
    }

    private static void guardarBinarioFichero(String nombreFichero, List<Integer> numeros) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombreFichero))) {
            for (Integer numero : numeros) {
                dos.writeInt(numero);
               
            }
        }
        System.out.println("Fichero " + nombreFichero + " guardado.");
    }

    private static void eliminarFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        if (fichero.delete()) {
            System.out.println("Fichero " + nombreFichero + " eliminado.");
        } else {
            System.out.println("No se pudo eliminar el fichero " + nombreFichero + ".");
        }
    }
}
