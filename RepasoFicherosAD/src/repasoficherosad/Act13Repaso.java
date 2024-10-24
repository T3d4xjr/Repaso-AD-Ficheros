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
 
@author
Dividir un fichero de texto por palabras clave
Implementa un programa que lea un fichero de texto (ej_13.txt)
y lo divida en varios ficheros más pequeños. La división se
realizará cada vez que se encuentre la línea “Capítulo X”.
El programa pedirá al usuario el nombre del fichero original
y los ficheros de salida se llamarán: nombreOriginal_capX.txt.
Por ejemplo, si el fichero ej_13.txt tiene 3 capítulos debería
crear los fichero ej_13_cap1.txt, ej_13_cap2.txt y ej_13_cap3.txt.
Cada uno con su respectivo capítulo.
*/
public class Act13Repaso {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("ej_13.txt"));
        String linea;
        BufferedWriter bw = null;
        while((linea=br.readLine())!=null){
            if(linea.contains("Capítulo")){
                String[] arrayPaco = linea.split(" ");
                String cap = arrayPaco[1];
                File nuevoFile = new File("Capitulo" + cap + ".txt");
                bw = new BufferedWriter(new FileWriter(nuevoFile));
            }else{
                bw.write(linea);
                bw.newLine();
                bw.flush();
            }
        }
    }
}
