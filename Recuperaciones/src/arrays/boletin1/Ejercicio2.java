package arrays.boletin1;

import java.util.Scanner;

public class Ejercicio2 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		double numeros[] = new double[5];

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce 5 números: ");
			numeros[i] = teclado.nextDouble();
		}

		for (double valor : numeros) {
			System.out.print(valor + " ");
		}

	}

}
