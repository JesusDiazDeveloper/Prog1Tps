package ejercicios;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*    	
7. Hacer un programa que dado una matriz ordenada creciente por filas de
enteros de tamaño 4*5 que se encuentra precargada, solicite al usuario un
numero entero y una fila, y luego inserte el numero en la matriz en la fila
indicada manteniendo su orden.
*/

public class tp8_ej7 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

public static void main(String [ ] args){
	int [] [] matint = new int [MAXFILA] [MAXCOLUMNA];
    cargar_matriz(matint); 
    imprimir_matriz(matint);
    int numero, filaIngresada;

    BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));

    try{
    System.out.println("Ingrese un numero:" );
    numero = Integer.valueOf(entrada.readLine());

    do{
    System.out.println("ingrese una fila:");
    filaIngresada = Integer.valueOf(entrada.readLine());
    }while((filaIngresada<0) || (filaIngresada>=MAXFILA));

    Insertar_numero_en_fila(matint[filaIngresada] , numero);

        imprimir_matriz(matint);;
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void Insertar_numero_en_fila( int [] fila, int numero){
    int pos = 0;
    while((pos<MAXCOLUMNA-1)&&(fila[pos]<numero)){
        pos++;
    }
    // if(pos<MAXCOLUMNA-1){
    // corrimiento_der(fila,pos);
    //     fila[pos]=numero;
    // }
    // else{
    //     fila[pos] = numero;
    // }
    corrimiento_der(fila,pos);   // de las 2 formas funciona, tanto la comentada
    fila[pos]=numero;           // como la no comentada. 
    
    }   
    public static void corrimiento_der(int [ ] arr, int pos){
    int indice = MAXCOLUMNA-1;
    while(indice>pos){
    arr [indice] = arr [ indice -1];
    indice--;
    }
    }

        public static void cargar_matriz(int[][] mat) {
            for (int fila = 0; fila < MAXFILA; fila++) {
                cargar_arreglo(mat[fila]);
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

    }
