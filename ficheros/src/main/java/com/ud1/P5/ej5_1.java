package com.ud1.P5;

import java.io.*;
import java.util.Scanner;

public class ej5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaFichero = "enteros.txt";
        
        try {
            // Guardar enteros
            guardarEnteros(rutaFichero, scanner);
            
            // Mostrar contenido antes del cambio
            System.out.println("\nContenido antes del cambio:");
            mostrarContenido(rutaFichero);
            
            // Cambiar 5 por 0
            cambiarCincoPorCero(rutaFichero);
            
            // Mostrar contenido después del cambio
            System.out.println("\nContenido después del cambio:");
            mostrarContenido(rutaFichero);
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
    
    public static void guardarEnteros(String ruta, Scanner scanner) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(ruta, "rw")) {
            System.out.println("Introduce enteros (escribe 'fin' para terminar):");
            
            while (true) {
                System.out.print("Número: ");
                String entrada = scanner.nextLine();
                
                if (entrada.equalsIgnoreCase("fin")) {
                    break;
                }
                
                try {
                    int numero = Integer.parseInt(entrada);
                    file.writeInt(numero);  // Cada int ocupa 4 bytes
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduce un número válido.");
                }
            }
        }
    }
    
    public static void cambiarCincoPorCero(String ruta) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(ruta, "rw")) {
            long fileSize = file.length();
            int numEnteros = (int) (fileSize / 4);  // Cada int ocupa 4 bytes
            
            for (int i = 0; i < numEnteros; i++) {
                long posicion = i * 4L;  // Calculamos la posición (cada int = 4 bytes)
                file.seek(posicion);
                
                int numero = file.readInt();
                
                if (numero == 5) {
                    // Nos posicionamos de nuevo y escribimos 0
                    file.seek(posicion);
                    file.writeInt(0);
                    System.out.println("Cambiado 5 por 0 en posición " + posicion);
                }
            }
        }
    }
    
    public static void mostrarContenido(String ruta) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(ruta, "r")) {
            long fileSize = file.length();
            int numEnteros = (int) (fileSize / 4);
            
            if (numEnteros == 0) {
                System.out.println("El fichero está vacío");
                return;
            }
            
            for (int i = 0; i < numEnteros; i++) {
                int numero = file.readInt();
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }
}