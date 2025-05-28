package arrays.busquedatesoro;

import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int filas;
		int columnas;

		System.out.println("BIENVENIDO A LA BUSQUEDA DEL TESORO");
		System.out.println("Elije el tamaño del tablero: ");
		System.out.println("Filas: ");
		filas = scanner.nextInt();
		System.out.println("Columnas: ");
		columnas = scanner.nextInt();

		Metodos.inicializaTablero(filas, columnas);

		Metodos.pintaTablero();

	}

}
