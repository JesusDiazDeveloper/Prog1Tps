package ejemplos;
/*
 * Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
 * encuentre la posicion fila, columna de un numero entero ingresado por el usuario. 
 * Si existe, muestre esa posicion por pantalla, o indique que no existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo5Prueba {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [] args){
        int matint [] [] = new int [MAXFILA] [MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        int numeroIngresado; 
        try{
            System.out.println("ingrese un numero: ");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            numeroIngresado = Integer.valueOf(entrada.readLine());
            imprimir_posicion_matriz( matint , numeroIngresado);
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void imprimir_posicion_matriz(int [] [] matint, int numeroIngresado) {
        /*por cada fila
         * revisar cada columna (posicion)
         * si la columna es distinta a MAXcolumna quiere decir que la encontro.
         * si no, no existe.
          */
            int columna = MAXCOLUMNA;
            int fila = 0; 
            while ((fila<MAXFILA) && (columna == MAXCOLUMNA)){
                columna = obtener_posicion_arreglo(matint[fila], numeroIngresado);
                if(columna==MAXCOLUMNA){
                    fila++;
                }
            }
            if ((fila < MAXFILA)&&(columna<MAXCOLUMNA)){
                System.out.println("el numero: " + numeroIngresado + " esta en la fila: [" + fila + "] y la columna ["+ columna +"]");
            }
            else{
                System.out.println("el numero ingresado no esta en la matriz");
            }
            }
    
    public static int obtener_posicion_arreglo(int [] fila, int numeroIngresado) {
        int pos = 0;
        while((pos<MAXCOLUMNA) && (fila [pos] != numeroIngresado)){
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
