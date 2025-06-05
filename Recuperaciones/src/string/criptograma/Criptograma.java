package string.criptograma;

import java.util.Scanner;

public class Criptograma {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("¡Bienvenido al juego CRIPTOGRAMA!");
		System.out.println("Tienes que descifrar el mensaje introduciendo códigos y letras.");
		System.out.println("Los códigos son de 2 dígitos (fila y columna del abecedario).\n");

		// 1. Desordena el array del abecedario
		FuncionesCriptograma.desordenaAbecedario();

		// 2. Selecciona una frase con la que jugar
		FuncionesCriptograma.eligeFrase();

		// 3. Codifica la frase seleccionada
		FuncionesCriptograma.codificaFrase();

		// 4. Bucle principal del juego
		while (!FuncionesCriptograma.sonIguales()) {
			// Mostrar la frase codificada
			System.out.println("Frase codificada:");
			System.out.println(FuncionesCriptograma.fraseCodificada);
			System.out.println();

			// Pedir código al usuario
			System.out.print("Introduce un código (2 dígitos): ");
			String codigo = scanner.nextLine().trim();

			// Validar que el código tenga exactamente 2 dígitos
			boolean codigoValido = true;
			if (codigo.length() != 2) {
				codigoValido = false;
			} else {
				if (!Character.isDigit(codigo.charAt(0)) || !Character.isDigit(codigo.charAt(1))) {
					codigoValido = false;
				}
			}

			if (!codigoValido) {
				System.out.println("Error: El código debe tener exactamente 2 dígitos.");
				System.out.println();
			} else {
				// Pedir letra al usuario
				System.out.print("Introduce una letra: ");
				String inputLetra = scanner.nextLine().trim().toLowerCase();

				boolean letraValida = true;
				if (inputLetra.length() != 1) {
					letraValida = false;
				}

				if (!letraValida) {
					System.out.println("Error: Debes introducir exactamente una letra.");
					System.out.println();
				} else {
					char letra = inputLetra.charAt(0);

					// Comprobar si el usuario ha acertado
					if (FuncionesCriptograma.compruebaCodigo(codigo, letra)) {
						System.out.println("¡Correcto! Has acertado.");
					} else {
						System.out.println("Incorrecto. Ese código no corresponde a esa letra.");
					}

					System.out.println();
				}
			}
		}

		// 5. Mensaje de enhorabuena
		System.out.println("¡ENHORABUENA! Has descifrado el mensaje completo:");
		System.out.println("\"" + FuncionesCriptograma.fraseReal + "\"");

		scanner.close();
	}
}