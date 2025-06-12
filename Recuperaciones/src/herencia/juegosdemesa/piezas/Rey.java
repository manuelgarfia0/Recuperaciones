package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enums.Color;

public class Rey extends PiezaAjedrez {

	public Rey(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Rey");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		// Movimiento básico del rey (no implementado completamente)
		return false;
	}
}