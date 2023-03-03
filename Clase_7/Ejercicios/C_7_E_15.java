package Ejercicios;

/*
 15. Hacer un programa que dado el arreglo definido y precargado
elimine del arreglo todas las ocurrencias 
de una secuencia patrón dada por otro arreglo de iguales
características (solo tiene esa secuencia). 
Al eliminar se pierden valores haciendo corrimientos.

    voy a necesitar: 
    cargar un arreglo con un patron que yo elija, 
    cargar un arreglo con secuencias. 
    2 arreglos A (tiene el patron) y B (tiene las secuencias). 
    variable para el tamanio de las secuencias de A y B las secuencias
    primero agarro la secuencia de A, saco el tamanio 
    luego comparo el tamanio con las siguientes secuencias de B 
    si el tamanio coincide, verifico si la posicion inicio es igual, 
    luego la siguiente, hasta fin. 
    si es asi, eliminar secuencia () en B. 
    y recorrer asi todo el arreglo B. 

 */
import java.util.Random;

public class C_7_E_15 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        int[] arregloPatron = new int[MAX];
        // int[] arregloPrincipal = new int[MAX];
        int[] arregloPrincipal = {0,1,0,2,2,0,0,0,4,4,0,2,2,0,7,2,2,0,0,0};
        int tamanioPatron = 0;
        int tamanioSecuencia = 0;
        int inicioSecuencia = 0;
        int finSecuencia = -1;
        int inicioPatron;
        int finPatron = -1;
        boolean sonIguales;
        cargar_patron(arregloPatron);
        imprimir_arreglo(arregloPatron);
        imprimir_arreglo(arregloPrincipal);
        //detecto el tamanio del patron: 
        inicioPatron = obtener_inicio_siguiente_secuencia(arregloPatron, finPatron + 1);
        finPatron = obtener_fin_secuencia(arregloPatron, inicioPatron);
        tamanioPatron = evaluar_tamanio_secuencia(arregloPatron, inicioPatron, finPatron);
        inicioSecuencia = obtener_inicio_siguiente_secuencia(arregloPrincipal, finSecuencia + 1);
        while(inicioSecuencia< MAX-1) {
            finSecuencia = obtener_fin_secuencia(arregloPrincipal, inicioSecuencia);
            System.out.println("Encontro una secuencia en: " + inicioSecuencia +" y " + finSecuencia);
            tamanioSecuencia = evaluar_tamanio_secuencia(arregloPrincipal, inicioSecuencia, finSecuencia);
            sonIguales = comparar(arregloPrincipal, inicioSecuencia, finSecuencia, tamanioSecuencia, arregloPatron, inicioPatron, finPatron , tamanioPatron);
                if (sonIguales) { /*como es expresion logica no necesito validar, si sonIguales es true, lo hace, si es false, no*/
                    System.out.println("eliminando secuencia en: " + inicioSecuencia + " y " + finSecuencia); 
                    eliminar_secuencia(arregloPrincipal, inicioSecuencia, finSecuencia);
                    System.out.println("inicio de suencia vale " + inicioSecuencia + " y fin de secuencia vale " + finSecuencia);
                    finSecuencia = inicioSecuencia-1; /* esto lo hago porque si no, el fin va a seguir valiendo lo mismo, o sea, esa posicion, pero al eliminar numeros, y correr el arreglo, otras secuencias pueden haber ingresado, asique tengo que empezar a buscar el proximo inicio desde el inicio anterior, porque lo otro fue eliminado. */
                    System.out.println("LUEGO inicio de suencia vale " + inicioSecuencia + " y fin de secuencia vale " + finSecuencia);
                    imprimir_arreglo(arregloPrincipal);
                }   
            inicioSecuencia = obtener_inicio_siguiente_secuencia(arregloPrincipal, finSecuencia + 1);
            }       
        System.out.println("el arreglo con las secuencias eliminadas: ");
        imprimir_arreglo(arregloPrincipal);
    }

    public static void eliminar_secuencia (int [] arr, int inicio, int fin){
        for(int i = inicio; i<=fin; i++){
            corrimiento_izquierda(arr, inicio);
        }
    } public static void corrimiento_izquierda(int [] arr , int pos){
        while(pos < MAX -1){
         arr [pos] = arr[pos+1];
         pos++;
         }
     }
   

    public static boolean comparar(int [] arregloPrincipal, int inicioSecuencia, int finSecuencia, int tamanioSecuencia, int[] arregloPatron, int inicioPatron, int finPatron , int tamanioPatron) {
        boolean comprobacion=false;
        if (tamanioSecuencia == tamanioPatron){ // solo entra en el while si son del mismo tamanio
            while(inicioSecuencia <= finSecuencia && arregloPrincipal[inicioSecuencia] == arregloPatron[inicioPatron]) { // va a incrementar solo si tienen lo mismo adentro
            inicioSecuencia++; // incrementa el numero que tiene la variable, pero no lo que esta adentro del arreglo 
            inicioPatron++; // lo mismo, y como son copias, no pasa nada, porque no se modifica afuera, sirve solo aca adentro. 
            }
        }
        if (inicioSecuencia > finSecuencia){ // le pongo esta condicion porque si eran todos iguales, cuando comparo inicioSecuencia es menor o igual  a finSecuencia y dijo que era igual, lo aumento en 1, por ende, se paso, inicio luego de la comparacion es mas grande, por eso luego corta el while. 
            comprobacion = true; 
        }
        return (comprobacion);
    }

    public static int evaluar_tamanio_secuencia(int[] arr, int inicio, int fin) {
        int pos = inicio;
        int contador = 0;
        while (pos <= fin) {
            contador++;
            pos++;
        }
        return contador;
    }

    public static void cargar_secuencias(int[] arr) {
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

    public static void cargar_patron(int[] arr) {
        // voy a cargar el arreglo con un 22 ..
        for (int i = 0; i < MAX; i++) {
            if ((i == 2) || (i == 3)) {
                arr[i] = 2;
            }
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }

    public static int obtener_fin_secuencia(int[] arrenteros, int pos) {
        while (arrenteros[pos] != 0) {
            pos++;
        }
        return pos - 1;
    }

    public static int obtener_inicio_siguiente_secuencia(int[] arrenteros, int pos) {
        while ((pos < MAX - 1)&&(arrenteros[pos] == 0)) { 
            pos++;
        }
        return pos;
    }
}