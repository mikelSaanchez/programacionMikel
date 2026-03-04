import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicioExamen {
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}

	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] participantes = new String[6];
		String[] tentadores = new String[6];
		int[][] nivelTentacion = new int[6][6];

		boolean salir = false;
		do {
			try {
				System.out.println();
				System.out.println("---LA ISLA DE LAS TENTACIONES JAVA---");
				System.out.println();
				System.out.println("Opción 1: “Llegada a la villa” (Carga de Datos)");
				System.out.println("Opción 2: “¡Hay más imágenes!” (Actualizar Tentación)");
				System.out.println("Opción 3: \"Hoguera de Confrontación\" (Matriz y Estadísticas)");
				System.out.println("Opción 4: “La luz de la tentación” (Alarma)");
				System.out.println("Opcion 5: Salir");
				System.out.println();
				System.out.print("Elige una opción: ");
				int opcion = leerInt();
				switch (opcion) {
				case 1:
					menu1(participantes, tentadores, nivelTentacion);
					break;
				case 2:
					menu2(participantes, tentadores, nivelTentacion);
					break;
				case 3:
					menu3(participantes, tentadores, nivelTentacion);
					break;
				case 4:
					menu4(participantes, tentadores, nivelTentacion);
					break;
				case 5:
					salir = true;
					System.out.println("Montoya, por favor");
					System.out.println("Nos vemos en la próxima edición");
					break;
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Introduce numero, no letras.");
			}
		} while (!salir);
	}

	public static void menu1(String[] participantes, String[] tentadores, int[][] nivelTentacion) throws IOException {
		System.out.println("--- LLEGADA A LA VILLA ---");
		System.out.println();
		System.out.println("Introduce los nombres de los 6 PARTICIPANTES:");
		for (int i = 0; i < participantes.length; i++) {
			do {
				System.out.println("Participante " + (i + 1) + " :");
				participantes[i] = leerString();
				if (participantes[i].isEmpty()) {
					System.out.println("El nombre no puede estar vacío. ");
				}
			} while (participantes[i].isEmpty());
		}
		System.out.println("Introduce los nombres de los 6 TENTADORES:");
		for (int i = 0; i < tentadores.length; i++) {
			do {
				System.out.println("Tentador " + (i + 1) + " :");
				tentadores[i] = leerString();
				if (tentadores[i].isEmpty()) {
					System.out.println("El nombre no puede estar vacío. ");
				}
			} while (tentadores[i].isEmpty());
		}
		System.out.println("¡Todos los participantes y tentadores han llegado a la villa!");
		for (int f = 0; f < nivelTentacion.length; f++) {
			for (int c = 0; c < nivelTentacion[f].length; c++) {
				nivelTentacion[c][c] = 0;
			}
		}
	}

	public static void menu2(String[] participantes, String[] tentadores, int[][] nivelTentacion) throws IOException {
		System.out.println("--- ¡HAY MÁS IMÁGENES! ---");
		System.out.println();
		System.out.println("Participantes: ");
		for (int i = 0; i < participantes.length; i++) {
			System.out.print(i + " " + participantes[i] + ", ");
		}
		System.out.println();
		System.out.println("Tentadores: ");
		for (int i = 0; i < tentadores.length; i++) {
			System.out.print(i + " " + tentadores[i] + ", ");
		}
		System.out.println();
		int numeroParticipante = -1;
		do {
			try {
				System.out.println("Introduce el índice del participante (0-5):");
				numeroParticipante = leerInt();
				if (numeroParticipante < 0 || numeroParticipante > 5) {
					System.out.println("El numero no esta entre 0 y 5.");
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Introduce numero, no letras.");
			}
		} while (numeroParticipante < 0 || numeroParticipante > 5);

		int numeroTentador = -1;
		do {
			try {
				System.out.println("Introduce el índice del tentador (0-5): ");
				numeroTentador = leerInt();
				if (numeroTentador < 0 || numeroTentador > 5) {
					System.out.println("El numero no esta entre 0 y 5.");
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Introduce numero, no letras.");
			}
		} while (numeroTentador < 0 || numeroTentador > 5);

		int puntuacion = -1;
		do {
			try {
				System.out.println("Introduce el grado de tentación a sumar(0-100):");
				puntuacion = leerInt();
				if (puntuacion < 0 || puntuacion > 100) {
					System.out.println("El numero no esta entre 0 y 100.");
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Introduce numero, no letras.");
			}
		} while (puntuacion < 0 || puntuacion > 100);

		nivelTentacion[numeroParticipante][numeroTentador - 1] = puntuacion;
		System.out.println("¡Tentación actualizada! " + participantes[numeroParticipante] + " y "
				+ tentadores[numeroTentador] + " ahora tienen un nivel de " + puntuacion);
	}

	public static void menu3(String[] participantes, String[] tentadores, int[][] nivelTentacion) throws IOException {
		System.out.println("--- HOGUERA DE CONFRONTACIÓN ---");
		System.out.println("MATRIZ DE TENTACIÓN:");

		System.out.print("\t\t");
		for (int i = 0; i < tentadores.length; i++) {
			System.out.print(tentadores[i] + "\t\t");
		}
		System.out.println("");
		for (int f = 0; f < nivelTentacion.length; f++) {
			System.out.print(participantes[f] + "\t\t");
			for (int c = 0; c < nivelTentacion[f].length; c++) {
				System.out.print(nivelTentacion[f][c] + "\t\t");
			}
			System.out.println();
		}

		System.out.println("PARTICIPANTE MÁS INFIEL:");
		int posMasInfiel = -1;
		int infielMayor = -1;
		for (int f = 0; f < nivelTentacion.length; f++) {
			int sumaInfiel = 0;
			for (int c = 0; c < nivelTentacion[f].length; c++) {
				sumaInfiel += nivelTentacion[f][c];
				if (sumaInfiel > infielMayor) {
					posMasInfiel = f;
					infielMayor = sumaInfiel;
				}
			}
		}
		System.out.println(participantes[posMasInfiel] + " con una tentación total de " + infielMayor);

		int conexionMayor = -1;
		int posF = -1;
		int posC = -1;
		for (int f = 0; f < nivelTentacion.length; f++) {
			for (int c = 0; c < nivelTentacion[f].length; c++) {
				if (conexionMayor < nivelTentacion[f][c]) {

					conexionMayor = nivelTentacion[f][c];
					posF = f;
					posC = c;
				}
			}
		}
		System.out.println("MAYOR CONEXIÓN:");
		System.out.println(
				participantes[posF] + " y " + tentadores[posC] + " con un nivel de tentación de " + conexionMayor);
	}

	public static void menu4(String[] participantes, String[] tentadores, int[][] nivelTentacion) throws IOException {

		System.out.println("--- LA LUZ DE LA TENTACIÓN ---");
		int umbralAlarma = -1;
		do {
			try {
				System.out.println("Introduce el umbral de alarma (1-100): ");
				umbralAlarma = leerInt();
				if (umbralAlarma < 0 || umbralAlarma > 100) {
					System.out.println("El numero no esta entre 0 y 100.");
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Introduce numero, no letras.");
			}
		} while (umbralAlarma < 0 || umbralAlarma > 100);
		System.out.println();
		System.out.println("BUSCANDO CONEXIONES PELIGROSAS...");
		System.out.println();
		boolean nocheTraquila = false;
		for (int f = 0; f < nivelTentacion.length; f++) {
			for (int c = 0; c < nivelTentacion[f].length; c++) {

				if (nivelTentacion[f][c] >= umbralAlarma) {
					System.out.println("¡ALARMA!" + participantes[f] + " y " + tentadores[c]
							+ " tienen un nivel de tentación de " + nivelTentacion[f][c]);
					nocheTraquila = true;
				}
			}
		}
		if (nocheTraquila == false) {
			System.out.println("Noche tranquila. La isla duerme. Por ahora");
		}
	}
}
