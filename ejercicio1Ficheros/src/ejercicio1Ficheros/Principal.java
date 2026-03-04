package ejercicio1Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Principal {

	public static void main(String[] args) throws IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("\t=== Gestion de Alumnos ===");
			System.out.println("1. Añadir alumno nuevo");
			System.out.println("2. Imprimir por pantalla nota media:");
			System.out.println("3. Generar otro fichero:");
			System.out.println("4. Salir.");
			System.out.print("¿Qué desea consultar?: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				añadirAlumno();
				break;
			case 2:
				calcularMedia();
				break;
			case 3:
				crearNuevoFichero();
				break;
			case 4:
				System.out.println("¡Saliendo!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);
	}

	private static void añadirAlumno() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean añadir = false;
		int res = -1;
		try {
			System.out.println("Introduce 1 si desea sobreescribir los datos y 2 si desea añadir los existentes: ");
			res = Integer.parseInt(leer.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		if (res == 1) {
			añadir = false;
		} else {
			añadir = true;
		}
		Alumno alumno = new Alumno();
		alumno.pedirDatos();
		alumno.guardar(añadir);
	}

	private static void calcularMedia() throws IOException {
		File f = new File("./alumno.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			Alumno a = new Alumno();

			String linea = br.readLine();

			while (linea != null) {
				String[] v;

				v = linea.split(": ");
				a.setExpendiente(Integer.parseInt(v[1]));

				linea = br.readLine();
				v = linea.split(": ");
				a.setNombre(v[1]);

				linea = br.readLine();
				double[] notas = new double[3];

				for (int i = 0; i < 3; i++) {
					linea = br.readLine();
					notas[i] = Double.parseDouble(linea);
				}
				a.setNotas(notas);

				System.out.println("La media del alumno " + a.getNombre() + " = " + a.calcularMedia());

				linea = br.readLine();

				br.close();
				fr.close();
			}

		} else {
			System.out.println("El fichero no existe.");
		}
	}

	private static void crearNuevoFichero() throws IOException {
		File f = new File("./alumno.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			String[] v;
			while (linea != null) {
				if (linea.startsWith("Nombre")) {
					v = linea.split(": ");
					String nombre = v[1];

					if (comprobarSiElNombreEsta(nombre) == false) {
						escribirNombre(nombre);
					}
				}
				linea = br.readLine();
			}
			br.close();
			fr.close();
			System.out.println("Fichero creado");
		} else {
			System.out.println("El fichero no existe.");
		}
	}

	private static void escribirNombre(String nombre) throws IOException {
		File f = new File("./nombres.txt");
		FileWriter fw = new FileWriter(f, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(nombre);

		fw.close();
		pw.close();

	}

	private static boolean comprobarSiElNombreEsta(String nombre) throws IOException {
		File f = new File("./nombres.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				if (linea.equalsIgnoreCase(nombre)) {
					br.close();
					return true;
				}
				linea = br.readLine();
			}
			br.close();
			return false;
		} else {
			return false;
		}
	}
}