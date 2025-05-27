package arrays.boletin1;

import java.util.Scanner;

public class Ejercicio6 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int numeros[] = new int[8];

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número: ");
			numeros[i] = teclado.nextInt();
		}
		for (int valor : numeros) {
			System.out.print(valor + " ");
			if (valor % 2 == 0) {
				System.out.println("Par");
			} else {
				System.out.println("Impar");
			}
		}
	}

}
