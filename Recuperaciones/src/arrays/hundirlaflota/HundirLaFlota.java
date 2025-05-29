package arrays.hundirlaflota;

import java.util.Arrays;
import java.util.Random;

public class HundirLaFlota {

	public static void main(String[] args) {

		char[][] tablero = new char[4][4];
		char[][] tableroJugador = new char[4][4];

		inicializaTablero(5, 5);
		pintaTablero(tablero);

	}

	static char[][] inicializaTablero(int filas, int columnas) {
		char[][] tablero = new char[filas][columnas];
		for (char[] guionMedio : tablero) {
			Arrays.fill(guionMedio, '-');
		}
		return tablero;
	}

	static char[][] creaTablero(int filas, int columnas) {
		char[][] tablero = new char[filas][columnas];
		for (char[] a : tablero) {
			Arrays.fill(a, 'A');
		}
		return tablero;
	}

	static void generarBarquitos(char[][] tablero, int numBarquitos) {
		Random random = new Random();
		int posI;
		int posJ;
		char caracter;
		int cont = 0;

		while (cont < numBarquitos) {
			posI = random.nextInt(0, tablero.length);
			posJ = random.nextInt(0, tablero[0].length);

			caracter = tablero[posI][posJ];

			if (caracter == '-') {
				tablero[posI][posJ] = 'B';
				cont++;
			}
		}

	}

	static void pintaTablero(char[][] tableroJugador) {
		int posI = 0;
		int posJ = 0;

		System.out.println("  ");
		for (int j = 0; j < tableroJugador[0].length; j++) {
			System.out.print("\t" + j);
		}

		System.out.println();

		for (int i = 0; i < tableroJugador.length; i++) {
			System.out.print((char) (i + 'A'));

			for (int j = 0; j < tableroJugador[i].length; j++) {
				if (tableroJugador[i][j] == 'B') {
					System.out.print("\t");
				} else {
					System.out.print("\t" + tableroJugador[i][j]);
				}
			}
			System.out.println();
		}
	}

}
