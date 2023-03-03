package Ejercicios;
/*
3. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, 
solicite al usuario una posición y 
realice un corrimiento a izquierda o hacia la menor posición del arreglo.

 */

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_3{

    public static final int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
    public static void main (String []args){
        int [] arrenteros = new int [MAX]; 
        int numeroIngresado;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros); 

        try{
            System.out.println("Por favor ingrese una posicion para hacer el corrimiento a izquierda: ");
            numeroIngresado= Integer.valueOf(entrada.readLine());
            corrimiento_izquierda(arrenteros, numeroIngresado);
            imprimir_arreglo_int(arrenteros); 
        }
        catch(Exception exc){
            System.out.println(exc);
        }


    }

    public static void corrimiento_izquierda(int []arrenteros, int numeroIngresado){
        int posicion = 1; 
        while((posicion <= numeroIngresado) ){
            arrenteros [posicion-1] = arrenteros [posicion];
            posicion++;
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

