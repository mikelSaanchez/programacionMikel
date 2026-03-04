import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Coche> coches = new ArrayList<>();
		ArrayList<Moto> motos = new ArrayList<>();

		boolean salir = false;
		do {
			System.out.println("1. Añadir Coche:");
			System.out.println("2. Añadir Moto:");
			System.out.println("3. Mostrar todos los coches.");
			System.out.println("4. Mostrar todas las motos");
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
				menu1(coches);
				break;
			case 2:
				menu2(motos);
				break;
			case 3:
				menu3(coches);
				break;
			case 4:
				menu4(motos);
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

	private static void menu1(ArrayList<Coche> coches) throws IOException {
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Introduce los datos del coche " + (i + 1) + " :");
			Coche c = new Coche();
			c.pedirDatos(i + 1);
			coches.add(c);
		}

	}

	private static void menu2(ArrayList<Moto> motos) throws IOException {
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Introduce los datos de la Moto " + (i + 1) + " :");
			Moto m = new Moto();
			m.pedirDatos(i + 1);
			motos.add(m);
		}
	}

	private static void menu3(ArrayList<Coche> coches) throws IOException {

		for (Coche c : coches) {
			c.mostrarDatos();
		}
	}

	private static void menu4(ArrayList<Moto> motos) throws IOException {
		
		for (Moto m : motos) {
			m.mostrarDatos();
		}
	}
}
