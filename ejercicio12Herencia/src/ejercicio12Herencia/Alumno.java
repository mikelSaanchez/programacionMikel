package ejercicio12Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alumno {

	private int id;
	private String nombre;
	private int edad;

	public void pedirDatos(int id) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		this.id = id;

		System.out.println("Introduce el nombre del alumno: ");
		nombre = leer.readLine();
		System.out.println("Introduce la edad del alumno: ");
		edad = Integer.parseInt(leer.readLine());

	}

	public int getId() {
		return id;
	}

}
