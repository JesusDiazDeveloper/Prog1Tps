package Ejercicios;
/*
8. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y elimine la primer ocurrencia de numero (un número igual) en el
arreglo (si existe).

 */
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_8{
    public static int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
    public static void main (String [] args ){
        int [] arrenteros = new int [MAX];
        int numeroIngresado, pos; 
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        ordenar_arreglo_burbujeo(arrenteros);
        imprimir_arreglo_int(arrenteros);
        try{
            System.out.println("ingrese un numero para eliminar su primera ocurrencia");
            numeroIngresado = Integer.valueOf(entrada.readLine());
            pos = encontrar_primer_ocurrencia (arrenteros , numeroIngresado);
            if (( pos < MAX-1)){
                System.out.println("ese numero esta en la posicion " + pos + "\nvamos a elminarlo" );
                corrimiento_izquierda(arrenteros, pos);
                imprimir_arreglo_int(arrenteros);
            }
            else {
                System.out.println("el numero no existe en el arreglo");
            }
          	
        }  
        catch(Exception exc){

        }
    }    

    public static void corrimiento_izquierda(int [] arr , int pos){
       while(pos < MAX -1){
        arr [pos] = arr[pos+1];
        pos++;
        }
    }

    public static int encontrar_primer_ocurrencia (int [] arrenteros ,int numeroIngresado){
        int pos = 0;
        while ((pos < MAX -1) && (numeroIngresado != arrenteros[pos])){
            pos++;
        }
        return pos;
    }





    public static void ordenar_arreglo_burbujeo(int[] arr){
        int temp; 										//defino variable temporal
        for(int i = 1;i < MAX;i++){				//for  i menor que MAX i++
        for (int j = 0 ; j < MAX - 1; j++){		// for j menor que MAX-1 ; j++
        if (arr[j] > arr[j+1]){		// si arreglo en posicion [j] es mayor que arr[j+1](que es el siguiente)
        temp = arr[j];				// entonces guardo el valor la posicion j en la temporal
        arr[j] = arr[j+1];			// a la posicion j le doy el valor de j+1 (la siguiente que seria mas pequeña)
        arr[j+1] = temp;				//a la posicion [j+1] le doy el valor que guarde en temp.  
        }
        }
        }
        }
    //-----------------------------------------------------------------------------------------------------------
  // carga de arreglo de int con valores de MINVALORaMAXVALOR

  public static void cargar_arreglo_aleatorio_int(int[]arr){
    Random r=new Random();
    for(int pos = 0;pos<MAX;pos ++){
    arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
    }
}


// impresion de arreglo de int (ABAJO)
    public static void imprimir_arreglo_int(int[]arr){
    for(int pos=0;pos<MAX;pos ++){
    System.out.println("nombre_arreglo["+pos+"]=>:"+arr[pos]);
    }
    }
}