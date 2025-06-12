package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enums.Color;

public class PiezaGo extends Pieza {

	public PiezaGo(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color);
	}

	@Override
	public String toString() {
		return "G: " + color + " (" + posicionY + ", " + convertirNumeroALetra(posicionX) + ")";
	}
}