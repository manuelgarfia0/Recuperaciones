package arrays.boletin1;

import java.util.Scanner;

public class Ejercicio3 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[10];

		for (int i = 9; i >= 0; i--) {
			System.out.println("Introduce un número: ");
			numeros[i] = teclado.nextInt();
		}

		for (int valor : numeros) {
			System.out.print(valor + " ");
		}

	}
}
