/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoficherosad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author tedax
 */
public class Act18Repaso {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner entrada =new Scanner(System.in);
        System.out.println("Elige la opcion de fichero para filtar los continentes elige 1 o 2");
        String opcion =entrada.nextLine();
        String nombreArchivo="";
        
        switch (opcion) {
            case "1":
                nombreArchivo="ej_16_1.csv";
                break;
            case "2":  
                nombreArchivo="ej_16_2.csv";
                break;
            default:
                throw new AssertionError();
        }

        BufferedReader br=new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        br.readLine();
        while((linea =br.readLine()) !=null)
        {
            String[] lineaComa =linea.split(",");
            String encontrarContinente =lineaComa[2];
            BufferedWriter bw =new BufferedWriter(new FileWriter("ej_16_" +opcion +encontrarContinente+".csv",true));
            bw.write(lineaComa[0]);
            bw.write(",");
            bw.write(lineaComa[1]);
            bw.write(",");
            bw.write(lineaComa[2]);
            bw.newLine();
            bw.flush();
            bw.close();    
        }
    }
}
