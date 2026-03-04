import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteCitaPrevia extends Paciente {

	private String especialidad;
	private LocalDate[] consultas = new LocalDate[5];
	private int numConsultas;

	public void pedirDatos(int id) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(id);

		System.out.println("Añada la especialidad del paciente: ");
		especialidad = leer.readLine();

	}

	public boolean añadirConsulta() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		if (numConsultas < 10) {

			System.out.println("Introdue la fecha de la cita:(dd/mm/yyyy) " + numConsultas);
			String fechaUsuario = leer.readLine();

			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fecha = LocalDate.parse(fechaUsuario, formato);
			consultas[numConsultas] = fecha;
			numConsultas++;
			return true;
		} else {
			return false;
		}
	}

	public void mostrarDatos() {
		super.mostrarDatos();

		System.out.println("Especialidad Medica: " + this.consultas);

		for (LocalDate fecha : consultas) {
			System.out.print(fecha + " ");
		}

		System.out.println("");
		System.out.println("----------------------------");

	}
}
