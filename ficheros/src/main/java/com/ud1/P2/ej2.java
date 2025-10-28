package com.ud1.P2;

import java.io.*;

public class ej2 {
    public static void main(String[] args) {
        try {
            // 1. ESCRIBIR TEXTO EN EL FICHERO
            escribirEnFichero("Fichero1.txt");

            // 2. LEER Y CONTAR PALABRAS
            int contador = mostrarContenidoYContar("Fichero1.txt");
            System.out.println("\nEl total de palabras es: " + contador);

            // 3. CREAR FICHERO TRANSFORMADO
            transformarFichero("Fichero1.txt", "Fichero1_modificado.txt");
            System.out.println("\nSe creó el fichero Ejercicio1_salida.txt con el contenido transformado");

        } catch (IOException e) {
            System.out.println("Error en la operación: " + e.getMessage());
        }
    }

    // MÉTODO PARA PEDIR TEXTO POR CONSOLA Y GUARDARLO
    private static void escribirEnFichero(String nombreFichero) throws IOException {
        try (BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreFichero, true))) {

            System.out.println("Escribe algo:");
            String texto = teclado.readLine();

            escritor.write(texto);
            escritor.newLine();
            System.out.println("Se guardó en " + nombreFichero);
        }
    }

    // MÉTODO PARA MOSTRAR EL CONTENIDO Y CONTAR PALABRAS
    private static int mostrarContenidoYContar(String nombreFichero) throws IOException {
        int totalPalabras = 0;
        System.out.println("\nContenido de " + nombreFichero + ":");

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                // CONTAR PALABRAS DE LA LÍNEA
                String[] palabras = linea.trim().split("\\s+");
                totalPalabras += palabras.length;
            }
        }
        return totalPalabras;
    }

    // MÉTODO PARA CREAR UN NUEVO FICHERO TRANSFORMADO
    private static void transformarFichero(String origen, String destino) throws IOException {
        try (BufferedReader entrada = new BufferedReader(new FileReader(origen));
             BufferedWriter salida = new BufferedWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = entrada.readLine()) != null) {
                // ELIMINAR ESPACIOS Y PASAR A MAYÚSCULAS
                String modificada = linea.replaceAll("\\s+", "").toUpperCase();
                salida.write(modificada);
                salida.newLine();
            }
        }
    }
}


