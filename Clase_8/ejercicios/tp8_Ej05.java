package ejercicios;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/* Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra
precargada, solicite al usuario un numero entero y elimine la primer ocurrencia de numero
en la matriz (un número igual) si existe. Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda y no continuar buscando.*/

public class tp8_Ej05 {
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 3;

    public static void main (String []args){
        int [] [] matint = new int[MAXFILA][MAXCOLUMNA];
        int numeroIngresado;
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_matriz(matint);
        imprimir_matriz(matint);
        try{
            System.out.println("ingrese un numero para verificar y eliminar: ");
            numeroIngresado = Integer.valueOf(entrada.readLine());
            buscar_y_eliminar_1er_ocurrencia_matriz(matint , numeroIngresado);
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void buscar_y_eliminar_1er_ocurrencia_matriz(int [] [] matint , int numeroIngresado){
        int fila = 0; 
        int columna = MAXCOLUMNA; 
        while((fila < MAXFILA)&&(columna==MAXCOLUMNA)){
            columna = buscar_numero_fila(matint[fila],numeroIngresado);
            if(columna!=MAXCOLUMNA){
                System.out.println("El numero se encontro en[" + fila +"] [" + columna + "]. Borrando... " ) ;
                corrimiento_izq(matint[fila],columna);
                imprimir_matriz(matint);
                break;
            }
            else{
                fila++;
            }
        }
        if(fila == MAXFILA){
            System.out.println("el numero no existe en la matriz");
        }
    }
    public static int buscar_numero_fila(int [] fila , int numeroIngresado){
        int columna = 0;
        while((columna<MAXCOLUMNA) && (fila[columna]!=numeroIngresado)){
            columna++;
        }
        return columna; 
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
