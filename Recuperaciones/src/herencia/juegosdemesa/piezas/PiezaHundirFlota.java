package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;
import herencia.juegosdemesa.enumerador.Direccion;

public class PiezaHundirFlota extends Pieza {

	private int tamaño;
	private Direccion direccion;

	public PiezaHundirFlota(char posicionX, int posicionY, Color color, int tamaño, Direccion direccion) {
		super(posicionX, posicionY, color);
		this.tamaño = tamaño;
		this.direccion = direccion;
	}

	public int getTamaño() {
		return tamaño;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "HF: " + tamaño + " " + direccion + " " + color + " (" + posicionY + ", "
				+ convertirNumeroALetra(posicionX) + ")";
	}
}