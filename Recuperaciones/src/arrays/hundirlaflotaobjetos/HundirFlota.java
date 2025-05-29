package arrays.hundirlaflotaobjetos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HundirFlota {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		char[][] tableroMaquina;

		JugadorFlota jug1;
		JugadorFlota jug2;
		JugadorFlota jugadorPrincipal;

		int filas;
		int columnas;
		int numBarquitos;

		char fila;
		int columna;

		boolean hundido;

		System.out.println("BIENVENIDO AL HUNDIR LA FLOTA");
		System.out.println("Introduzca el número de filas del tablero");
		filas = scanner.nextInt();
		System.out.println("Introduzca el número de columnas del tablero");
		columnas = scanner.nextInt();
		numBarquitos = (int) Math.sqrt(filas * columnas);

		tableroMaquina = creaTablero(filas, columnas);
		jug1 = new JugadorFlota("Paco", filas, columnas);
		jug2 = new JugadorFlota("Pepe", filas, columnas);

		generarBarquitos(tableroMaquina, numBarquitos);
		jugadorPrincipal = jug1;

		while (jugadorPrincipal.getContHundidos() < numBarquitos) {

			System.out.println(jugadorPrincipal);

			System.out.println("Introduzca la fila como letra:");
			fila = scanner.next().toUpperCase().charAt(0);
			System.out.println("Introduzca la columna como número:");
			columna = scanner.nextInt();

			hundido = jugadorPrincipal.lanzaBomba(tableroMaquina, fila, columna);

			if (!hundido) {
				System.out.println("AGUA");
				jugadorPrincipal = (jugadorPrincipal == jug1) ? jug2 : jug1;
			} else {
				System.out.println("HUNDIDO");
			}
		}

		System.out.println("ENHORABUENA! HA GANADO " + jugadorPrincipal.getNombre());

		scanner.close();
	}

	public static char[][] creaTablero(int filas, int columnas) {
		char[][] tablero = new char[filas][columnas];
		for (int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], 'A');
		}
		return tablero;
	}

	public static void generarBarquitos(char[][] tablero, int numBarquitos) {
		Random rand = new Random();
		int cont = 0;
		int fila;
		int columna;

		while (cont < numBarquitos) {
			fila = rand.nextInt(tablero.length);
			columna = rand.nextInt((tablero[0].length));
			if (tablero[fila][columna] != 'B') {
				tablero[fila][columna] = 'B';
				cont++;
			}
		}
	}

	public static boolean turnoJugador(char[][] tablero, char[][] tableroJugador) {
		char fila;
		int columna;
		boolean hundido = false;

		System.out.println("Introduzca la fila como letra:");
		fila = scanner.next().toUpperCase().charAt(0);
		System.out.println("Introduzca la columna como número:");
		columna = scanner.nextInt();

		tableroJugador[fila - 'A'][columna - 1] = tablero[fila - 'A'][columna - 1];
		if (tablero[fila - 'A'][columna - 1] == 'B') {
			System.out.println("HUNDIDO");
			hundido = true;
		} else {
			System.out.println("AGUA");
		}

		return hundido;
	}

}