/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tedax
 */
public class Act17Repaso {
   public static void main(String[] args) throws IOException {
        ArrayList<String[]> productoLista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("ej_15.csv"));
        String linea;

        // Leer el archivo CSV y almacenar los productos en una lista
        while ((linea = br.readLine()) != null) {
            String[] lineaSpliteada = linea.split(",");
            productoLista.add(lineaSpliteada);
        }
        br.close();

        // Ordenar los productos por precio (índice 1) usando el método de burbuja
        for (int i = 0; i < productoLista.size() - 1; i++) {
            for (int j = 0; j < productoLista.size() - 1 - i; j++) {
                double precio1 = Double.parseDouble(productoLista.get(j)[1]);
                double precio2 = Double.parseDouble(productoLista.get(j + 1)[1]);
                if (precio1 > precio2) {
                    // Intercambiar productos
                    String[] temp = productoLista.get(j);
                    productoLista.set(j, productoLista.get(j + 1));
                    productoLista.set(j + 1, temp);
                }
            }
        }

        // Mostrar el producto más barato y el más caro
        String[] productoMasBarato = productoLista.get(0);
        String[] productoMasCaro = productoLista.get(productoLista.size() - 1);

        System.out.println("Producto más barato: " + productoMasBarato[0] + ", Precio: " + productoMasBarato[1]);
        System.out.println("Producto más caro: " + productoMasCaro[0] + ", Precio: " + productoMasCaro[1]);

        // Guardar los productos ordenados en un nuevo archivo CSV
        BufferedWriter bw = new BufferedWriter(new FileWriter("ej_15_ordenado.csv"));
        for (String[] producto : productoLista) {
            bw.write(String.join(",", producto));
            bw.newLine();
        }
        bw.close();
    }
}
