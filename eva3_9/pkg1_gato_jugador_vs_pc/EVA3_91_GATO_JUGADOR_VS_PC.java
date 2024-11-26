/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_9.pkg1_gato_jugador_vs_pc;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jose Enrique
 */
public class EVA3_91_GATO_JUGADOR_VS_PC {

    /**
     * @param args the command line arguments
     */
    static char[][] tablero = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    static char jugador = 'X';
    static char computadora = 'O';
    static char turno = jugador;
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner captu = new Scanner(System.in);
        
        while (true) {
            tableroJuego();
            if (turno == jugador) {
                movimientoJugador(captu);
                if (elGanador(jugador)) {
                    tableroJuego();
                    System.out.println("Felicidades ganaste");
                    break;
                }
                turno = computadora;
            } else {
                pcMovimiento();
                if (elGanador(computadora)) {
                    tableroJuego();
                    System.out.println("La computadora gano eres un perdedor mejor suerte la proxima");
                    break;
                }
                turno = jugador;
            }

            if (tableroLleno()) {
                tableroJuego();
                System.out.println("Es un empate");
                break;
            }
        }
    }

    // Función para imprimir el tablero
    public static void tableroJuego() {
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            if (i < 2) System.out.println("_______________");
        }
    }

    // Función para realizar el movimiento del jugador
    public static void movimientoJugador(Scanner captu) {
        int posicion;
        while (true) {
            System.out.println("Es tu turno jugador " + jugador + " Elige una posicion (1-9): ");
            posicion = captu.nextInt();
            if (posicion >= 1 && posicion <= 9 && tablero[(posicion - 1) / 3][(posicion - 1) % 3] != jugador && tablero[(posicion - 1) / 3][(posicion - 1) % 3] != computadora) {
                tablero[(posicion - 1) / 3][(posicion - 1) % 3] = jugador;
                break;
            } else {
                System.out.println("posicion invalida elige otra por favor");
            }
        }
    }

    // Función para realizar el movimiento de la computadora
    public static void pcMovimiento() {
        Random rand = new Random();
        int posicion;
        while (true) {
            posicion = rand.nextInt(9) + 1;
            if (tablero[(posicion - 1) / 3][(posicion - 1) % 3] != jugador && tablero[(posicion - 1) / 3][(posicion - 1) % 3] != computadora) {
                tablero[(posicion - 1) / 3][(posicion - 1) % 3] = computadora;
                break;
            }
        }
        System.out.println("La computadora elegio la posicion: " + posicion);
    }

    // Función para verificar si un jugador ha ganado
    public static boolean elGanador(char jugador) {
        // Comprobar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true;
            }
        }
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }
        return false;
    }

    // Función para verificar si el tablero está lleno
    public static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != jugador && tablero[i][j] != computadora) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
