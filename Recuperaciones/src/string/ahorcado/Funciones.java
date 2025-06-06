package string.ahorcado;

import java.util.Random;

public class Funciones {

	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };

	static final int NUMINTENTOS = 7;

	static String palabraSecreta = "";

	static String palabraPista = "";

	static String noAcertadas = "";

	static void generaPalabra() {
		Random rand = new Random();

		int pos = rand.nextInt(0, palabras.length);

		palabraSecreta = palabras[pos];

		palabraPista = "_".repeat(palabraSecreta.length());
	}

	static boolean compruebaLetra(char letra) {
		boolean res = false;
		char nuevaLetra = Character.toLowerCase(letra);

		// Verificar si la letra ya fue probada
		if (palabraPista.indexOf(nuevaLetra) >= 0 || noAcertadas.indexOf(nuevaLetra) >= 0) {
			return true; // No cuenta como intento si ya fue probada
		}

		char[] arrayPista = palabraPista.toCharArray();

		int pos = palabraSecreta.indexOf(nuevaLetra);

		if (pos < 0) {
			noAcertadas += nuevaLetra + " ";
		} else {
			res = true;
			while (pos >= 0) {
				arrayPista[pos] = nuevaLetra;
				pos = palabraSecreta.indexOf(nuevaLetra, pos + 1);
			}
		}

		palabraPista = String.valueOf(arrayPista);
		return res;
	}

	static void compruebaPalabra(String palabra) {
		String nuevaPalabra = palabra.toLowerCase();

		if (nuevaPalabra.equals(palabraSecreta)) {
			palabraPista = palabraSecreta;
		}
	}
}