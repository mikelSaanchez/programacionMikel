package ejercicio12Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

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
				registrarAlumno(alumnos);
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
			
				break;
			case 5:
				
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
	private static void registrarAlumno(ArrayList<Alumno> alumnos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoAlumno = "";
		do {
			System.out.println("introduce si el alumno es de FP o de secundaria: ");
			tipoAlumno = leer.readLine();
			if (!tipoAlumno.equalsIgnoreCase("FP") && !tipoAlumno.equalsIgnoreCase("Secundaria")) {
				System.out.println("El paciente no es correcto.");
			}
		} while (!tipoAlumno.equalsIgnoreCase("FP") && !tipoAlumno.equalsIgnoreCase("Secundaria"));

		int id = 1;
		if (alumnos.size() > 0) {
			id = alumnos.getLast().getId() + 1;
			if (tipoAlumno.equalsIgnoreCase("FP")) {
				EstudianteFP alumnoFP = new EstudianteFP();
				alumnoFP.pedirDatos(id);
				alumnos.add(alumnoFP);

			} else {
				EstudianteSecundaria alumnoSecun = new EstudianteSecundaria();
				alumnoSecun.pedirDatos(id);
				alumnos.add(alumnoSecun);
			}
		}
	}

}
