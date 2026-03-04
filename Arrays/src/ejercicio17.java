import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio17 {
	
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}

	public static void main(String[] args) {
		boolean salir = false;
		int [] notaClase = new int[10];

		do {
			try {
		System.out.println("1. Introducir las 10 calificaciones (validar que estén entre 0 y 10, y que no se introducen letras)");
		System.out.println("2. Mostrar todas las calificaciones con su número de alumno");
		System.out.println("3. Calcular y mostrar la media de la clase");
		System.out.println("4. Contar y mostrar cuántos aprobados (>=5) y suspensos hay");
		System.out.println("5. Mostrar la nota más alta y más baja con sus posiciones");
		System.out.println("6. Contar cuántos alumnos tienen más de un 8");
		System.out.println("7. Salir");
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(notaClase);
		break;
		case 2:
			menu2(notaClase);
		break;
		case 3:
		
		break;
		case 4:
		
		break;
		case 5:
		
		break;
		case 6:
		salir = true;
		System.out.println("¡Hasta luego!");
		break;
		default:
		System.out.println("Opción no válida");
		}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);
}
	public static void menu1(int notaClase[]) throws NumberFormatException, IOException {
				for(int i = 0; i<notaClase.length;i++) {
			int notaAlumno = -1;
			while (notaAlumno < 0 || notaAlumno > 10) {
				System.out.println("Añade la nota del alumno "+(i+1)+" :");
				notaAlumno = leerInt();
				if (notaAlumno < 0 || notaAlumno > 10) {
					System.out.println("Nota no valida. Tiene que ser entre 1 y 10");
					}
			}
			notaClase[i]=notaAlumno;
		}
	}
	public static void menu2(int notaClase[]) {
		for(int i = 0; i< notaClase.length;i++) {
			System.out.println("La nota del alumno "+(i+1)+" es: "+ notaClase[i]);
		}
	}
}

	


