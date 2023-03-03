package Ejercicios;
/*
    14. Hacer un programa que dado el arreglo definido y precargado,
    y un número entero ingresado por el usuario, 
    copie de forma continua las secuencias de tamaño igual alnúmero ingresado 
    en otro arreglo de iguales características e inicializado con 0. 
    La copia en este último arreglo deben comenzar desde el principio del mismo.
    
    /*try 
        pedir el numero al usuario 
        guardarlo
        recorrer el arreglo buscando una secuencia con ese tamaño, 
        si la encuentra, ir cargando desde atras para adelante en la posicion 
        0 el arreglo. 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class C_7_E_14 {
        public static final int MAX = 20;
        public static final int MAXVALOR = 9;
        public static final int MINVALOR = 1;
        public static final double PROBABILIDAD = 0.4;
    public static void main (String [] args){
        int [] A = new int [MAX];
        int [] B = new int [MAX];
        int numeroIngresado; 
        int pos = 0;
        int tamanio=0;
        int inicio=0;
        int fin = -1; 
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in) );
        cargar_secuencias(A);
        cargar_arreglo_con_0(B);
        imprimir_arreglo(A);
        imprimir_arreglo(B);
        try{
            System.out.println("ingrese un numero: ");
            numeroIngresado= Integer.valueOf(entrada.readLine());
            while (pos<MAX-1){
                inicio = obtener_inicio_siguiente_secuencia(A, fin+1);
                fin = obtener_fin_secuencia(A, inicio);
                tamanio = evaluar_tamanio_secuencia(A, inicio,fin);
                System.out.println("tamanio vale " + tamanio );
                if (tamanio == numeroIngresado ){
                copiar_secuencia_en_otro_arreglo( A, B, inicio, fin );
                imprimir_arreglo(B);
                } 
                System.out.println("fin vale:" + fin);  
                pos=fin;
                pos++;
                System.out.println("y ahora pos vale:" + pos);  
        }
        }
        catch(Exception exc){
            System.out.println(exc);
        }
        

    }
    public static void copiar_secuencia_en_otro_arreglo( int [] A, int [] B, int inicio, int fin ){
        //esto copia desde atras para adelante, o sea, desde fin hasta inicio.
        int pos=0;
        while(fin>=inicio){
            corrimiento_derecha(B, pos);
            B[0]=A[fin];
            fin--;
        }
    }
    
    public static void corrimiento_derecha(int [] arr, int pos){
        for(int i=MAX-1; i>pos; i--){
            arr [i] = arr [i-1]; 
        }
    }

    public static void cargar_arreglo_con_0(int [] arr){
        for (int i = 0; i < MAX ; i++){
            arr[i]= 0;
        }
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
    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
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
    public static int evaluar_tamanio_secuencia(int [] arr,int  inicio,int fin){
        int pos = inicio ;
        int contador = 0;
        while (pos<=fin){
            contador++;
            pos++;
        }
        return contador;
    }
}