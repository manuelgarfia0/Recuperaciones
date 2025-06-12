package herencia.mando.mandos;

import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;
import herencia.mando.interfaces.Volumen;

public class MandoTV extends Mando implements Volumen {

	private int volumen = 0;
	private int canal = 1;

	public MandoTV(String modelo, double altura, double anchura) throws ModeloException {
		super(modelo, altura, anchura);
	}

	public MandoTV(String modelo, double altura, double anchura, double precio)
			throws ModeloException, PrecioException {
		super(modelo, altura, anchura, precio);
	}

	public int getVolumen() {
		return volumen;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public void subirCanal() {
		canal++;
	}

	public void bajarCanal() {
		if (canal > 1) {
			canal--;
		}
	}

	@Override
	public boolean subirVolumen() {
		boolean resultado = false;
		if (volumen <= 95) {
			volumen += 5;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public boolean bajarVolumen() {
		boolean resultado = false;
		if (volumen >= 5) {
			volumen -= 5;
			resultado = true;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "MandoTV [modelo=" + getModelo() + ", altura=" + getAltura() + ", anchura=" + getAnchura() + ", precio="
				+ getPrecio() + ", encendido=" + isEncendido() + ", volumen=" + volumen + ", canal=" + canal + "]";
	}
}