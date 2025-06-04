package string.ahorcado;

public class Main {

	public static void main(String[] args) {
		Funciones.generaPalabra();

		System.out.println("Palabra secreta: " + Funciones.palabraSecreta);

		Funciones.compruebaLetra('a');

		System.out.println(Funciones.palabraPista);
		System.out.println(Funciones.noAcertadas);

		Funciones.compruebaLetra('e');

		System.out.println(Funciones.palabraPista);
		System.out.println(Funciones.noAcertadas);
	}

}