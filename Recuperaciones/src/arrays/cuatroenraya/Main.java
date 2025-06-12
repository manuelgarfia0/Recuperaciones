package arrays.cuatroenraya;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		char jugadorActual = 'X';
		boolean juegoTerminado = false;

		Comprobaciones.inicializarTablero();

		System.out.println("¡Bienvenido al Cuatro en Raya!");
		System.out.println("Jugador X comienza primero");
		System.out.println("Introduce el número de columna (0-6) donde quieres colocar tu ficha");
		System.out.println("Las fichas caerán por gravedad hasta la posición más baja disponible");

		while (!juegoTerminado) {
			// Mostrar tablero
			mostrarTablero();

			// Pedir movimiento al jugador actual
			System.out.println("\nTurno del jugador " + jugadorActual);
			System.out.print("Introduce la columna (0-6): ");

			try {
				int columna = scanner.nextInt();

				// Validar movimiento
				if (esMovimientoValido(columna)) {
					// Encontrar la fila donde caerá la ficha
					int fila = Comprobaciones.encontrarFilaDisponible(columna);

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
					System.out.println("Columna inválida o llena. Introduce un número entre 0-6.");
				}
			} catch (Exception e) {
				System.out.println("Entrada inválida. Por favor, introduce un número entre 0 y 6.");
				scanner.nextLine(); // Limpiar buffer
			}
		}

		scanner.close();
	}

	public static void mostrarTablero() {
		System.out.println("\nTablero actual:");
		System.out.println("0 1 2 3 4 5 6");
		for (int i = 0; i < Comprobaciones.tablero.length; i++) {
			for (int j = 0; j < Comprobaciones.tablero[i].length; j++) {
				System.out.print(Comprobaciones.tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean esMovimientoValido(int columna) {
		// Verificar que la columna esté en rango y que no esté llena
		return columna >= 0 && columna < 7 && Comprobaciones.encontrarFilaDisponible(columna) != -1;
	}

	public static boolean tableroLleno() {
		// El tablero está lleno si todas las columnas están llenas (fila superior
		// ocupada)
		for (int j = 0; j < Comprobaciones.tablero[0].length; j++) {
			if (Comprobaciones.tablero[0][j] == '-') {
				return false;
			}
		}
		return true;
	}
}
