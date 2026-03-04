import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ejercicio15 {
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	public static String leerString() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String palabra = leer.readLine();
		return palabra;
	}
	public static void main(String[] args) {
	Map <String, Integer> victorias = new HashMap<>();

	boolean salir = false;
	do {
	try {
	System.out.println();
	System.out.println("-------Victorias de LOL-------");
	System.out.println();
	System.out.println("1. Registrar equipo (inicializar con 0 victorias)");
	System.out.println("2. Registrar una victoria (incrementar su contador)");
	System.out.println("3. Mostrar las victorias actuales de cada equipo");
	System.out.println("4. Mostrar el equipo ganador");
	System.out.println("5. Comprobar si un existe");
	System.out.println("6. Eliminar equipo ");
	System.out.println("7. Mostrar total de partidas jugadas (total de victorias)");
	System.out.println("8. Mostrar porcentaje de votos de cada candidato");
	System.out.println("9. Comprobar si hay empate (dos o más con victorias iguales)");
	System.out.println("10. Salir");
	System.out.println();
	System.out.print("Elige una opción: ");
	int opcion = leerInt();
	switch (opcion) {
	case 1:
		menu1(victorias);
	break;
	case 2:
		menu2(victorias);
	break;
	case 3:
		menu3(victorias);
	break;
	case 4:
		menu4(victorias);
	break;
	case 5:
		menu5(victorias);
	break;
	case 6:
		menu6(victorias);
	break;
	case 7:
		menu7(victorias);
	break;
	case 8:
		menu8(victorias);
	break;
	case 9:
		menu9(victorias);
	break;
	case 10:
		salir = true;
		System.out.println("¡Saliendo!");
	break;
		}
	}catch(IOException  | NumberFormatException e) {
		System.out.println("Introduce numero, no letras.");
	}
	}while(!salir);


	}
	public static void menu1(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Registrar equipo---");
		
		System.out.println("Añade el nombre del equipo para añadir: ");
		String nombre = leerString();		
	
		victorias.put(nombre, 0);
		
	}
	public static void menu2(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Registrar una victoria ---");
		
		System.out.println("Añade el nombre del equipo para añadir: ");
		String nombre = leerString();		
		
		
		int ganar = victorias.get(nombre);
		ganar++;
		victorias.put(nombre, ganar);
		
	}
	public static void menu3(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Mostrar las victorias actuales de cada equipo ---");
		
		for (Map.Entry<String, Integer> valores : victorias.entrySet()) {
			System.out.println(valores.getKey() + " => " + valores.getValue());
			}
	}
	public static void menu4(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Mostrar el equipo ganador ---");
		int posMayor = 0;
		String equipo = "";
		for (Map.Entry<String, Integer> valores : victorias.entrySet()) {
			if(posMayor<valores.getValue()) {
				posMayor = valores.getValue();
				equipo = valores.getKey();
				}
			}
		System.out.println("El equipo ganador es "+ equipo+" con: "+posMayor+" puntos.");
	}
	public static void menu5(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Comprobar si un existe ---");
		
		System.out.println("Añada el nombre que quiera comprobar: ");
		String nombreComprobar = leerString();
		
		if(victorias.containsKey(nombreComprobar)) {
			System.out.println("Existe el equipo.");	
			}else {
				System.out.println("No existe el equipo.");
			}
	}
	public static void menu6(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Eliminar equipo ---");
		
		System.out.println("Añada el nombre que quiera eliminar: ");
		String nombreElim = leerString();
		
		if(victorias.remove(nombreElim)==null) {
		System.out.println("No se ha borrado nada.");	
		}else {
			System.out.println("Contacto borrado correctamente.");
		}
	}
	public static void menu7(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- Mostrar total de partidas jugadas ---");
		
		int totalVictorias = 0;
		
		for (Map.Entry<String, Integer> valores : victorias.entrySet()) {
			
			totalVictorias+= valores.getValue();
			}
		System.out.println("El total de victorias es: "+totalVictorias);
	}
	public static void menu8(Map<String, Integer> victorias) throws IOException {
		System.out.println("--- No se hace :)---");
		
	}
	public static void menu9(Map<String, Integer> victorias) throws IOException {
		System.out.println("Comprobar si hay empate ");
		
		
	}
}
