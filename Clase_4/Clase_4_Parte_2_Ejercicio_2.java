/*
2. Hacer un programa que solicite la carga desde consola de
un carácter y realice: imprima si es dígito, o letra minúscula, o
es cualquier otro carácter. Si es letra minúscula indicar si es
vocal o consonante.

*/ 
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase_4_Parte_2_Ejercicio_2{
    public static void main ( String[] args){

        char caracter;

        try{
            BufferedReader entrada = new BufferedReader (new InputStreamReader (System.in));

            System.out.println("Ingrese un caracter: "); 
            caracter = entrada.readLine().charAt(0);

            if((caracter >= '0') && (caracter <='9')){
                System.out.println("el elemento es un digito.");
            }
            else if ((caracter >= 'a') && (caracter <= 'z')){
                System.out.println("el elemento es una letra minuscula.");
                
                switch(caracter){
                    case 'a': case 'e': case'i': case 'o': case'u':{
                        System.out.println("El caracter es una vocal");
                    }
                    default: {
                        System.out.println("El caracter es una consonante.");
                    }
                }
            }
            else {
                System.out.println("es cualquier otro caracter."); 
            }
        }    
        catch(Exception exc){
            System.out.println(exc)
        }
    }        
}