package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class principal {

	public static void main(String[] args) throws IOException {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		do {
			System.out.println();
			System.out.println("== GESTION FACTURAS  ==");
			System.out.println("1. Crear factura:");
			System.out.println("2. Añadir concepto:");
			System.out.println("3. Ver desglose");
			System.out.println("4. Calcular total:");
			System.out.println("5. Factura más alta");
			System.out.println("6. Resumen contable:");
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
				menu1(facturas);
				break;
			case 2:
				menu2(facturas);
				break;
			case 3:
				menu3(facturas);
				break;
			case 4:
				menu4(facturas);
				break;
			case 5:
				menu5(facturas);
				break;
			case 6:
				menu6(facturas);
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

	public static void menu1(ArrayList<Factura> facturas) throws IOException {

		Factura f = new Factura();
		f.pedirDatos(facturas);
		facturas.add(f);

	}

	public static void menu2(ArrayList<Factura> facturas) throws IOException {
		int idBuscar = pedirID();
		boolean enc = false;
		for (Factura fac : facturas) {
			if (fac.getId() == idBuscar) {
				fac.añadirConceptoPrecio();
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado la factura");
		}
	}

	public static void menu3(ArrayList<Factura> facturas) throws IOException {
		int idBuscar = pedirID();
		boolean enc = false;
		for (Factura fac : facturas) {
			if (fac.getId() == idBuscar) {
				fac.mostrarDatos();
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado la factura");
		}
	}

	public static void menu4(ArrayList<Factura> facturas) throws IOException {
		int idBuscar = pedirID();
		boolean enc = false;
		for (Factura fac : facturas) {
			if (fac.getId() == idBuscar) {
				System.out.println("El importe total con el IVA es: " + fac.subtotalFInal());
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado la factura");
		}
	}

	public static void menu5(ArrayList<Factura> facturas) throws IOException {
		double FacturaAlta = -1;
		Factura clienteCaro = null;
		for (Factura fac : facturas) {
			if (fac.subtotalFInal() > FacturaAlta) {
				FacturaAlta = fac.subtotalFInal();
				clienteCaro = fac;
			}
		}
		if (clienteCaro != null) {
			System.out.println("--Imprimiendo resultados--");
			clienteCaro.mostrarDatos();
		}
	}

	public static void menu6(ArrayList<Factura> facturas) throws IOException {
		for (Factura fac : facturas) {
			System.out.println("--CLiente: " + fac.getCliente() + " - " + fac.subtotalFInal());
		}
	}

	public static int pedirID() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID de la factura para acceder: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		return idABuscar;
	}
}
