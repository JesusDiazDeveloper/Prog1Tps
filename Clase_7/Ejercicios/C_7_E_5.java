package Ejercicios;
/*
5. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra
precargado, solicite al usuario un numero entero y elimine la primer 
ocurrencia del numero (un número igual) en el arreglo (si existe).
Para ello tendrá que buscar la posición y si está,
realizar un corrimiento a izquierda (queda una copia de la última posición del arreglo en la
anteúltima posición). 
 */

 
 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_5{

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
            elminar_primera_ocurrencia(arrenteros, numero);
            imprimir_arreglo_int(arrenteros);
        }
        catch(Exception exc){

        }

    }


    public static void elminar_primera_ocurrencia(int[]arrenteros, int numero){
        int pos=0;
        while ((pos < MAX ) && (numero != arrenteros[pos])){
            pos++;
        }
        	if(numero == arrenteros[pos]){
            while(pos<MAX-1){
            arrenteros [pos] = arrenteros [pos+1]; 
          	System.out.println("esto funciona");
          	pos++;
                  }
         	}
             // no funciona esta parte, deberia imprimir que el valor no existe.
             else if (pos == MAX){ 
               	System.out.println("ese valor no existe en el arreglo");
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
