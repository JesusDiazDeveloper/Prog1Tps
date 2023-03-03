/* 
Escribir un programa que mientras el usuario ingrese un número entero
entre 1 y 10 realice:
– Si el numero ingresado es múltiplo de 3 pida ingresar un caracter, y para el caracter
ingresado imprima a que tipo de carácter esta asociado:
• “letra minúscula” si el caracter es una letra del abecedario en minúscula;
• “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
• “dígito” si el caracter corresponde a un carácter número;
• “otro” para los restantes casos de caracteres.
– Si el numero ingresado es múltiplo de 5 imprima la tabla de multiplicar del numero
ingresado.


pedir entero
guardar 
mientras entero entre 1 y 10
    if entero multiplo de 3 
        ingresar un caracter e imprimir su tipo. 
    else if entero multiplo de 5 
        imprimir tabla de mult. de ese num. 

 */
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

class C_6_E_11 {
	public static void main(String[] args) {

		int entero;
		char caracter; 
		boolean comprobar = true;

		BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));

		try{

			while (comprobar == true){
				System.out.println("Ingrese un entero entre 1 y 10");
				entero = Integer.valueOf(entrada.readLine());
				if((entero>=1)&&(entero<=10)){
					if ((entero % 3) == 0){
						System.out.println("Ingrese un caracter");
						caracter = entrada.readLine().charAt(0);
						comprobar_char_digito_minuscula_mayuscula_u_otro(caracter);
					}
					else if ((entero % 5)==0){
						imprimir_tabla_de_multiplicar_de_(entero);
					}

				}
				else{
					comprobar = false; 
					System.out.println("ese numero no esta en el rango, el programa termino");
				}
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
			else if ((caracter >= 'A') && (caracter <= 'Z')){
				System.out.println("el elemento es una letra Mayuscula.");
			}
			else {
				System.out.println("es cualquier otro caracter."); 
			}

		}
		public static void imprimir_tabla_de_multiplicar_de_(int entero){
			for(int i=1 ; i <= entero ; i++ ){
				System.out.println( entero + " * " + i + " = " + entero*i);
			}
		}
	}

