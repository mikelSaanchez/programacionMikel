import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ejercicio12 {	
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

	public static void main(String[] args) {
	Map <String, Integer> agenda = new HashMap<>();
		
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------Agenda-------");
		System.out.println();
		System.out.println("1. Añadir contacto (nombre como clave, teléfono como valor)");
		System.out.println("2. Buscar teléfono por nombre");
		System.out.println("3. Mostrar todos los contactos");
		System.out.println("4. Eliminar contacto por nombre");
		System.out.println("5. Comprobar si existe un contacto");
		System.out.println("6. Modificar teléfono de un contacto existente");
		System.out.println("7. Mostrar cantidad total de contactos");
		System.out.println("8. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(agenda);
		break;
		case 2:
			menu2(agenda);
		break;
		case 3:
			menu3(agenda);
		break;
		case 4:
			menu4(agenda);
		break;
		case 5:
			menu5(agenda);
		break;
		case 6:
			menu6(agenda);
		break;
		case 7:
			menu7(agenda);
		break;
		case 8:
			salir = true;
			System.out.println("¡Saliendo!");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);

	}
	public static void menu1(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Añadir Contacto---");
		
		System.out.println("Añade el nombre del contacto para añadir: ");
		String nombre = leerString();		
		
		System.out.println("Añade el numero de ese contacto: ");
		int telefono = leerInt();
		
		agenda.put(nombre, telefono);
	}
	public static void menu2(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Buscar teléfono por nombre---");
		
		System.out.println("Añada el nombre del telefono que quiera buscar: ");
		String nombreBuscar = leerString();
		
		if(agenda.getOrDefault(nombreBuscar,-1)==-1) {
			System.out.println("Ese nombre no esta en la lista.");
		}else {
			System.out.println("El telefono de "+nombreBuscar+" es "+agenda.get(nombreBuscar));
		}
		
	}
	public static void menu3(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Mostrar todos los contactos---");
		
		for (Map.Entry<String, Integer> valores : agenda.entrySet()) {
			System.out.println(valores.getKey() + " => " + valores.getValue());
			}
	}
	public static void menu4(Map<String, Integer> agenda) throws IOException {
		System.out.println("--- Eliminar contacto por nombre---");
		
		System.out.println("Añada el nombre que quiera eliminar: ");
		String nombreElim = leerString();
		
		if(agenda.remove(nombreElim)==null) {
		System.out.println("No se ha borrado nada.");	
		}else {
			System.out.println("Contacto borrado correctamente.");
		}

	}
	public static void menu5(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Comprobar si existe un contacto---");
		
		System.out.println("Añada el nombre que quiera comprobar: ");
		String nombreComprobar = leerString();
		
		if(agenda.containsKey(nombreComprobar)) {
			System.out.println("Existe el contacto.");	
			}else {
				System.out.println("No existe el contacto.");
			}
	}
	public static void menu6(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Modificar teléfono de un contacto existente---");
		
		System.out.println("Añada el nombre del contacto que quiera modificar: ");
		String nombreModificar = leerString();
		
		if(agenda.containsKey(nombreModificar)) {
			System.out.println("Añade el numero de ese contacto: ");
			int telefono = leerInt();
			agenda.put(nombreModificar, telefono);
		}else {
			System.out.println("No existe el contacto.");
		}
	}
	public static void menu7(Map<String, Integer> agenda) throws IOException {
		System.out.println("---Mostrar cantidad total de contactos---");
		
		System.out.println("La cantidad de contactos es: "+agenda.size());
		
	}

}
