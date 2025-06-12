package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public class Caballo extends PiezaAjedrez {

	public Caballo(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Caballo");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		// Movimiento básico del caballo (no implementado completamente)
		return false;
	}
}