import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio6 {
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}
		public static int leerInt() throws NumberFormatException, IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(leer.readLine());
			return num;
		}
		public static char leerChar() throws IOException {
			BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
			char palabra = leer.readLine().toUpperCase().charAt(0);
			return palabra;
		}
	public static void main(String[] args) {
		
		ArrayList <String> tarea = new ArrayList<>();
		
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------TAREAS PENDIENTES-------");
		System.out.println();
		System.out.println("A. Añadir tarea al final de la lista");
		System.out.println("B. Insertar tarea en una posición específica");
		System.out.println("C. Mostrar todas las tareas (numeradas)");
		System.out.println("D. Marcar tarea como completada (eliminarla de la lista)");
		System.out.println("E. Mostrar número total de tareas pendientes");
		System.out.println("F. Buscar si existe una tarea específica");
		System.out.println("G. Eliminar todas las tareas");
		System.out.println("H. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		char opcion = leerChar();
		switch (opcion) {
		case 'A':
			opcionA( tarea);
		break;
		case 'B':
			opcionB( tarea);
		break;
		case 'C':
			opcionC( tarea);
		break;
		case 'D':
		
		break;
		case 'E':
			
		break;
		case 'F':
			
		break;
		case 'G':
			
		break;
		case 'H':
			salir = true;
			System.out.println("Montoya, por favor");
			System.out.println("Nos vemos en la próxima edición");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);
	}
	
	public static void opcionA(ArrayList <String> tarea) throws IOException {
		System.out.println("----Añadir tarea al final----");
		System.out.println("Añadir tarea a la lista:");
		String tareas = leerString();
		tarea.add(tareas);
		
	}
	public static void opcionB(ArrayList<String> tarea) throws IOException {
		
		System.out.println("----Añadir tarea en una posicion----");
		System.out.println("Introduce una posicion:");
		int pos = leerInt();
		System.out.println("Añadir tarea a la lista:");
		String tareas = leerString();
		
		tarea.add(pos, tareas);
		
	}
	public static void opcionC(ArrayList<String> tarea) throws IOException {
		
	}
}
