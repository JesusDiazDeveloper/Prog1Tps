package Ejercicios;

/*2. Hacer un programa que dado un arreglo de 
enteros de tamaño 10 que se encuentra
precargado, obtenga la cantidad de números 
pares que tiene y la imprima.
 */

/*
importar ramdom 

main 
    variables constantes x3
    declarar arreglo
            int resultado
    cargarlo 
    imprimirlo 
    resultado = obtener_cantidad_de_numeros_pares;
    imprimir variable resultado

    metodo funcion int (int [] arrenteros){
        int cantidad_de_pares= 0;
        for (recorrer x max){
            if ((arrenteros[i] %2 == 0 ) ||(arrenteros[i]== 0 )){
                cantidad_de_pares++
            }        
        }
        return cantidad_de_pares
    } 

*/
import java.util.Random;
    public class C_7_E_2 {
      public static final int MAX=10;
      public static final int MINVALOR=1;
      public static final int MAXVALOR= 10;
    	public static void main (String[]args) {

              
            int [] arrenteros= new int [MAX];
            int resultado;
            cargar_arreglo_aleatorio_int(arrenteros);
            imprimir_arreglo_int(arrenteros); 
            resultado = obtener_cantidad_de_numeros_pares(arrenteros);
            System.out.println("la cantidad de pares es: " + resultado);
        
    } 

    
    public static int obtener_cantidad_de_numeros_pares(int [] arrenteros){
        int cantidad_de_pares= 0;
        for (int i=0 ; i<MAX ; i++){
            if ((arrenteros[i] %2 == 0 ) ||(arrenteros[i]== 0 )){
                cantidad_de_pares++;
            }        
        }
      	
        return cantidad_de_pares;
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
    System.out.println("arrenteros["+pos+"]=>:"+arr[pos]);
    }
    }


}
