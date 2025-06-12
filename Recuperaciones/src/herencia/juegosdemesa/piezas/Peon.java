package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public class Peon extends PiezaAjedrez {

	public Peon(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Peon");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		// Movimiento básico del peón (no implementado completamente)
		return false;
	}
}