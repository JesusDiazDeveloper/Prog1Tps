

/*
Tema 2: Se tiene una matriz que contiene caracteres digito y caracteres 
letra minúscula. 
a) Considerando solo las columnas que tienen caracteres letra minúscula, 
se pide obtener el número de la columna que tiene la menor 
cantidad de consonantes menores al caracter 'm'. 
b) Determinar si en un arreglo dado de caracteres letra minúscula 
ordenado ascendente, están todas las consonantes incluídas en la columna 
correspondiente al número de columna obtenido en a). Observaciones:_el
 tamaño del arreglo es igual a la cantidad de columnas de la matriz, 
 _la matriz y el arreglo están precargados,  realizar el programa 
 completo bien modularizado sin métodos de carga  e impresión, 
 ni utilizar estructuras auxiliares.
 */
import java.util.Random;

public class EvaluacionTema2 {

    public static final int MAXFILA = 6;
    public static final int MAXCOLUMNA = 7;
    public static final double PROBABILIDAD = 0.4;
    public static int consonantesMenor = MAXFILA + 1;
    public static boolean existeColumnaConLetras = false;

    public static void main(String[] args) {

        char[][] matchar = { { 'a', 'a', 'a', 'f', 'g', '2', 'a' },
                             { 'b', 'h', 'a', '2', 'r', 'h', 'b' },
                             { 'c', '2', 'h', 'f', 'a', 'h', 'a' },
                             { 'a', 'a', 'd', 'f', 'b', '2', 'b' },
                             { 'l', 'a', 'j', '2', 'e', 'h', 'o' },
                             { 'l', '2', 'g', 'f', 'c', 'h', 'd' } };
        
        char [] arreglo = { 'a', 'b', 'c', 'g', 'a', 'a', 'd' };

        imprimir_matriz_char(matchar);
        resolucion(matchar,arreglo);
        System.out.println("------------------");
    }

    public static void resolucion(char[][] mat , char [] arreglo) {
        int columna = 0;
        int columnaConMenorConsonantes=MAXCOLUMNA+1;
        int contadorConsonantes = 0;
        while (columna < MAXCOLUMNA) {
            int fila = 0;
            boolean existeColumnaConConsonantes = false;

            while ((fila < MAXFILA) && (mat[fila][columna] >= 'a') && (mat[fila][columna] <= 'z')) {
                fila++;
            }
            if (fila == MAXFILA) {
                int filaCondicion = 0;
                contadorConsonantes = 0;
                existeColumnaConLetras = true;
                while (filaCondicion < MAXFILA) {
                    if ((mat[filaCondicion][columna] < 'm') && (mat[filaCondicion][columna] != 'a')
                            && (mat[filaCondicion][columna] != 'e') && (mat[filaCondicion][columna] != 'i')) {
                        contadorConsonantes++;
                        // System.out.println("la letra que entro es: " + mat[filaCondicion][columna]);
                    }
                    filaCondicion++;
                }

                
            }
            // System.out.println("columna es:" + columna);
            // System.out.println("consonantesMenor es"+ consonantesMenor);
            // System.out.println("y contadorDe consonantes vale: " + contadorConsonantes);
            if (contadorConsonantes < consonantesMenor){
                consonantesMenor = contadorConsonantes;
                columnaConMenorConsonantes = columna;
                // System.out.println("columna al final vale: "+ columnaConMenorConsonantes);
                
            }
            columna++;
        }
        if ((existeColumnaConLetras)&&(columnaConMenorConsonantes<MAXCOLUMNA+1)) {
            System.out.println(
            "la columna con menor cantidad de consonantes menores a 'm' es: " + columnaConMenorConsonantes);
        } else {
            System.out.println("no existe una fila que solo tenga letras y que tenga aunque sea 1 consonante.");
        }

        boolean estaBien = true;
        int filaLPM = 0;

        while ((filaLPM<MAXFILA)&&(estaBien==true)){
            if((mat[filaLPM][columnaConMenorConsonantes] < 'm') && (mat[filaLPM][filaLPM] != 'a')
            && (mat[filaLPM][columnaConMenorConsonantes] != 'e') && (mat[filaLPM][columnaConMenorConsonantes] != 'i')){
                estaBien = evaluar_si_existe_en_el_arreglo(arreglo, mat[filaLPM][columnaConMenorConsonantes]);
            }
            filaLPM++;
        }
        if(filaLPM==MAXFILA){
            System.out.println("todas las letras existen en el arreglo");
        }
        else{
            System.out.println("no se cumple la condicion");
        }


    }
    public static boolean evaluar_si_existe_en_el_arreglo(char [] arr, char letra){
        boolean ok=false;
        int pos=0;
        while((pos<MAXCOLUMNA)&&(arr[pos]<letra)){
            pos++;
        }
        if((pos<MAXCOLUMNA)&&(arr[pos]==letra)){
            ok=true;
        }
        return ok;
    }

    public static void imprimir_matriz_char(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }

    public static void imprimir_arreglo_char(char[] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }

    public static void imprimir_arreglo_charPrueba(char[] arr) {
        for (int pos = 0; pos < MAXFILA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }

    public static void cargar_matriz_char(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_char(mat[fila]);
        }
    }

    public static void cargar_arreglo_char(char[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (char) (r.nextInt(26) + 'a');
        }
    }
}
