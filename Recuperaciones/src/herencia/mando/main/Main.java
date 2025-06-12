package herencia.mando.main;

import java.util.Arrays;
import herencia.mando.excepciones.ModeloException;
import herencia.mando.excepciones.PrecioException;
import herencia.mando.mandos.*;

public class Main {

	public static void main(String[] args) {

		Mando[] mandos = new Mando[10];

		try {
			// Rellenamos la tabla a mano con diferentes tipos de mandos
			mandos[0] = new MandoTV("Samsung Smart", 15.5, 5.2, 45.90);
			mandos[1] = new MandoMinicadena("Sony Music", 12.0, 4.5, 25.50);
			mandos[2] = new MandoAspiradora("Dyson V11", 18.0, 6.0);
			mandos[3] = new MandoAireAcondicionado("LG Dual", 20.0, 7.5, 89.99);
			mandos[4] = new MandoTV("LG OLED", 14.8, 5.0, 52.30);
			mandos[5] = new MandoMinicadena("Panasonic Audio", 13.2, 4.8);
			mandos[6] = new MandoAspiradora("Roomba i7", 16.5, 5.8, 75.00);
			mandos[7] = new MandoAireAcondicionado("Mitsubishi Electric", 19.5, 7.0);
			mandos[8] = new MandoTV("Philips 4K", 15.0, 5.5, 48.75);
			mandos[9] = new MandoMinicadena("Bose SoundTouch", 11.8, 4.2, 95.50);

			// Ordenamos la tabla por orden alfabético del modelo
			Arrays.sort(mandos);

			// Imprimimos la tabla ordenada
			System.out.println("TABLA DE MANDOS ORDENADA");
			for (int i = 0; i < mandos.length; i++) {
				System.out.println((i + 1) + ". " + mandos[i]);
			}

			System.out.println("\nREALIZANDO ACCIONES CON CADA MANDO");

			// Recorremos la tabla realizando las acciones especificadas
			for (int i = 0; i < mandos.length; i++) {
				System.out.println("\nProcesando mando " + (i + 1) + ": " + mandos[i].getModelo() + " ---");

				// 1. Encender
				mandos[i].onOff();
				System.out.println("Mando encendido: " + mandos[i].isEncendido());

				// 2. Acciones específicas según el tipo de mando
				if (mandos[i] instanceof MandoTV) {
					MandoTV mandoTV = (MandoTV) mandos[i];
					// Cambiar el canal
					mandoTV.subirCanal();
					System.out.println("Canal actual: " + mandoTV.getCanal());
					// Subir el volumen
					boolean subioVolumen = mandoTV.subirVolumen();
					System.out.println("Subir volumen: " + subioVolumen + " - Volumen actual: " + mandoTV.getVolumen());
					// Bajar el volumen
					boolean bajoVolumen = mandoTV.bajarVolumen();
					System.out.println("Bajar volumen: " + bajoVolumen + " - Volumen actual: " + mandoTV.getVolumen());

				} else if (mandos[i] instanceof MandoMinicadena) {
					MandoMinicadena mandoMinicadena = (MandoMinicadena) mandos[i];
					// Subir el volumen
					boolean subioVolumen = mandoMinicadena.subirVolumen();
					System.out.println(
							"Subir volumen: " + subioVolumen + " - Volumen actual: " + mandoMinicadena.getVolumen());
					// Bajar el volumen
					boolean bajoVolumen = mandoMinicadena.bajarVolumen();
					System.out.println(
							"Bajar volumen: " + bajoVolumen + " - Volumen actual: " + mandoMinicadena.getVolumen());

				} else if (mandos[i] instanceof MandoAspiradora) {
					MandoAspiradora mandoAspiradora = (MandoAspiradora) mandos[i];
					// Subir velocidad
					boolean subioVelocidad = mandoAspiradora.subirVelocidad();
					System.out.println("Subir velocidad: " + subioVelocidad + " - Velocidad actual: "
							+ mandoAspiradora.getVelocidad());
					// Bajar velocidad
					boolean bajoVelocidad = mandoAspiradora.bajarVelocidad();
					System.out.println("Bajar velocidad: " + bajoVelocidad + " - Velocidad actual: "
							+ mandoAspiradora.getVelocidad());

				} else if (mandos[i] instanceof MandoAireAcondicionado) {
					MandoAireAcondicionado mandoAire = (MandoAireAcondicionado) mandos[i];
					// Cambiar el modo
					System.out.println("Modo inicial: " + mandoAire.getModo());
					mandoAire.cambiarModo();
					System.out.println("Modo después del cambio: " + mandoAire.getModo());
					// Cambiar la temperatura
					System.out.println("Temperatura inicial: " + mandoAire.getTemperatura());
					mandoAire.subirTemperatura();
					System.out.println("Temperatura después de subir: " + mandoAire.getTemperatura());
					mandoAire.bajarTemperatura();
					System.out.println("Temperatura después de bajar: " + mandoAire.getTemperatura());
					// Subir velocidad
					boolean subioVelocidad = mandoAire.subirVelocidad();
					System.out.println(
							"Subir velocidad: " + subioVelocidad + " - Velocidad actual: " + mandoAire.getVelocidad());
					// Bajar velocidad
					boolean bajoVelocidad = mandoAire.bajarVelocidad();
					System.out.println(
							"Bajar velocidad: " + bajoVelocidad + " - Velocidad actual: " + mandoAire.getVelocidad());
				}

				System.out.println("Estado final: " + mandos[i]);
			}

		} catch (ModeloException e) {
			System.err.println("Error en el modelo: " + e.getMessage());
		} catch (PrecioException e) {
			System.err.println("Error en el precio: " + e.getMessage());
		}
	}
}