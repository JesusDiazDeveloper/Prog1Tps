package Ejemplos;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.util.Random;



public class C_7_Ejemp_4 {
    public static final int MAX = 10; 
    public static final int MAXVALOR=10;
    public static final int MINVALOR=1;
    public static void main (String[]args){
        int [] arrenteros = new int [MAX];
        int numero, resultado; 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        cargar_arreglo_aleatorio_int(arrenteros);
        imprimir_arreglo_int(arrenteros);

        try {
            System.out.println("Ingrese un entero para verificar su posicion");
            numero = Integer.valueOf(entrada.readLine());
            resultado = verificar_si_existe_numero_dentro_del_arreglo(arrenteros, numero);
            if (resultado < MAX){
                System.out.println( "La posicion de ese valor es " + resultado); 
            }
            else{
                System.out.println( numero + " no existe dentro del arreglo");
                 }
        }
                 catch(Exception exc) {
        System.out.println(exc);
    }
    }


    public static int verificar_si_existe_numero_dentro_del_arreglo(int [] arrenteros, int numero){
    int pos = 0; 
    while ((pos < MAX ) && (numero != arrenteros[pos])){
        pos++;
    } 
    return pos; 
}
	
// carga de arreglo de int
    public static void cargar_arreglo_aleatorio_int(int[]arr){
        Random r=new Random();
        for(int pos = 0;pos<MAX;pos ++){
        arr[pos]=(r.nextInt(MAXVALOR-MINVALOR+1)+MINVALOR);
        }
    }

// impresion de arreglo de int
    public static void imprimir_arreglo_int(int[]arr){
    for(int pos=0;pos<MAX;pos ++){
    System.out.println("nombre_arreglo["+pos+"]=>:"+arr[pos]);
    }
}
}