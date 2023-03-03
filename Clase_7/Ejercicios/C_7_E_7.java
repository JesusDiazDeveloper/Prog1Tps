package Ejercicios;
/*
7. Hacer un programa que dado un arreglo ordenado creciente de enteros
de tamaño 10 que se encuentra precargado, solicite al usuario un numero
entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del arreglo)
y colocar el numero en el arreglo en la posición indicada.
*/

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_7{
    public static int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
    public static void main (String [] args ){
        int [] arrenteros = new int [MAX];
        int numeroIngresado; 
        int posicionIngresada;
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        ordenar_arreglo_burbujeo(arrenteros);
        imprimir_arreglo_int(arrenteros);
        try{
            System.out.println("Ingrese un valor desde el cual hacer el corrimiento: ");
            posicionIngresada = Integer.valueOf(entrada.readLine());
            System.out.println("ingrese un numero para ingresar en esa posicion ");
            numeroIngresado = Integer.valueOf(entrada.readLine());
            insertar_numero_en_arreglo_ordenado(arrenteros, posicionIngresada, numeroIngresado);
          	imprimir_arreglo_int(arrenteros);
        }  
        catch(Exception exc){

        }

    }

    public static void insertar_numero_en_arreglo_ordenado(int []arrenteros, int posicionIngresada, int numeroIngresado){
        int posicion = MAX-1;
        while(posicion>=posicionIngresada){
            if(posicionIngresada==posicion){
                arrenteros[posicion]=numeroIngresado;
            }
            else{arrenteros[posicion]=arrenteros[posicion-1];
            }
            posicion--;
        }
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


    
