package herencia.mando.mandos;

import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;

public class Mando implements Comparable<Mando> {

	private String modelo;
	private double altura;
	private double anchura;
	private double precio;
	private boolean encendido = false;

	public Mando(String modelo, double altura, double anchura) throws ModeloException {
		if (modelo != null && !modelo.isBlank()) {
			this.modelo = modelo;
		} else {
			throw new ModeloException();
		}
		if (altura > 0) {
			this.altura = altura;
		}

		if (anchura > 0) {
			this.anchura = anchura;
		}
	}

	public Mando(String modelo, double altura, double anchura, double precio) throws ModeloException, PrecioException {
		this(modelo, altura, anchura);
		if (precio >= 0) {
			this.precio = precio;
		} else {
			throw new PrecioException();
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEncendido() {
		return encendido;
	}

	public String getModelo() {
		return modelo;
	}

	public double getAltura() {
		return altura;
	}

	public double getAnchura() {
		return anchura;
	}

	public void onOff() {
		encendido = !encendido;
	}

	@Override
	public int compareTo(Mando o) {
		return modelo.compareToIgnoreCase(o.modelo);
	}

	/**
	 * @return Devuelve una cadena con la información del mando
	 */
	@Override
	public String toString() {
		String res = "Modelo: " + modelo + "\n";
		res += "Altura: " + altura + "\n";
		res += "Anchura: " + anchura + "\n";
		res += "Precio: " + precio + "\n";
		res += encendido ? "Encendido" : "Apagado" + "\n";

		return res;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;

		if (obj instanceof Mando nuevoMando) {
			if (modelo.equals(nuevoMando.modelo)) {
				res = true;
			}
		}

		return res;
	}

}
