package SanchezRomeroMikel_Ficheros;

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
			System.out.println("\n=== CONSEJO DE PROGRAMADORES DE CYL ===");
			System.out.println("1. Añadir candidato");
			System.out.println("2. Ver candidatos de un partido");
			System.out.println("3. Actualizar votos de un candidato");
			System.out.println("4. Exportar acta final de resultados");
			System.out.println("5. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números.");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("-- AÑADIR CANDIDATO --");
				añadirCandidato();
				break;
			case 2:
				System.out.println("-- BUSCAR POR PARTIDO --");
				buscarPartido();
				break;
			case 3:
				System.out.println("-- ACTUALIZAR VOTOS --");
				actualizarVotos();
				break;
			case 4:
				System.out.println("-- EXPORTAR ACTA FINAL --");
				exportarActa();
				break;
			case 5:
				System.out.println("Saliendo del programa. ¡Hasta pronto!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
			}

		} while (!salir);

	}

	private static void añadirCandidato() {
		Candidato candidato = new Candidato();
		candidato.pedirDatos();
		candidato.guardar();

	}

	private static void buscarPartido() throws IOException {
		String partidoABuscar = Lecturas.leerOpcion(
				"Introduce el partido (Partido JavaScriptero / Alianza Java Enterprise / P.C.D. / Movimiento IA First):",
				new String[] { "Partido JavaScriptero", "Alianza Java Enterprise", "Movimiento IA First", "P.C.D." });

		File f = new File("./candidatos.txt");
		Candidato candidato = new Candidato();
		int totalVotos = 0;
		boolean enc = false;
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			System.out.println("Partido: " + partidoABuscar);
			while (linea != null) {
				candidato.leerLibro(linea);
				if (partidoABuscar.equalsIgnoreCase(candidato.getPartido())) {
					System.out.println(candidato.getNombre() + "--------" + candidato.getNumVotos());
					totalVotos += candidato.getNumVotos();
					enc = true;
				}
				linea = br.readLine();

			}
			System.out.println("--------------------------------------");
			System.out.println("Total votos del partido: " + totalVotos);

			br.close();
			fr.close();

		} else {
			System.out.println("El fichero no existe.");
		}
		if (enc == false) {
			System.out.println("No se han encontrado candidatos para ese partido");
		}

	}

	private static void actualizarVotos() throws IOException {

		int idABuscar = Lecturas.leerEntero("Introduce el id del candidato:");
		File f = new File("./candidatos.txt");
		Candidato candidato = new Candidato();
		boolean enc = false;
		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			File temporal = new File("candidatos_temp.txt");

			FileWriter fw = new FileWriter(temporal);
			PrintWriter pw = new PrintWriter(fw);
			String linea = br.readLine();

			while (linea != null) {
				candidato.leerLibro(linea);
				if (idABuscar == candidato.getId()) {
					enc = true;
					System.out.println(
							candidato.getNombre() + " tiene actualmente " + candidato.getNumVotos() + " votos.");
					int nuevosVotos = Lecturas.leerEnteroMayorQue("Introduce el nuevo número de votos:",
							candidato.getNumVotos());
					candidato.setNumVotos(nuevosVotos);

					pw.println(candidato.getId() + "-" + candidato.getNombre() + "-" + candidato.getPartido() + "-"
							+ candidato.getNumVotos());

					System.out.println("Votos actualizados correctamente.");
				} else {
					pw.println(candidato.getId() + "-" + candidato.getNombre() + "-" + candidato.getPartido() + "-"
							+ candidato.getNumVotos());
				}
				linea = br.readLine();

			}

			pw.flush();
			pw.close();
			fw.close();
			br.close();
			fr.close();

			if (f.delete()) {
				temporal.renameTo(f);
			} else {
				System.err.println("Error borrando el archivo orginal");
			}

			if (enc == false) {
				System.err.println("Candidato no encontrado.");
			}

		} else {
			System.out.println("El fichero no existe.");
		}

	}

	private static void exportarActa() throws IOException {
		File f = new File("./candidatos.txt");
		Candidato candidato = new Candidato();

		if (f.exists()) {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			File actaFinal = new File("./acta_final.txt");
			FileWriter fw = new FileWriter(actaFinal, false);
			PrintWriter pw = new PrintWriter(fw);

			String linea = br.readLine();
			int totalVotos = 0;
			while (linea != null) {
				candidato.leerLibro(linea);

				totalVotos += candidato.getNumVotos();
				pw.println(linea);

				linea = br.readLine();

			}
			pw.println("Total votos: " + totalVotos);
			pw.println("Ganador: " + candidato.getNombre() + " (" + candidato.getPartido() + ")");

			br.close();
			fr.close();
			pw.flush();
			pw.close();
			fw.close();
			System.out.println("Acta generada: acta_final.txt");
		} else {
			System.out.println("El fichero no existe.");
		}
	}
}
