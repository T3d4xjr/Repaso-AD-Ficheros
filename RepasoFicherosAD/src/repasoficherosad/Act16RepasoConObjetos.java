/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act16RepasoConObjetos {
     public static void main(String[] args) throws IOException {

        // Pedir al usuario el nombre del fichero CSV a leer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el archivo CSV a leer:");
        String nombreArchivo = scanner.nextLine();
        File file = new File(nombreArchivo);

        // Leer el fichero CSV
        List<Producto> productos = leerArchivoCSV(file);

        int opcion = 0;
        // Menú
        do {
            System.out.println("Elige la opción que quieras hacer:");
            System.out.println("1. Crear nuevo producto");
            System.out.println("2. Modificar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Guardar productos");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    crearProductos(productos);
                    break;
                case 2:
                    modificarProducto(productos);
                    break;
                case 3:
                    eliminarProducto(productos);
                    break;
                case 4:
                    try {
                        escribirEnFichero(file, productos);
                        System.out.println("Productos guardados correctamente.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al guardar los productos: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

    }

    // Método para leer el archivo CSV
    public static List<Producto> leerArchivoCSV(File fichero) throws FileNotFoundException, IOException {
        List<Producto> productos = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fichero);
             DataInputStream dis = new DataInputStream(fis);
             BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                // Comprobar que tiene 3 columnas
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    double precio = Double.parseDouble(datos[1].trim());
                    int stock = Integer.parseInt(datos[2].trim());
                    productos.add(new Producto(nombre, precio, stock));
                }
            }
        }
        return productos;
    }
    // Método para escribir los productos en el fichero CSV
    public static void escribirEnFichero(File fichero, List<Producto> productos) throws FileNotFoundException, IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {
            for (Producto producto : productos) {
                bw.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getStock());
                bw.newLine();  // Añadir salto de línea
            }
        } 
    }

    // Método para crear nuevos productos
    public static void crearProductos(List<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto:");
        String nombreProducto = scanner.nextLine();
        System.out.println("Introduce el precio del producto:");
        double precioProducto = scanner.nextDouble();
        System.out.println("Introduce el stock del producto:");
        int stock = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        productos.add(new Producto(nombreProducto, precioProducto, stock));
        System.out.println("Producto creado correctamente.");
    }

    // Método para modificar el producto
    public static void modificarProducto(List<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto a modificar:");
        String nombre = scanner.nextLine();

        // Buscar el producto por nombre para modificarlo
        Producto producto = buscarProductoNombre(productos, nombre);
        if (producto != null) {
            System.out.println("Introduce el nuevo precio:");
            double precio = scanner.nextDouble();
            System.out.println("Introduce el nuevo stock:");
            int stock = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            producto.setPrecio(precio);
            producto.setStock(stock);
            System.out.println("Producto modificado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para eliminar el producto
    public static void eliminarProducto(List<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del producto a eliminar:");
        String nombre = scanner.nextLine();

        // Buscar el producto por nombre para eliminarlo
        Producto producto = buscarProductoNombre(productos, nombre);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Método para buscar el producto por nombre
    public static Producto buscarProductoNombre(List<Producto> productos, String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
