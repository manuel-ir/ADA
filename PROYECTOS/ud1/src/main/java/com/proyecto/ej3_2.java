package com.proyecto;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ej3_2 {

    public static void main(String[] args) {

    }

    public static void escribirFichero() {

        try (FileOutputStream dos = new FileOutputStream("nums")) {
            DataOutputStream d = new DataOutputStream(dos);

            d.writeInt(12);
            d.writeChar(' ');
            d.writeInt(14);
            d.writeChar('\n');
            d.writeDouble(25);
            d.writeChar(' ');
            d.writeDouble(12);
            d.writeChar('\n');

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
