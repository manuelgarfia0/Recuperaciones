package arrays.boletin1;

import java.util.Scanner;

public class Ejercicio5 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		double numeros[] = new double[10];
		double sumaNumeros = 0;
		double max = Double.MIN_VALUE;
		double min = Double.MAX_VALUE;

		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número: ");
			numeros[i] = teclado.nextDouble();
			sumaNumeros += numeros[i];

			if (numeros[i] > max) {
				max = numeros[i];
			}
			if (numeros[i] < min) {
				min = numeros[i];
			}
		}

		System.out.println("La suma de los números es: " + sumaNumeros);
		System.out.println("El número mayor es: " + max);
		System.out.println("El número menor es: " + min);

	}

}
