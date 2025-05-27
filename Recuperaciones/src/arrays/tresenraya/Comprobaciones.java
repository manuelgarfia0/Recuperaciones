package arrays.tresenraya;

import java.util.Arrays;

public class Comprobaciones {

	static char tablero[][] = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', 'X', 'O' } };

	public static void inicializarTablero() {
		for (char[] fila : tablero) {
			Arrays.fill(fila, '-');
		}
	}

	public static boolean ganador(char jugador) {
		return filas(jugador) || columnas(jugador) || diagonalIzquierdaDerecha(jugador)
				|| diagonalDerechaIzquierda(jugador);
	}

	// Comprobación por filas
	public static boolean filas(char jugador) {
		int i = 0;
		int j = 0;
		boolean res = false;
		boolean auxRes = true;

		while (i < tablero.length && !res) {
			while (j < tablero[i].length && auxRes) {
				if (tablero[i][j] != jugador) {
					auxRes = false;
				}
				j++;
			}
			res = auxRes;
			auxRes = false;
			i++;
		}
		return res;
	}

	// Comprobación por columnas
	public static boolean columnas(char jugador) {
		int i = 0;
		int j = 0;
		boolean res = false;
		boolean auxRes = true;

		while (j < tablero[i].length && !res) {
			while (i < tablero.length && auxRes) {
				if (tablero[i][j] != jugador) {
					auxRes = false;
				}
				i++;
			}
			res = auxRes;
			auxRes = false;
			j++;
		}

		return res;
	}

	// Comprobación diagonal de izquierda a derecha
	public static boolean diagonalIzquierdaDerecha(char jugador) {
		int i = 0;
		boolean res = true;

		while (i < tablero.length && res) {
			if (tablero[i][i] != jugador) {
				res = false;
			}
			i++;
		}

		return res;
	}

	public static boolean diagonalDerechaIzquierda(char jugador) {
		int i = 0;
		boolean res = true;

		while (i < tablero.length && res) {
			if (tablero[i][tablero.length - i - 1] != jugador) {
				res = false;
			}
			i++;
		}

		return res;
	}

}
