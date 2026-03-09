package ejercicioOPcionalFicheros;

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
			System.out.println("\t=== Gestion de Campamento ===");
			System.out.println("Opción 1: Añadir una nueva actividad. ");
			System.out.println("Opción 2: Buscar actividades por sección.");
			System.out.println("Opción 3: Realizar una inscripción");
			System.out.println("Opción 4: Exportar participantes de una actividad");
			System.out.println("4. Salir");
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
				opcion1();
				break;
			case 2:
				opcion2();
				break;
			case 3:
				opcion3();
				break;
			case 4:
				opcion4();
				break;
			case 5:
				System.out.println("¡Saliendo!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);

	}

	private static void opcion1() {
		Actividad actividad = new Actividad();
		actividad.pedirDatos();
		actividad.guardar();

	}

	private static void opcion2() throws IOException {

		String sección = Lecturas.leerOpcion("Introduce la sección (Chiqui, Preas, Centro):",
				new String[] { "Chiqui", "Preas", "Centro" });
		File f = new File("./actividades.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			int sumaPrecios = 0;
			while (linea != null) {
				String[] datos = linea.split(";");

				String nombre = datos[1];
				String seccionAbuscar = datos[2];
				int precio = Integer.parseInt(datos[3]);
				int plazas = Integer.parseInt(datos[4]);
				if (seccionAbuscar.equalsIgnoreCase(sección)) {

					System.out.println("ACTIVIDAD: " + nombre);
					System.out.println("\t Precio: " + precio);
					System.out.println("\t Plazas disponibles: " + plazas);
					sumaPrecios += precio;

				}
				linea = br.readLine();

			}
			System.out.println("\t\t Total:" + sumaPrecios);

			br.close();
			fr.close();

		} else {
			System.out.println("El fichero no existe.");
		}
	}

	private static void opcion3() throws IOException {
		Inscripcion inscripcion = new Inscripcion();
		Actividad actividad = new Actividad();
		int id = Lecturas.leerEntero("Introduce el id de la actividad a la que te quieres inscribir:");
		int edad = Lecturas.leerEnteroEnRango("Introduce la edad (8-17): ", 8, 17);
		File f = new File("./actividades.txt");

		File archivoTemporal = new File("actividades_tmp.txt");
		FileWriter fw = new FileWriter(archivoTemporal, false);
		PrintWriter pw = new PrintWriter(fw);
		boolean actividadEncontrada = false;
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(";");

				String seccionAbuscar = datos[2];

				if (seccionAbuscar.equalsIgnoreCase("Chiqui")) {
					if (edad < 8 || edad > 11) {
						inscripcion.pedirDatos();
						inscripcion.guardar();
					} else {
						System.out.println("No tienes la edad adecuada para inscribirte en esta actividad.");
					}

				} else if (seccionAbuscar.equalsIgnoreCase("Preas")) {
					if (edad < 12 || edad > 14) {
						inscripcion.pedirDatos();
						inscripcion.guardar();
					} else {
						System.out.println("No tienes la edad adecuada para inscribirte en esta actividad.");
					}

				} else {
					if (edad > 15) {
						inscripcion.pedirDatos();
						inscripcion.guardar();
					} else {
						System.out.println("No tienes la edad adecuada para inscribirte en esta actividad.");
					}
				}

				if (actividad.getId() == inscripcion.getId()) {
					actividadEncontrada = true;
					int nuevaCantidad = Integer.parseInt(datos[3]) - 1;
					actividad.setNumPlazas(nuevaCantidad);
				}

				pw.println(actividad.getId() + "," + actividad.getNombre() + "," + actividad.getSección() + ","
						+ actividad.getNumPlazas() + "," + actividad.getPrecio());

				linea = br.readLine();

			}

			br.close();
			fr.close();
			pw.flush();
			pw.close();
			fw.close();

			if (actividadEncontrada == true) {
				inscripcion.guardar();
				if (f.delete()) {
					archivoTemporal.renameTo(f);
				} else {
					System.out.println("Error al actualizar el archivo.");
				}
			} else {
				System.out.println("El fichero no existe.");
			}
		}
	}

	private static void opcion4() throws IOException {
		int id = Lecturas.leerEntero("Introduce el id de la actividad que quieres exportar:");

		File f = new File("./actividades.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(";");

				int idABuscar = Integer.parseInt(datos[0]);
				String nombre = datos[1];
				if (idABuscar == id) {
					File ficheroReseñasJugador = new File("./" + nombre + ".txt");
					FileWriter fw = new FileWriter(ficheroReseñasJugador, true);
					PrintWriter pw = new PrintWriter(fw);

					pw.println(linea);
					pw.flush();
					fw.close();
					pw.close();
					System.out.println("Inscripciones exportadas en:"+ nombre + ".txt\"");
				}
				linea = br.readLine();

			}

			br.close();
			fr.close();

		} else {
			System.out.println("El fichero no existe.");
		}
	}
}
