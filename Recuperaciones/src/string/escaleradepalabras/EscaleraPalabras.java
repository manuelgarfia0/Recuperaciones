package string.escaleradepalabras;

import java.util.Scanner;

/**
 * Clase principal que implementa el main y controla la ejecución del juego
 */
public class EscaleraPalabras {

	/**
	 * Método principal que ejecuta el juego
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX_INTENTOS = 7;
		int intentosRealizados = 0;

		// Seleccionar un nuevo juego
		JuegoEscalera.seleccionaJuego();

		// Mostrar información del juego
		System.out.println("=== JUEGO ESCALERA DE PALABRAS ===");
		System.out.println("Palabra de inicio: " + JuegoEscalera.getPalabraInicio());
		System.out.println("Palabra objetivo: " + JuegoEscalera.getPalabraObjetivo());
		System.out.println("Tienes " + MAX_INTENTOS + " intentos para llegar a la palabra objetivo.");
		System.out.println("En cada paso solo puedes cambiar una letra.\n");

		boolean juegoTerminado = false;
		boolean hasGanado = false;

		while (!juegoTerminado && intentosRealizados < MAX_INTENTOS) {
			System.out.println("Jugada actual: " + JuegoEscalera.getJugada());
			System.out.print("Introduce tu siguiente palabra: ");
			String intento = scanner.nextLine().toUpperCase().trim();

			// Verificar longitud de 4 letras
			if (intento.length() != 4) {
				System.out.println("La palabra debe tener exactamente 4 letras. Inténtalo de nuevo.\n");
			} else {
				// Verificar si el intento es correcto
				if (!JuegoEscalera.compruebaIntento(intento)) {
					System.out.println(
							"Intento erróneo. Solo puedes cambiar una letra respecto a la palabra anterior.\n");
				} else {
					// El intento es correcto, añadirlo a la jugada
					JuegoEscalera.agregarIntento(intento);
					intentosRealizados++;

					// Verificar si ha alcanzado la palabra objetivo
					if (intento.equals(JuegoEscalera.getPalabraObjetivo())) {
						hasGanado = true;
						juegoTerminado = true;
					}

					System.out.println("¡Bien! Intento " + intentosRealizados + " de " + MAX_INTENTOS + "\n");
				}
			}
		}

		// Mostrar resultado final
		System.out.println("Jugada final: " + JuegoEscalera.getJugada());

		if (hasGanado) {
			System.out.println("¡¡¡ENHORABUENA!!! Has conseguido llegar a la palabra objetivo '"
					+ JuegoEscalera.getPalabraObjetivo() + "' en " + intentosRealizados + " intentos.");
		} else {
			System.out.println("Has perdido. Se han agotado los " + MAX_INTENTOS
					+ " intentos sin alcanzar la palabra objetivo '" + JuegoEscalera.getPalabraObjetivo() + "'.");
		}

		scanner.close();
	}
}