package string.ahorcado;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int intentosRestantes = Funciones.NUMINTENTOS;
		int opcion;

		// 1. Generar la palabra a adivinar
		Funciones.generaPalabra();

		// 2. Imprimir la pista inicial
		System.out.println("Letras usadas no acertadas: " + Funciones.noAcertadas);
		System.out.println("Pista: " + Funciones.palabraPista);

		// 3. Bucle principal del juego
		while (!Funciones.palabraPista.equals(Funciones.palabraSecreta) && intentosRestantes > 0) {

			// Mostrar menú
			System.out.println("\n--- MENÚ ---");
			System.out.println("1. Introducir una letra");
			System.out.println("2. Introducir una palabra");
			System.out.print("Selecciona una opción (1 o 2): ");

			// Leer opción y validar
			while (!scanner.hasNextInt() || (opcion = scanner.nextInt()) < 1 || opcion > 2) {
				System.out.println("Opción inválida. Por favor, introduce 1 o 2:");
				scanner.nextLine(); // Limpiar buffer
			}
			scanner.nextLine(); // Consumir el salto de línea

			if (opcion == 1) {
				// Opción 1: Introducir una letra
				System.out.print("Introduce una letra: ");
				String entrada = scanner.nextLine();

				if (entrada.length() == 1) {
					char letra = entrada.charAt(0);
					boolean yaUsada = false;

					// Verificar si la letra ya fue usada
					char letraMin = Character.toLowerCase(letra);
					if (Funciones.palabraPista.indexOf(letraMin) >= 0 || Funciones.noAcertadas.indexOf(letraMin) >= 0) {
						yaUsada = true;
						System.out.println("Ya has usado esa letra anteriormente.");
					}

					if (!yaUsada) {
						boolean acierto = Funciones.compruebaLetra(letra);
						if (!acierto) {
							intentosRestantes--;
						}
					}
				} else {
					System.out.println("Por favor, introduce solo una letra.");
				}

			} else if (opcion == 2) {
				// Opción 2: Introducir una palabra
				System.out.print("Introduce una palabra: ");
				String palabra = scanner.nextLine();

				String palabraAnterior = Funciones.palabraPista;
				Funciones.compruebaPalabra(palabra);

				// Si no acertó la palabra completa, cuenta como intento fallido
				if (palabraAnterior.equals(Funciones.palabraPista)) {
					intentosRestantes--;
				}
			}

			// Imprimir la pista actualizada (el main se encarga de imprimir)
			System.out.println("Letras usadas no acertadas: " + Funciones.noAcertadas);
			System.out.println("Pista: " + Funciones.palabraPista);

			// Imprimir intentos restantes
			System.out.println("Intentos restantes: " + intentosRestantes);
		}

		// 4. Mensaje final
		if (Funciones.palabraPista.equals(Funciones.palabraSecreta)) {
			System.out.println("\n¡¡ENHORABUENA!! HAS ACERTADO");
		} else {
			System.out.println("\nGAME OVER");
			System.out.println("La palabra era: " + Funciones.palabraSecreta);
		}

		scanner.close();
	}
}