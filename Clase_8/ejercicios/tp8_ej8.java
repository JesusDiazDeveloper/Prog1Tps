package ejercicios;


/*
 8. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, 

solicite al usuario un numero entero y una fila, 

y elimine la primer ocurrencia de numero en la fila indicada (un número igual) si existe.

 */

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tp8_ej8 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String []args){
        int [][] matint = new int [MAXFILA][MAXCOLUMNA];
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        int numero;
        int filaIngresada;

        cargar_matriz(matint);
        imprimir_matriz(matint);
        
        try{
            System.out.println("ingrese un numero: ");
            numero = Integer.valueOf(entrada.readLine());
            System.out.println("ingrese una fila");
            filaIngresada = Integer.valueOf(entrada.readLine());
            elminar_primera_ocurrencia(matint[filaIngresada], numero);
            imprimir_matriz(matint);
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void elminar_primera_ocurrencia(int[]fila, int numero){
        int pos=0;
        while ((pos < MAXCOLUMNA ) && (numero != fila[pos])){
            pos++;
        }
        	if(numero == fila[pos]){
            while(pos<MAXCOLUMNA-1){
            fila [pos] = fila [pos+1]; 
          	System.out.println("esto funciona");
          	pos++;
                  }
         	}
             // no funciona esta parte, deberia imprimir que el valor no existe.
             else if (pos == MAXCOLUMNA){ 
               	System.out.println("ese valor no existe en el arreglo");
             }
}


    public static void corrimiento_izq(int [] fila , int columna){
        while(columna<MAXCOLUMNA-1){
            fila[columna] = fila[columna+1];
            columna++;
        }
    }

    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_matriz(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo(mat[fila]);
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
    public static void ordenar_filas(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            ordenar_arreglo_seleccion(mat[fila]);
        }
    }
    public static void cargar_matriz (int [][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo(mat[fila]);
        }
        ordenar_filas(mat);
    }
    public static void ordenar_arreglo_seleccion(int [ ] arr) {
        int posMenor, temp;
        for (int i = 0; i < MAXCOLUMNA; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAXCOLUMNA; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                temp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = temp;
            }
        }
    }
}
