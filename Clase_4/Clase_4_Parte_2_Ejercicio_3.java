/*3. Construir un programa que solicite desde teclado un número de
mes y posteriormente notifique por pantalla la cantidad de días
de ese mes. En el caso de que ingrese 2 como número de mes
(febrero), para imprimir la cantidad de días deberá solicitar
ingresar un número de anio (no usar ñ), para determinar si es
bisiesto o no con la siguiente sentencia:
_si ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) es verdadero,
entonces es bisiesto.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase_4_Parte_2_Ejercicio_3.java{
    public static void main ( String [] args){

        int mes;
        int anio; 

        try{
            BufferedReader entrada = new BufferedReader( new InputStreamReader(System.in));

            System.out.println( "Introduzca el numero de un mes: ");
            mes = Integer.valueOf (entrada.readLine());

            switch (mes) { 
                case 1: case 3: case 5: case 7: case 8: case 10: case 12: {
                    System.out.println("El mes seleccionado tiene 31 dias.");
                    break;
                }
                case 4: case 6: case 9: case 11: {
                    System.out.println("El mes seleccionado tiene 30 dias.");
                    break;
                }
                default:{
                  System.out.println("Ha seleccionado febrero, por favor ingrese el numero de anio: ");
                  anio = Integer.valueOf(entrada.readLine());

                    if (((anio % 4 == 0) && (anio % 100 != 0)) || (anio % 400 == 0)){
                        System.out.println("Ese año corresponde a Biciesto, por lo tanto febrero tiene 29 dias.");
                    }
                    else{
                        System.out.println("El mes de febrero de ese anio tiene 28 dias.");
                    }
                    break;
                }    
            }
        }
        catch(Exception exc){
            System.out.println(exc);
        }
    }
}