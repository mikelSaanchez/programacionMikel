package ejercicio1_FicherosBinarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("1. Añadir un nuevo producto al fichero");
			System.out.println("2. Mostrar por pantalla todos los productos");
			System.out.println("3. Calcular y mostrar el valor total del inventario");
			System.out.println("4. Salir");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números.");
				}
			}
			
			switch (opcion) {
			case 1:
				opcion1();
				break;
			case 2:

				break;
			case 3:

				break;
					
			case 4:
				System.out.println("Saliendo del programa. ¡Hasta pronto!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
			}

		} while (!salir);
			
	}

	private static void opcion1() throws FileNotFoundException {

		TiendaDeportes tienda = new TiendaDeportes();
		tienda.pedirDatos();
		tienda.guardar();

	}
}
