package arrays.boletin1;

import java.util.Scanner;

public class Ejercicio8 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[100];
		int numPosicion;
		int contador = 0;

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 11);
		}

		for (int valor : numeros) {
			System.out.print(valor + " ");
		}

		System.out.println("");

		System.out.println("Introduce un número del 1 al 10 para saber en cuantas posiciones del array está: ");
		numPosicion = teclado.nextInt();

		for (int valor : numeros) {
			if (valor == numPosicion) {
				contador++;
			}
		}
		System.out.println(numPosicion + " aparece " + contador + " veces");

	}

}
