package arrays.cuatroenraya;

import java.util.Arrays;

public class Comprobaciones {

	static char tablero[][] = new char[6][7]; // Tablero típico de Connect 4: 6 filas x 7 columnas

	public static void inicializarTablero() {
		for (char[] fila : tablero) {
			Arrays.fill(fila, '-');
		}
	}

	public static boolean ganador(char jugador) {
		return filas(jugador) || columnas(jugador) || diagonalIzquierdaDerecha(jugador)
				|| diagonalDerechaIzquierda(jugador);
	}

	// Comprobación por filas - busca 4 consecutivas
	public static boolean filas(char jugador) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j <= tablero[i].length - 4; j++) {
				if (tablero[i][j] == jugador && 
					tablero[i][j + 1] == jugador && 
					tablero[i][j + 2] == jugador && 
					tablero[i][j + 3] == jugador) {
					return true;
				}
			}
		}
		return false;
	}

	// Comprobación por columnas - busca 4 consecutivas
	public static boolean columnas(char jugador) {
		for (int j = 0; j < tablero[0].length; j++) {
			for (int i = 0; i <= tablero.length - 4; i++) {
				if (tablero[i][j] == jugador && 
					tablero[i + 1][j] == jugador && 
					tablero[i + 2][j] == jugador && 
					tablero[i + 3][j] == jugador) {
					return true;
				}
			}
		}
		return false;
	}

	// Comprobación diagonal de izquierda a derecha (hacia abajo-derecha)
	public static boolean diagonalIzquierdaDerecha(char jugador) {
		for (int i = 0; i <= tablero.length - 4; i++) {
			for (int j = 0; j <= tablero[i].length - 4; j++) {
				if (tablero[i][j] == jugador && 
					tablero[i + 1][j + 1] == jugador && 
					tablero[i + 2][j + 2] == jugador && 
					tablero[i + 3][j + 3] == jugador) {
					return true;
				}
			}
		}
		return false;
	}

	// Comprobación diagonal de derecha a izquierda (hacia abajo-izquierda)
	public static boolean diagonalDerechaIzquierda(char jugador) {
		for (int i = 0; i <= tablero.length - 4; i++) {
			for (int j = 3; j < tablero[i].length; j++) {
				if (tablero[i][j] == jugador && 
					tablero[i + 1][j - 1] == jugador && 
					tablero[i + 2][j - 2] == jugador && 
					tablero[i + 3][j - 3] == jugador) {
					return true;
				}
			}
		}
		return false;
	}

	// Método para encontrar la fila disponible en una columna (las fichas caen por gravedad)
	public static int encontrarFilaDisponible(int columna) {
		for (int i = tablero.length - 1; i >= 0; i--) {
			if (tablero[i][columna] == '-') {
				return i;
			}
		}
		return -1; // Columna llena
	}
}
