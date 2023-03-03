/*
 Tema 1: Se tiene una matriz de caracteres letra minúscula,
  a) Para las primeras 3 filas que tienen una cantidad impar 
  de vocales, se pide obtener el número de la fila que tiene 
  la menor cantidad de consonantes. b) Agregar en un arreglo de caracteres 
  letra minúscula ordenado ascendente (manteniendo su orden en todo momento), 
  las consonantes mayores al caracter letra 'f' de la fila correspondiente al 
  número de fila cbtenido en a).

Observaciones: el tamaño del arreglo es igual a la cantidad de filas de la matriz, 
_la matriz y el arreglo están precargados, realizar el programa completo
 bien modularizado sin métodos de carga e impresión, ni utilizar estructuras 
 auxiliares.
*/

import java.util.Random;


public class Evaluacion {
    public static final int MAXFILA = 16;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        char [] arrchar= {'a','a','a','f','g','h','k','m','g','h','k','m','g','h','k','m','g','h'};
        cargar_matriz_char(matchar);
        System.out.println("-----------------------------------");
        imprimir_arreglo_charPrueba(arrchar);
        // System.out.println("Matriz inicial");
        // imprimir_matriz_char(matchar);
        resolucion(matchar,arrchar);
        System.out.println("-----------------------------------");
        imprimir_arreglo_charPrueba(arrchar);
        
    }

    public static void resolucion(char [][] mat , char [] arreglo){
        int contador = 0;
        int fila = 0; 
        int cantidad_de_consonantes_actual =0;
        int consonantesMenor=MAXCOLUMNA+1; 
        boolean tiene_vocales_impar;
        int fila_requerida=0;        

        while ((fila<MAXFILA)&&(contador<3)){
            tiene_vocales_impar = saber_si_tiene_vocales_impar(mat[fila]); 
            // if(tiene_vocales_impar){
            //     System.out.println("La fila" + fila + "tiene vocales impar");
            // }
            if(tiene_vocales_impar){
                cantidad_de_consonantes_actual= saber_cantidad_de_consonantes(mat[fila]);
                if (cantidad_de_consonantes_actual<consonantesMenor){
                    fila_requerida=fila;
                    consonantesMenor = cantidad_de_consonantes_actual;
                    contador++;
                }
            }
            fila++;
        }
        System.out.println("La fila que tiene la menor cantidad de consonantes es:" + fila_requerida);
        programa_b(mat[fila_requerida],arreglo);
        
    }
    public static boolean saber_si_tiene_vocales_impar(char [] fila ){
        boolean tieneCantidadImpar=false;
        int pos = 0;
        int contador=0;
        while(pos<MAXCOLUMNA){
            if((fila[pos]=='a')||(fila[pos]=='e')||(fila[pos]=='i')||(fila[pos]=='o')||(fila[pos]=='u')){
                contador++;
            }      
            pos++;  
        }
        if((contador%2)!=0){
            tieneCantidadImpar=true;
        }
        return tieneCantidadImpar;
    } 
    public static int  saber_cantidad_de_consonantes(char[]fila ){
        int contador = 0; 
        int pos=0;
        while(pos<MAXCOLUMNA){
            if((fila[pos]!='a')&&(fila[pos]!='e')&&(fila[pos]!='i')&&(fila[pos]!='o')&&(fila[pos]!='u')){
                contador++;
            }
            pos++;
        }

        return contador;
    }
    public static void programa_b( char [] fila , char []arreglo){
        int pos=0;
        while(pos<MAXFILA){
            if(fila[pos]>'f'){
                System.out.println("Ingreso un " + fila[pos]);
                insertar_letra_en_arreglo(arreglo , fila[pos]);
                imprimir_arreglo_charPrueba(arreglo);

        } 
        pos++;
    }
    }
    public static void insertar_letra_en_arreglo(char [] arr,char numeroParaIngresar){
        int pos=0;
        while((pos<MAXFILA)&&(numeroParaIngresar>arr[pos])){
            pos++;
        }
        System.out.println("pos vale:" + pos);
        if(pos<MAXFILA){
            corrimiento_der(arr,pos);
            arr[pos]=numeroParaIngresar;
        }
        else{
            arr[MAXFILA-1]=numeroParaIngresar;
        }
    }

    public static void corrimiento_der(char [ ] arr, int pos){
        int indice = MAXFILA-1;
        while(indice>pos){
        arr [indice] = arr [ indice -1];
        indice--;
        }
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
    public static void cargar_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_char(mat[fila]);
        }
    }
    public static void cargar_arreglo_char(char [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (char)(r.nextInt(26) + 'a');
        }
    }

}
