package Ejercicios;
import java.util.Random;

public class C_7_E_12 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;
    public static void main (String [] args){
        int [] arr = new int [MAX];
        int resultado;
        cargar_secuencias(arr);
        imprimir_arreglo(arr);
        resultado = obtener_inicio_anteultima_secuencia (arr);
        System.out.println("la posicion de inicio de la anteultima secuencia es: " + resultado);
    }
    public static int obtener_inicio_anteultima_secuencia (int [] arr){
        int contador=0;
        int posInicio= MAX-1;
        int posFin;
        while(contador != 2){
        System.out.println("entro en el while y posInicio vale " + posInicio);
        posFin = obtener_fin_secuencia_desde_derecha(arr, posInicio); 
        System.out.println("1er fin de secuencia: " + posFin );
        posInicio = obtener_incio_secuencia_adentro(arr , posFin);
        System.out.println("1er inicio de secuencia: " + posInicio );
        if (posInicio != 0 ){contador++;}
        posInicio--;// 
    }
    
    return posInicio+1;
    }

    public static int obtener_incio_secuencia_adentro (int [] arrenteros,int pos){
        while(arrenteros [pos] != 0){
            pos--;
        }
        return pos+1;
    }

    public static int obtener_fin_secuencia_desde_derecha(int [ ] arrenteros, int pos) {
        while(arrenteros[pos] == 0){
            pos--;
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
    
    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}

/*
 * 12. Hacer un programa que dado el arreglo definido y precargado 
 * permita encontrar la
posición de inicio de la anteúltima secuencia (considerar comenzar a buscarla a
partir de la ultima posición del arreglo).

 */