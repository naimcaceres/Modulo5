package Modulo5;

public class Tablero {

    private String tablero [][] = new String[3][3];

    //Consturctor
    public Tablero() {
        /*
        - Le decimos que recorra cada fila, y que dentro de cada fila, recorra cada columna
          y las reellene con un "-" para iniciarlo como "vacío"
         */
        for(int f = 0; f < tablero.length; f++) {
            for(int c = 0; c < tablero[f].length; c++) {
                tablero[f][c] = "-";
            }
        }
    }

    //Mostrar tablero
    public void mostrarTablero() {
        System.out.println("  1 2 3");

        /*
        - Le decimos que se imprima un "  1 2 3" al iniciar para marcar las columnas
        - Luego inicializamos un recorrido de cada fila con un for y le decimos que a cada
          indice de la fila le sume uno, ya que si el indice es 0, la fila es 1, entonces debe ser
          f + 1 y un " " para que quede más agradable al usuario
        - También le diremos que recorra cada columna y que a cada "-"le sume un espacio para
          que quede más agradable al usuario
        - Imprimimos un salto de linea para que quede ordenado el TaTeTi   1 2 3
                                                                         1 - - -
                                                                         2 - - -
                                                                         3 - - -
         */

        for(int f = 0; f < tablero.length; f++) {
            System.out.print((f + 1) + " ");
            for(int c = 0; c < tablero[f].length; c++) {
                System.out.print(tablero[f][c] + " ");
            }
            System.out.println();
        }
    }



    // Coloco una marca en el tablero

    public void colocarMarca(int fila, int columna, String marca){
        /* - Se resta 1 en la fila y columna para ajustar al indice correcto, es decir, cuando
             el usuario ponga por ejemplo fila 1, la funcion tiene que buscar el indice 0, no el 1
             por eso es que se inicializa con fila -- y columna --
           - Dentro del primer if-else, le decimos que si la fila y columna ingresada es mayor a 0 y menor a 3,
             entra en el if, sino "Posición errónea"
           - Hay un un segundo if-else que lo que hace es verificiar si la posición elegida esta vacía "-"
             y que si esta vacía, coloque una marca en la ubicación que quiere el usuario, sino,
             casilla ocupada, pierde turno
         */
        fila--;
        columna--;

        if(fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            if(tablero[fila][columna] == "-"){
                tablero[fila][columna] = marca;
            }else{
                System.out.println("Esta casilla esta ocupada. Pierde turno.");
            }
        }else{
            System.out.println("Posición errónea. Intente nuevamente ");
        }
    }

    //Verificar si el tablero está lleno
    public boolean tableroLleno(){
        /*
            - Creamos un metodo booleano que devuelva true o false
            - Luego dentro del metodo creamos un for que recorra las filas y dentro de ese for, otro que
              recorra las columnas.
            - Dentro del segundo for, tenemos un if, que verifica si hay alguna casilla vacía,
              si encuentra alguna vacía, osea (tablero[f][c] == "-"), retorna falso, sino, al salir del for
              retorna true
         */
        for(int f = 0; f < tablero.length; f++) {
            for(int c = 0; c < tablero[f].length; c++) {
                // Verificar si hay alguna casilla vacía
                if(tablero[f][c] == "-"){
                    return false; // Si encuentra alguna casilla vacía
                }
            }
        }
        return true;
    }

    public boolean hayGanador(){
        // Verifico si hay un ganador

        // Verifico si hay un ganador por filas

       /* if((tablero[0][0] != "-") && (tablero [0][0].equals(tablero[0][1]) && tablero[0][1].equals(tablero[0][2]))) {
           return true;
        }

        if((tablero [1][0] != "-") && (tablero [1][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[1][2]) )){
            return true;
        }


        if((tablero [2][0] != "-") && (tablero [2][0].equals(tablero[2][1]) && tablero[2][1].equals(tablero[2][2]) )){
            return true;
        }



        // Verifico si hay un ganador por columnas



        if((tablero[0][0] != "-") && (tablero [0][0].equals(tablero[1][0]) && tablero[1][0].equals(tablero[2][0]))) {
            return true;
        }

        if((tablero [0][1] != "-") && (tablero [0][1].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][1]) )){
            return true;
        }

        if((tablero [0][2] != "-") && (tablero [0][2].equals(tablero[1][2]) && tablero[1][2].equals(tablero[2][2]) )){
            return true;
        }

        //Verifico si hay un ganador por diagonales

        if ((tablero[0][0] != "-") && (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]))) {
            return true;
        }

        if ((tablero[2][0]) != "-" && (tablero[2][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[0][2]))) {
            return true;
        }
        return false; */

        //OTRA FORMA BASTANTE MÁS CORTA

        //Ganador por filas

        /*
            - Hacemos un for que recorra cada fila, y que si encuentra una fila, que todas sus columnas
              sean iguales y ninguna esté vacía ("-"), retornará true, osea esa fila hizo TaTeTi, 3 en línea
         */

        for(int f = 0; f < tablero.length; f++) {
            if(tablero[f][0] == tablero[f][1] && tablero[f][1] == tablero[f][2] && tablero[f][0] != "-"){
                return true;
            }
        }

        //Ganador por columnas

        /*
           - Hacemos un for que recorra cada columna, y que si encuentra una columna, que todas sus filas
             sean iguales y ninguna esté vacía ("-"), retornará true, osea esa columna hizo TaTeTi, 3 en línea

         */

        for(int c = 0; c < tablero.length; c++) {
            if(tablero[0][c] == tablero[1][c] && tablero[1][c] == tablero[2][c] && tablero[0][c] != "-"){
                return true;
            }
        }

       // Ganador por diagonales

        /*
            - Hacemos un for que recorra la fila 1 columna 1, fila 2 columna 2 y fila 3 columna 3, si
              las 3 son iguales, retornara true, ya que hay un ganador en diagonal
         */

        if(tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != "-"){
            return true;
        }

        /*
            - Hacemos un for que recorra la fila 3 columna 3, fila 2 columna 2 y fila 1 columna 1, si
              las 3 son iguales, retornara true, ya que hay un ganador en diagonal
         */

        if(tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != "-"){
            return true;
        }
        return false;


    }

    /*
        - Hacemos un metodo booleano que tiene un if, que verifica, si no hay ganador y el tablero está lleno
          retorna true (hay empate), sino retorna falso.
     */

    public boolean hayEmpate(){
        if(!hayGanador() && tableroLleno()){
            return true;
        }
        return false;
    }


}
