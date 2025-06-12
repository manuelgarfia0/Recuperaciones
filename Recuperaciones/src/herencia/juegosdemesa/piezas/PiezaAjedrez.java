package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public abstract class PiezaAjedrez extends Pieza {

	protected String nombre;

	public PiezaAjedrez(char posicionX, int posicionY, Color color, String nombre) {
		super(posicionX, posicionY, color);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "A: " + nombre + " " + color + " (" + posicionY + ", " + convertirNumeroALetra(posicionX) + ")";
	}
}