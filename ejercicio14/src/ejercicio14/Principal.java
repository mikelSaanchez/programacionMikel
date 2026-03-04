package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Alumno>alumnos = new ArrayList<Alumno>();
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		do {
			System.out.println("== Gestión Alumnos DAW  ==");
			System.out.println("1. Registrar estudiante");
			System.out.println("2  Añadir nota");
			System.out.println("3. Ver calificaciones ");
			System.out.println("4. Calcular media");
			System.out.println("5. Estudiante brillante");
			System.out.println("6. Alerta de suspensos");
			System.out.println("7. Salir");
			System.out.println("Introduce una opcion: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {

				try {
					opcion = Integer.parseInt(leer.readLine());
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir numeros");
				}
				datosOK = true;
			}
			switch (opcion) {
			case 1:
				menu1(alumnos);
				break;
			case 2:
				menu2(alumnos);
				break;
			case 3:
				menu3(alumnos);
				break;
			case 4:	
				menu4(alumnos);
				break;
			case 5:
				menu5(alumnos);
				break;
			case 6:
				menu6(alumnos);
				break;		
			case 7:
				System.out.println("¡ARANCELES PARA TODOS!");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (!salir);
	}

	public static void menu1(ArrayList<Alumno> alumnos) throws IOException {
		Alumno a = new Alumno();
		a.pedirDatos(alumnos);
		alumnos.add(a);
		
	}
	public static void menu2(ArrayList<Alumno> alumnos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante a añadir una nota: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		boolean enc = false;
		for (Alumno alumno : alumnos) {
			if (alumno.getId() == idABuscar) {
				alumno.amadirNota();
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado el alumno");
		}
	}
	public static void menu3(ArrayList<Alumno> alumnos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante a añadir una nota: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		boolean enc = false;
		for (Alumno alumno : alumnos) {
			if (alumno.getId() == idABuscar) {
				alumno.verCalificaciones();
				enc = true;
			}
		}
		if(!enc) {
			System.out.println("No se ha encontrado el alumno.");
		}
	}
	public static void menu4(ArrayList<Alumno> alumnos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del estudiante a añadir una nota: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		boolean enc = false;
		for (Alumno alumno : alumnos) {
			if (alumno.getId() == idABuscar) {
				alumno.mostrarMedia();
				enc = true;
			}
		}
		if(!enc) {
			System.out.println("No se ha encontrado el alumno.");
		}
	}
	public static void menu5(ArrayList<Alumno> alumnos) throws IOException {
		
		double notaMediaMax = -1;
		Alumno alumnoBrillante = null;
		for (Alumno alumno : alumnos) {
			if(alumno.devolverMedia()>notaMediaMax) {
				notaMediaMax = alumno.devolverMedia();
				alumnoBrillante= alumno;
			}
		}
		System.out.println("El alumno brillante es: "+alumnoBrillante.toString());
	}
	public static void menu6(ArrayList<Alumno> alumnos) throws IOException {
		
		for(int i = 0; i< alumnos.size();i++) {
			
			double[] notasAlumno = alumnos.get(i).getNotas();
			boolean haySuspenso = false;
			for(int j = 0; j< alumnos.get(i).getNumNotas();i++) {
				if(notasAlumno[j]<5) {
					haySuspenso=true;
				}
			}
			if(haySuspenso) {
				System.out.println("El alumno "+alumnos.get(i).getNombre()+ " esta suspenso.");
			}
		}
		
	}
}
