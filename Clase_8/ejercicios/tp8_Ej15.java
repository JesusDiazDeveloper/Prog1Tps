/*
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada 
 * elimine todas las secuencias que tienen orden descendente entre sus elementos.
 * 
 * 
 * declaro matriz 
 * cargo todo, 
 * eliminar_todas_las_sec_ord_desc
 */

package ejercicios;

import java.util.Random;

public class tp8_Ej15 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_char(matchar);
        System.out.println("Matriz inicial");
        imprimir_matriz_char(matchar);
        eliminar_secuencias_orden_descendente_matriz(matchar);
        System.out.println("Matriz sin secuencias descendentes");
        imprimir_matriz_char(matchar);
    }

    public static void eliminar_secuencias_orden_descendente_matriz(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_orden_descendente_fila(mat[fila]);
        }
    }


    public static void eliminar_secuencias_orden_descendente_fila(char[] fila) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(fila, fin + 1);
        while (inicio < MAXCOLUMNA - 1) {
            fin = obtener_fin_secuencia(fila, inicio);
            if (es_descendente(fila, inicio, fin)) {
                eliminar_secuencia(fila, inicio, fin);
            }
            inicio = obtener_inicio_secuencia(fila, fin + 1);
        }
    }

    public static boolean es_descendente(char[] fila, int inicio, int fin) {
        for(int pos = inicio; pos <= fin; pos++) {
            if ((fila[pos] <= fila[pos + 1]) || (inicio == fin)){
                return false;
            }
        }
        return true;
    }

    public static void eliminar_secuencia(char[] fila, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(fila, inicio);
        }
    }

    public static void corrimientoIzq(char[] fila, int inicio) {
        for(int i = inicio; i < MAXCOLUMNA - 1; i++) {
            fila[i] = fila[i + 1];
        }
    }

    public static int obtener_inicio_secuencia(char [ ] fila, int pos) {
        while ((pos < MAXCOLUMNA) && (fila[pos] == ' ')) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(char [ ] fila, int pos) {
        while ((pos < MAXCOLUMNA) && (fila[pos] != ' ')) {
            pos++;
        }
        return pos - 1;
    }

    public static void cargar_matriz_secuencias_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_filaeglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_filaeglo_secuencias_char(char [ ] fila) {
        Random r = new Random();
        fila[0] = ' ';
        fila[MAXCOLUMNA - 1] = ' ';
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                fila[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                fila[pos] = ' ';
            }
        }
    }

    public static void imprimir_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_filaeglo_char(mat[fila]);
        }
    }

    public static void imprimir_filaeglo_char(char [] fila) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + fila[pos] + "]");
        }
        System.out.println("");
    }
}