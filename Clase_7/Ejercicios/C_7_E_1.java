package Ejercicios;
/*1. Hacer un programa que dado un arreglo de enteros 
de tamaño 10 que se encuentra precargado,
invierta el orden del contenido 
(por ejemplo: el que está en 0 se intercambia
con el que está en 9, el que está en 1 con el que está en 8...). 
Este intercambio no se debe realizar de manera explícita, 
hay que hacer un método que incluya una iteración de  intercambio.
*/

/* 
 import random 
 main 
    delcaro max.
            maxvalor.
            min valor.
    declarar arreglo
        
    cargar arreglo 
    imprimir arreglo 
    invertir_el_orden_del_arreglo(arrenteros);
    System.out.println(arrenteros);

    public static void invertir_el_orden_del_arreglo(arrenteros)
    int temporal;
    for (int i=0; i < MAX/2 ; i++){
        temporal= i;
        arrenteros [i] = arrenteros [MAX]-1-i;
        arrenteros [MAX-1-i] = temporal;
    }
 */

import java.util.Random;

public class C_7_E_1 {
   	public static final int MAX = 10; // tamaño del arreglo
    public static final int MAXVALOR=10; // Valor para cargar del arreglo
    public static final int MINVALOR=1; // Valor para cargar del arreglo
    public static void main (String[]args){
        int [] arrenteros = new int [MAX]; 
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros); 
        invertir_el_orden_del_arreglo(arrenteros);
        System.out.println("\n\n Ahora, el arreglo esta invertido: ");
        imprimir_arreglo_int(arrenteros);
    }

    public static void invertir_el_orden_del_arreglo(int [] arrenteros){
        int auxiliar;
        for (int i=0; i<MAX/2 ; i++){
        	auxiliar = arrenteros [MAX-1-i]; // auxiliar guarda el numero que esta en la posicion MAX-1-i (10-1-0 = 9)
        	arrenteros [MAX-1-i] = arrenteros[i]; // i vale 0 --> a la posicion 10-1-0 (posicion 9) = a lo que esta en la posicion 0 
        																// i vale 1 -->  2da vuelta: 10 -1-1 (posicion 8) =  a lo que esta en la posicion 1
        	arrenteros [i]= auxiliar;// lo mismo pero invertido, a la poscicon10-1-0 (posicion 9) = al valor que guarde de lo que valia i
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


