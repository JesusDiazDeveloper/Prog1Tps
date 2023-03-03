package Ejercicios;
/*
 9. Hacer un programa que dado un arreglo de enteros de tamaño 10 que se
encuentra precargado, solicite al usuario el ingreso de dos números
enteros (posiciones del arreglo) y ordene de forma creciente el arreglo
entre dos posiciones correspondientes a los números ingresados.
 */


import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_9{
    public static int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
        public static void main (String [] args ){
        int [] arrenteros = new int [MAX];
        int posInicio;
        int posFin;  
        BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros);
        
        try{
            System.out.println("Ingrese la posicion menor: ");
            posInicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posicion Mayor: ");
            posFin = Integer.valueOf(entrada.readLine());
            ordenar_arreglo_entre_dos_posiciones(arrenteros, posInicio, posFin);
          	imprimir_arreglo_int(arrenteros);
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }

    public static void ordenar_arreglo_entre_dos_posiciones(int [] arr,int posInicio,int posFin){
        int temp; 										//defino variable temporal
        for(int i = posInicio ; i <= posFin; i++){				//for  i menor que MAX i++
            for (int j = posInicio ; j <= posFin; j++){		// for j menor que MAX-1 ; j++
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



