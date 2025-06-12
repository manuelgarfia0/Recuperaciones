package herencia.juegosdemesa.piezas;

import herencia.juegosdemesa.enumerador.Color;

public class Torre extends PiezaAjedrez {

	public Torre(char posicionX, int posicionY, Color color) {
		super(posicionX, posicionY, color, "Torre");
	}

	@Override
	public boolean moverA(char posicionX, int posicionY) {
		boolean resultado = false;
		int nuevaX = convertirLetraANumero(posicionX);

		if (nuevaX >= 1 && nuevaX <= 8 && posicionY >= 1 && posicionY <= 8) {
			// La torre se mueve en horizontal o vertical
			if ((nuevaX == this.posicionX && posicionY != this.posicionY)
					|| (posicionY == this.posicionY && nuevaX != this.posicionX)) {
				this.posicionX = nuevaX;
				this.posicionY = posicionY;
				resultado = true;
			}
		}
		return resultado;
	}
}