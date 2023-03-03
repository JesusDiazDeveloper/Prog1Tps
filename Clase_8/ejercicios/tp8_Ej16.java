package ejercicios;

/*16. Hay dos matrices MAT1 y MAT2 de secuencias de caracteres letras separados
por espacios de tamaño MAXF x MAXC que están precargadas. Ambas
matrices están precargadas y cada fila empieza y termina con caracteres
espacios. Además se tiene el siguiente método:
– un método que retorna el índice inicial de la secuencia de mayor tamaño de un
arreglo de secuencias (de caracteres letras minúsculas separados por espacios) de
tamaño MAXFIL.
Se pide realizar un programa que
– contenga la definición de los encabezados de los métodos de carga de la matriz y
del método mencionado en el enunciado (se supone que existen y no se requiere
implementarlos).
– para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
– para MAT1 agregue al principio de cada secuencia el primer carácter de la
secuencia de mayor tamaño de dicha fila.
– en cada fila, si se verifica que la secuencia de mayor tamaño de la fila para MAT1 es
mayor que la primer secuencia en dicha fila para MAT2, las intercambie (la que está
en MAT1 pasa a MAT2 y la que esta en MAT2 pasa a MAT1) sin usar estructuras
auxiliares (otros arreglos o matrices).
– para un valor de fila ingresado por el usuario verifique e imprima si la primera
secuencia de MAT1 en dicha fila es igual la primera secuencia de MAT2 en dicha fila.
*/
import java.util.Random;

public class tp8_Ej16 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 15;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        char[][] MAT1 = new char[MAXFILA][MAXCOLUMNA];
        char[][] MAT2 = new char[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_char(MAT1);
        imprimir_matriz_char(MAT1);
        System.out.println("--------------------");
        cargar_matriz_secuencias_char(MAT2);
        imprimir_matriz_char(MAT2);
        // eliminar_1er_vocal_secuencias(MAT1);
        // eliminar_1er_vocal_secuencias(MAT2);
        // agregar_1er_car_inicio_sec_de_mayor_sec(MAT1);
        System.out.println("--------------------");
        // imprimir_matriz_char(MAT1);
        // System.out.println("--------------------");
        // imprimir_matriz_char(MAT2);
    }

    public static void agregar_1er_car_inicio_sec_de_mayor_sec(char [] [] MAT ){
        for(int fila = 0; fila <MAXFILA; fila++){
            int pos_caracter;
            char caracter;
            /*– para MAT1 agregue al principio de cada secuencia el primer carácter de la
            secuencia de mayor tamaño de dicha fila.*/
            pos_caracter = obtener_incio_secuencia_mayor(MAT[fila]);
            caracter = MAT[fila][pos_caracter];
            System.out.println("el caracter es: --->" + caracter);
            insertar_caracter_antes_secuencias(MAT[fila],caracter);
        }
    }
    public static void insertar_caracter_antes_secuencias(char [] fila, char caracter ){
        int fin = -1;
        int inicio = obtener_inicio_secuencia(fila,fin+1);
        while(inicio<MAXCOLUMNA){
            corrimiento_der_menos2(fila,inicio);
            fila[inicio] = caracter;
            fin = obtener_fin_secuencia(fila,inicio); // aca busco el fin luego de hacer el corrimiento porque si lo busco antes, la secuencia cambia de lugar. 
            inicio = obtener_inicio_secuencia (fila,fin+1);
        }
    }
    public static void corrimiento_der_menos2(char []fila , int pos){
        int indice = MAXCOLUMNA-2;
        while(indice>pos){
            fila[indice]= fila[indice-1];
            indice--;
        }
    }
    public static void eliminar_1er_vocal_secuencias(char[][] MAT) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_1er_vocal_una_secuencia_fila(MAT[fila]);
        }
    }
    public static void eliminar_1er_vocal_una_secuencia_fila(char [] fila){
        int fin = -1;
        int inicio = obtener_inicio_secuencia(fila, fin + 1);
        while((inicio < MAXCOLUMNA - 1)){
            fin = obtener_fin_secuencia(fila, inicio);
            int pos = inicio; 
            while ((fila[pos] != 'a') && (fila[pos] != 'e') && (fila[pos] != 'i') && (fila[pos] != 'o')
                && (fila[pos] != 'u') && (pos<=fin)) {
                    pos++;}
            if(pos>fin){
            inicio = obtener_inicio_secuencia(fila, fin+1);
            }
            else{
                corrimientoIzq(fila,pos);
                inicio = obtener_inicio_secuencia(fila, fin+1);
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
        while (inicio < MAXCOLUMNA - 1) {
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

    /*
     * 
     * metodo que pide:
     * – para MAT1 y MAT2 elimine de cada secuencia el primer carácter vocal.
     */

    public static int obtener_inicio_secuencia(char[] fila, int pos) {
        while ((pos < MAXCOLUMNA) && (fila[pos] == ' ')) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(char[] fila, int pos) {
        while ((pos < MAXCOLUMNA) && (fila[pos] != ' ')) {
            pos++;
        }
        return pos - 1;
    }

    public static void cargar_matriz_secuencias_char(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }
    public static void corrimientoIzq(char[] fila, int inicio) {
        for(int i = inicio; i < MAXCOLUMNA - 1; i++) {
            fila[i] = fila[i + 1];
        }
    }
    public static void cargar_arreglo_secuencias_char(char[] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXCOLUMNA - 1] = ' ';
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }
    }

    public static void imprimir_matriz_char(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }

    public static void imprimir_arreglo_char(char[] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
