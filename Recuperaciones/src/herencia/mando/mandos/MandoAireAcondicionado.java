package herencia.mando.mandos;

import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;
import herencia.mando.interfaces.Velocidad;

public class MandoAireAcondicionado extends Mando implements Velocidad {

	enum Modo {
		FRIO, CALOR
	}

	private Modo modo = Modo.FRIO;
	private int temperatura;
	private int velocidad = 0;

	public MandoAireAcondicionado(String modelo, double altura, double anchura) throws ModeloException {
		super(modelo, altura, anchura);
	}

	public MandoAireAcondicionado(String modelo, double altura, double anchura, double precio)
			throws ModeloException, PrecioException {
		super(modelo, altura, anchura, precio);
	}

	public Modo getModo() {
		return modo;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void cambiarModo() {
		if (modo == Modo.FRIO) {
			modo = Modo.CALOR;
		} else {
			modo = Modo.FRIO;
		}
	}

	public void subirTemperatura() {
		temperatura++;
	}

	public void bajarTemperatura() {
		temperatura--;
	}

	@Override
	public boolean subirVelocidad() {
		boolean resultado = false;
		if (velocidad < 5) {
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
		return "MandoAireAcondicionado [modelo=" + getModelo() + ", altura=" + getAltura() + ", anchura=" + getAnchura()
				+ ", precio=" + getPrecio() + ", encendido=" + isEncendido() + ", modo=" + modo + ", temperatura="
				+ temperatura + ", velocidad=" + velocidad + "]";
	}
}