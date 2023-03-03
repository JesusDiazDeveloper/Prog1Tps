package ejercicios;
import java.util.Random;

/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, obtenga la cantidad de números pares que tiene y la imprima.*/

public class tp8_Ej02 {
    public static final int MAXVALOR= 9;
    public static final int MINVALOR= 1;
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10; 

    public static void main (String []args){
        int cantidad; 
        int [] [] mat = new int [MAXFILA][MAXCOLUMNA];
        cargar_matriz(mat);
        imprimir_matriz(mat);
        cantidad = cantidad_numeros_pares_matriz(mat);
        System.out.println("La matriz tiene " + cantidad + " numeros pares. ");

    }

    public static int cantidad_numeros_pares_matriz(int [][] mat){
        int cantidadDePAres,suma =0; 
        for (int fila = 0; fila < MAXFILA ; fila++){
            cantidadDePAres = cantidad_de_numeros_pares(mat[fila]);
            suma +=  cantidadDePAres;
        }
        return suma;
    }
    public static int cantidad_de_numeros_pares (int [] fila){
        int cantidadDePAres=0;
        for(int columna= 0; columna<MAXCOLUMNA; columna++){
            if(fila[columna]%2 == 0){
                cantidadDePAres++;
            }
        }
        return cantidadDePAres; 
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
