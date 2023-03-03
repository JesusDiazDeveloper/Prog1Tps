/*4. Escribir un programa que 

mientras el usuario cargue desdeteclado un numero entero distinto de 0, 
imprima por pantalla la suma que se obtiene de 
invocar un método
     que calcula la sumatoria de los primeros 200 números
     naturales (son números enteros en 1 y 200).


     importar librerias

     main ()
         declarar entero
                 comprobar
                 buffer 
     
         mientras (comprobar = true) 
            pedir numero entero
            guardarlo en entero 
            if (entero distinto de 0 )
                
                 metodo de suma ()
             else 
                 comprobar false
     
     metodo sumar 
         int suma = 0 
             for hasta 200 que sume el valor de i en cada iteracion a suma. 
             imprimir por pantalla  suma 
     */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C_6_E_{
    public static void main(String [] args) {
        int entero; 
        boolean comprobar = true; 
        BufferedReader entrada = new BufferedReader ( new InputStreamReader (System.in));

        
            try{
	            while(comprobar == true){
	        	System.out.println("Ingrese un numero entero distinto de 0");
	            entero = Integer.valueOf(entrada.readLine());
	            if (entero != 0){
	                suma_hasta_200();
	            }
	            else{
	                comprobar = false;
	                System.out.println("el programa finalizo");
	            }
	            }
            }
            catch(Exception exc){
            	System.out.println(exc);
            }
        }
    public static int suma_hasta_200(){
        int suma = 0; 
        int valorMaximo= 200;
        for (int i = 0 ; i<=valorMaximo; i++){
            suma += i;
        }
        System.out.println("el valor es " + suma);
        return suma; // esto no se porque no funciona. PREGUNTAR. 
    }
}




        
