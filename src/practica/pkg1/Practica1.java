package practica.pkg1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * @author Luciano Xiquín
 * @author 
 * @author 
 * @author
 * 
 */
public class Practica1 {

    /*El unico beneficio de tener las 25 matrices como variables globales es
      el uso que se le da en el metodo switch_m
      el cual por cierto es muy primitivo y propiamente de principiantes
     */
    static double[][] A; //1
    static double[][] B; //2
    static double[][] C; //3
    static double[][] D; //4
    static double[][] E; //5
    static double[][] F; //6
    static double[][] G; //7
    static double[][] H; //8
    static double[][] I; //9
    static double[][] J; //10
    static double[][] K; //11
    static double[][] L; //12
    static double[][] M; //13
    static double[][] N; //14
    static double[][] O; //15
    static double[][] P; //16
    static double[][] Q; //17
    static double[][] S; //18
    static double[][] T; //19
    static double[][] U; //20
    static double[][] V; //21
    static double[][] W; //22
    static double[][] X; //23
    static double[][] Y; //24
    static double[][] Z; //25
    

    //Decidí volver el escaner global, espero que no sea una mala idea
    //Los metodos que lo utilizaban de local eran switch_m, sub_menu y main
    static Scanner sc = new Scanner(System.in);
    static double[][] R; // 26
    /*
    Este sí que sera un 'espaguetti code', la vdd
    Metodos como switch_m son redundantes y bastante tediosos de programar,
    sin embargo al no haber forma (hasta donde yo se) de usar un Scanner, 
    un switch y una variable string para para.
     */

    //variable auxiliar para reportes
    static String operacion = "";

    public static void main(String[] args) {
        Boolean menu = true;   
        //Memu principal
        while (menu = true) {
            System.out.println("***Menu Principal***"
                                + "\n1)Cargar Matrices"
                                + "\n2)Suma de matrices"
                                + "\n3)Resta de matrices"
                                + "\n4)Multiplicación"
                                + "\n5)División"
                                + "\n6)Transpuesta de una matriz"
                                + "\n7)Matriz inversa"
                                + "\n8)Potencia de una matriz" 
                                + "\n9)Determinante"
                                + "\n10)Salir");
            try {
                int opcion;
                switch (opcion = sc.nextInt()) {
                    case 1:
                        System.out.println("****************" + "\nIntroduzca la ruta del archivo");
                        leerArchivo();
                        break;
                    case 2:
                        System.out.println("Nombre de la primer matriz:");
                        double[][] m10 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        double[][] m20 = switch_m();
                        //int[][] resultado_suma;
                        try {
                            R = suma_m(m10, m20);
                            System.out.println("Resultado de la suma es:");
                            imprimir_m(R);
                            System.out.println("==================");
                            operacion = "Suma";
                            reporte(m10, m20);
                        } catch (Exception e) {
                            System.out.println("Las matrices no son iguales");
                        }
                        break;
                    case 3:
                        System.out.println("Nombre de la primer matriz:");
                        double[][] m11 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        double[][] m21 = switch_m();
                        //int[][] resultado_resta;
                        try {
                            R = resta_m(m11, m21);
                            System.out.println("Resultado de la resta es:");
                            imprimir_m(R);
                            System.out.println("==================");
                            operacion = "Resta";
                            reporte(m11, m21);
                        } catch (Exception e) {
                            System.out.println("Las matrices no son iguales");
                        }
                        break;

                    case 4:
                        sub_menu();
                        break;
                    case 5: 
                       try{
                        division();
                        
                        }catch(Exception e){
                        System.out.println("La división no es posible");
                        }
                        break;
                    case 6:
                        double[][] original;
                        System.out.println("Nombre de la Matriz:");
                        original = switch_m();
                        R = Traspuesta(original);
                        reporteTranspuesta();
                        System.out.println("Transpuesta:");
                        imprimir_m(R);
                        System.out.println("==================");
                        break;
                    case 7:
                        double[][] inversa;
                        System.err.print("Nombre de la Matriz:");
                        inversa = switch_m();
                        try{
                        R = Inversa(inversa);
                        operacion = "Inversa";
                        reporteInversa(inversa);
                        }catch(Exception e){
                         System.out.println("Las matriz no es cuadrada");
                        }
                        System.out.println("^^Inversa^^");
                        imprimir_m(R);
                        System.err.println("==================");
                        break;
                    case 8:

                        Scanner entrada = new Scanner(System.in);
                        double[][] m1 = {
                                {1, 1},
                                {1, 1}
                        };


                        try{
                            System.out.println("Ingresar la potencia de elevacion de la matriz");
                            int potencia = entrada.nextInt();

                            if (potencia > 0){
                                //Inicializacion unica del valalor m2=m1 para que la vuelta 2 del ciclo m2 se matenga estatica con la ayuda de valor auxiliar
                                int filas = m1.length;
                                int columnas = m1[0].length;
                                double[][] aux = new double[m1.length][m1[0].length];
                                if (filas == columnas){
                                    double[][] m2 = new double[filas][columnas];
                                    for (int i = 0; i < m1.length; i++) {
                                        for (int j = 0; j < m1[0].length; j++) {
                                            m2[i][j] = m1[i][j];
                                        }
                                    }
                                    if (potencia>1){
                                        //Inicio de procedimiento de potenciacion
                                        for (int b=1;b<=potencia-1;b++) {
                                            // Utilizando una arrreglo llamado aux para mantener el valor anterior de m2
                                            for (int i = 0; i < m1.length; i++) {
                                                for (int j = 0; j < m1[0].length; j++) {
                                                    aux[i][j]=m2[i][j];
                                                }
                                            }
                                            //Lugar en donde se almacena el resultado
                                            double[][] producto = new double[m1.length][m2[0].length];
                                            // Realizamos esto por cada columna de la  matriz m2
                                            for (int a = 0; a < m2[0].length; a++) {
                                                // Dentro recorremos las filas de la matriz m1
                                                for (int i = 0; i < m1.length; i++) {
                                                    int suma = 0;
                                                    // cada columna de la matriz m1
                                                    for (int j = 0; j < m1[0].length; j++) {
                                                        // Multiplicamos y sumamos resultado
                                                        suma += m1[i][j] * m2[j][a];
                                                    }
                                                    // Se llena dentro de la matriz producto dentro del producto
                                                    producto[i][a] = suma;
                                                }
                                            }
                                            // Mostrando producto de la multipliacion
                                            int c=b+1;
                                            System.out.print("Imprimiendo matriz elevado a la "+c+"\n");
                                            for (int i = 0; i < m2.length; i++) {
                                                System.out.print("[");
                                                for (int j = 0; j < m2[0].length; j++) {
                                                    System.out.print("  "+producto[i][j]);
                                                    m2[i][j]= aux[i][j];
                                                    m1[i][j] = producto[i][j];
                                                }
                                                System.out.print(" ] \n");
                                            }
                                        }
                                        reportePotencia(potencia);
                                    }else{
                                        // Impresion de matriz elevado a la 1
                                        System.out.print("Imprimiendo Matriz elevado a la 1\n");
                                        for (int i = 0; i < m2.length; i++) {
                                            System.out.print("[");
                                            for (int j = 0; j < m2[0].length; j++) {
                                                System.out.print(" "+m1[i][j]);
                                            }
                                            System.out.print(" ] \n");
                                        }
                                        reportePotencia(potencia);
                                    }
                                }else{
                                    System.out.println("No se puede realizar el prodemiento de elevacion de potencias para esta matriz");
                                    System.out.println("Para que pueda realizarse la matriz seleccionada");
                                }
                            }else{
                                System.out.println("El valor numerico ingresado para la elevacion debera de ser positivo, mayor que 0");
                            }
                        }catch (Exception e){
                            System.out.println("Debes de ingresar un numero entero para realizar la potencia de la matriz seleccionada");
                        }
                        break;
                    case 9:
                        //Aquí no se puedeo usar la matriz 'R' por que la 
                        //determinate es un entero
                        double[][] m19;
                        System.err.print("Nombre de la Matriz:");
                        m19 = switch_m();
                        double determinante;
                        try {
                            determinante = Det(m19);
                            System.err.print("LA DETERMINANTE ES:" +"[ " + determinante + "]");
                            System.out.println("==================");
                            reporteDeterminante(determinante, m19);
                        } catch (Exception e) {
                            System.out.println("La dimensiones de la matriz exceden 3x3");
                        }
                        break;
                    case 10:
                        System.exit(0);
                    default:
                        System.out.println("Seleccione una opción valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("...Introduzca una entrada valida");
            }
        }
    }

    //Terminado
    private static void leerArchivo() {

        //variables auxiliar para la lectura del archivo
        String nombreMatriz;
        String[] contenidoFila;
        String[] filaMatriz;
        String[] columnasMatriz;
        double[][] matrixAux = null;

        try {

            File archivo = new File(sc.nextLine());
            String linea = "";
            sc.nextLine();//Escanea la primera linea de mi archivo

            while(sc.hasNextLine()){

                linea += sc.hasNextLine() + "\n";

            }

            //Aquí empieza el algoritmo para saber el nombre de mi matriz y llenar la matriz correspondiente
            for (int i = 0; i < 26; i++) {

                contenidoFila = linea.split(":");
                nombreMatriz = contenidoFila[0].trim();
                //separamos el contenido del nombre
                filaMatriz = contenidoFila[1].split(";"); //Aquí ya tenemos las filas de mi matriz
                for (int j = 0; j < filaMatriz.length; j++) {

                    columnasMatriz = filaMatriz[j].split(",");

                    matrixAux = new double[filaMatriz.length][columnasMatriz.length];

                        for (int k = 0; k < columnasMatriz.length; k++) {

                            if(filaMatriz[0].length() == filaMatriz[j].length()){

                                matrixAux[j][k] = Integer.parseInt(columnasMatriz[k]);

                            }
                            else{
                                System.out.println("Se omitio la matriz");
                                i-=1;
                                break;
                            }

                        }

                }

                //Ya que tenemos la matriz cargada y pasando las excepciones la guardamos en su respectivo lugar
                if(nombreMatriz.equals("A") && matrixAux != null){
                    A = matrixAux;
                }
                if(nombreMatriz.equals("B") && matrixAux != null){
                    B = matrixAux;
                }
                if(nombreMatriz.equals("C") && matrixAux != null){
                    C = matrixAux;
                }
                if(nombreMatriz.equals("D") && matrixAux != null){
                    D = matrixAux;
                }
                if(nombreMatriz.equals("E") && matrixAux != null){
                    E = matrixAux;
                }
                if(nombreMatriz.equals("F") && matrixAux != null){
                    F = matrixAux;
                }
                if(nombreMatriz.equals("G") && matrixAux != null){
                    G = matrixAux;
                }
                if(nombreMatriz.equals("H") && matrixAux != null){
                    H = matrixAux;
                }
                if(nombreMatriz.equals("I") && matrixAux != null){
                    I = matrixAux;
                }
                if(nombreMatriz.equals("J") && matrixAux != null){
                    J =  matrixAux;
                }
                if(nombreMatriz.equals("K") && matrixAux != null){
                    K = matrixAux;
                }
                if(nombreMatriz.equals("L") && matrixAux != null){
                    L = matrixAux;
                }
                if(nombreMatriz.equals("M") && matrixAux != null){
                    M = matrixAux;
                }
                if(nombreMatriz.equals("N") && matrixAux != null){
                    N = matrixAux;
                }
                if(nombreMatriz.equals("O") && matrixAux != null){
                    O = matrixAux;
                }
                if(nombreMatriz.equals("P") && matrixAux != null){
                    P = matrixAux;
                }
                if(nombreMatriz.equals("Q") && matrixAux != null){
                    Q = matrixAux;
                }
                if(nombreMatriz.equals("S") && matrixAux != null){
                    S = matrixAux;
                }
                if(nombreMatriz.equals("T") && matrixAux != null){
                    T = matrixAux;
                }
                if(nombreMatriz.equals("U") && matrixAux != null){
                    U = matrixAux;
                }
                if(nombreMatriz.equals("V") && matrixAux != null){
                    V = matrixAux;
                }
                if(nombreMatriz.equals("W") && matrixAux != null){
                    W = matrixAux;
                }
                if(nombreMatriz.equals("X")){
                    X = matrixAux;
                }
                if(nombreMatriz.equals("Y")){
                    Y = matrixAux;
                }
                if(nombreMatriz.equals("Z")){
                    Z = matrixAux;
                }
                if(nombreMatriz.equals("R") && matrixAux != null){
                    R = matrixAux;
                }

            }

            sc.close();

        }
        catch (Exception e){
            System.out.println("No se pudo leer el archivo");
            System.out.println(e.getLocalizedMessage());
        }

    }

    //No comment
    static double[][] suma_m(double[][] m1, double[][] m2) throws Exception {
        double[][] aux; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        aux = new double[m1.length][m1[0].length];
        if ((m1.length == m2.length) && (m1[0].length == m2[0].length)) {
            //'for' doble anidado para la suma 
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    aux[i][j] = m2[i][j] + m1[i][j];
                }
            }
        } else {
            throw new Exception();
        }
        return aux;

    }

    //Exactamente la misma operación de suma
    static double[][] resta_m(double[][] m1, double[][] m2) throws Exception {
        double[][] aux; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        aux = new double[m1.length][m1[0].length];
        if ((m1.length == m2.length) && (m1[0].length == m2[0].length)) {
            //'for' doble anidado para la suma 
            for (int i = 0; i < m2.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    aux[i][j] = m2[i][j] - m1[i][j];
                }
            }
        } else {
            throw new Exception();
        }
        return aux;

    }

    //Sub menu para la multiplicación
    private static void sub_menu() {
        
        boolean menu = true;
        int op;
        do{
            System.out.println("***Multiplicación***");
            try {
                System.out.println("1)Producto de un escalar y una matriz" + "\n2)Producto de 2 matrices" + "\n3)Volver");
                switch (op = sc.nextInt()) {
                    case 1:
                        R = multiplicacion();
                        imprimir_m(R);
                        System.out.println("==================");
                        break;
                    case 2:
                        System.out.println("Nombre de la primer matriz:");
                        double[][] m1 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        double[][] m2 = switch_m();

                        /* Numero de Filas de la primera Matriz */
                        int filas = m1.length;
                        /* Numero de Columnas de la segunda Matriz */
                        int columnas = m2[0].length;

                        double[][] m3 = new double[filas][columnas];

                        /*Evaluacion de las dos matrices de lectura*/
                        if(multiplicacionmatriz(m1,m2,m3)){
                            imprimir_m(m3);
                            reporte(m1, m2);
                        } else {
                            /*Si no se cumple con la condicion
                             */
                            System.out.println("Matrices no compatibles");
                        }

                        break;
                    case 3:
                        menu = false;
                        break;
                    default:
                        System.out.println("Seleccione una opción valida");
                }
            } catch (Exception e) {
                System.out.println("...Introduzca una entrada valida");
            }
        } while (menu = true);
    }

    //Multiplicación de una matriz por escalar
    static double[][] multiplicacion() throws Exception {
        double[][] aux;
        double[][] res_aux;
        int num;
        System.out.println("Introduzca el escalar:");
        num = sc.nextInt();
        System.out.println("Nombre de la matriz:");
        aux = switch_m();
        res_aux = new double[aux.length][aux[0].length];
        //Debo checar este for
        for (int i = 0; i < res_aux.length; i++) {
            for (int j = 0; j < res_aux[0].length; j++) {
                res_aux[i][j] = num * aux[i][j];
            }
        }
        reporteMultiplicacionEscalar(num);
        return res_aux;
    }

    //Producto de dos matrices
    public static boolean multiplicacionmatriz(double[][] m1, double[][] m2, double[][] m3){
        boolean compatible=true;
        if (m1[0].length != m2.length){
            compatible = false;
        }else{
            for (int i=0;i<m1.length;i++){
                for (int j=0; j < m2[i].length; j++) {
                    for (int k=0;k<m2.length;k++){
                        m3[i][j]+=m1[i][k]*m2[k][j];
                    }
                }
            }
        }
        return compatible;
    }

    //Debo encontrar una solución más elegante para este proceso
    static double[][] switch_m() {
        //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        String letter = sc.next();
        double[][] aux = null;
        if (letter.equals("A")) {
            aux = A;
            //1
        }
        if (letter.equals("B")) {
            aux = B;
            //2
        }
        if (letter.equals("C")) {
            aux = C; 
            //3
        }
        if (letter.equals("D")) {
            aux = D;
            //4
        }
        if (letter.equals("E")) {
            aux = E;
            //5
        }
        if (letter.equals("F")) {
            aux = F;
            //6
        }
        if (letter.equals("G")) {
            aux = G;
            //7
        }
        if (letter.equals("H")) {
            aux = H;
            //8
        }
        if (letter.equals("I")) {
            aux = I;
            //9
        }
        if (letter.equals("J")) {
            aux = J;//10
        }
        if (letter.equals("K")) {
            aux = K;//11
        }
        if (letter.equals("L")) {
            aux = L;//12
        }
        if (letter.equals("M")) {
            aux = M;//13
        }
        if (letter.equals("N")) {
            aux = N;//14
        }
        if (letter.equals("O")) {
            aux = O;//15
        }
        if (letter.equals("P")) {
            aux = P;//16
        }
        if (letter.equals("Q")) {
            aux = Q;//17
        }
        if (letter.equals("R")) {
            aux = R;//18
        }
        if (letter.equals("S")) {
            aux = S;//19
        }
        if (letter.equals("T")) {
            aux = T;//20
        }
        if (letter.equals("U")) {
            aux = U;//21
        }
        if (letter.equals("V")) {
            aux = V;//22
        }
        if (letter.equals("W")) {
            aux = W;//23
        }
        if (letter.equals("X")) {
            aux = X;//24
        }
        if (letter.equals("Y")) {
            aux = Y;//25
        }
        if (letter.equals("Z")) {
            aux = Z;//26
        }
        if (letter.equals("Test0")) {

        }
        if (letter.equals("Test1")) {

        }
        if (letter.equals("Test2")) {

        }
        if (letter.equals("Test3")) {

        }
        if (letter.equals("Test5")) {

        }
        return aux;
    }

    //Método exclusivo para la impresión de las matrices
    static double[][] imprimir_m(double[][] res) {
        double[][] aux = res; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        for (double[] aux1 : aux) {
            for (int j = 0; j < aux[0].length; j++) {
                System.out.print("[ " + aux1[j] + "]");
            }
            System.out.println("");
        }
        return aux;
    }

    private static double[][] Traspuesta(double[][] original) {
        double[][] aux;//El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        aux = new double[original[0].length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                aux[j][i] = original[i][j];
            }
        }
        System.err.println("Matriz original:");
        imprimir_m(original);
        System.err.println("==================");
        return aux;
    }

    private static double Det(double[][] m19) throws Exception {
    double aux_det = 0;
    System.err.println("DE LA MATRIZ");
    imprimir_m(m19);
        if(m19.length == m19[0].length){
            if (m19.length == 2) {
                //Funciona
                aux_det = m19[0][0] * m19[1][1] - m19[0][1] * m19[1][0];
            }
            if (m19.length == 3) {
                double left = m19[0][0] * m19[1][1] * m19[2][2] - m19[1][0] * m19[2][1] * m19[0][2] + m19[2][0] * m19[0][1] * m19[1][2];
                double right = m19[0][2] * m19[1][1] * m19[2][0] - m19[1][2] * m19[2][1] * m19[0][0] + m19[2][2] * m19[0][1] * m19[1][0];
                aux_det = left - right;
            }
            if (m19.length > 3) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        return aux_det;
    }

    /*
    La forma en que use los arreglos auxiliares con nomenclatura m1,m2,m11, m22, etc
    ha cambiado a lo largo del codigo, al principio estaban en "Main", pero es mejor 
    crearlos en los métodos, al fin y al cabo, el metodo que se invoca no es afectado 
    por ello
    */
    private static double[][] Inversa(double[][] aux) throws Exception {
        double[][] inv;
        if (aux[0].length == aux.length) {
            double det;
            det = Det(aux);
            double[][] trans;
            double[][] adj;
            trans = Traspuesta(aux);
            adj = Adjunta(trans);
            /*System.out.println(det);
            imprimir_m(trans);
            imprimir_m(adj);
            Está parte solo era para garantizar que todo estuviera en orden
            */
            inv = new double[adj.length][adj[0].length];
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj[0].length; j++) {
                    inv[i][j]= adj[i][j]/det;
                }
            }
        } else {
            throw new Exception();
        }

        return inv;

    }

    static double[][] Adjunta(double[][] adj) throws Exception {
        double[][] aux;
        aux = new double[adj.length][adj[0].length];
        if (adj.length == 2) {
            //int tl = adj[1][1];
            //int br = adj[0][0];
            aux[0][0] = adj[1][1];
            aux[1][1] = adj[0][0];
            aux[0][1] = -adj[0][1];
            aux[1][0] = -adj[1][0];
        }
        if (adj.length == 3) {
            aux[0][0] = adj[1][1] * adj[2][2] - adj[1][2] * adj[2][1];
            aux[0][1] = - adj[1][0] * adj[2][2] + adj[1][2] * adj[2][0];
            aux[0][2] = adj[1][0] * adj[2][1] - adj[1][1] * adj[2][0];
            aux[1][0] = - adj[0][1] * adj[2][2] + adj[0][2] * adj[2][1];
            aux[1][1] =  adj[0][0] * adj[2][2] - adj[0][2] * adj[2][0];
            aux[1][2] = - adj[0][0] * adj[2][1] + adj[0][1] * adj[2][0];
            aux[2][0] = adj[0][1] * adj[1][2] - adj[0][2] * adj[1][1];
            aux[2][1] = - adj[0][0] * adj[1][2] + adj[0][2] * adj[1][0];
            aux[2][2] = adj[0][0] * adj[1][1] - adj[0][1] * adj[1][0];
        }
        if (adj.length > 3){
         throw new Exception();
        }

        return aux;

    }

    public static void division() throws Exception {
        System.out.println("Primera matriz: ");
        double[][] m1 = switch_m();
        System.out.println("Segunda matriz: ");
        double[][] m2 = switch_m();
        try {
            double[][] inversa = Inversa(m2);
            double[][] m4 = new double[m1.length][m2[0].length];

            if (multiplicacionmatriz(m1, inversa, m4)) {
                imprimir_m(m4);
                 R = m4;
            }
            reporte(m1, m2);
        } catch (Exception e) {
            System.out.println("Las matrices no son iguales en dimensiones");
        }

    }

    //Los reportes se basan en el mismo sistema, sistema sencillo para escribir un archivo html
    public static void reporte(double[][] uno, double[][] dos){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null && uno != null && dos != null){

            try{

                fichero = new FileWriter("Reporte"+operacion+".html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte"+operacion+"</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte"+ operacion +"</h1>");

                pw.println("<p style=\"text-align:center;\">Matrices Operandos</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz uno

                for (int i = 0; i < uno.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < uno[0].length; j++) {
                        pw.println("<td>" + uno[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz dos

                for (int i = 0; i < dos.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < dos[0].length; j++) {
                        pw.println("<td>" + dos[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");

                pw.println("<p style=\"text-align:center;\">Matriz R</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < R.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < R[0].length; j++) {
                        pw.println("<td>" + R[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");


                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

    public static void reporteMultiplicacionEscalar(int num){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null){

            try{

                fichero = new FileWriter("ReporteME.html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte Multiplicacion Escalar</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte Multiplicación por un Escalar</h1>");

                pw.println("<p style=\"text-align:center;\">Matriz R</p>");

                pw.println("<p style=\"text-align:center;\">Escalar: "+String.valueOf(num)+"</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < R.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < R[0].length; j++) {
                        pw.println("<td>" + R[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");


                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

    public static void reporteTranspuesta(){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null){

            try{

                fichero = new FileWriter("ReporteMT.html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte Transpuesta</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte Transpuesta</h1>");

                pw.println("<p style=\"text-align:center;\">Matriz Transpuesta</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < R.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < R[0].length; j++) {
                        pw.println("<td>" + R[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");


                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

    public static void reporteInversa(double[][] uno){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null && uno != null){

            try{

                fichero = new FileWriter("Reporte"+operacion+".html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte Inversa</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte"+ operacion +"</h1>");

                pw.println("<p style=\"text-align:center;\">Matriz Original</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz uno

                for (int i = 0; i < uno.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < uno[0].length; j++) {
                        pw.println("<td>" + uno[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");

                pw.println("<p style=\"text-align:center;\">Matriz R</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < R.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < R[0].length; j++) {
                        pw.println("<td>" + R[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");


                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

    public static void reportePotencia(int num){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null){

            try{

                fichero = new FileWriter("ReportePM.html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte Potencia</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte Potencia de una Matriz</h1>");

                pw.println("<p style=\"text-align:center;\">Matriz R</p>");

                pw.println("<p style=\"text-align:center;\">Potencia: "+String.valueOf(num)+"</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < R.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < R[0].length; j++) {
                        pw.println("<td>" + R[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");


                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

    public static void reporteDeterminante(double det, double[][] matrix){

        FileWriter fichero = null;
        PrintWriter pw = null;

        if(R != null){

            try{

                fichero = new FileWriter("ReporteDeterminante.html");
                pw = new PrintWriter(fichero);

                pw.println("<!DOCTYPE html>\n"
                        + "<htlm lang=\"es\">\n" +
                        "<head>\n"
                        + "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <title>Reporte Determinante</title>\n"
                        + "</head>\n"
                        + "<body>\n");

                pw.println("<h1 style=\"text-align:center;\">Reporte Determinante de una Matriz</h1>");

                pw.println("<p style=\"text-align:center;\">Matriz</p>");

                pw.println("<table border=\"1\" style=\"width:100%\">");//imprimimos la matriz resultado R

                for (int i = 0; i < matrix.length; i++) { //imprimir las matrices
                    pw.println("<tr>");
                    for (int j = 0; j < matrix[0].length; j++) {
                        pw.println("<td>" + matrix[i][j] + "</td>");
                    }
                    pw.println("</tr>");
                }

                pw.println("</table>");

                pw.println("<p style=\"text-align:center;\">Determinante: "+ det +"</p>");

                pw.println(" "
                        + "    \n"
                        + "</body>\n"
                        + "</html>");

                fichero.close();

            }
            catch (Exception e){
                System.out.println("No se pudo generar el reporte");
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getCause());
            }

        }

    }

}