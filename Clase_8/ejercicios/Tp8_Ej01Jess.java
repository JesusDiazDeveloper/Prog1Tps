package ejercicios;
import java.util.Random;
/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que 
 * se encuentra precargada,
 * invierta el orden del contenido por fila. 
 * Este intercambio no se debe realizar de manera explícita,
 * hay que hacer un método que incluya una iteración de intercambio.
 */

public class Tp8_Ej01Jess {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static void main (String[]args){
        int [] [] matint = new int [MAXFILA] [MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        invertir_filas_de_matriz(matint);
        imprimir_matriz(matint);
    }
    
    public static void invertir_filas_de_matriz(int [] [] matint){
        int fila = 0;
        while(fila<MAXFILA){
            invertir_orden_arreglo(matint[fila]);
            fila++;
        }

    }
    public static void invertir_orden_arreglo(int [] fila ){
        int temp;
        System.out.println("MAXCOLUMNA/2 vale" + MAXCOLUMNA/2);
        for(int i = 0; i < (MAXCOLUMNA/2); i++){
            temp = fila[i];
            fila[i]=fila[MAXCOLUMNA-1-i];
            fila[MAXCOLUMNA-1-i] = temp;
        }
        
    }


    public static void cargar_matriz (int [][] mat) {
        Random r = new Random();
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

