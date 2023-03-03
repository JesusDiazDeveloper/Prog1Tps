package ejemplos;
/*
 * Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
 * encuentre la posicion fila,columna de un numero entero ingresado por el usuario. Si existe,
 * muestre esa posicion por pantalla, o indique que no existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo5 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ][ ] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        try {
            System.out.println("Ingrese un numero entero:");
            int num = Integer.valueOf(entrada.readLine());
            buscar_e_imprimir_pos_matriz(matint, num); // procedimiento directamente esto me imprime si existe o no. 
        } catch (Exception exc) {
            System.out.println(exc);
        }
    } // aca termina el main, re chiquito, bien ahi. 

    public static void buscar_e_imprimir_pos_matriz(int [ ][ ] mat, int num) {
        int fila = 0; // lo hago con un while porque no se donde terminar el recorrido. 
        int columna = MAXCOLUMNA;
        while ((fila < MAXFILA) && (columna == MAXCOLUMNA)) { // o sale porque fila se paso (no lo encontro), o sale porque encontro la posicion, entonces columna cambio.
            columna = obtener_pos_arreglo(mat[fila], num);// esto me devuelve o una posicion que encontro, o el valor de MAXCOLUMNA porque recorrio todo el arreglo y ya no es menor a MAXCOLUMNA
            if (columna == MAXCOLUMNA) {
                fila++;
            }
        }
        if ((fila < MAXFILA) && (columna < MAXCOLUMNA)) {
            System.out.println(num + " está en la fila " + fila + " columna " + columna);
        } else {
            System.out.println(num + " no existe en la matriz.");
        }
    }

    public static int obtener_pos_arreglo(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAXCOLUMNA) && (arr[pos] != num)) {
            pos++;
        }
        return pos;
    }

    public static void cargar_matriz (int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo(mat[fila]);
        }
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo(mat[fila]);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}