package repasoficherosad;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tedax
 */
public class Act14Repaso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero (ej: ej_13.txt):");
        String nombreFichero = scanner.nextLine();

        // Verificar si el fichero existe
        File fichero = new File(nombreFichero);
        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        // Pedir el capítulo que desea obtener el usuario
        System.out.println("Introduce el número del capítulo que deseas obtener (ej: 1, 2, 3...):");
        int numeroCapitulo = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        String capituloBuscado = "Capítulo " + numeroCapitulo;
        String contenidoCapitulo = buscarCapitulo(fichero, capituloBuscado);

        // Verificar si se encontró el capítulo
        if (contenidoCapitulo == null) {
            System.out.println("El capítulo " + numeroCapitulo + " no se ha encontrado.");
        } else {
            System.out.println("Capítulo " + numeroCapitulo + " encontrado.");
            System.out.println("¿Quieres mostrar el capítulo o guardarlo en un fichero?");
            System.out.println("Escribe 'mostrar' o 'guardar':");
            String accion = scanner.nextLine().trim().toLowerCase();

            if (accion.equals("mostrar")) {
                System.out.println("\n" + contenidoCapitulo);
            } else if (accion.equals("guardar")) {
                System.out.println("Introduce el nombre del fichero donde deseas guardar el capítulo:");
                String nombreNuevoFichero = scanner.nextLine();

                // Verificar si el fichero ya existe
                File nuevoFichero = new File(nombreNuevoFichero);
                while (nuevoFichero.exists()) {
                    System.out.println("El fichero ya existe. Introduce un nuevo nombre de fichero:");
                    nombreNuevoFichero = scanner.nextLine();
                    nuevoFichero = new File(nombreNuevoFichero);
                }

                // Guardar el contenido en un nuevo fichero
                try {
                    escribirFichero(nuevoFichero, contenidoCapitulo);
                    System.out.println("El capítulo se ha guardado en el fichero: " + nombreNuevoFichero);
                } catch (IOException e) {
                    System.out.println("Error al escribir en el fichero: " + e.getMessage());
                }
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    // Método para buscar el capítulo en el fichero
    public static String buscarCapitulo(File fichero, String capituloBuscado) {
        String contenidoCapitulo = "";
        boolean capituloEncontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Capítulo") && capituloEncontrado) {
                    break;  // Al encontrar otro capítulo se termina la búsqueda
                }

                if (linea.trim().equalsIgnoreCase(capituloBuscado)) {
                    capituloEncontrado = true; // Encontró el capítulo
                    contenidoCapitulo += linea + "\n"; // Concatenar la línea al contenido del capítulo
                } else if (capituloEncontrado) {
                    contenidoCapitulo += linea + "\n"; // Concatenar líneas hasta el siguiente capítulo
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }

        return capituloEncontrado ? contenidoCapitulo : null;
    }

    // Método para escribir el contenido en un fichero
    public static void escribirFichero(File nuevoFichero, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nuevoFichero))) {
            writer.write(contenido);
        }
    }
}
