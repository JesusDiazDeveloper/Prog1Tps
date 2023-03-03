/*
8. Escribir un programa que mientras que el usuario ingrese un caracter letra
     minúscula, pida ingresar un numero entero. Si el número ingresado está
     entre 1 y 5 inclusive deberá imprimir la tabla de multiplicar de dicho
     numero.


*/

import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class C_6_E_8 {
  public static void main(String[] args) {
      char caracter; 
      int entero; 
      boolean comprobar = true; 
      BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));

      try{
        
        while (comprobar = true){
            System.out.println("Ingrese un caracter letra minuscula");
            caracter = entrada.readLine().charAt(0);
            if((carcter>=a)&&(caracter<=z)){
                System.out.println("Ingrese un entero"); 
                entero = Integer.valueOf(entrada.readLine()); 
                if((entero>=1)&&(entero<=5)){
                    imprimir_tabla_de_multiplicar_de_(entero);
                }
                else{
                    System.out.println("ese numero es mayor a 5 o menor a 1");
                }
            }
            else{
                System.out.println("esa no es una letra minuscula");
                System.out.println("el programa termino.");
                break;
            }

        }
        
      }
      catch (Exception exc){
        System.out.println(exc);
      }

  }
  public static void imprimir_tabla_de_multiplicar_de_(int entero){
    for(i=1 ; i <= entero ; i++ ){
        System.out.println(entero + " * " + i + " = " entero*i);
    }
}
}
