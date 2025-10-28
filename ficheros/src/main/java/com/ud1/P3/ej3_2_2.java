package com.ud1.P3;

import java.io.*;
import java.util.Scanner;

public class ej3_2_2 {
    public static void main(String[] args) {
       

        String ruta = System.getProperty("user.home") + "/Escritorio/parejas.txt";

        try (
            FileOutputStream fos = new FileOutputStream(ruta);
            DataOutputStream dos = new DataOutputStream(fos);
            Scanner sc = new Scanner(System.in);
        ) {
            while (true) {
                System.out.print("Introduce el primer número (o pulsa INTRO para salir): ");
                String entrada = sc.nextLine();
                if (entrada.isEmpty()) break; // SI NO HAY NÚMERO, SE SALE

                int num1 = Integer.parseInt(entrada);

                System.out.print("Introduce el segundo número: ");
                int num2 = Integer.parseInt(sc.nextLine());

                // ESCRIBIMOS LOS DOS NÚMEROS EN EL FICHERO COMO INT
                dos.writeInt(num1);
                dos.writeInt(num2);
            }

            dos.flush(); // ASEGURA QUE TODOS LOS DATOS SE ESCRIBAN EN EL FICHERO
            System.out.println("ARCHIVO CREADO EN: " + ruta);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: NO SE PUDO CREAR EL ARCHIVO.");
        } catch (IOException e) {
            System.out.println("ERROR DE ENTRADA/SALIDA.");
        } catch (NumberFormatException e) {
            System.out.println("ERROR: SE ESPERABA UN NÚMERO ENTERO.");
        }

        // MUESTRA EL CONTENIDO DEL FICHERO
        System.out.println("\n CONTENIDO DEL FICHERO");
        try (
            FileInputStream fis = new FileInputStream(ruta);
            DataInputStream dis = new DataInputStream(fis);
        ) {
            try {
                while (true) {
                    int num1 = dis.readInt();
                    int num2 = dis.readInt();
                    System.out.println(num1 + " " + num2);
                }
            } catch (EOFException e) {
                // CUANDO SE LLEGA AL FINAL DEL FICHERO, SE TERMINA
                System.out.println("FIN DEL FICHERO");
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: ARCHIVO NO ENCONTRADO PARA LECTURA.");
        } catch (IOException e) {
            System.out.println("ERROR DE ENTRADA/SALIDA AL LEER EL ARCHIVO.");
        }
    }
}

