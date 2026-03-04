import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.plaf.multi.MultiPopupMenuUI;

public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

		boolean salir = false;
		do {
			System.out.println("\n=== HOSPITAL ===");
			System.out.println("1. Registrar Paciente");
			System.out.println("2. Añadir tratamiento a paciente urgencias");
			System.out.println("3. Añadir consulta a paciente cita previa");
			System.out.println("4. Mostrar Historial de un Paciente");
			System.out.println("5. Filtrar Urgencias por Gravedad");
			System.out.println("6. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				registrarPaciente(pacientes);
				break;
			case 2:
				añadirTratamientos(pacientes);
				break;
			case 3:
				añadirConsulta(pacientes);
				break;
			case 4:
				mostralHistorial(pacientes);
				break;
			case 5:
				filtrarPorUrgencia(pacientes);
				break;
			case 6:
				System.out.println("¡El Equipo Rocket ha robado tu código! ¡Wobbuffet!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void registrarPaciente(ArrayList<Paciente> pacientes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoPaciente = "";
		do {
			System.out.println("introduce si el paciente es de urgencias o de cita previa: ");
			tipoPaciente = leer.readLine();
			if (tipoPaciente.equalsIgnoreCase("urgencias") && tipoPaciente.equalsIgnoreCase("cita")) {
				System.out.println("El paciente no es correcto.");
			}
		} while (!tipoPaciente.equalsIgnoreCase("urgencias") && !tipoPaciente.equalsIgnoreCase("cita"));

		int id = 1;
		if (pacientes.size() > 0) {
			id = pacientes.getLast().getId() + 1;
			if (tipoPaciente.equalsIgnoreCase("urgencias")) {
				PacienteUrgencias pacienteUrg = new PacienteUrgencias();
				pacienteUrg.pedirDatos(id);
				pacientes.add(pacienteUrg);

			} else {
				PacienteCitaPrevia pacienteCita = new PacienteCitaPrevia();
				pacienteCita.pedirDatos(id);
				pacientes.add(pacienteCita);
			}
		}
	}

	public static Paciente buscarPacienteId(ArrayList<Paciente> pacientes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idPciente = -1;

		boolean datosOK = false;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del paciente a buscar: ");
				idPciente = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				System.err.println("Solo puedes introducir numeros");
			}
		}

		for (Paciente paciente : pacientes) {
			if (paciente.getId() == idPciente) {
				return paciente;
			}
		}
		System.out.println("No se ha encontrado paciente");
		return null;
	}

	private static void añadirTratamientos(ArrayList<Paciente> pacientes) throws IOException {

		Paciente paciente = buscarPacienteId(pacientes);

		if (paciente != null) {
			if (paciente instanceof PacienteUrgencias) {
				if (((PacienteUrgencias) paciente).añadirTratamiento() == true) {
					System.out.println("Tratamiento añadido");
				} else {
					System.out.println("No se pueden añadir mas tratamientos");
				}
			} else {
				System.out.println("Paciente Incorrecto.");
			}
		}
	}

	private static void añadirConsulta(ArrayList<Paciente> pacientes) throws IOException {

		Paciente paciente = buscarPacienteId(pacientes);

		if (paciente != null) {
			if (paciente instanceof PacienteCitaPrevia) {
				if (((PacienteCitaPrevia) paciente).añadirConsulta() == true) {
					System.out.println("Cita añadida");
				} else {
					System.out.println("No se pueden añadir mas citas");
				}
			} else {
				System.out.println("Paciente Incorrecto.");
			}
		}
	}

	private static void mostralHistorial(ArrayList<Paciente> pacientes) throws IOException {
		Paciente paciente = buscarPacienteId(pacientes);
		if (paciente != null) {
			if (paciente instanceof PacienteCitaPrevia) {
				((PacienteCitaPrevia) paciente).mostrarDatos();
			} else {
				((PacienteUrgencias) paciente).mostrarDatos();
			}
		}
	}

	private static void filtrarPorUrgencia(ArrayList<Paciente> pacientes) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int gravedad = 0;
		while (!datosOK) {

			do {
				System.out.print("Introduce la gravedad (1-5): ");
				gravedad = Integer.parseInt(leer.readLine());
				if (gravedad < 1 || gravedad > 5)
					System.out.println("La gravedad solo puuede ser entre 1 y 5");
			} while (gravedad < 1 || gravedad > 5);
			datosOK = true;
		}
		boolean enc = false;
		for (Paciente paciente : pacientes) {
			if (paciente instanceof PacienteUrgencias) {
				if (((PacienteUrgencias) paciente).getGravedad() == gravedad) {
					((PacienteUrgencias) paciente).mostrarDatos();
				}
			}
		}
		if (!enc) {
			System.out.println("No hay pacientes con el nivel de gravedad. ");
		}

	}
}
