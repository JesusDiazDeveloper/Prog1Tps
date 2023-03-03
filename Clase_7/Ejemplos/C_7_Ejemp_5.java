package Ejemplos;

/* Hacer un programa que dado un arreglo de enteros de tamano 8 que se 
encuentra precargado, solicite al usuario una posicion y
realice un corrimiento a derecha o hacia la mayor posicion del arreglo. 
Ademas imprima el arreglo antes y despues del corrimiento */

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;



public class C_7_Ejemp_5 {
    public static final int MAX = 8; // tamaño del arreglo
    public static final int MAXVALOR=10; // Valor para cargar del arreglo
    public static final int MINVALOR=1; // Valor para cargar del arreglo
    public static void main (String[]args){
        int [] arrenteros;
        arrenteros = new int [MAX];  
        int posicion; 
      	BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros);
        try{
            System.out.println("Ingrese la posicion del arreglo: ");
            posicion = Integer.valueOf(entrada.readLine());
            hacer_corriemiento_a_derecha(arrenteros ,posicion );
            imprimir_arreglo_int(arrenteros);
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }
    /*Un corrimiento a derecha es:

        mientras indice < poscion (porque empieza de atras para adelante). 
        Me paro en la ultima posicion, seria: indice = MAX-1; maximo es 8, se para en 7. 
        Si no es asi, copio el valor de la posicion [indice -1](1 a la izquierda) a [indice](en donde estoy parado)
        paso a la siguiente posicion decrementando el indice en 1. (indice--); 
        
        */ 
    public static void hacer_corriemiento_a_derecha(int [] arr, int posicion ){
        int indice = MAX-1; 
        while (indice>posicion){
            arr [indice] = arr [indice-1]; 
            indice--;
        }
    }


    





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
