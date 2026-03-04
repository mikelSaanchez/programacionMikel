package ejercicio16Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Personas {

	private int dni;
	private String nombre;
	private int edad;
	private LocalDate fechaNacimiento;
	private String nacionalidad;

	public void pedirDatos(ArrayList<Deportistas> deportistas) throws IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(99999999) + 10000000;
		} while (estaRepetido(deportistas, idGenerado));
		dni = idGenerado;

		System.out.println("Introduce el nombre del deportista:");
		nombre = leer.readLine();

		System.out.println("Introduce la edad :");
		edad = Integer.parseInt(leer.readLine());

		System.out.println("Introduce la fecha:");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaTemp = leer.readLine();
		fechaNacimiento = LocalDate.parse(fechaTemp, formato);

		System.out.println("Introduce la nacionalidad:");
		nacionalidad = leer.readLine();

	}

	private boolean estaRepetido(ArrayList<Deportistas> deportistas, int idGenerado) {

		for (int i = 0; i < (deportistas.size() - 1); i++) {

			if (deportistas.get(i).getDni() == dni) {
				return true;
			}
		}
		return false;
	}

	public int getDni() {
		return dni;
	}

	public void mostrarDatos() {
		System.out.println("----------");
		System.out.println("DNI" + this.dni);
		System.out.println("Nombre" + this.nombre);
		System.out.println("Edad" + this.edad);
		System.out.println("Fecha Nacimiento" + this.fechaNacimiento);
		System.out.println("Nacionalidad" + this.nacionalidad);
	}
}
