package herencia.juegosdemesa.main;

import java.util.Arrays;

import herencia.juegosdemesa.enums.Color;
import herencia.juegosdemesa.enums.Direccion;
import herencia.juegosdemesa.piezas.Caballo;
import herencia.juegosdemesa.piezas.Pieza;
import herencia.juegosdemesa.piezas.PiezaAjedrez;
import herencia.juegosdemesa.piezas.PiezaDamas;
import herencia.juegosdemesa.piezas.PiezaGo;
import herencia.juegosdemesa.piezas.PiezaHundirFlota;
import herencia.juegosdemesa.piezas.Rey;
import herencia.juegosdemesa.piezas.Torre;

public class Main {

	public static void main(String[] args) {

		Pieza[] piezas = new Pieza[10];

		// Rellenamos la tabla a mano con diferentes tipos de piezas
		piezas[0] = new PiezaDamas('d', 2, Color.BLANCO);
		piezas[1] = new Caballo('h', 6, Color.NEGRO);
		piezas[2] = new PiezaGo('e', 7, Color.BLANCO);
		piezas[3] = new PiezaHundirFlota('f', 3, Color.GRIS, 4, Direccion.ARRIBA);
		piezas[4] = new Torre('a', 1, Color.BLANCO);
		piezas[5] = new PiezaDamas('c', 5, Color.NEGRO);
		piezas[6] = new PiezaGo('b', 8, Color.GRIS);
		piezas[7] = new PiezaHundirFlota('g', 4, Color.NEGRO, 3, Direccion.DERECHA);
		piezas[8] = new Rey('e', 1, Color.BLANCO);
		piezas[9] = new PiezaDamas('f', 6, Color.BLANCO);

		// Ordenamos la tabla por posición Y y luego por posición X
		Arrays.sort(piezas);

		// Imprimimos la tabla ordenada
		System.out.println("TABLA DE PIEZAS ORDENADA");
		for (int i = 0; i < piezas.length; i++) {
			System.out.println((i + 1) + ". " + piezas[i]);
		}

		System.out.println("REALIZANDO ACCIONES CON CADA PIEZA");

		// Recorremos la tabla realizando las acciones especificadas
		for (int i = 0; i < piezas.length; i++) {
			System.out.println("\nProcesando pieza " + (i + 1) + " ---");

			if (piezas[i] instanceof PiezaDamas) {
				PiezaDamas piezaDamas = (PiezaDamas) piezas[i];

				// 1. Mostrar su información
				System.out.println("Información inicial: " + piezaDamas);

				// 2. Cambiar su posición a una correcta (movimiento diagonal)
				boolean movimientoCorrect = piezaDamas.moverA('f', 4);
				System.out.println("Movimiento correcto realizado: " + movimientoCorrect);

				// 3. Mostrar su información
				System.out.println("Información después del movimiento correcto: " + piezaDamas);

				// 4. Cambiar su posición a una incorrecta (no diagonal)
				boolean movimientoIncorrecto = piezaDamas.moverA('a', 4);
				System.out.println("Movimiento incorrecto realizado: " + movimientoIncorrecto);

				// 5. Mostrar su información
				System.out.println("Información después del movimiento incorrecto: " + piezaDamas);

			} else if (piezas[i] instanceof PiezaAjedrez) {
				PiezaAjedrez piezaAjedrez = (PiezaAjedrez) piezas[i];

				// 1. Mostrar su información
				System.out.println("Información: " + piezaAjedrez);

				// 2. Si es una torre
				if (piezaAjedrez instanceof Torre) {
					Torre torre = (Torre) piezaAjedrez;

					// Cambiar su posición a una correcta (horizontal o vertical)
					boolean movimientoCorrect = torre.moverA('a', 5);
					System.out.println("Movimiento correcto de torre realizado: " + movimientoCorrect);

					// Mostrar su información
					System.out.println("Información después del movimiento correcto: " + torre);

					// Cambiar su posición a una incorrecta (diagonal)
					boolean movimientoIncorrecto = torre.moverA('c', 7);
					System.out.println("Movimiento incorrecto de torre realizado: " + movimientoIncorrecto);

					// Mostrar su información
					System.out.println("Información después del movimiento incorrecto: " + torre);
				}

			} else if (piezas[i] instanceof PiezaHundirFlota) {
				PiezaHundirFlota piezaHF = (PiezaHundirFlota) piezas[i];

				// 1. Mostrar su información
				System.out.println("Información: " + piezaHF);

			} else if (piezas[i] instanceof PiezaGo) {
				PiezaGo piezaGo = (PiezaGo) piezas[i];

				// 1. Mostrar su información
				System.out.println("Información: " + piezaGo);
			}
		}
	}
}