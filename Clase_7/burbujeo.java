
public class burbujeo {
    public static final int MAX = 10; // esto no es necesario. 
    public static void ordenar_arreglo_burbujeo(int[] arr){
        int temp; 										//defino variable temporal
        for(int i = 1;i < MAX;i++){				//for  i menor que MAX i++
        for (int j = 0 ; j < MAX - 1; j++){		// for j menor que MAX-1 ; j++
        if (arr[j] > arr[j+1]){		// si arreglo en posicion [j] es mayor que arr[j+1](que es el siguiente)
        temp = arr[j];				// entonces guardo el valor la posicion j en la temporal
        arr[j] = arr[j+1];			// a la posicion j le doy el valor de j+1 (la siguiente que seria mas pequeña)
        arr[j+1] = temp;				//a la posicion [j+1] le doy el valor que guarde en temp.  
        }
        }
        }
        }
  }    