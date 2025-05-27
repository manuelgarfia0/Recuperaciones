package arrays.boletin1;

public class Ejercicio1 {

	public static void main(String[] args) {

		int numAleatorios[] = new int[9];

		for (int numeros : numAleatorios) {
			numeros = (int) (Math.random() * 101);
			System.out.print(numeros + " ");
		}

	}

}
