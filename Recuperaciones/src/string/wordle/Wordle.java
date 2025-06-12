package string.wordle;

import java.util.Random;

public class Wordle {
	private String palabraSecreta;
	private int intentosRealizados;
	private final int MAX_INTENTOS = 6;
	private final int LONGITUD_PALABRA = 5;

	// Códigos ANSI para colores
	private final String RESET = "\u001B[0m";
	private final String VERDE = "\u001B[42m\u001B[30m"; // Fondo verde, texto negro
	private final String AMARILLO = "\u001B[43m\u001B[30m"; // Fondo amarillo, texto negro
	private final String GRIS = "\u001B[47m\u001B[30m"; // Fondo gris, texto negro
	private final String BLANCO = "\u001B[40m\u001B[37m"; // Fondo negro, texto blanco
	private String[] palabrasPosibles = { "GATOS", "PERRO", "LIBRO", "CAMPO", "PLAYA", "VERDE", "AZUL", "ROJO", "NEGRO",
			"BLANCO", "CASA", "MESA", "SILLA", "PUERTA", "VENTANA", "AGUA", "FUEGO", "TIERRA", "VIENTO", "CIELO" };

	public Wordle() {
		Random random = new Random();
		this.palabraSecreta = palabrasPosibles[random.nextInt(palabrasPosibles.length)];
		this.intentosRealizados = 0;
	}

	// Convierte una palabra a mayúsculas y valida su longitud
	public String procesarPalabra(String palabra) {
		String palabraProcesada = palabra.toUpperCase().trim();
		return (palabraProcesada.length() == LONGITUD_PALABRA) ? palabraProcesada : "";
	}

	// Verifica si una letra está en la palabra secreta
	public boolean contieneLetra(char letra) {
		return palabraSecreta.indexOf(letra) != -1;
	}

	// Cuenta cuántas veces aparece una letra en una palabra
	public int contarLetra(String palabra, char letra) {
		int contador = 0;
		int i = 0;
		while (i < palabra.length()) {
			contador = (palabra.charAt(i) == letra) ? contador + 1 : contador;
			i++;
		}
		return contador;
	}

	// Obtiene el estado de una letra en una posición específica
	public char obtenerEstadoLetra(String intento, int posicion) {
		char letraIntento = intento.charAt(posicion);
		char letraSecreta = palabraSecreta.charAt(posicion);

		if (letraIntento == letraSecreta) {
			return 'V'; // Verde - posición correcta
		}

		int aparicionesEnSecreta = contarLetra(palabraSecreta, letraIntento);
		int aparicionesAnteriores = contarLetraHastaPosicion(intento, letraIntento, posicion);
		int posicionesCorrectasRestantes = contarPosicionesCorrectasDespues(intento, letraIntento, posicion);

		return (aparicionesAnteriores < aparicionesEnSecreta - posicionesCorrectasRestantes) ? 'A' : 'G'; // A=Amarillo,
																											// G=Gris
	}

	// Cuenta apariciones de una letra hasta cierta posición
	private int contarLetraHastaPosicion(String palabra, char letra, int posicion) {
		int contador = 0;
		int i = 0;
		while (i < posicion) {
			contador = (palabra.charAt(i) == letra) ? contador + 1 : contador;
			i++;
		}
		return contador;
	}

	// Cuenta posiciones correctas de una letra después de cierta posición
	private int contarPosicionesCorrectasDespues(String intento, char letra, int posicion) {
		int contador = 0;
		int i = posicion + 1;
		while (i < intento.length()) {
			contador = (intento.charAt(i) == letra && palabraSecreta.charAt(i) == letra) ? contador + 1 : contador;
			i++;
		}
		return contador;
	}

	// Genera el resultado visual de un intento con colores
	public String generarResultado(String intento) {
		String resultado = "";
		int i = 0;
		while (i < LONGITUD_PALABRA) {
			char estado = obtenerEstadoLetra(intento, i);
			char letra = intento.charAt(i);
			String colorLetra = obtenerColorLetra(estado, letra);
			resultado = resultado + colorLetra;
			i++;
		}
		return resultado;
	}

	// Aplica el color correspondiente a una letra según su estado
	public String obtenerColorLetra(char estado, char letra) {
		String color = (estado == 'V') ? VERDE : ((estado == 'A') ? AMARILLO : GRIS);
		return color + " " + letra + " " + RESET;
	}

	// Verifica si el intento es correcto
	public boolean esIntentoGanador(String intento) {
		return intento.equals(palabraSecreta);
	}

	// Verifica si el juego ha terminado
	public boolean juegoTerminado(String ultimoIntento) {
		return esIntentoGanador(ultimoIntento) || intentosRealizados >= MAX_INTENTOS;
	}

	// Incrementa el contador de intentos
	public void registrarIntento() {
		intentosRealizados = (intentosRealizados < MAX_INTENTOS) ? intentosRealizados + 1 : intentosRealizados;
	}

	// Muestra las reglas del juego
	public void mostrarReglas() {
		System.out.println("=== WORDLE ===");
		System.out.println("Adivina la palabra de " + LONGITUD_PALABRA + " letras en " + MAX_INTENTOS + " intentos.");
		System.out.println(VERDE + " VERDE " + RESET + " = Letra correcta en posición correcta");
		System.out.println(AMARILLO + " AMARILLO " + RESET + " = Letra correcta en posición incorrecta");
		System.out.println(GRIS + " GRIS " + RESET + " = Letra no está en la palabra");
		System.out.println();
	}

	// Muestra el estado actual del juego
	public void mostrarEstado() {
		System.out.println("Intento " + (intentosRealizados + 1) + "/" + MAX_INTENTOS);
	}

	// Muestra el mensaje de resultado final
	public void mostrarResultadoFinal(boolean gano) {
		String mensaje = gano ? "¡Felicidades! Has adivinado la palabra: " + palabraSecreta
				: "Game Over. La palabra era: " + palabraSecreta;
		System.out.println(mensaje);
	}

	// Valida que una palabra solo contenga letras
	public boolean esEntradaValida(String entrada) {
		int i = 0;
		boolean esValida = true;
		while (i < entrada.length() && esValida) {
			esValida = Character.isLetter(entrada.charAt(i));
			i++;
		}
		return esValida && entrada.length() == LONGITUD_PALABRA;
	}

	// Getters
	public int getIntentosRealizados() {
		return intentosRealizados;
	}

	public int getMaxIntentos() {
		return MAX_INTENTOS;
	}

	public String getPalabraSecreta() {
		return palabraSecreta;
	}
}