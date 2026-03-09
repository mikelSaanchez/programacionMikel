package ejercicioOPcionalFicheros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

public class Actividad {
	
	private int id;
	private String nombre;
	private int numPlazas;
	private String sección;
	private int precio;
	
	public void pedirDatos() {

		boolean todoOk = false;

		do {
			try {
				
				id = Lecturas.leerEntero("Introduce el id de la actividad:");
				nombre = Lecturas.leerString("Introduce el nombre de la actividad:");
				sección = Lecturas.leerOpcion("Introduce la sección (Chiqui, Preas, Centro):", new String [] {"Chiqui","Preas","Centro"});
				numPlazas = Lecturas.leerEntero("Introduce el número de plazas disponibles:");
				precio = Lecturas.leerEntero("Introduce el precio de la actividad:");

				todoOk = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} while (!todoOk);
	}
	
	public void guardar() {
		File f = new File("./actividades.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);

			pw.println(id+";"+nombre+";"+sección+";"+numPlazas+";"+precio);

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

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSección() {
		return sección;
	}

	public void setSección(String sección) {
		this.sección = sección;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}


