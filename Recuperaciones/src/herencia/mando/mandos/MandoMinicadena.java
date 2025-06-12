package herencia.mando.mandos;

import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;
import herencia.mando.interfaces.Volumen;

public class MandoMinicadena extends Mando implements Volumen {

	private int volumen = 0;

	public MandoMinicadena(String modelo, double altura, double anchura) throws ModeloException {
		super(modelo, altura, anchura);
	}

	public MandoMinicadena(String modelo, double altura, double anchura, double precio)
			throws ModeloException, PrecioException {
		super(modelo, altura, anchura, precio);
	}

	public int getVolumen() {
		return volumen;
	}

	@Override
	public boolean subirVolumen() {
		boolean resultado = false;
		if (volumen <= 90) {
			volumen += 10;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean bajarVolumen() {
		boolean resultado = false;
		if (volumen >= 10) {
			volumen -= 10;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "MandoMinicadena [modelo=" + getModelo() + ", altura=" + getAltura() + ", anchura=" + getAnchura()
				+ ", precio=" + getPrecio() + ", encendido=" + isEncendido() + ", volumen=" + volumen + "]";
	}
}