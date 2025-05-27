package arrays.tresenraya;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		char jugadorActual = 'X';
		boolean juegoTerminado = false;

		Comprobaciones.inicializarTablero();

		System.out.println("Jugador X comienza primero");
		System.out.println("Introduce fila y columna (0-2) separadas por espacio");

		while (!juegoTerminado) {
			// Mostrar tablero
			mostrarTablero();

			// Pedir movimiento al jugador actual
			System.out.println("\nTurno del jugador " + jugadorActual);
			System.out.print("Introduce tu movimiento (fila columna): ");

			try {
				int fila = scanner.nextInt();
				int columna = scanner.nextInt();

				// Validar movimiento
				if (esMovimientoValido(fila, columna)) {
					// Realizar movimiento
					Comprobaciones.tablero[fila][columna] = jugadorActual;

					// Comprobar si hay ganador
					if (Comprobaciones.ganador(jugadorActual)) {
						mostrarTablero();
						System.out.println("\n¡Felicidades! El jugador " + jugadorActual + " ha ganado!");
						juegoTerminado = true;
					} else if (tableroLleno()) {
						mostrarTablero();
						System.out.println("\n¡Empate! El tablero está lleno.");
						juegoTerminado = true;
					} else {
						// Cambiar turno
						jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
					}
				} else {
					System.out.println("La casilla ya está ocupada o fuera de rango.");
				}
			} catch (Exception e) {
				System.out.println("Entrada inválida. Por favor, introduce dos números separados por espacio.");
				scanner.nextLine(); // Limpiar buffer
			}
		}

		scanner.close();
	}

	public static void mostrarTablero() {
		System.out.println("\nTablero actual:");
		System.out.println("  0 1 2");
		for (int i = 0; i < Comprobaciones.tablero.length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < Comprobaciones.tablero[i].length; j++) {
				System.out.print(Comprobaciones.tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean esMovimientoValido(int fila, int columna) {
		return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && Comprobaciones.tablero[fila][columna] == '-';
	}

	public static boolean tableroLleno() {
		for (int i = 0; i < Comprobaciones.tablero.length; i++) {
			for (int j = 0; j < Comprobaciones.tablero[i].length; j++) {
				if (Comprobaciones.tablero[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
}