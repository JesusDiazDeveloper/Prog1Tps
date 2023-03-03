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

public class C_6_E_4{
    public static void main(String [] args) {
        int entero; 
        boolean comprobar = true; 
      	int MAX = 200;
        BufferedReader entrada = new BufferedReader ( new InputStreamReader (System.in));
        
            try{
	            while(comprobar == true){
	        	System.out.println("Ingrese un numero entero distinto de 0");
	            entero = Integer.valueOf(entrada.readLine());
	            if (entero != 0){
	                int sumaHasta200 = suma_hasta_(MAX);
	                System.out.println(sumaHasta200);
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
    public static int suma_hasta_( int valorMaximo){
        int suma = 0; 
      	valorMaximo = 200; 
        for (int i = 0 ; i<=valorMaximo; i++){
            suma += i;
        }
        return suma; 
    }
}




        
