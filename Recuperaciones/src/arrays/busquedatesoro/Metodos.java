package arrays.busquedatesoro;

import java.util.Arrays;
import java.util.Random;

public class Metodos {

	public static char[][] tablero;
	public static int posI;
	public static int posJ;

	public static void inicializaTablero(int numFilas, int numColumnas) {
		char tablero[][] = new char[numFilas][numColumnas];
		for (char[] espacios : tablero) {
			Arrays.fill(espacios, ' ');
		}
	}

	public static void generaPosicionTesoro() {
		Random random = new Random();
		int randomI = random.nextInt(0, tablero.length);
		int randomJ = random.nextInt(0, tablero[0].length);
		tablero[randomI][randomJ] = 'X';
	}

	public static void generaObstaculos(int numObstaculos) {
		Random random = new Random();
		int randomI;
		int randomJ;
		char caracter;
		int cont = 0;

		while (cont < numObstaculos) {
			randomI = random.nextInt(0, tablero.length);
			randomJ = random.nextInt(0, tablero[0].length);

			caracter = tablero[randomI][randomJ];

			if (caracter == ' ' && !obstaculosAlrededor(randomI, randomJ)) {
				tablero[randomI][randomJ] = '*';
				cont++;
			}
		}

	}

	public static boolean obstaculosAlrededor(int obsI, int obsJ) {
		boolean enc = false;
		int i = obsI - 1;
		int j;

		if (obsI < 0) {
			i = obsI + 1;
		}

		while (i < tablero.length && i <= obsI + 1 && !enc) {
			j = (obsJ - 1) < 0 ? obsJ + 1 : (obsJ - 1);
			while (j < tablero[i].length && j <= obsJ + 1 && !enc) {
				if (tablero[i][j] == '*') {
					enc = true;
				}
				j++;
			}
			i++;
		}

		return enc;
	}

	public static void generaPosicionJugador() {
		Random random = new Random();
		int randI;
		int randJ;

		do {
			randI = random.nextInt(0, tablero.length);
			randJ = random.nextInt(0, tablero[0].length);
		} while (tablero[posI][posJ] != ' ');
	}

	public static void pintaTablero() {
		for (int j = 0; j < tablero[0].length; j++) {
			System.out.println("\t" + (char) (j + 'A'));
		}

		System.out.println();

		for (int i = 0; i < tablero.length; i++) {
			System.out.println(i + 1);

			for (int j = 0; j < tablero[i].length; i++) {
				if (posI == i && posJ == j) {
					System.out.println("\t" + 'J');
				} else if (tablero[i][j] == 'X') {
					System.out.println("\t");
				} else {
					System.out.println("\t" + tablero[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static int mueveJugador(String movimiento) {
		return posI;
	}
}
