package Ejercicios;

import java.util.Random;

public class C_7_E_11 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
    int [] arr= new int [MAX]; 
    cargar_secuencias(arr);
    imprimir_arreglo(arr);
    int resultado = encontrar_inicio_sec_mas_grande(arr);
    System.out.println("la posicion de inicio de la secuencia cuya suma es mayor es: " + resultado); 
}

public static int encontrar_inicio_sec_mas_grande(int [] arr){
    int inicio = 0;
    int fin = -1;
    int inicioMayor=0;
    int sumaMayor=0;
    int sumaActual = 0; 
    while( inicio <MAX-1){
        inicio = obtener_inicio_siguiente_secuencia(arr, fin+1);
        fin= obtener_fin_secuencia(arr, inicio);
        sumaActual = obtener_suma_de_secuencia(arr,inicio,fin);
        System.out.println( sumaActual + " en la posicion " + inicio); // esto se puede sacar, es para ver mas facil las sumas. 
        if(sumaActual > sumaMayor){
            sumaMayor = sumaActual;
            inicioMayor = inicio; 
        }
        sumaActual=0;
        inicio=fin;
        inicio++;
    }
    return inicioMayor;   

} 

public static int obtener_suma_de_secuencia(int [] arr, int inicio, int fin){
    int suma = 0; 
    while(inicio <= fin){
        suma+=arr[inicio];
        inicio++;
    }
    return suma; 
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
public static int obtener_fin_secuencia(int [ ] arrenteros, int pos) {
    while(arrenteros[pos] != 0){
        pos++;
    }
    return pos-1; 
}

public static void cargar_secuencias(int [ ] arr) {
    Random r = new Random();
    arr[0] = 0;
    arr[MAX - 1] = 0;
    for (int pos = 1; pos < MAX - 1; pos++) {
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
}
/* tengo que recorrer todo el arreglo, y encontrar las secuencias, e ir comparandolas, 
 * si la suma de la secuencia A es mayor que la de la secuencia B, sigo con la secuencia A
 * si no, A ahora va a vale ¨¨ 
 */

// 11. Hacer un programa que dado el arreglo definido y precargado permita encontrar la
// posición de inicio de la secuencia cuya suma de valores sea mayor.
