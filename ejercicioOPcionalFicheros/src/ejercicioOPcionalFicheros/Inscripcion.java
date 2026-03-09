package ejercicioOPcionalFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Inscripcion {
	
	private int id;
	private String nombre;
	private int edad;
	private int teléfono;
	
	
	public void pedirDatos() {

		boolean todoOk = false;

		do {
			try {
				
				id = Lecturas.leerEntero("Introduce el id de la actividad:");
				nombre = Lecturas.leerString("Introduce el nombre:");
				edad = Lecturas.leerEntero("Introduce la edad:");
				teléfono = Lecturas.leerEntero("Introduce teléfono de contacto:");

				todoOk = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} while (!todoOk);
	}
	
	public void guardar() {
		File f = new File("./inscripciones.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(id+";"+nombre+";"+edad+";"+teléfono);

			pw.flush();
			fw.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

