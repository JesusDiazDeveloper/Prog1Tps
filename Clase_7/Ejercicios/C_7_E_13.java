package Ejercicios;
/*
 13. Hacer un programa que dado el arreglo definido y precargado, 
 y un número entero ingresado por el usuario, 
elimine las secuencias de tamaño igual al número ingresado.
 */
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C_7_E_13 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;
    public static void main (String [] args){
    int numeroIngresado;
    int [] arr = new int [MAX];
    BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
    cargar_secuencias(arr);
    imprimir_arreglo(arr);
    try{
        System.out.println("Ingrese un numero");
        numeroIngresado = Integer.valueOf(entrada.readLine()); 
        eliminar_secuencias_tamanio_ingresado(arr ,numeroIngresado);
        imprimir_arreglo(arr);
    }
    catch(Exception exc){
        System.out.println(exc);
    }
    }
    public static void eliminar_secuencias_tamanio_ingresado( int [] arr , int numeroIngresado ){
    int pos = 0;
    int tamanio=0;
    int inicio=0;
    int fin = -1; 
    while (pos<MAX-1){
        inicio = obtener_inicio_siguiente_secuencia(arr, fin+1);
        fin = obtener_fin_secuencia(arr, inicio);
        tamanio = evaluar_tamanio_secuencia(arr, inicio,fin);
        System.out.println("tamanio vale " + tamanio );
        if (tamanio == numeroIngresado){
            System.out.println("inicio vale: " + inicio);//ESTO ES PARA QUE SEA MAS VISUAL SOLAMENTE
            System.out.println("fin vale: " + fin);//ESTO ES PARA QUE SEA MAS VISUAL SOLAMENTE
            System.out.println("ELIMINANDO SECUENCIA");//ESTO ES PARA QUE SEA MAS VISUAL SOLAMENTE
            eliminar_secuencia(arr,inicio,fin);
        }
        pos=fin;
        pos++;
    }
        /*

        crear metodo contador cantidad de elementos
        siguo recorriendo hasta la posicion MAX -1. */

    }
    public static int evaluar_tamanio_secuencia(int [] arr,int  inicio,int fin){
        int pos = inicio ;
        int contador = 0;
        while (pos<=fin){
            contador++;
            pos++;
        }
        return contador;
    }
    
    public static void eliminar_secuencia (int [] arr, int inicio, int fin){
        for(int i = inicio; i<=fin; i++){
            corrimiento_izquierda(arr, inicio);
        }
    }

    public static int obtener_fin_secuencia(int [ ] arrenteros, int pos) {
        while(arrenteros[pos] != 0){
            pos++;
        }
        return pos-1; 
    }
    
    public static int obtener_inicio_siguiente_secuencia(int [ ] arrenteros, int pos) {
        if(arrenteros [pos] != 0){
            pos= obtener_fin_secuencia(arrenteros, pos);
            pos++;
        }
        while((arrenteros[pos] == 0 ) && (pos < MAX-1)){ // pongo MAX-1 porque se que en la posicion 19 hay 1 cero, entonces, si en la posicion 18 todavia hay un 0, quiere decir que no va a haber otra secuencia. y porque si no pongo esto, el bucle seria infinito porque pos una vez que llega a 19 nunca va a ser distinto de 0. 
            pos++;
        }
        return pos;
    }

    public static void cargar_secuencias(int [ ] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;
        for (int pos = 1; pos < MAX-1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }
    public static void corrimiento_izquierda(int [] arr , int pos){
        while(pos < MAX -1){
         arr [pos] = arr[pos+1];
         pos++;
         }
     }
    


    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
