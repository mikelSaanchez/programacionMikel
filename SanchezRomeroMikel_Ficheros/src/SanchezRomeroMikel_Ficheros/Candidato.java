package SanchezRomeroMikel_Ficheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Candidato {

	private int id;
	private String nombre;
	private String partido;
	private int numVotos;

	public void pedirDatos() {

		boolean todoOk = false;

		do {
			try {

				id = Lecturas.leerEntero("Introduce el id: ");
				nombre = Lecturas.leerString("Introduce el nombre:");
				partido = Lecturas.leerOpcion(
						"Introduce el partido (Partido JavaScriptero / Alianza Java Enterprise / P.C.D. / Movimiento IA First):",
						new String[] { "Partido JavaScriptero", "Alianza Java Enterprise", "Movimiento IA First",
								"P.C.D." });
				numVotos = Lecturas.leerEnteroMayorQue("Introduce los votos:", 0);

				todoOk = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} while (!todoOk);
	}

	public void guardar() {
		File f = new File("./candidatos.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(id + "-" + nombre + "-" + partido + "-" + numVotos);

			pw.flush();
			fw.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leerLibro(String linea) throws IOException {
		String[] datos = linea.split("-");

		this.id = Integer.parseInt(datos[0].trim());
		this.nombre = datos[1].trim();
		this.partido = datos[2].trim();
		this.numVotos = Integer.parseInt(datos[3].trim());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getNumVotos() {
		return numVotos;
	}

	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}

}
