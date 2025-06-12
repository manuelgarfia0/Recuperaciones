package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public class Alfil extends PiezaAjedrez {

	public Alfil(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Alfil");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		// Movimiento básico del alfil (no implementado completamente)
		return false;
	}
}