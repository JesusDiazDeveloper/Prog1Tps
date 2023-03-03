package Ejercicios;
/*6. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, 
solicite al usuario un numero entero 
y elimine todas las ocurrencias de numero en el arreglo. 
Mientras exista (en cada iteración tiene que buscar la posición dentro del
arreglo) 
tendrá que usar la posición para realizar un corrimiento a izquierda 
(quedarán tantas copias de la última posición del arreglo 
como cantidad de ocurrencias del número).*/


import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_6{

    public static final int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
    public static void main (String []args){
        int [] arrenteros = new int [MAX]; 
        int numero;
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros);
        try{
            System.out.println("Ingrese un numero para eliminar del arreglo: ");
            numero = Integer.valueOf(entrada.readLine());
            elminar_todas_las_ocurrencias(arrenteros, numero);
            imprimir_arreglo_int(arrenteros);
        }
        catch(Exception exc){
            System.out.println(exc);
        }

    }
    public static void elminar_todas_las_ocurrencias(int [] arrenteros, int numero){
        int posicion = 0;
        if(arrenteros[MAX-1]==numero){
            arrenteros[MAX-1]= 0;
        }
        while (posicion<MAX-1){
            if (arrenteros[posicion]==numero){
                corrimiento_izq(arrenteros, posicion);
                posicion++;
            }
            else{
                posicion++;
            }
        }
    }

      //-----------------------------------------------------------------------------------------------------------
  // carga de arreglo de int con valores de MINVALORaMAXVALOR

    public static void corrimiento_izq (int [] arr, int pos){
        while (pos<MAX-1){
            arr[pos]=arr[pos+1];
            pos++;
        }
    }

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
