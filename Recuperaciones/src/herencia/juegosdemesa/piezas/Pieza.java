package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enums.Color;

public abstract class Pieza implements Comparable<Pieza> {

	protected int posicionX;
	protected int posicionY;
	protected Color color;

	public Pieza(char posicionX, int posicionY, Color color) {
		this.posicionX = convertirLetraANumero(posicionX);
		this.posicionY = posicionY;
		this.color = color;
	}

	protected int convertirLetraANumero(char letra) {
		int resultado = 0;
		if (letra >= 'a' && letra <= 'h') {
			resultado = letra - 'a' + 1;
		} else if (letra >= 'A' && letra <= 'H') {
			resultado = letra - 'A' + 1;
		}
		return resultado;
	}

	protected char convertirNumeroALetra(int numero) {
		char resultado = 'a';
		if (numero >= 1 && numero <= 8) {
			resultado = (char) ('a' + numero - 1);
		}
		return resultado;
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

	@Override
	public int compareTo(Pieza otra) {
		int resultado = Integer.compare(this.posicionY, otra.posicionY);
		if (resultado == 0) {
			resultado = Integer.compare(this.posicionX, otra.posicionX);
		}
		return resultado;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;
//		if (this == obj) {
//			resultado = true;
//		} else if (obj != null && this.getClass() == obj.getClass()) {
//			Pieza otra = (Pieza) obj;
//			if (this.posicionX == otra.posicionX && this.posicionY == otra.posicionY) {
//				resultado = true;
//			}
//		}
		if (obj instanceof Pieza nuevaPieza) {
			if (posicionX == nuevaPieza.posicionX && posicionY == nuevaPieza.posicionY) {
				resultado = true;
			}
		}
		return resultado;
	}

	public abstract String toString();
}