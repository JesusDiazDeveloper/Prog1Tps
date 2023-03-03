package ejercicios;

import java.util.Random;

public class Evaluacion{
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 30;
    public static final double PROBABILIDAD = 0.4;
    public static final int MAXVALOR= 9;
    public static final int MINVALOR= 1;


    public static void main (String [] args){
        int [][] matriz = new int [MAXFILA][MAXCOLUMNA];
        int [] arreglo = new int [] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        cargar_matriz_secuencias_int(matriz);
        imprimir_matriz(matriz);
        System.out.println("---------------------------------");
        System.out.println("arreglo antes del proceso");
        imprimir_arreglo(arreglo);
        resolucion (matriz,arreglo);
        System.out.println("-------------Final-------------");
        imprimir_arreglo(arreglo);
    }

    public static void resolucion(int [][] mat, int [] arr){
        int contadorFilas = 0; 
        boolean terminoMatriz=false;
        boolean tiene5omenos;
        while((contadorFilas<4)&&(terminoMatriz==false)){
            for (int fila=0;fila<MAXFILA;fila++){
                tiene5omenos = averiguar_fila_5_o_menos_sin_ord_asc(mat[fila]);
                if (tiene5omenos){
                    corrimiento_der(arr);
                    arr [0] = fila; 
                    contadorFilas++;
                    if(contadorFilas==4){
                        fila=MAXFILA;
                        System.out.println("fila vale" + fila);
                    }
                }
            }
            if(contadorFilas<4){
                terminoMatriz = true;
                System.out.println("la matriz tiene menos de 4 filas que cumplen con la condicion");
            }
        }
    }
    public static boolean averiguar_fila_5_o_menos_sin_ord_asc(int [] fila){
        int fin= -1;
        int inicio;
        int contadorAscendente=0;
        boolean es_ascendente;
        boolean cumpleCondicion = true;
        inicio = obtener_inicio_secuencia(fila, fin+1);
        while(inicio<MAXCOLUMNA-1){
            fin=obtener_fin_secuencia(fila, inicio);
            es_ascendente = averiguar_sec_ascendente(fila,inicio,fin);
            if(es_ascendente){
                contadorAscendente++;
            }
            if (contadorAscendente == 6){
                cumpleCondicion = false;
                break;
            }
            inicio = obtener_inicio_secuencia(fila, fin+1);
        }
        return cumpleCondicion;
    }

    public static boolean averiguar_sec_ascendente(int [] fila, int inicio,int fin){
        int pos=inicio; 
        boolean es_ascendente = false; 
        while((fila [pos]<fila[pos+1])){
            pos++;
        }
        if(pos == fin){
            es_ascendente = true;
        }
        return es_ascendente;
    }



    public static int obtener_fin_secuencia(int [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }
    public static int obtener_inicio_secuencia(int [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }
    public static void corrimiento_der (int [] fila){
        int pos = MAXCOLUMNA-1;
        while ( pos > 0){
            fila [pos] = fila [pos-1];
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
    public static void cargar_matriz_secuencias_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_int(mat[fila]);
        }
        System.out.println(" ");
    }
    public static void cargar_arreglo_secuencias_int(int [ ] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAXCOLUMNA - 1] = 0;
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }
}