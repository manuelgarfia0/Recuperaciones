package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public class Dama extends PiezaAjedrez {

	public Dama(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Dama");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		// Movimiento básico de la dama (no implementado completamente)
		return false;
	}
}