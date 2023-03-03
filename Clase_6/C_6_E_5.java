/* el diseño seria

public class Clase_6_Ejemplo_10 {
    public static void main(String[] args){
    obtener numero1 entero
    obtener numero2 entero
    obtener caracter
    imprimir resultado operacion matematica (carácter, numero1, numero2)
    }
    public static void imprimir resultado operacion matematica (opción, numero1, numero2){
    si la opción es
    
    a imprimir numero1 + numero2
    b imprimir numero1 - numero2
    c imprimir numero1 * numero2
    d imprimir numero1 / numero2
    
    }
    }

*/


import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class C_6_E_9 {
  public static void main(String[] args) {
      char caracter; 
      int entero1;
      int entero2;  
      boolean comprobar = true; 
      BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));

      try{
        
        while (comprobar = true){
            System.out.println("Ingrese el primer entero"); 
            entero1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese el segundo entero"); 
            entero2 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un caracter letra minuscula dependiendo la operacion  que quiera realizar:\n a = suma , b = resta, c = multiplicacion, d = division");
            caracter = entrada.readLine().charAt(0);
            operacion_matematica_basica(caracter, entero1, entero2); 
        }

      }
      catch (Exception exc){
        System.out.println(exc);
      }
  }
  public static int operacion_matematica_basica (char opcion, int numero1, int numero2){
    int resultado;
    switch(opcion){
        case'a':{
            resultado = numero1 + numero2;
          	break;
        }
        case'b':{
            resultado = numero1 - numero2;
          	break;
        }
        case'c':{
            resultado = numero1 * numero2;
          break;
        }
        case'd':{
            resultado = numero1 / numero2;
          break;
        }
    }
        return resultado; 
  }
}