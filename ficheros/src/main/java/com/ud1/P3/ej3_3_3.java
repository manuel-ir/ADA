package com.ud1.P3;

import java.io.*;
public class ej3_3_3 {
//Ejercicio3


    public static void main(String[] args) {
 
        String ruta = "/home/alumnadotarde/Escritorio/parejas.txt";

        try (
            FileInputStream fis = new FileInputStream(ruta);
            DataInputStream dis = new DataInputStream(fis);
        ) {
            int sumaCol1 = 0;
            int contador = 0;

            int sumaPonderada = 0;
            int sumaPesos = 0;

            try {
                while (true) {
                    // LEEMOS UNA PAREJA DE NÚMEROS
                    int num1 = dis.readInt();
                    int num2 = dis.readInt();

                    // ACUMULAMOS PARA MEDIA ARITMÉTICA
                    sumaCol1 += num1;
                    contador++;

                    // ACUMULAMOS PARA MEDIA PONDERADA
                    sumaPonderada += num1 * num2;
                    sumaPesos += num2;
                }
            } catch (EOFException e) {
                // CUANDO SE LLEGA AL FINAL DEL FICHERO, SE CALCULAN LOS RESULTADOS
                if (contador > 0) {
                    double mediaAritmetica = (double) sumaCol1 / contador;
                    double mediaPonderada = (double) sumaPonderada / sumaPesos;

                    System.out.println("MEDIA ARITMÉTICA DE LA PRIMERA COLUMNA: " + mediaAritmetica);
                    System.out.println("MEDIA PONDERADA DE LA PRIMERA COLUMNA: " + mediaPonderada);
                } else {
                    System.out.println("NO HAY DATOS EN EL ARCHIVO.");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: ARCHIVO NO ENCONTRADO.");
        } catch (IOException e) {
            System.out.println("ERROR DE ENTRADA/SALIDA.");
        }
    }
}

