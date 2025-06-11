package string.mastermind;

import java.util.Random;

public class Mastermind {
	/**
	 * Cadena cuyos caracteres son los distintos colores
	 */
	private String colores = "RVABNL";
	/**
	 * Código que debe adivinar el jugador. Tiene longitud 5
	 */
	private String codigo;
	/**
	 * Constante que indica el número de intentos que tiene el jugador
	 */
	private final int numeroDeIntentos = 20;
	/**
	 * Cadena en la que se van a ir almacenando los intentos previos del jugador
	 */
	private String intentosPrevios = "";

	/**
	 * Constructor: Genera una combinación de colores al azar y lo almacena en
	 * código
	 */
	public Mastermind() {
		Random random = new Random();
		String codigoGenerado = "";
		int i = 0;
		int indiceAleatorio = 0;

		while (i < 5) {
			indiceAleatorio = random.nextInt(colores.length());
			codigoGenerado += colores.charAt(indiceAleatorio);
			i++;
		}

		this.codigo = codigoGenerado;
	}

	/**
	 * Getter para colores
	 *
	 * @return colores
	 */
	public String getColores() {
		return colores;
	}

	/**
	 * Getter para código
	 *
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Getter para número de intentos
	 *
	 * @return numeroDeIntentos
	 */
	public int getNumeroDeIntentos() {
		return numeroDeIntentos;
	}

	/**
	 * Getter para intentos previos
	 *
	 * @return intentosPrevios
	 */
	public String getIntentosPrevios() {
		return intentosPrevios;
	}

	/**
	 * Comprueba cuántos colores están en la misma posición que en el código y
	 * cuántos colores están en el código pero en posiciones erróneas. Añade esta
	 * nueva combinación en intentosPrevios.
	 *
	 * @param intento combinación de colores a comprobar
	 * @return pista con formato "B# R#"
	 */
	public String compruebaCodigo(String intento) {
		int posicionesCorrectas = 0; // B
		int coloresEnPosicionErronea = 0; // R
		String codigoCopia = codigo;
		String intentoCopia = intento;
		int i = 0;
		int j = 0;
		char colorIntento = ' ';
		String pista = "";

		// Contar posiciones correctas (B)
		i = 0;
		while (i < 5) {
			if (codigo.charAt(i) == intento.charAt(i)) {
				posicionesCorrectas++;
				// Marcar como procesados con *
				codigoCopia = codigoCopia.substring(0, i) + "*" + codigoCopia.substring(i + 1);
				intentoCopia = intentoCopia.substring(0, i) + "*" + intentoCopia.substring(i + 1);
			}
			i++;
		}

		// Contar colores en posiciones erróneas (R)
		i = 0;
		while (i < 5) {
			if (intentoCopia.charAt(i) != '*') {
				colorIntento = intentoCopia.charAt(i);
				j = 0;
				while (j < 5) {
					if (codigoCopia.charAt(j) == colorIntento) {
						coloresEnPosicionErronea++;
						codigoCopia = codigoCopia.substring(0, j) + "*" + codigoCopia.substring(j + 1);
						j = 5; // Para salir del bucle
					}
					if (j < 5) {
						j++;
					}
				}
			}
			i++;
		}

		// Crear pista
		pista = "B" + posicionesCorrectas + " R" + coloresEnPosicionErronea;

		// Añadir esta nueva combinación en intentosPrevios
		if (!intentosPrevios.isEmpty()) {
			intentosPrevios += "\n";
		}
		intentosPrevios += intento + " - " + pista;

		return pista;
	}
}