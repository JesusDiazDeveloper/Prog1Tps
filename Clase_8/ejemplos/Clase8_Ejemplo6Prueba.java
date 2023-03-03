package ejemplos;
 /*
 * Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
 * solicite al usuario una posicion fila, columna, y realice un corrimiento a derecha. Ademas imprima
 * la matriz antes y despues del corrimiento
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo6Prueba {
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;

    public static void main (String []args){
        int [] [] matint = new int[MAXFILA][MAXCOLUMNA];
        int filaIngresada, columnaIngresada; 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz(matint);
        imprimir_matriz(matint);
        try{
            System.out.println("Ingrese una fila: ");
            filaIngresada = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una columna: ");
            columnaIngresada = Integer.valueOf(entrada.readLine());
            if ((filaIngresada >= 0) && (filaIngresada < MAXFILA) && (columnaIngresada >= 0) && (columnaIngresada < MAXCOLUMNA)){
                corrimiento_der(matint[filaIngresada], columnaIngresada);
                imprimir_matriz(matint);
            }
            else{
                System.out.println("ingreso una fila/columna que no pertenece a la matriz");
            }
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }
    
    public static void corrimiento_der(int [] filaDeLaMatriz, int columnaIngresada) {
        int pos = MAXCOLUMNA-1;
        while (pos>columnaIngresada){
            filaDeLaMatriz[pos] = filaDeLaMatriz[pos-1];  
            pos--;
        } 
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