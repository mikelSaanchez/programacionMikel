import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paciente {

	private int id;
	private String nombre;
	private int edad;
	private long telefono;

	public void pedirDatos(int id) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		this.id = id;

		System.out.println("Introduce el nombre del paciente: ");
		nombre = leer.readLine();
		System.out.println("Introduce la edad del paciente: ");
		edad = Integer.parseInt(leer.readLine());
		System.out.println("Introduce el telefono del paciente: ");
		telefono = Long.parseLong(leer.readLine());
	}

	public int getId() {
		return id;
	}
	public void mostrarDatos() {
		System.out.println("ID: " + this.id);
		System.out.println("Nombre paciente " + this.nombre);
		System.out.println("Edad paciente " + this.edad);
		System.out.println("Telefono paciente " + this.telefono);
	}

}
