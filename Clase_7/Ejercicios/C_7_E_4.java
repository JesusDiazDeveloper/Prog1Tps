package Ejercicios;
/*
 4. Hacer un programa que dado un arreglo de enteros de tamaño 10 
 que se encuentraprecargado, 
 solicite al usuario un numero entero y lo agregue al principio 
del arreglo (posición 0). Para ello tendrá que realizar un corrimiento 
a derecha (se pierde el último valor del arreglo) 
y colocar el numero en el arreglo en la posición indicada.


    declarar arreglo
            numero a ingresar
    cargar arreglo
    imprimir arreglo 
    
    try 
        pedir valor a ingresar
        guardarlo 
        agregar_valor_al_inicio_del_arreglo(arrenteros, numero);
        imprimir el arreglo de nuevo. 


    public static void agregar_valor_al_inicio_del_arreglo(int [] arrenteros,int numero){
        for (int i=0 ; i < MAX ; i++ ){
            aux=arrenteros[i]
            if (i=0){
                arrenteros[0]= numero;
            }
            else{
                arrenteros[i+1] = arrenteros[i]; 
            }
        }

    }
 */

 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;

public class C_7_E_4{

    public static final int MAX=10;
    public static final int MINVALOR=1;
    public static final int MAXVALOR= 10;
    public static void main (String [] args){
        int [] arrenteros = new int [MAX];
        int numero; 
    cargar_arreglo_aleatorio_int(arrenteros);
    imprimir_arreglo_int(arrenteros);
	BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
    try{ 
    System.out.println("Ingrese el valor que ocupara la primera posicion: ");
    numero= Integer.valueOf(entrada.readLine());
    agregar_valor_al_inicio_del_arreglo(arrenteros, numero);
    imprimir_arreglo_int(arrenteros);
    }
    catch(Exception exc){
        System.out.println(exc);
    }

    
    }
    public static void agregar_valor_al_inicio_del_arreglo(int [] arrenteros,int numero){
	  int posicion = 0;  
      int indice = MAX-1; 
      	while(indice>posicion){
          arrenteros[indice]= arrenteros[indice-1];
          indice--;
        }
      arrenteros[0]=numero;
      
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
 