
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class C_6_E_9 {
  public static void main (String[] args) {
      char caracter; 
      int entero1;
      int entero2;
      int resultado;
      boolean comprobar = true; 
      BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));

      try{
        
        while (comprobar == true){
            System.out.println("Ingrese el primer entero"); 
            entero1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese el segundo entero"); 
            entero2 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un caracter letra minuscula dependiendo la operacion  que quiera realizar:\n a = suma , b = resta, c = multiplicacion, d = division");
            caracter = entrada.readLine().charAt(0);
            if ((caracter <= 'd' ) && (caracter >= 'a' )){
            resultado = operacion_matematica_basica(caracter, entero1, entero2);
            System.out.println("el resultado de la operacion es: " + resultado + ".");
            }
            else{
            	System.out.println("esa no es una opcion valida");
            	comprobar = false; 
            }
            }
      }
      catch (Exception exc){
        System.out.println(exc);
      }
  }
  public static int operacion_matematica_basica (char opcion, int numero1, int numero2){
    int resultado = 0;
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

