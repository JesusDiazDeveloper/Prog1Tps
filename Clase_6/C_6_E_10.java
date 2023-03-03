/* 10. Escribir un programa que mientras el usuario ingrese un número entero
  entre 1 y 10, pida ingresar un caracter,y por cada caracter ingresado
  imprima:
 -"letra minúscula" si el caracter es una letra del abecedario en minúscula;
 -"letra mayúscula" si el caracter es una letra del abecedario en mayúscula;
 -"dígito" si el caracter corresponde a un carácter número;
 -"otro" para los restantes casos de caracteres.
   



   
   */
  import java.io.BufferedReader; 
  import java.io.InputStreamReader; 
  
  class C_6_E_10 {
    public static void main(String[] args) {
      
      int entero;
      char caracter = 'a'; 
      boolean comprobar = true; 
      
      
      BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));
  
      try{
        System.out.println("Ingrese un entero entre 1 y 10");
        entero = Integer.valueOf(entrada.readLine());
        while ((entero>=1)&&(entero<=10)){
          if ((entero % 3) == 0){
          System.out.println("Ingrese un caracter o precione * para terminar");
          caracter = entrada.readLine().charAt(0);
          comprobar_char_digito_minuscula_mayuscula_u_otro(caracter);
          if (caracter == '*'){
            break;
          }
          }
          
        }
        else{
          System.out.println("el entero no cumple con lo que te pedi.");
        }
        }
      catch (Exception exc){
        System.out.println(exc);
      }
  
    }
  
      public static void comprobar_char_digito_minuscula_mayuscula_u_otro ( char caracter) {
              if((caracter >= '0') && (caracter <='9')){
                  System.out.println("el elemento es un digito.");
              } 
              else if ((caracter >= 'a') && (caracter <= 'z')){
                  System.out.println("el elemento es una letra minuscula.");
              }
              else if (caracter == '*'){
                System.out.println("El programa terminoo");
              }
              else if ((caracter >= 'A') && (caracter <= 'Z')){
                  System.out.println("el elemento es una letra Mayuscula.");
              }
              else {
                  System.out.println("es cualquier otro caracter."); 
              }
  
      }
  }
  