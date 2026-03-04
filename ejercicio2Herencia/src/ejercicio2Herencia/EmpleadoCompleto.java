package ejercicio2Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmpleadoCompleto extends Empleado {

	private int antiguedad;

	public void pedirDatos(int id) throws NumberFormatException, IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(id);

		System.out.println("Introduce la entiguedad del empleado: ");
		antiguedad = Integer.parseInt(leer.readLine());
	}
	
	public double sueldo() {
		
		 return super.getSalarioBase()+(antiguedad *100);
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Sueldo: "+  sueldo());
		System.out.println("Antiguedad: "+antiguedad);
	}
}
