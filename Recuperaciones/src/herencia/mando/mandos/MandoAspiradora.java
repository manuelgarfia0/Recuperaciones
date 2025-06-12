package herencia.mando.mandos;

import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;
import herencia.mando.interfaces.Velocidad;

public class MandoAspiradora extends Mando implements Velocidad {

	private int velocidad = 0;

	public MandoAspiradora(String modelo, double altura, double anchura) throws ModeloException {
		super(modelo, altura, anchura);
	}

	public MandoAspiradora(String modelo, double altura, double anchura, double precio)
			throws ModeloException, PrecioException {
		super(modelo, altura, anchura, precio);
	}

	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public boolean subirVelocidad() {
		boolean resultado = false;
		if (velocidad < 3) {
			velocidad++;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean bajarVelocidad() {
		boolean resultado = false;
		if (velocidad > 0) {
			velocidad--;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "MandoAspiradora [modelo=" + getModelo() + ", altura=" + getAltura() + ", anchura=" + getAnchura()
				+ ", precio=" + getPrecio() + ", encendido=" + isEncendido() + ", velocidad=" + velocidad + "]";
	}
}