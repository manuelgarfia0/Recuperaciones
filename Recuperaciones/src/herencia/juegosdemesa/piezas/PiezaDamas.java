package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;
import herencia.juegosdemesa.interfaz.Movil;

public class PiezaDamas extends Pieza implements Movil {

	public PiezaDamas(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color);
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		boolean resultado = false;
		int nuevaX = convertirLetraANumero(posicionX);

		if (nuevaX >= 1 && nuevaX <= 8 && posicionY >= 1 && posicionY <= 8) {
			int diferenciaX = Math.abs(nuevaX - this.posicionX);
			int diferenciaY = Math.abs(posicionY - this.posicionY);

			if (diferenciaX == diferenciaY && diferenciaX > 0) {
				this.posicionX = nuevaX;
				this.posicionY = posicionY;
				resultado = true;
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "D: " + color + " (" + posicionY + ", " + convertirNumeroALetra(posicionX) + ")";
	}
}