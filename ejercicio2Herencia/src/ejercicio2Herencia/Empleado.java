package ejercicio2Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Empleado {

	private int id;
	private String nombre;
	private int salarioBase;
	private String departamento;

	public void pedirDatos(int id) throws NumberFormatException, IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		this.id = id;

		System.out.println("Introduce el nombre del empleado: ");
		nombre = leer.readLine();
		System.out.println("Introduce el salario base: ");
		salarioBase = Integer.parseInt(leer.readLine());
		System.out.println("Introduce el departamento: ");
		departamento = leer.readLine();

	}
	
	public void mostrarDatos() {
	System.out.println("ID: "+id);
	System.out.println("Nombre : "+nombre);
	System.out.println("Departamento : "+departamento);
	}



	public int getId() {
		return id;
	}
	public int getSalarioBase() {
		return salarioBase;
	}
	
}
