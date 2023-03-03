package Ejercicios;

/*16. Hacer un programa que dado el arreglo definido y precargado elimine todas las
secuencias que tienen orden descendente entre sus elementos.
*/
import java.util.Random;

public class C_7_E_16 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        int[] arrenteros = new int[MAX];
        cargar_secuencias(arrenteros);
        imprimir_arreglo(arrenteros);
        eliminar_secuencias_desendentes(arrenteros);
        imprimir_arreglo(arrenteros);
    }

    public static void eliminar_secuencias_desendentes(int[] arrenteros) {
        int inicio = 0;
        int fin = -1;
        boolean comprobacion;
        int tamanio;
        inicio = obtener_inicio_siguiente_secuencia(arrenteros, fin + 1);
        System.out.println("inicio antes del while empieza en: " + inicio);
        while (inicio < MAX - 1) {
            fin = obtener_fin_secuencia(arrenteros, inicio);
            comprobacion = es_desendente(arrenteros, inicio, fin);
            tamanio = evaluar_tamanio_secuencia(arrenteros, inicio, fin);
            if ((comprobacion == true ) && (tamanio>1)){
                eliminar_secuencia(arrenteros, inicio, fin);
                System.out.println("fin es:" + fin);
                System.out.println("encontre un inicio de desendente en y BORRANDO:" + inicio);
                fin=inicio-1; // hago esto porque si no, cuando vuelva a buscar el proximo inicio, va a empezar desde fin +1, y yo necesito volver a comprobar desde el lugar donde borre la secuencia. 
                System.out.println("inicio -1 y fin es : " + fin );
                imprimir_arreglo(arrenteros); 
            }
            inicio = obtener_inicio_siguiente_secuencia(arrenteros, fin + 1);
        }

    }

    public static void eliminar_secuencia (int [] arr, int inicio, int fin){
        for(int i = inicio; i<=fin; i++){
            corrimiento_izquierda(arr, inicio);
        }
    }

    public static void corrimiento_izquierda(int[] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static boolean es_desendente(int[] arrenteros, int inicio, int fin) {
        boolean comprobacion = false;

        while ((arrenteros[inicio] > arrenteros[inicio + 1]) && (inicio < fin)) {
            System.out.println("inicio vale: " + inicio);
            inicio++;
        }
        if (inicio == fin) {
            comprobacion = true;
            System.out.println("comprobacion es true");
        }

        return comprobacion;
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
    public static int evaluar_tamanio_secuencia(int[] arr, int inicio, int fin) {
        int pos = inicio;
        int contador = 0;
        while (pos <= fin) {
            contador++;
            pos++;
        }
        return contador;
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
        if (arrenteros[pos] != 0) {
            pos = obtener_fin_secuencia(arrenteros, pos);
            pos++;
        }
        while ((pos < MAX - 1) && (arrenteros[pos] == 0)) {
            System.out.println("obtener siguiente inicio: pos vale " + pos);
            pos++;
        }
        return pos;
    }
}
