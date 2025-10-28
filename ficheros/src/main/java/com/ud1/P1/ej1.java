package com.ud1.P1;


import java.io.File;
import java.io.IOException;

public class ej1 {

    public static void main(String[] args) {

        // DEFINIMOS LA RUTA BASE EN EL ESCRITORIO
        String basePath = System.getProperty("user.home") + "/Desktop";

        // EJERCICIO 1: CREAR ESTRUCTURA
        crearEstructura(basePath);

        // EJERCICIO 2: LISTAR
        System.out.println("\n LISTADO ");
        File directorioRaiz = new File(basePath, "d");
        listarDirectorio(directorioRaiz, "");

        // EJERCICIO 3: LISTAR MODIFICADO
        System.out.println("\n LISTADO MODIFICADO ");
        listarModificar(basePath + "/d");

        // EJERCICIO 4: FILTRAR POR EXTENSIÓN
        System.out.println("\n ARCHIVOS .txt EN d1 ");
        listarPorExtension(basePath + "/d/d1", ".txt");

        // EJERCICIO 5: BORRAR ARCHIVOS .txt
        System.out.println("\n BORRANDO ARCHIVOS .txt EN d1 ");
        eliminarArchivos(basePath + "/d/d1");
    }

    // 1. CREAR ESTRUCTURA DE DIRECTORIOS Y FICHEROS
    public static void crearEstructura(String basePath) {
        try {
            File d = new File(basePath, "d");
            if (d.mkdir()) System.out.println("Creado: " + d.getName());

            File d1 = new File(d, "d1");
            if (d1.mkdir()) System.out.println("Creado: " + d1.getName());
            new File(d1, "f11.txt").createNewFile();
            new File(d1, "f12.txt").createNewFile();

            File d2 = new File(d, "d2");
            d2.mkdir();
            File d21 = new File(d2, "d21");
            d21.mkdir();
            new File(d2, "f21.txt").createNewFile();
            File d22 = new File(d2, "d22");
            d22.mkdir();
            new File(d22, "f222.txt").createNewFile();

            File d3 = new File(d, "d3");
            d3.mkdir();
            File d31 = new File(d3, "d31");
            d31.mkdir();

        } catch (IOException e) {
            System.out.println("Error al crear la estructura: " + e.getMessage());
        }
    }

    // 2. LISTAR DIRECTORIOS Y ARCHIVOS
    public static void listarDirectorio(File dir, String sangria) {
        if (dir.isDirectory()) {
            System.out.println(sangria + dir.getName());
            File[] hijos = dir.listFiles();
            if (hijos != null) {
                for (File f : hijos) {
                    listarDirectorio(f, sangria + "   ");
                }
            }
        } else {
            System.out.println(sangria + ficherito(dir));
        }
    }

    private static String ficherito(File f) {
        return  f.getName();
    }

    // 3. LISTAR MODIFICADO: COMPRUEBA EXISTENCIA Y VUELVE A LISTAR
    public static void listarModificar(String ruta) {
        File raiz = new File(ruta);
        if (!raiz.exists()) {
            System.out.println("El directorio no existe.");
            return;
        }
        listarDirectorio(raiz, "");
    }

    // 4. MUESTRA ARCHIVOS POR EXTENSIÓN
    public static void listarPorExtension(String ruta, String extension) {
        File carpeta = new File(ruta);
        File[] hijos = carpeta.listFiles();

        if (hijos == null) {
            System.out.println("No se pudo acceder al directorio.");
            return;
        }

        for (File f : hijos) {
            if (f.isFile() && f.getName().endsWith(extension)) {
                System.out.println(f.getName());
            }
        }
    }

    // 5. ELIMINA ARCHIVOS CON EXTENSIÓN .txt
    public static void eliminarArchivos(String ruta) {
        File carpeta = new File(ruta);
        File[] hijos = carpeta.listFiles();

        if (hijos == null) {
            System.out.println("No se pudo acceder al directorio.");
            return;
        }

        for (File f : hijos) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                if (f.delete()) {
                    System.out.println("Borrado: " + f.getName());
                }
            }
        }
    }
}

