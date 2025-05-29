package arrays.busquedatesoro;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int filas;
		int columnas;
		boolean juegoActivo = true;
		int resultadoMovimiento;
		String movimiento;

		System.out.println("BIENVENIDO A LA BUSQUEDA DEL TESORO");
		System.out.println("Elije el tamaño del tablero: ");
		System.out.println("Filas: ");
		filas = scanner.nextInt();
		System.out.println("Columnas: ");
		columnas = scanner.nextInt();
		scanner.nextLine(); // Limpiar buffer

		// Inicializar el juego
		Metodos.inicializaTablero(filas, columnas);
		Metodos.generaObstaculos((int) (Math.sqrt(filas * columnas) / 2));
		Metodos.generaPosicionTesoro();
		Metodos.generaPosicionJugador();

		System.out.println("\n¡Juego iniciado!");
		System.out.println("Encuentra el tesoro (X) moviendo al jugador (J)");
		System.out.println("Los obstáculos están marcados con (*)");
		System.out.println("Comandos: ARRIBA, ABAJO, IZQUIERDA, DERECHA, SALIR\n");

		// Bucle principal del juego
		while (juegoActivo) {

			// Mostrar tablero actual
			Metodos.pintaTablero();

			// Solicitar movimiento
			System.out.print("\nIngresa tu movimiento: ");
			movimiento = scanner.nextLine().trim();

			// Verificar si quiere salir
			if (movimiento.equalsIgnoreCase("SALIR")) {
				juegoActivo = false;
				System.out.println("¡Gracias por jugar!");
			} else {
				// Procesar movimiento
				resultadoMovimiento = Metodos.mueveJugador(movimiento);

				// Evaluar resultado del movimiento
				if (resultadoMovimiento == 1) {
					// Tesoro encontrado
					juegoActivo = false;
					Metodos.pintaTablero();
					System.out.println("\n¡FELICIDADES! ¡HAS ENCONTRADO EL TESORO!");
				} else if (resultadoMovimiento == -1) {
					// Movimiento inválido (obstáculo o fuera de límites)
					System.out.println("Intenta otro movimiento.");
				} else if (resultadoMovimiento == -2) {
					// Comando no reconocido
					System.out.println("Comandos válidos: ARRIBA, ABAJO, IZQUIERDA, DERECHA, SALIR");
				}
				// Si resultadoMovimiento == 0, el movimiento fue exitoso y continúa el juego
			}
		}

		scanner.close();
	}
}