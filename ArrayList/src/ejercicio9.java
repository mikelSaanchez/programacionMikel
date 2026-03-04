import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ejercicio9 {
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
	ArrayList <String> canciones = new ArrayList<>();
		
		boolean salir = false;
		do {
		try {
		System.out.println();
		System.out.println("-------TAREAS PENDIENTES-------");
		System.out.println();
		System.out.println("1. Añadir canción al final");
		System.out.println("2. Añadir canción al inicio de la playlist");
		System.out.println("3. Mostrar todas las canciones (numeradas desde 1)");
		System.out.println("4. Eliminar canción por posición");
		System.out.println("5. Buscar canción por nombre");
		System.out.println("6. Mover una canción a otra posición (pedir posición origen y destino)");
		System.out.println("7. Mostrar la primera y última canción de la playlist");
		System.out.println("8. Mostrar total de canciones");
		System.out.println("9. Shuffle (mezclar aleatoriamente - usar Collections.shuffle() )");
		System.out.println("10. Eliminar canciones duplicadas");
		System.out.println("11. Salir");
		System.out.println();
		System.out.print("Elige una opción: ");
		int opcion = leerInt();
		switch (opcion) {
		case 1:
			menu1(canciones);
		break;
		case 2:
			menu2(canciones);
		break;
		case 3:
			menu3(canciones);
		break;
		case 4:
			menu4(canciones);
		break;
		case 5:
			menu5(canciones);
		break;
		case 6:
			menu6(canciones);
		break;
		case 7:
			menu7(canciones);
		break;
		case 8:
			menu8(canciones);
		break;
		case 9:
			menu9(canciones);
		break;
		case 10:
			menu10(canciones);
		break;
		case 11:
			salir = true;
			System.out.println("¡Saliendo!");
		break;
			}
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Introduce numero, no letras.");
		}
		}while(!salir);
	}
	public static void menu1(ArrayList <String> canciones) throws IOException {
		System.out.println("---Añadir canción al final---");
		System.out.println("Añada la cancion que quiera añadir, al final: ");
		String cancion = leerString();
		canciones.add(cancion);		
		}
	public static void menu2(ArrayList <String> canciones) throws IOException {
		System.out.println("---Añadir canción al inicio de la playlist---");
		System.out.println("Añada la cancion que quiera añadir al principio: ");
		String cancion = leerString();
		canciones.add(0,cancion);
		}
	public static void menu3(ArrayList <String> canciones) throws IOException {
		System.out.println("--- Mostrar todas las canciones---");
		for(int i = 0; i<canciones.size();i++) {
			System.out.println((i+1)+" "+canciones.get(i));
		}
	}
	public static void menu4(ArrayList <String> canciones) throws IOException {
		System.out.println("---Eliminar canción por posición---");
		int pos =-1;
		do {
		System.out.println("Posicion que quiera borrar: ");
		 pos = leerInt();
		}while(pos<0 && pos > canciones.size());
		canciones.remove(pos);
		}
	public static void menu5(ArrayList <String> canciones) throws IOException {
		System.out.println("---Buscar canción por nombre---");
		System.out.println("Añada la cancion que quiera buscar: ");
		String canBuscar = leerString();
		
		if(canciones.contains(canBuscar)) {
			for(int i = 0;i<canciones.size();i++) {
				if(canciones.get(i).equalsIgnoreCase(canBuscar)) {
					System.out.println("La cancion esta en la posicion: "+i);
				}
			}
		}else {
			System.out.println("Su cancion no la tiene.");
		}		
	}
	public static void menu6(ArrayList <String> canciones) throws IOException {
		System.out.println("---Mover una canción a otra posición---");
		int pos1 =-1;
		do {
		System.out.println("Posicion que quiera borrar: ");
		 pos1 = leerInt();
		}while(pos1<0 && pos1 > canciones.size());
		
		int pos2 =-1;
		do {
		System.out.println("Posicion que quiera borrar: ");
		pos2 = leerInt();
		}while(pos2<0 && pos2 > canciones.size());
		

		System.out.println(canciones);
		Collections.swap(canciones, pos1, pos2);
		System.out.println(canciones);
	}
	public static void menu7(ArrayList <String> canciones) throws IOException {
		System.out.println("--- Mostrar la primera y última canción de la playlist---");
		System.out.println("La primera cancion es: "+canciones.getFirst());
		System.out.println("La ultima cancion es: "+canciones.getLast());
	}
	public static void menu8(ArrayList <String> canciones) throws IOException {
		System.out.println("---Mostrar total de canciones---");
		System.out.println("El total de canciones es: "+canciones.size());
		
	}
	public static void menu9(ArrayList <String> canciones) throws IOException {
		System.out.println("---Shuffle---");
		System.out.println("Canciones normales");
		System.out.println(canciones);
		
		Collections.shuffle(canciones); 
		System.out.println("Canciones mezcladas");
		System.out.println(canciones);
	}
	public static void menu10(ArrayList<String> canciones) {
		System.out.println("---Eliminar canciones duplicadas---");
		
		ArrayList <String> cancioneSinDuplicado = new ArrayList<>();
		
		for(String c : canciones) {
			
			if(!cancioneSinDuplicado.contains(c)) {
				cancioneSinDuplicado.add(c);
			}
			
		}
		canciones=cancioneSinDuplicado;
	}
}
