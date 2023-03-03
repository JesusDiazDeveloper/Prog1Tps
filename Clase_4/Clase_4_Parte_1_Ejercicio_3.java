/*3. Escribir un programa que ingrese un número entero por teclado y
realice:
_ imprima es múltiplo de 6 y de 7 si cumple con esa condición,
_ o imprima es mayor a 30 y múltiplo de 2 si cumple con esa
condición,
_ imprima si el cociente de la división de dicho número con 5 es
mayor a 10 sin importar las condiciones previas.
*/ 

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase_4_Parte_1_Ejercicio_3{
    public static void main (String [] args) {

        int entero; 

        try{ 
            BufferedReader entrada = new BufferedReader ( new InputStreamReader (System.in));

            System.out.println("Ingrese un entero: ");
            entero = entrada.readLine();

            if (((entero % 6) == 0) && ((entero % 7) == 0)){
                System.out.println( "El valor ingresado es multiplo de 6 y de 7");
            }
            else if ((entero > 30) && ((entero % 2) == 0)){
                System.out.println("El valor ingresado es multiplo de 2 y mayor a 30");
            }
            

            if (((entero / 5) > 10) ){
                System.out.println( "el cociente de la división de dicho número con 5 es
                mayor a 10 ");
            }
            else{ 
                System.out.println("el cociente de la división de dicho número con 5 no es
                mayor a 10 ");
            }
        }
        catch (Exception exc){
            System.out.println(exc);
        }
    }
}