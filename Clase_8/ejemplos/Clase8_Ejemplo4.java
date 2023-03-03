package ejemplos;

import java.util.Random;

public class Clase8_Ejemplo4{
    public static int MAXFILA = 4;
    public static int MAXCOLUMNA = 5; 
    public static int MINVALOR= 1;
    public static int MAXVALOR = 9;
    public static void main (String []args){
        int [] [] matint = new int [MAXFILA] [MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        imprimir_promedio_columnas(matint);

    }    
    
    public static void imprimir_promedio_columnas(int[][] matint) {
        for (int columna= 0; columna<MAXCOLUMNA; columna++ ){
            System.out.println("el promedio de la columna " + columna + "es: " + obtener_promedio_columna(matint,columna) );
        }
    }

    public static int obtener_promedio_columna(int[][] matint, int columna) {
        int suma = 0;
        for(int fila = 0; fila < MAXFILA ; fila++){
            suma += matint[fila][columna];
        }
        // int promedio = suma/MAXFILA; (si pongo promedio tambien funciona, es lo mismo). 
        return suma/MAXFILA; 
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
