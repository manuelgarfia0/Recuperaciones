package arrays.hundirlaflotaobjetos;

import java.util.Arrays;

public class JugadorFlota {

	private String nombre;
	private int contHundidos = 0;
	private char[][] tablero;

	public JugadorFlota(String nombre, int filas, int columnas) {
		this.nombre = nombre;

		tablero = new char[filas][columnas];

		for (int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], '-');
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getContHundidos() {
		return contHundidos;
	}

	public boolean lanzaBomba(char[][] tableroMaquina, char fila, int columna) {
		boolean hundido = false;

		tablero[fila - 'A'][columna - 1] = tableroMaquina[fila - 'A'][columna - 1];
		if (tablero[fila - 'A'][columna - 1] == 'B') {
			hundido = true;
			contHundidos++;
		}

		return hundido;
	}

	public String toString() {
		char caracter;
		char caracterA = 'A';
		String res = "TURNO DE " + nombre + "\n";

		for (int i = 1; i <= tablero[0].length; i++) {
			res += "\t" + i;
		}

		res += "\n";

		for (int i = 0; i < tablero.length; i++) {
			caracter = (char) (caracterA + i);
			res += caracter + "\t";
			for (int j = 0; j < tablero[0].length; j++) {
				res += tablero[i][j] + "\t";
			}
			res += "\n";
		}
		return res;
	}

}