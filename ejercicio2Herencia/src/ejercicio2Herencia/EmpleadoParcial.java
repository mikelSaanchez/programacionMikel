package ejercicio2Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmpleadoParcial extends Empleado {

	private int meses;

	public void pedirDatos(int id) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(id);

		System.out.println("Introduce los meses que lleva el empleado: ");
		meses = Integer.parseInt(leer.readLine());
	}
	
	public double sueldo() {
		return super.getSalarioBase();
	}
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Sueldo: "+  sueldo());
		System.out.println("Meses: "+meses);
	}
}
