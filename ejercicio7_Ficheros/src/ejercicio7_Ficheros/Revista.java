package ejercicio7_Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Revista {

	private int id;
	private String titulo;
	private String autor;
	private int añoPublicacion;
	private boolean prestado;
	private int numEdicicion;
	
	public void pedirDatos() throws IOException {

		boolean todoOk = false;

		do {
			try {
				
				id = Lecturas.leerEntero("Introduce el id de la actividad:");
				while (idExiste(id)) {
					System.out.println("ID repetido");
					System.out.print("Introduce otro ID: ");
					id = Lecturas.leerEntero("Introduce el id de la actividad:");
				}
				titulo = Lecturas.leerString("Introduce el titulo:");
				autor = Lecturas.leerString("Escribe el autor:");
				añoPublicacion = Lecturas.leerEntero("Introduce el año de publicacion");
				prestado = Lecturas.leerSiNo("Introduce si esta prestado:");
				numEdicicion =Lecturas.leerEntero("Introduce el num de la edicion");

				todoOk = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} while (!todoOk);
	}
	private boolean idExiste(int idBuscar) throws IOException {
		File archivo = new File("biblioteca.txt");
		if (!archivo.exists())
			return false;
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		while (linea != null) {
			String datos[] = linea.split(",");
			if (Integer.parseInt(datos[1]) == idBuscar) {
				br.close();
				return true;
			}
			linea = br.readLine();
		}
		br.close();
		return false;
	}
	
	public void guardar() {
		File f = new File("./biblioteca.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println("Revista,"+id+","+titulo+","+autor+","+añoPublicacion+","+prestado+","+numEdicicion);

			pw.flush();
			fw.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
