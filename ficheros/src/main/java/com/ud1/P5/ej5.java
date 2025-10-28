package com.ud1.P5;

import java.io.*;
import java.util.Scanner;

public class ej5 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la ruta del fichero a procesar: ");
        String ruta = scanner.nextLine();
        
        try {
            procesarFichero(ruta);
            System.out.println("Fichero procesado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al procesar el fichero: " + e.getMessage());
        }
        
        scanner.close();
    }
    
    public static void procesarFichero(String ruta) throws IOException {
        // Usamos RandomAccessFile para acceso directo
        try (RandomAccessFile file = new RandomAccessFile(ruta, "rw")) {
            StringBuilder contenido = new StringBuilder();
            long posLectura = 0;
            long posEscritura = 0;
            
            // Leemos todo el contenido caracter por caracter
            while (posLectura < file.length()) {
                file.seek(posLectura);
                char caracter = (char) file.readByte();
                
                // Si no es espacio en blanco, lo procesamos
                if (!Character.isWhitespace(caracter)) {
                    // Convertimos a mayúsculas
                    char caracterProcesado = Character.toUpperCase(caracter);
                    
                    // Escribimos en la posición correspondiente
                    file.seek(posEscritura);
                    file.writeByte(caracterProcesado);
                    posEscritura++;
                }
                
                posLectura++;
            }
            
            // Truncamos el fichero a la nueva longitud
            file.setLength(posEscritura);
        }
    }
}
