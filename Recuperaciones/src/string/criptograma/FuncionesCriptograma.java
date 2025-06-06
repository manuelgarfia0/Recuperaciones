package string.criptograma;

import java.util.Random;

// Clase que contiene las funciones del juego
class FuncionesCriptograma {

	// Atributos estáticos/variables globales
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	static String fraseReal;
	static String fraseCodificada;

	// Función para desordenar el abecedario
	static void desordenaAbecedario() {
		Random rand = new Random();

		// Crear array temporal con todas las letras
		char[] letras = new char[27];
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				letras[index] = abecedario[i][j];
				index++;
			}
		}

		// Algoritmo Fisher-Yates para mezclar
		for (int i = letras.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);
			char temp = letras[i];
			letras[i] = letras[j];
			letras[j] = temp;
		}

		// Volver a colocar las letras mezcladas en el array 2D
		index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				abecedario[i][j] = letras[index];
				index++;
			}
		}
	}

	// Función para elegir una frase al azar
	static void eligeFrase() {
		Random rand = new Random();
		int indice = rand.nextInt(frases.length);
		fraseReal = frases[indice];
	}

	// Función para codificar la frase
	static void codificaFrase() {
		String resultado = "";

		for (int k = 0; k < fraseReal.length(); k++) {
			char letra = fraseReal.charAt(k);

			if (letra == ' ') {
				resultado = resultado + "  "; // Dos espacios para representar un espacio real
			} else {
				// Buscar la letra en el array abecedario
				boolean encontrada = false;
				int i = 0;
				while (i < 3 && !encontrada) {
					int j = 0;
					while (j < 9 && !encontrada) {
						if (abecedario[i][j] == letra) {
							resultado = resultado + i + j + " ";
							encontrada = true;
						}
						j++;
					}
					i++;
				}
			}
		}

		// Eliminar espacio final si existe
		if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) == ' ') {
			resultado = resultado.substring(0, resultado.length() - 1);
		}

		fraseCodificada = resultado;
	}

	// Función para comprobar si un código corresponde a una letra
	static boolean compruebaCodigo(String codigo, char letra) {
		boolean resultado = false;

		if (codigo.length() == 2) {
			int fila = -1;
			int columna = -1;
			boolean esNumerico = true;

			// Verificar si los caracteres son numéricos
			if (Character.isDigit(codigo.charAt(0)) && Character.isDigit(codigo.charAt(1))) {
				fila = Character.getNumericValue(codigo.charAt(0));
				columna = Character.getNumericValue(codigo.charAt(1));
			} else {
				esNumerico = false;
			}

			// Verificar que las coordenadas sean válidas
			if (esNumerico && fila >= 0 && fila < 3 && columna >= 0 && columna < 9) {
				// Comprobar si el código corresponde a la letra
				if (abecedario[fila][columna] == letra) {
					// Sustituir todas las ocurrencias del código por la letra
					String[] partes = fraseCodificada.split(" ");
					String nuevaCodificacion = "";

					for (int i = 0; i < partes.length; i++) {
						if (i > 0) {
							nuevaCodificacion = nuevaCodificacion + " ";
						}

						if (partes[i].equals(codigo)) {
							nuevaCodificacion = nuevaCodificacion + letra;
						} else {
							nuevaCodificacion = nuevaCodificacion + partes[i];
						}
					}

					fraseCodificada = nuevaCodificacion;
					resultado = true;
				}
			}
		}

		return resultado;
	}

	// Función para comprobar si las frases son iguales
	static boolean sonIguales() {
		boolean iguales = true;
		String fraseSinEspacios = "";
		String codificadaSinEspacios = "";

		// Quitar espacios de fraseReal
		for (int i = 0; i < fraseReal.length(); i++) {
			if (fraseReal.charAt(i) != ' ') {
				fraseSinEspacios = fraseSinEspacios + fraseReal.charAt(i);
			}
		}

		// Quitar espacios de fraseCodificada
		for (int i = 0; i < fraseCodificada.length(); i++) {
			if (fraseCodificada.charAt(i) != ' ') {
				codificadaSinEspacios = codificadaSinEspacios + fraseCodificada.charAt(i);
			}
		}

		// Comparar caracter por caracter
		if (fraseSinEspacios.length() != codificadaSinEspacios.length()) {
			iguales = false;
		} else {
			int i = 0;
			while (i < fraseSinEspacios.length() && iguales) {
				if (fraseSinEspacios.charAt(i) != codificadaSinEspacios.charAt(i)) {
					iguales = false;
				}
				i++;
			}
		}

		return iguales;
	}
}