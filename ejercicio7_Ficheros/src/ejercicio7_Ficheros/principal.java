package ejercicio7_Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("\t=== Gestion de Campamento ===");
			System.out.println("1. Añadir un nuevo libro o revista");
			System.out.println("2. Gestionar los préstamos. ");
			System.out.println("3. Gestionar la devolución. ");
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
				System.out.println("¡Saliendo!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);

	}

	private static void opcion1() throws IOException {
		String opcion = Lecturas.leerOpcion("Que quiere añadir:(libro o revista)", new String[] { "libro", "Revista" });

		if (opcion.equalsIgnoreCase("libro")) {
			Libro libro = new Libro();
			libro.pedirDatos();
			libro.guardar();
		} else {
			Revista revista = new Revista();
			revista.pedirDatos();
			revista.guardar();
		}
	}

	private static void opcion2() throws IOException {

		int idABuscar = Lecturas.leerEntero("Introduce el ID del libro a buscar: ");

		File f = new File("./biblioteca.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			File temporal = new File("biblioteca_tmp.txt");

			FileWriter fw = new FileWriter(temporal);
			PrintWriter pw = new PrintWriter(fw);

			String linea = br.readLine();
			boolean idEncontrado = false;

			while (linea != null) {

				Libro libro = new Libro();
				libro.leerLibro(linea);

				if (idABuscar == libro.getId()) {
					idEncontrado = true;

					if (libro.isPrestado() == true) {

						libro.setPrestado(false);

						pw.println("Libro," + libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + ","
								+ libro.getAñoPublicacion() + "," + libro.isPrestado() + "," + libro.getGenero());

						System.out.println("El libro si esta disponible para ser prestado.");

					}

				} else {
					pw.println("Libro," + libro.getId() + "," + libro.getTitulo() + "," + libro.getAutor() + ","
							+ libro.getAñoPublicacion() + "," + libro.isPrestado() + "," + libro.getGenero());

				}

				linea = br.readLine();

				pw.flush();
				pw.close();
				fw.close();
			}
			
			if (temporal.delete()) {
				temporal.renameTo(f);
			} else {
				System.err.println("Error borrando el archivo orginal");
			}
			
			if (idEncontrado == false) {
				System.out.println("El ID no coincide con el seleccionado");
			}

			br.close();
			fr.close();

		} else {
			System.out.println("El fichero no existe.");
		}

	}

	private static void opcion3() {
		// TODO Auto-generated method stub

	}

}
