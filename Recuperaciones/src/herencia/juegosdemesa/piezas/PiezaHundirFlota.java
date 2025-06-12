package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enums.Color;
import herencia.juegosdemesa.enums.Direccion;

public class PiezaHundirFlota extends Pieza {

	private int tamano;
	private Direccion direccion;

	public PiezaHundirFlota(char posicionX, int posicionY, Color color, int tamano, Direccion direccion) {
		super(posicionX, posicionY, color);
		this.tamano = tamano;
		this.direccion = direccion;
	}

	public int getTamano() {
		return tamano;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "HF: " + tamano + " " + direccion + " " + color + " (" + posicionY + ", "
				+ convertirNumeroALetra(posicionX) + ")";
	}
}