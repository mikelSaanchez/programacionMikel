package ejercicio2Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		boolean salir = false;
		do {
			System.out.println("1. Añadir empleado tiempo completo:");
			System.out.println("2. Añadir empleado temporal:");
			System.out.println("3. Calcular salario de un empleado:");
			System.out.println("4. Mostrar todos los empleados y sus datos:");
			System.out.println("5. Salir:");
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
				menu1(empleados);
				break;
			case 2:
				menu2(empleados);
				break;
			case 3:
				menu3(empleados);
				break;
			case 4:
				menu4(empleados);
				break;
			case 5:
				System.out.println("¡Saliendo!");
				salir = true;
				break;
			default:
				System.err.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void menu1(ArrayList<Empleado> empleados) throws NumberFormatException, IOException {

		int id = 1;
		if (empleados.size() > 0) {
			id = empleados.getLast().getId() + 1;
		}
		EmpleadoCompleto emp = new EmpleadoCompleto();
		emp.pedirDatos(id);
		empleados.add(emp);

	}

	private static void menu2(ArrayList<Empleado> empleados) throws NumberFormatException, IOException {

		int id = 1;
		if (empleados.size() > 0) {
			id = empleados.getLast().getId() + 1;
		}
		EmpleadoParcial emp = new EmpleadoParcial();
		emp.pedirDatos(id);
		empleados.add(emp);

	}

	private static void menu3(ArrayList<Empleado> empleados) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}

		boolean enc = false;
		for (Empleado emp : empleados) {
			if (emp.getId() == idABuscar) {
				if (emp instanceof EmpleadoCompleto) {
					System.out.println("El salario del empleado completo es: " + ((EmpleadoCompleto) emp).sueldo());
					enc = true;
				} else {
					System.out.println("El salsario del empleado Parcial es: " + ((EmpleadoParcial) emp).sueldo());
				}
			}
		}

		if (!enc) {
			System.out.println("No se ha encontrado el empleado");
		}

	}

	private static void menu4(ArrayList<Empleado> empleados) throws NumberFormatException, IOException {
		for (Empleado emp : empleados) {
			if (emp instanceof EmpleadoCompleto) {
				((EmpleadoCompleto) emp).mostrarDatos();
			} else {
				((EmpleadoParcial) emp).mostrarDatos();
			}
		}
	}
}
