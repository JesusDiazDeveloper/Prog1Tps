
package ejercicios;

import java.util.Random;

public class prueba16 {
    public static final int MAXF = 5;
    public static final int MAXC = 15;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        char[][] mat1 = new char[MAXF][MAXC];
        char[][] mat2 = new char[MAXF][MAXC];
        cargar_matriz_secuencias_char(mat1);
        cargar_matriz_secuencias_char(mat2);
        System.out.println("Matriz 1 Antes de todo");
        imprimir_matriz_char(mat1);
        System.out.println("Matriz 2 Antes de todo");
        imprimir_matriz_char(mat2);
        resolucion(mat1, mat2);
        System.out.println("Matriz 1 resuelta");
        imprimir_matriz_char(mat1);
        System.out.println("Matriz 2 resuelta");
        imprimir_matriz_char(mat2);
    }

public static void resolucion(char[][]mat1, char[][]mat2){
    
    for (int fila=0; fila<MAXF ; fila++){
        int pos=0;
        int posinicial1 = obtener_incio_secuencia_mayor(mat1[fila]);
        int posinicial2 = obtener_inicio_secuencia(mat2[fila],pos);
        int posfinal1 = obtener_fin_secuencia(mat1[fila],posinicial1);
        int posfinal2 = obtener_fin_secuencia(mat2[fila],posinicial2);
        int largo1 = (posfinal1+1)-posinicial1;
        int largo2 = (posfinal2+1)-posinicial2;
        if(largo1>largo2){
            System.out.println("INTERCAMBIO EN FILA: " + fila);
            intercambio(mat1[fila],mat2[fila],posinicial1,posinicial2,largo1,largo2);
        }
        else{
            System.out.println("la condicion no se cumplio en la fila: " + fila);
        }
    }
}

public static void intercambio (char []mat1, char[]mat2, int posinicial1, int posinicial2, int largo1, int largo2){
    char temp;
    int col1=posinicial1;
    int col2=posinicial2;
    int contador=0;
    int diferencia= (largo1-largo2);
    while(contador<diferencia){
        corrimiento_der(mat2,posinicial2);
        contador ++;
    }
    int contadorintercambios=0;
    while(contadorintercambios<largo1){
        temp = mat2[col2];
        mat2[col2]=mat1[col1];
        mat1[col1]=temp;
        contadorintercambios++;
        col2++;
        col1++;
    }
    while(largo1>largo2){ // para borrar, hay que hacer corrimientos izq hasta que la que queremos achicar tenga el largo de la mas chica! easy pero no tan easy ajaja
        corrimientoIzq(mat1, posinicial1);
        largo1--;
    }
    // System.out.println("-----------------------------");
    // imprimir_arreglo_char(mat1); // esto era para las pruebas.. 
    // imprimir_arreglo_char(mat2);

}

public static int obtener_inicio_secuencia (char[]fila , int pos){
    while((pos<MAXC)&&(fila[pos]==' ')){
        pos++;
    }
    return pos;
}

    public static int obtener_fin_secuencia(char[] fila, int pos) {
        while ((pos < MAXC) && (fila[pos] != ' ')) {
            pos++;
        }
        return pos-1;
        }

    public static void corrimiento_der(char []  fila, int posinicial2) {
        int col = MAXC - 2;
        while (col > posinicial2) {
            fila[col] = fila[col - 1];
            col--;
        }
    }
    public static void cargar_matriz_secuencias_char(char[][] mat) {
        for (int fila = 0; fila < MAXF; fila++) {
            cargar_arreglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }
    public static void corrimientoIzq(char[] fila, int inicio) {
        for(int i = inicio; i < MAXC - 1; i++) {
            fila[i] = fila[i + 1];
        }
    }
    public static void cargar_arreglo_secuencias_char(char[] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXC - 1] = ' ';
        for (int pos = 1; pos < MAXC - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }
    }
    public static int obtener_incio_secuencia_mayor(char fila[]) {
        int fin = -1;
        int largoDeSecuenciaActual;
        int largoSecuenciaMayor = 0;
        int inicioMayor = 0;
        int finMayor = 0;
        int inicio = obtener_inicio_secuencia(fila, fin + 1);
        while (inicio < MAXC - 1) {
            fin = obtener_fin_secuencia(fila, inicio);
            largoDeSecuenciaActual = fin - inicio + 1;
            if (largoDeSecuenciaActual > largoSecuenciaMayor) {
                inicioMayor = inicio;
                finMayor = fin;
                largoSecuenciaMayor = largoDeSecuenciaActual;
            }
            inicio = obtener_inicio_secuencia(fila, fin + 1);
        }  
        return inicioMayor;
    }
    public static void imprimir_matriz_char(char[][] mat) {
        for (int fila = 0; fila < MAXF; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }
    public static void imprimir_arreglo_char(char[] arr) {
        for (int pos = 0; pos < MAXC; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}