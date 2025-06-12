package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enums.Color;
import herencia.juegosdemesa.interfaz.Movil;

public abstract class PiezaAjedrez extends Pieza implements Movil {

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