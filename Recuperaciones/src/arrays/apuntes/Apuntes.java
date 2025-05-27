package arrays.apuntes;

public class Apuntes {

	public static void main(String[] args) {
		System.out.println("=== CLASE COMPLETA DE ARRAYS EN JAVA ===\n");

		// 1. DECLARACIÓN E INICIALIZACIÓN DE ARRAYS
		declaracionInicializacion();

		// 2. RECORRIDO DE ARRAYS CON BUCLES
		recorridoConBucles();

		// 3. BÚSQUEDA EN ARRAYS CON CONDICIONES
		busquedaEnArrays();

		// 4. MODIFICACIÓN DE ARRAYS
		modificacionArrays();

		// 5. ARRAYS MULTIDIMENSIONALES
		arraysMultidimensionales();

		// 6. MÉTODOS ÚTILES PARA ARRAYS
		metodosUtiles();
	}

	// 1. DECLARACIÓN E INICIALIZACIÓN
	public static void declaracionInicializacion() {
		System.out.println("1. DECLARACIÓN E INICIALIZACIÓN DE ARRAYS");
		System.out.println("==========================================");

		// Declaración y creación
		int[] numeros = new int[5]; // Array de 5 elementos inicializados en 0

		// Inicialización directa
		int[] enteros = { 10, 20, 30, 40, 50 };
		String[] nombres = { "Ana", "Carlos", "María", "Pedro" };

		// Otra forma de inicialización
		double[] precios = new double[] { 12.5, 15.0, 8.75, 22.30 };

		System.out.println("Array de enteros: ");
		for (int i = 0; i < enteros.length; i++) {
			System.out.print(enteros[i] + " ");
		}

		System.out.println("\nArray de nombres: ");
		for (String nombre : nombres) {
			System.out.print(nombre + " ");
		}
		System.out.println("\n");
	}

	// 2. RECORRIDO CON BUCLES
	public static void recorridoConBucles() {
		System.out.println("2. RECORRIDO DE ARRAYS CON BUCLES");
		System.out.println("=================================");

		int[] numeros = { 5, 12, 8, 23, 1, 17, 9 };

		// Bucle for tradicional
		System.out.println("Recorrido con bucle for tradicional:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i] + " ");
		}

		// Bucle for-each (mejorado)
		System.out.println("\n\nRecorrido con for-each:");
		for (int numero : numeros) {
			System.out.print(numero + " ");
		}

		// Bucle while
		System.out.println("\n\nRecorrido con while:");
		int i = 0;
		while (i < numeros.length) {
			System.out.print(numeros[i] + " ");
			i++;
		}

		// Recorrido inverso
		System.out.println("\n\nRecorrido inverso:");
		for (int j = numeros.length - 1; j >= 0; j--) {
			System.out.print(numeros[j] + " ");
		}
		System.out.println("\n");
	}

	// 3. BÚSQUEDA CON CONDICIONES
	public static void busquedaEnArrays() {
		System.out.println("3. BÚSQUEDA EN ARRAYS CON CONDICIONES");
		System.out.println("====================================");

		int[] calificaciones = { 85, 92, 78, 96, 88, 73, 90 };

		// Buscar elemento específico
		int buscado = 88;
		boolean encontrado = false;
		int posicion = -1;

		for (int i = 0; i < calificaciones.length && !encontrado; i++) {
			if (calificaciones[i] == buscado) {
				encontrado = true;
				posicion = i;
			}
		}

		if (encontrado) {
			System.out.println("Calificación " + buscado + " encontrada en posición: " + posicion);
		} else {
			System.out.println("Calificación " + buscado + " no encontrada");
		}

		// Contar elementos que cumplen condición
		int aprobados = 0;
		for (int calificacion : calificaciones) {
			if (calificacion >= 80) {
				aprobados++;
			}
		}
		System.out.println("Estudiantes aprobados (≥80): " + aprobados);

		// Encontrar máximo y mínimo
		int max = calificaciones[0];
		int min = calificaciones[0];

		for (int calificacion : calificaciones) {
			if (calificacion > max) {
				max = calificacion;
			}
			if (calificacion < min) {
				min = calificacion;
			}
		}

		System.out.println("Calificación máxima: " + max);
		System.out.println("Calificación mínima: " + min);

		// Calcular promedio
		double suma = 0;
		for (int calificacion : calificaciones) {
			suma += calificacion;
		}
		double promedio = suma / calificaciones.length;
		System.out.println("Promedio: " + String.format("%.2f", promedio));
		System.out.println();
	}

	// 4. MODIFICACIÓN DE ARRAYS
	public static void modificacionArrays() {
		System.out.println("4. MODIFICACIÓN DE ARRAYS");
		System.out.println("=========================");

		int[] numeros = { 1, 2, 3, 4, 5 };

		System.out.println("Array original:");
		imprimirArray(numeros);

		// Duplicar todos los valores
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] *= 2;
		}

		System.out.println("Array después de duplicar valores:");
		imprimirArray(numeros);

		// Reemplazar valores negativos por 0
		int[] valores = { -5, 10, -3, 7, -1, 15 };
		System.out.println("Array con valores negativos:");
		imprimirArray(valores);

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] < 0) {
				valores[i] = 0;
			}
		}

		System.out.println("Array después de reemplazar negativos por 0:");
		imprimirArray(valores);

		// Intercambiar primer y último elemento
		int[] intercambio = { 100, 200, 300, 400, 500 };
		System.out.println("Antes del intercambio:");
		imprimirArray(intercambio);

		int temp = intercambio[0];
		intercambio[0] = intercambio[intercambio.length - 1];
		intercambio[intercambio.length - 1] = temp;

		System.out.println("Después del intercambio:");
		imprimirArray(intercambio);
		System.out.println();
	}

	// 5. ARRAYS MULTIDIMENSIONALES
	public static void arraysMultidimensionales() {
		System.out.println("5. ARRAYS MULTIDIMENSIONALES");
		System.out.println("============================");

		// Matriz 3x3
		int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Matriz 3x3:");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		// Suma de elementos de la matriz
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				suma += matriz[i][j];
			}
		}
		System.out.println("Suma total de elementos: " + suma);

		// Buscar elemento en matriz
		int buscar = 5;
		boolean encontradoEnMatriz = false;
		int filaEncontrada = -1;
		int columnaEncontrada = -1;

		for (int i = 0; i < matriz.length && !encontradoEnMatriz; i++) {
			for (int j = 0; j < matriz[i].length && !encontradoEnMatriz; j++) {
				if (matriz[i][j] == buscar) {
					encontradoEnMatriz = true;
					filaEncontrada = i;
					columnaEncontrada = j;
				}
			}
		}

		if (encontradoEnMatriz) {
			System.out.println("Elemento " + buscar + " encontrado en posición [" + filaEncontrada + "]["
					+ columnaEncontrada + "]");
		}

		// Matriz de calificaciones por estudiante y materia
		String[] estudiantes = { "Ana", "Carlos", "María" };
		String[] materias = { "Math", "Science", "History" };
		int[][] calificaciones = { { 85, 90, 78 }, // Ana
				{ 92, 88, 85 }, // Carlos
				{ 79, 95, 91 } // María
		};

		System.out.println("\nCalificaciones por estudiante:");
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i] + ":");
			for (int j = 0; j < materias.length; j++) {
				System.out.println("  " + materias[j] + ": " + calificaciones[i][j]);
			}

			// Calcular promedio del estudiante
			double sumaEst = 0;
			for (int j = 0; j < calificaciones[i].length; j++) {
				sumaEst += calificaciones[i][j];
			}
			double promedioEst = sumaEst / calificaciones[i].length;
			System.out.println("  Promedio: " + String.format("%.2f", promedioEst));
			System.out.println();
		}
	}

	// 6. MÉTODOS ÚTILES
	public static void metodosUtiles() {
		System.out.println("6. MÉTODOS ÚTILES PARA ARRAYS");
		System.out.println("=============================");

		int[] numeros = { 64, 34, 25, 12, 22, 11, 90 };

		System.out.println("Array original:");
		imprimirArray(numeros);

		// Ordenar array (Bubble Sort simple)
		ordenarArray(numeros);
		System.out.println("Array ordenado:");
		imprimirArray(numeros);

		// Copiar array
		int[] copia = copiarArray(numeros);
		System.out.println("Copia del array:");
		imprimirArray(copia);

		// Invertir array
		int[] invertido = invertirArray(numeros);
		System.out.println("Array invertido:");
		imprimirArray(invertido);

		// Verificar si array está ordenado
		boolean estaOrdenado = estaOrdenado(numeros);
		System.out.println("¿El array está ordenado? " + estaOrdenado);
	}

	// MÉTODOS AUXILIARES

	public static void imprimirArray(int[] arr) {
		for (int elemento : arr) {
			System.out.print(elemento + " ");
		}
		System.out.println();
	}

	public static void ordenarArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// Intercambiar elementos
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static int[] copiarArray(int[] original) {
		int[] copia = new int[original.length];
		for (int i = 0; i < original.length; i++) {
			copia[i] = original[i];
		}
		return copia;
	}

	public static int[] invertirArray(int[] original) {
		int[] invertido = new int[original.length];
		for (int i = 0; i < original.length; i++) {
			invertido[i] = original[original.length - 1 - i];
		}
		return invertido;
	}

	public static boolean estaOrdenado(int[] arr) {
		boolean ordenado = true;
		for (int i = 0; i < arr.length - 1 && ordenado; i++) {
			if (arr[i] > arr[i + 1]) {
				ordenado = false;
			}
		}
		return ordenado;
	}
}

/*
 * CONCEPTOS CLAVE CUBIERTOS:
 * 
 * 1. DECLARACIÓN E INICIALIZACIÓN: - Diferentes formas de crear arrays -
 * Inicialización con valores - Tamaño fijo de arrays
 * 
 * 2. RECORRIDO CON BUCLES: - for tradicional con índices - for-each mejorado -
 * while loop - Recorridos en diferentes direcciones
 * 
 * 3. CONDICIONES EN ARRAYS: - Búsqueda de elementos (sin break) - Conteo con
 * condiciones - Encontrar máximo/mínimo - Validaciones
 * 
 * 4. MODIFICACIÓN: - Cambio de valores - Operaciones matemáticas - Reemplazo
 * condicional - Intercambio de elementos
 * 
 * 5. ARRAYS MULTIDIMENSIONALES: - Matrices 2D - Bucles anidados (con
 * condiciones de corte) - Aplicaciones prácticas
 * 
 * 6. ALGORITMOS BÁSICOS: - Ordenamiento - Copia de arrays - Inversión -
 * Validaciones (un solo return)
 * 
 * TÉCNICAS APLICADAS PARA EVITAR BREAK Y MÚLTIPLES RETURNS: - Uso de variables
 * booleanas de control en bucles - Condiciones compuestas con && en bucles - Un
 * solo return por función - Control de flujo mediante flags
 * 
 * EJERCICIOS PROPUESTOS: 1. Crear un programa que encuentre el segundo número
 * más grande 2. Implementar búsqueda binaria sin break 3. Crear un juego de
 * tres en raya usando matriz 4. Calcular la mediana de un array 5. Rotar
 * elementos del array hacia la izquierda/derecha
 */