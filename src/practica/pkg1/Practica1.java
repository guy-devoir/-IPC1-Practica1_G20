package practica.pkg1;

import java.util.Scanner;

/**
 * @author Luciano Xiquín
 */
public class Practica1 {

    /*El unico beneficio de tener las 25 matrices como variables globales es
      el uso que se le da en el metodo switch_m
      el cual por cierto es muy primitivo y propiamente de principiantes
     */
    static int[][] A={{1,2},{3,4}}; //1
    static int[][] B={{2,2},{2,2}}; //2
    static int[][] C ={{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; //3
    static int[][] D ={{-2,4,5},{6,7,-3},{3,0,2}}; //4
    static int[][] E; //5
    static int[][] F; //6
    static int[][] G; //7
    static int[][] H; //8
    static int[][] I; //9
    static int[][] J; //10
    static int[][] K; //11
    static int[][] L; //12
    static int[][] M; //13
    static int[][] N; //14
    static int[][] O; //15
    static int[][] P; //16
    static int[][] Q; //17
    static int[][] S; //18
    static int[][] T; //19
    static int[][] U; //20
    static int[][] V; //21
    static int[][] W; //22
    static int[][] X; //23
    static int[][] Y; //24
    static int[][] Z; //25
    
    //Decidí volver el escaner global, espero que no sea una mala idea
    //Los metodos que lo utilizaban de local eran switch_m, sub_menu y main
    static Scanner sc = new Scanner(System.in);
    static int[][] R;
    /*
    Este sí que sera un 'espaguetti code', la vdd
    Metodos como switch_m son redundantes y bastante tediosos de programar,
    sin embargo al no haber forma (hasta donde yo se) de usar un Scanner, 
    un switch y una variable string para para.
     */
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
                                + "\n10)Reportes"
                                + "\n11)Salir");
            try {
                int opcion;
                switch (opcion = sc.nextInt()) {
                    case 1:
                        System.out.println("****************" + "\nIntroduzca la ruta del archivo");
                        leerarchivo();
                        break;
                    case 2:
                        System.out.println("Nombre de la primer matriz:");
                        int[][] m10 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        int[][] m20 = switch_m();
                        //int[][] resultado_suma;
                        try {
                            R = suma_m(m10, m20);
                            System.out.println("Resultado de la suma es:");
                            imprimir_m(R);
                            System.out.println("==================");
                        } catch (Exception e) {
                            System.out.println("Las matrices no son iguales");
                        }
                        break;
                    case 3:
                        System.out.println("Nombre de la primer matriz:");
                        int[][] m11 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        int[][] m21 = switch_m();
                        //int[][] resultado_resta;
                        try {
                            R = resta_m(m11, m21);
                            System.out.println("Resultado de la suma es:");
                            imprimir_m(R);
                            System.out.println("=================="); 
                        } catch (Exception e) {
                            System.out.println("Las matrices no son iguales");
                        }
                        break;

                    case 4:
                        sub_menu();
                        break;
                    case 5:
                        break;
                    case 6:
                        R = Traspuesta();
                        System.out.println("Transpuesta:");
                        imprimir_m(R);
                        System.out.println("==================");
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        //Aquí no se puedeo usar la matriz 'R' por que la 
                        //determinate es un entero
                        int determinante;
                        try {
                            determinante = Det();
                            System.err.print("LA DETERMINANTE ES:" +"[ " + determinante + "]");
                        } catch (Exception e) {
                            System.out.println("La dimensiones de la matriz exceden 3x3");
                        }
                        
                        break;
                    case 10:
                        break;
                    case 11:
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

    //Sin empezar
    private static void leerarchivo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //No comment
    static int[][] suma_m(int[][] m1, int[][] m2) throws Exception {
        int[][] aux; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        aux = new int[m1.length][m1[0].length];
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
    static int[][] resta_m(int[][] m1, int[][] m2) throws Exception {
        int[][] aux; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        aux = new int[m1.length][m1[0].length];
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
        while (menu = true) {
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
                        int[][] m1 = switch_m();
                        System.out.println("Nombre de la segunda matriz:");
                        int[][] m2 = switch_m();
                        try{
                        R = producto_m(m1, m2);
                        imprimir_m(R);
                        System.out.println("==================");
                        }catch(Exception e){
                            System.out.println("...Introduzca una entrada valida");
                            System.out.println("(╯°□°)╯︵ ┻━┻");
                        }
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Seleccione una opción valida");
                }
            } catch (Exception e) {
                System.out.println("...Introduzca una entrada valida");
            }
        }
    }

    //Multiplicación de una matriz por escalar
    static int[][] multiplicacion() throws Exception {
        int[][] aux;
        int[][] res_aux;
        int num;
        System.out.println("Introduzca el escalar:");
        num = sc.nextInt();
        System.out.println("Nombre de la matriz:");
        aux = switch_m();
        res_aux = new int[aux.length][aux[0].length];
        //Debo checar este for
        for (int i = 0; i < res_aux.length; i++) {
            for (int j = 0; j < res_aux[0].length; j++) {
                res_aux[i][j] = num * aux[i][j];
            }
        }
        return res_aux;
    }

    //Producto de dos matrices (Sin acabar)
    static int[][] producto_m(int[][] m1, int[][] m2) throws Exception {
        int[][] aux = null;
        if (m1.length == m2[0].length) {
            for (int k = 0; k < m1.length; k++) {
                for (int i = 0; i < m2[0].length; i++) {
                    for (int j = 0; j < m1[0].length; j++) {
                        aux[k][i] += m1[i][j] * m2[j][k];
                    }
                }
            }
        } else {
            throw new Exception();
        }

        return aux;
    }

    //Debo encontrar una solución más elegante para este proceso
    static int[][] switch_m() {
        //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        String letter = sc.next();
        int[][] aux = null;
        if (letter.equals("A")) {
            aux = A;
        }
        if (letter.equals("B")) {
            aux = B;
        }
        if (letter.equals("C")) {
            aux = C;
        }
        if (letter.equals("D")) {
            aux = D;
        }
        if (letter.equals("E")) {
            aux = E;
        }
        return aux;
    }

    //Método exclusivo para la impresión de las matrices
    static int[][] imprimir_m(int[][] res) {
        int[][] aux = res; //El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        for (int[] aux1 : aux) {
            for (int j = 0; j < aux[0].length; j++) {
                System.err.print("[ " + aux1[j] + "]");
            }
            System.err.println("");
        }
        return aux;
    }

    private static int[][] Traspuesta() {
        int[][] aux;//El arreglo auxiliar está solo para alamacenar matrices y regresar un valor
        int[][] original;
        System.out.println("Nombre de la Matriz:");
        original = switch_m();
        aux = new int[original[0].length][original.length];
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

    private static int Det() throws Exception {
    int aux_det = 0;
    int[][] m1;
    System.err.print("Nombre de la Matriz:");
    m1 = switch_m();
    System.err.println("DE LA MATRIZ");
    imprimir_m(m1);
        if(m1.length == m1[0].length){
            if (m1.length == 2) {
                //Funciona
                aux_det = m1[0][0] * m1[1][1] - m1[0][1] * m1[1][0];
            }
            if (m1.length == 3) {
                int left = m1[0][0] * m1[1][1] * m1[2][2] - m1[1][0] * m1[2][1] * m1[0][2] + m1[2][0] * m1[0][1] * m1[1][2];
                int right = m1[0][2] * m1[1][1] * m1[2][0] - m1[1][2] * m1[2][1] * m1[0][0] + m1[2][2] * m1[0][1] * m1[1][0];
                aux_det = left - right;
            }
            if (m1.length > 3) {
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
}