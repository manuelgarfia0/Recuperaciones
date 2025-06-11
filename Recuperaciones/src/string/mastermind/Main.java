package string.mastermind;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mastermind juego = new Mastermind();
		int intentosRealizados = 0;
		boolean haAcertado = false;
		String intento = "";
		String pista = "";

		// Se le da la bienvenida al juego
		System.out.println("¡Bienvenido al juego MASTERMIND!");
		System.out.println("Colores disponibles: R(ojo), V(erde), A(zul), B(lanco), N(egro), L(ila)");
		System.out.println("Debes adivinar un código de 5 colores.");
		System.out.println("Tienes " + juego.getNumeroDeIntentos() + " intentos.");
		System.out.println("Los colores se pueden repetir.");
		System.out.println();

		// Se le va pidiendo al jugador códigos de colores hasta que acierte o hasta que
		// agote los intentos
		while (intentosRealizados < juego.getNumeroDeIntentos() && !haAcertado) {
			System.out.print("Intento " + (intentosRealizados + 1) + "/" + juego.getNumeroDeIntentos()
					+ " - Introduce tu código (5 colores): ");
			intento = scanner.nextLine().toUpperCase();

			// Si el código introducido por el jugador no tiene 5 caracteres exactos se le
			// debe seguir pidiendo códigos hasta que introduzca uno válido
			while (intento.length() != 5) {
				System.out.println("Error: El código debe tener exactamente 5 caracteres.");
				System.out.print("Introduce tu código (5 colores): ");
				intento = scanner.nextLine().toUpperCase();
			}

			// Comprobar el código
			pista = juego.compruebaCodigo(intento);
			intentosRealizados++;

			// Tras cada intento, se mostrarán los intentos previos con sus correspondientes
			// pistas
			System.out.println();
			System.out.println("INTENTOS PREVIOS");
			System.out.println(juego.getIntentosPrevios());
			System.out.println();

			// Verificar si ha acertado
			if (intento.equals(juego.getCodigo())) {
				haAcertado = true;
			}
		}

		// Si el usuario ha acertado se le dará la enhorabuena al jugador y se acabará
		// el programa
		if (haAcertado) {
			System.out.println("¡ENHORABUENA! ¡Has adivinado el código!");
			System.out.println("El código era: " + juego.getCodigo());
		} else {
			// Si ha agotado los intentos y no ha acertado se le mostrará un mensaje
			// indicando que ha perdido y mostrando la solución
			System.out.println("Has perdido. Has agotado los " + juego.getNumeroDeIntentos() + " intentos.");
			System.out.println("La solución era: " + juego.getCodigo());
		}

		scanner.close();
	}
}