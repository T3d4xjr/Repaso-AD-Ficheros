/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author  Editar productos desde un fichero CSV
 *
 * Crea un programa que lea un fichero CSV (ej_15.csv) con una lista de
 * productos (nombre, precio, stock). El programa debe poder crear nuevos
 * productos y modificar y eliminar los productos existentes. Las modificaciones
 * seán guardadas en el mismo fichero inicial (ej_15.csv).
 */

public class Act16Repaso {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> nameArray = new ArrayList<>();
        ArrayList<String> priceArray = new ArrayList<>();
        ArrayList<String> stockArray = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(new File("ej_15.csv")));
        String linea;
        String[] lineaArray;
        while ((linea = br.readLine()) != null) {
            lineaArray = linea.split(",");
            nameArray.add(lineaArray[0]);
            priceArray.add(lineaArray[1]);
            stockArray.add(lineaArray[2]);
        }

        System.out.println("Vamos a hacer un menu \n"
                + "1. Añadir \n"
                + "2. Modificar \n"
                + "3. Eliminar ");
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        switch (op) {
            case "1":
                System.out.println("Dame el nombre");
                String respName = sc.nextLine();
                System.out.println("Dame el precio");
                String respPrice = sc.nextLine();
                System.out.println("Dame el stock");
                String respStock = sc.nextLine();
                nameArray.add(respName);
                nameArray.add(respPrice);
                nameArray.add(respStock);
                break;
            case "2":
                System.out.println("Dime el nombre exacto del producto que quieres encontrar");
                String respToFind = sc.nextLine();
                boolean enc = false;
                int index = 0;
                while (enc != true) {
                    if (nameArray.get(index).equalsIgnoreCase(respToFind)) {
                        enc = true;
                    } else {
                        index++;
                    }
                }
                System.out.println("Que quieres modificar: "
                        + "1. Nombre"
                        + "2. Precio"
                        + "3. Stock");
                Scanner scMod = new Scanner(System.in);
                int mod = Integer.parseInt(scMod.nextLine());
                switch (mod) {
                    case 1:
                        System.out.println("Por cual lo quieres cambiar");
                        String cambioN = sc.nextLine();
                        nameArray.set(index, cambioN);
                        break;
                    case 2:
                        System.out.println("Por cual lo quieres cambiar");
                        String cambioP = sc.nextLine();
                        nameArray.set(index, cambioP);
                        break;
                    case 3:
                        System.out.println("Por cual lo quieres cambiar");
                        String cambioS = sc.nextLine();
                        nameArray.set(index, cambioS);
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            case "3":
                System.out.println("Dime el nombre exacto del producto que quieres encontrar");
                String respToFindEl = sc.nextLine();
                boolean enc1 = false;
                int index2 = 0;
                while (enc1 != true) {
                    if (nameArray.get(index2).equalsIgnoreCase(respToFindEl)) {
                        enc = true;
                    } else {
                        index2++;
                    }
                }
                nameArray.remove(index2);
                priceArray.remove(index2);
                stockArray.remove(index2);
                break;
            default:
                throw new AssertionError();
        }
    }

}
