package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public abstract class Pieza implements Comparable<Pieza> {

	protected int posicionX;
	protected int posicionY;
	protected Color color;

	public Pieza(char posicionX, int posicionY, Color color) {
		this.posicionX = convertirLetraANumero(posicionX);
		this.posicionY = posicionY;
		this.color = color;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public Color getColor() {
		return color;
	}

	public int convertirLetraANumero(char letra) {
		int resultado = 0;
		if (letra >= 'a' && letra <= 'h') {
			resultado = letra - 'a' + 1;
		} else if (letra >= 'A' && letra <= 'H') {
			resultado = letra - 'A' + 1;
		}
		return resultado;
	}

	public char convertirNumeroALetra(int numero) {
		char resultado = 'a';
		if (numero >= 1 && numero <= 8) {
			resultado = (char) ('a' + numero - 1);
		}
		return resultado;
	}

	@Override
	public int compareTo(Pieza o) {
		int resultado = Integer.compare(this.posicionY, o.posicionY);
		if (resultado == 0) {
			resultado = Integer.compare(this.posicionX, o.posicionX);
		}
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Pieza nuevaPieza) {
			if (getClass().equals(nuevaPieza.getClass()) && posicionX == nuevaPieza.posicionX
					&& posicionY == nuevaPieza.posicionY) {
				resultado = true;
			}
		}
		return resultado;
	}

	public abstract String toString();
}