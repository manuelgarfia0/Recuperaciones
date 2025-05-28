package arrays.busquedatesoro;

import java.util.Arrays;
import java.util.Random;

public class Metodos {

	public static char[][] tablero;
	public static int posI;
	public static int posJ;

	public static void inicializaTablero(int numFilas, int numColumnas) {
		tablero = new char[numFilas][numColumnas];
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

		if (i < 0) {
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
		} while (tablero[randI][randJ] != ' ');

		posI = randI;
		posJ = randJ;
	}

	public static void pintaTablero() {
		System.out.println("  ");
		for (int j = 0; j < tablero[0].length; j++) {
			System.out.print("\t" + j);
			// En caso de querer poner la columna con letras
//			System.out.print("\t" + (char) (j + 'A'));
		}

		System.out.println();

		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + 1);

			for (int j = 0; j < tablero[i].length; j++) {
				if (posI == i && posJ == j) {
					System.out.print("\t" + 'J');
				} else if (tablero[i][j] == 'X') {
					System.out.print("\t");
				} else {
					System.out.print("\t" + tablero[i][j]);
				}
			}
			System.out.println();
		}
	}

	public static int mueveJugador(String movimiento) {
		int res = 0;

		int moverseI;
		int moverseJ;

		switch (movimiento.toUpperCase()) {
		case "ARRIBA" -> {
			moverseI = posI - 1;
			moverseJ = posJ;

			verificacionMovimiento();
		}
		case "ABAJO" -> {
			moverseI = posI + 1;
			moverseJ = posJ;

			verificacionMovimiento();
		}
		case "DERECHA" -> {
			moverseI = posI;
			moverseJ = posJ + 1;

			// Verificar límites
			verificacionMovimiento();
		}
		case "IZQUIERDA" -> {
			moverseI = posI;
			moverseJ = posJ - 1;

			// Verificar límites
			verificacionMovimiento();
		}
		default -> {
			System.out.println("Movimiento no válido. Usa: ARRIBA, ABAJO, IZQUIERDA, DERECHA");
			res = -2;
		}
		}

		return res;
	}

	public static int verificacionMovimiento() {
		int res = 0;
		int moverseI = 0;
		int moverseJ = 0;

		if (moverseI >= tablero.length) {
			System.out.println("No puedes moverte fuera del tablero!");
			res = -1;
		} else if (tablero[moverseI][moverseJ] == '*') {
			System.out.println("¡Hay un obstáculo ahí! No puedes moverte.");
			res = -1;
		} else {
			posI = moverseI;
			if (tablero[posI][posJ] == 'X') {
				System.out.println("¡Felicidades! ¡Has encontrado el tesoro!");
				res = 1;
			}
		}

		return res;
	}
}
