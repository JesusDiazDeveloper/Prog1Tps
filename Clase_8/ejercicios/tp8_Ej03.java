package ejercicios;
/*Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario una posición fila, columna y realice un corrimiento a
izquierda.*/
     
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class tp8_Ej03 {
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
                corrimiento_izq(matint[filaIngresada], columnaIngresada);
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

    public static void corrimiento_izq(int [] fila , int columna){
        while(columna<MAXCOLUMNA-1){
            fila[columna] = fila[columna+1];
            columna++;
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
