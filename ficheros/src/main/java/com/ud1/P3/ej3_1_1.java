package com.ud1.P3;
    
import java.io.*;

public class ej3_1_1 {
    public static void main(String[] args) {
     
        String rutaEntrada = "/home/alumnadotarde/Escritorio/shrek.webp"; 
        String rutaSalida = "/home/alumnadotarde/Escritorio/copia_shrek.webp";

        try (
            FileInputStream fis = new FileInputStream(rutaEntrada);
            FileOutputStream fos = new FileOutputStream(rutaSalida);
        ) {
            // BUFFER DE BYTES PARA LEER LA IMAGEN
            byte[] buffer = new byte[1024];
            int bytesLeidos;

            // LEEMOS Y ESCRIBIMOS HASTA QUE NO QUEDEN DATOS
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("COPIA REALIZADA CORRECTAMENTE EN: " + rutaSalida);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: NO SE ENCONTRÓ EL ARCHIVO DE ENTRADA.");
        } catch (IOException e) {
            System.out.println("ERROR DE ENTRADA/SALIDA: " + e.getMessage());
        }
    }
}

