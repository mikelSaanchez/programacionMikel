import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Contenido> contenidos = new ArrayList<Contenido>();

		boolean salir = false;
		do {
			System.out.println("\n=== SPOTY ===");
			System.out.println("Opción 1: Añadir contenido");
			System.out.println("Opción 2: Mostrar contenido por categoría");
			System.out.println("Opción 3: Añadir contenido a playlist");
			System.out.println("Opción 4: Estadísticas del perfil");
			System.out.println("Opción 5: Salir");
			System.out.print("¿Qué desea consultar?: ");

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
				System.out.println("=== Añadir contenido ===");
				añadirContenido(contenidos);
				break;
			case 2:
				System.out.println("=== Mostrar contenido por categoría ===");
				mostrarContenido(contenidos);
				break;
			case 3:
				System.out.println("=== Añadir contenido a playlist ===");
				añadirContenidoPlaylist(contenidos);
				break;
			case 4:
				System.out.println("=== Estadísticas del perfil ===");
				estadisticas(contenidos);
				break;
			case 5:
				System.out.println("¡Saliendo!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);

	}

	private static void añadirContenido(ArrayList<Contenido> contenidos) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("¿Cuántos contenidos desea añadir?: ");
		int contenidosAñadir = Integer.parseInt(leer.readLine());

		for (int i = 0; i < contenidosAñadir; i++) {
			System.out.println("Añadiendo contenido " + (i + 1) + " de " + contenidosAñadir);
			String tipoContenido = "";
			do {
				System.out.println("Tipo de contenido (Cancion o Podcast): ");
				tipoContenido = leer.readLine();
				if ((!tipoContenido.equalsIgnoreCase("Cancion") && !tipoContenido.equalsIgnoreCase("podcast"))) {
					System.out.println("Introduce una opción válida");
				}
			} while ((!tipoContenido.equalsIgnoreCase("Cancion") && !tipoContenido.equalsIgnoreCase("podcast")));

			if (tipoContenido.equalsIgnoreCase("Cancion")) {
				Cancion c = new Cancion();
				c.pedirDatos(contenidos);
				contenidos.add(c);
			} else {
				Podcast c = new Podcast();
				c.pedirDatos(contenidos);
				contenidos.add(c);
			}
		}
	}

	private static void mostrarContenido(ArrayList<Contenido> contenidos) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoContenido = "";
		do {
			System.out.println("Introduce la categoría (música-podcast-audiolibro-meditación):");
			tipoContenido = leer.readLine();
			if ((!tipoContenido.equalsIgnoreCase("música") && !tipoContenido.equalsIgnoreCase("podcast")
					&& !tipoContenido.equalsIgnoreCase("audiolibro")
					&& !tipoContenido.equalsIgnoreCase("meditación"))) {
				System.out.println("Introduce una opción válida");
			}

		} while ((!tipoContenido.equalsIgnoreCase("música") && !tipoContenido.equalsIgnoreCase("podcast")
				&& !tipoContenido.equalsIgnoreCase("audiolibro") && !tipoContenido.equalsIgnoreCase("meditación")));

		for (Contenido c : contenidos) {
			if (c.getCategoria().equalsIgnoreCase(tipoContenido)) {
				System.out.println(c.toString());
			}
		}
	}

	private static void añadirContenidoPlaylist(ArrayList<Contenido> contenidos) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		String [] playList = new String [15];
		int tamañoPlayList = 0;
		System.out.println("Introduce el título del contenido a añadir a la playlist:");
		String tituloABuscar = leer.readLine();
		for (Contenido c : contenidos) {
			if(c.getTitulo().equalsIgnoreCase(tituloABuscar)) {
				System.out.println("Este contenido ya esta en su playlist");
			}else {
				
				System.out.println("Contenido añadido correctamente a la playlist");
				for(int i = 0; i<tamañoPlayList;i++) {
					
					c.setPlaylist(true);
						
					
				}
			}
		}
		
		
	}
	private static void estadisticas(ArrayList<Contenido> contenidos) throws NumberFormatException, IOException {
		
	}
	
}
