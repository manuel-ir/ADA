package com.practica;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      
        /*
        9.  Tabla de multiplicar: Pide al usuario un número y muestra su tabla de multiplicar del 1 al 10.
        10. Palíndromo: Escribe un programa que determine si una cadena ingresada por el usuario es un palíndromo (se lee igual de adelante hacia atrás).
        11. Máximo y mínimo en un array: Crea un programa que encuentre el valor máximo y mínimo en un array de números.
        12. Ordenar un array: Escribe un programa que ordene un array de enteros en orden ascendente.
        13. Conversión de grados: Crea un programa que convierta grados Celsius a Fahrenheit y viceversa.
        14. Contador de palabras: Pide al usuario que ingrese una frase y cuenta cuántas palabras hay en ella.
        15. Números primos: Escribe un programa que imprima todos los números primos entre 1 y N, donde N es ingresado por el usuario.
        16. Suma de dígitos: Crea un programa que sume los dígitos de un número ingresado por el usuario. */
        
      
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int res;

        for (int i = 1; i <= 10; i++){
          res = num * i;
          
         System.out.print(res + " ");
        }
       
        
    }
}