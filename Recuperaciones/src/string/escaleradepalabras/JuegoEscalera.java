package string.escaleradepalabras;

import java.util.Random;

/**
 * Clase que contiene la lógica y funciones del juego Escalera de Palabras
 */
class JuegoEscalera {

	// Variables globales estáticas
	static String[][] juegos = { { "CASA", "PATO" }, { "PISO", "TUBO" }, { "CENA", "MURO" }, { "BONO", "DEDO" },
			{ "ROJO", "PASA" } };

	static String palabraInicio;
	static String palabraObjetivo;
	static String jugada;

	/**
	 * Selecciona aleatoriamente uno de los posibles juegos definidos. Almacena en
	 * palabraInicio y palabraObjetivo los valores correspondientes. Inicializa
	 * jugada con la palabra de inicio.
	 */
	public static void seleccionaJuego() {
		Random random = new Random();
		int filaSeleccionada = random.nextInt(juegos.length);

		palabraInicio = juegos[filaSeleccionada][0];
		palabraObjetivo = juegos[filaSeleccionada][1];
		jugada = palabraInicio;
	}

	/**
	 * Devuelve el último intento hecho por el usuario a partir de lo almacenado en
	 * jugada.
	 * 
	 * @return String con la última palabra de la jugada
	 */
	public static String ultimoIntento() {
		String[] intentos = jugada.split(" - ");
		return intentos[intentos.length - 1];
	}

	/**
	 * Comprueba si el nuevo intento es correcto (solo varía una letra respecto al
	 * último intento).
	 * 
	 * @param intento Nueva palabra introducida por el jugador
	 * @return true si el intento es correcto, false en caso contrario
	 */
	public static boolean compruebaIntento(String intento) {
		String ultimaPalabra = ultimoIntento();

		// Verificar que ambas palabras tengan la misma longitud
		if (intento.length() != ultimaPalabra.length()) {
			return false;
		}

		int diferencias = 0;

		// Contar las diferencias entre las dos palabras
		for (int i = 0; i < intento.length(); i++) {
			if (intento.charAt(i) != ultimaPalabra.charAt(i)) {
				diferencias++;
			}
		}

		// Solo debe haber exactamente una diferencia
		return diferencias == 1;
	}

	// Métodos getter para acceder a las variables desde la clase principal
	public static String getPalabraInicio() {
		return palabraInicio;
	}

	public static String getPalabraObjetivo() {
		return palabraObjetivo;
	}

	public static String getJugada() {
		return jugada;
	}

	public static void agregarIntento(String intento) {
		jugada += " - " + intento;
	}
}