package string.wordle;

import java.util.Scanner;

public class WordleMain {
	public static void main(String[] args) {
		Wordle juego = new Wordle();
		Scanner scanner = new Scanner(System.in);

		juego.mostrarReglas();

		String ultimoIntento = "";

		while (!juego.juegoTerminado(ultimoIntento)) {
			juego.mostrarEstado();
			System.out.print("Ingresa tu palabra: ");

			String entrada = scanner.nextLine();
			String palabraProcesada = juego.procesarPalabra(entrada);

			if (palabraProcesada.isEmpty() || !juego.esEntradaValida(entrada)) {
				System.out.println("Por favor, ingresa una palabra válida de 5 letras.");
				continue;
			}

			juego.registrarIntento();
			ultimoIntento = palabraProcesada;

			String resultado = juego.generarResultado(ultimoIntento);
			System.out.println("Resultado: " + resultado);
			System.out.println();
		}

		boolean gano = juego.esIntentoGanador(ultimoIntento);
		juego.mostrarResultadoFinal(gano);

		scanner.close();
	}
}