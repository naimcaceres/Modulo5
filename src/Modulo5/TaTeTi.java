package Modulo5;

import java.util.Scanner;

public class TaTeTi {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;


    //Constructor
    public TaTeTi(){
        tablero = new Tablero();
        jugador1 = new Jugador (null, "X");
        jugador2 = new Jugador (null, "O");
        jugadorActual = jugador1;
    }


    //Inicializamos juego
    public void jugar(){

        System.out.println("Bienvenido al TaTeTi creado por Naim");

        Scanner scanner = new Scanner(System.in);
        int fila, columna;
        boolean jugadaValida;

        String nombre1;
        String nombre2;
        // Le decimos que no puede ingresar nombre vacio
        do{
            System.out.println("Ingrese el nombre del jugador 1:");
            nombre1 = scanner.nextLine().trim();
            jugador1.setNombre(nombre1);
            if (nombre1.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Por favor, ingréselo nuevamente.");
            } else if (!nombre1.matches("^[a-zA-Z]+$")) {
                System.out.println("El nombre solo puede contener letras. Por favor, ingréselo nuevamente.");
            }
        } while (nombre1.isEmpty() || !nombre1.matches("^[a-zA-Z]+$"));


        // Le decimos que no puede ingresar nombre vacio
        do {
            System.out.println("Ingrese el nombre del jugador 2:");
            nombre2 = scanner.nextLine().trim();
            jugador2.setNombre(nombre2);
            if (nombre2.isEmpty()) {
                System.out.println("El nombre no puede estar vacío. Por favor, ingréselo nuevamente.");
            } else if (!nombre2.matches("^[a-zA-Z]+$")) {
                System.out.println("El nombre solo puede contener letras. Por favor, ingréselo nuevamente.");
            }
        } while (nombre2.isEmpty() || !nombre2.matches("^[a-zA-Z]+$"));


        while (!tablero.hayEmpate()){
            System.out.println("Turno de " + jugadorActual.getNombre() + " que juega con la marca: " + jugadorActual.getMarca());
            tablero.mostrarTablero();

            jugadaValida = false;
            while (!jugadaValida){
                System.out.println("Ingrese la fila: ");
                fila = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese la columna: ");
                columna = scanner.nextInt();
                scanner.nextLine();
                tablero.colocarMarca(fila, columna, jugadorActual.getMarca());
                tablero.mostrarTablero();
                limpiarConsola();

                if(!tablero.hayGanador()){
                    cambiarJugador();
                    System.out.println();
                    System.out.println("Turno de " + jugadorActual.getNombre());
                    tablero.mostrarTablero();
                }else{
                    limpiarConsola();
                    System.out.println("El ganador es: " + jugadorActual.getNombre());
                    jugadaValida = true;
                    tablero.mostrarTablero();
                }

                if(tablero.hayEmpate()){
                    jugadaValida = true;
                    limpiarConsola();
                    System.out.println("Hay un empate!");
                    tablero.mostrarTablero();
                    System.out.println("1. Volver a jugar");
                    System.out.println("2. Terminar");
                    String continuar = scanner.nextLine();
                    if(continuar.equals("1")){
                        TaTeTi jugarDeNuevo = new TaTeTi();
                        jugarDeNuevo.jugar();
                        break;
                    }else if (continuar.equals("2")){
                        System.out.println("El juego ha terminado, espero se hayan divertido.");
                        break;
                    }else{
                        break;
                    }

                }
            }
            if(tablero.hayGanador()){
                break;
            }
        }


    }

    public void cambiarJugador(){
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


}