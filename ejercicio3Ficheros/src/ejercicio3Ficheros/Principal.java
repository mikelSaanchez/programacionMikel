package ejercicio3Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("\t=== Gestion de Plagas ===");
			System.out.println("1. Añadir una reseña y escribirlo en el fichero");
			System.out.println("2. Mostrar por pantalla el listado con los títulos de vide"
					+ "ojuego que hay en él fichero, y su nota media.");
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

	private static void opcion1() {
		Reseña reseña = new Reseña();
		reseña.pedirDatos();
		reseña.guardar();

	}

	private static void opcion2() throws IOException {
		ArrayList<videoJuego> videojuegos = new ArrayList<>();

		File f = new File("./reseñas.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(";");

				String nombreVideoJuego = datos[1];

				int nota = Integer.parseInt(datos[2]);

				boolean enc = false;

				for (int i = 0; i < videojuegos.size() && enc == false; i++) {

					if (videojuegos.get(i).getNombre().equalsIgnoreCase(nombreVideoJuego)) {
						videojuegos.get(i).añadirNota(nota);
						enc = true;
					}
				}

				if (!enc) {
					videoJuego nuevoVideoJuego = new videoJuego(nombreVideoJuego);
					nuevoVideoJuego.añadirNota(nota);
					videojuegos.add(nuevoVideoJuego);
				}
				linea = br.readLine();
			}
			br.close();
			fr.close();

			System.out.println("Listado de videoJuegos y su nota media: ");
			for (videoJuego vid : videojuegos) {
				System.out.println(vid.getNombre() + " : " + vid.calcularMedia());
			}
		} else {
			System.out.println("El fichero no existe.");
		}
	}

	private static void opcion3() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("./reseñas.txt");
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			System.out.println("Introduce el nombre del jugador: ");
			String nombreJugador = leer.readLine();

			File reseñasJugador = new File("./reseñas_" + nombreJugador + ".txt");

			String linea = br.readLine();
			boolean enc = false;

			while (linea != null) {
				String[] datos = linea.split(";");

				String nombreJugadorReseña = datos[0];

				if (nombreJugador.equalsIgnoreCase(nombreJugadorReseña)) {
					enc = true;
					FileWriter fw = new FileWriter(reseñasJugador, true);
					PrintWriter pw = new PrintWriter(fw);

					pw.println(linea);

					pw.flush();
					fw.close();
					pw.close();
					
				}

				linea = br.readLine();
			}
			br.close();
			fr.close();
			if(enc) {
				System.out.println("Se ha creado el archivo.");
			}else {
				System.out.println("No se ha encontrado el jugador.");
			}
			
		} else {
			System.out.println("El fichero no existe.");

		}

	}

}
