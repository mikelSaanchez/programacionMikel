package ejercicio7_Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Libro {

	private int id;
	private String titulo;
	private String autor;
	private int añoPublicacion;
	private boolean prestado;
	private String genero;

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
				genero = Lecturas.leerString("Introduce el genero:");

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

			pw.println("Libro,"+id+","+titulo+","+autor+","+añoPublicacion+","+prestado+","+genero);

			pw.flush();
			fw.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public void leerLibro(String linea) throws IOException {
		String[] datos = linea.split(",");
		
		this.id = Integer.parseInt(datos[1].trim());
		this.titulo = datos[2].trim();
		this.autor = datos[3].trim();
		this.añoPublicacion = Integer.parseInt(datos[4].trim());
		this.prestado = Boolean.parseBoolean(datos[5].trim());
		this.genero = datos[6].trim();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	

}
