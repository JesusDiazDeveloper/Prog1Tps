/*
7. Escribir un programa que mientras el usuario ingresa un numero de mes
     (entero) entre 1 y 12 inclusive, muestre por pantalla la cantidad de días del
     mes ingresado (suponer febrero de 28 días) (¿mostrar por pantalla la
     cantidad de días del mes debería realizarse con un método? Debería).

*/

/* 
import  
    main
    declarar entero mes 
    comprobar
    buffer 

    try 
        mientras comprobar true
        obtener entero 
        si esta entre 1 y 12 
            ejecutar metodo de meses 
        si no
            comprobar = false


    metodo que revisa el mes 
    si MES es 1,3,5,7,8,10,12 imprimir tiene 31 dias 
    si MEs es 2 imprimir tiene 28 
    si MES es 4, 6, 9, 11 


*/
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class C_6_E_7 {
  public static void main(String[] args) {
      int mes; 
      boolean comprobar = true; 
      BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));

      try{
        
        while (comprobar = true){
            System.out.println("Ingrese un entero"); 
            mes = Integer.valueOf(entrada.readLine()); 
            if ((mes >= 1) && (mes <=12)){
                calcular_dias_del_mes(mes); 
            }
            else{
                System.out.println("ese no es el valor de un mes");
                System.out.println("el programa termino.");
                break;
            }

        }
        
      }
      catch (Exception exc){
        System.out.println(exc);
      }
  
  }
  public static void calcular_dias_del_mes(int mes){
    switch(mes){
        case '1': case '3': case '5': case '7': case '8': case '10': case '12':{
            System.out.println("el mes tiene 31 dias ");
            break;
        }
        case '2':{
            System.out.println("El mes tiene 28 dias");
            break;
        }
        case '4': case '6': case '9': case '11':{
            System.out.println("El mes tiene 30 dias");
            break;
        }
    }
  }
}

