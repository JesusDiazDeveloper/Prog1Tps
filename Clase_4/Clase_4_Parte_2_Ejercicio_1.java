/*1. Hacer un programa que solicite la carga desde consola de un numero entero 
y realice:

_si el numero es positivo, 
    imprima “grande” si es mayor a 100 
    o “chico “ si es menor. 
    Además deberá imprimir que el valor es positivo.

_si no lo es, 
    mprima si el numero es par, 
    o si el numero es múltiplo de 3, 
    o ninguna de las opciones anteriores.*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase_4_Parte_2_Ejercicio_1{
    public static void main (String [] args){

        int entero;

        try{
            BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));

            System.out.println( "Ingrese un entero: ");
            entero = Integer.valueOf ( entrada.readLine()); // ERROR: me habia faltado esto!! 

            if ( entero >= 0){
                if (entero > 100){
                    System.out.println("Grande");
                }
                else{
                    System.out.println("Chico");
                }
                System.out.println("El valor es positivo.");
            }

            else{
                if ((entero % 2) ==0){
                    System.out.println("el numero negativo es par.");
                }
                else if ((entero % 3)==0){
                    System.out.println("el numero negativo es multiplo de 3");
                }
                else{
                    System.out.println("el numero ingresado es negativo, no es multiplo
                    de 3 ni es un numero par.");
                }
            }
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }
}
