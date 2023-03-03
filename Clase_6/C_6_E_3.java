
import java.io.BufferedReader;
import java.io.InputStreamReader; 

public class C_6_E_3{
    public static void main (String [] args){

        char minuscula;
        boolean comprobar = true; 
        BufferedReader entrada = new BufferedReader(new InputStreamReader (System.in));

        try{ 
            while (comprobar == true){
                System.out.println("Ingrese una letra minuscula");
                minuscula = entrada.readLine().charAt(0);
                if ((minuscula >= 'a' ) && (minuscula <= 'z' )){
                     tabla_de_multiplicar_de_n();
                }
                else {
                    System.out.println("El caracter ingresado no es una letra minuscula.");
                    comprobar = false ;
                }
            }
        } 
        catch(Exception exc){
            System.out.println(exc);
        } 
        System.out.println("Termino el programa.");
    }
    public static void tabla_de_multiplicar_de_n (){
    	int n= 9;
        for(int i = 1; i <=10 ; i++){
            System.out.println(n * i);
        }
}
}
