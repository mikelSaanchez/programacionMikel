package ejercicio15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Factura {

	private int id;
	private String cliente;
	private String[] conceptos = new String[5];
	private double[] importes = new double[5];
	private int numConceptos;
	private final double iva = 0.21;

	public void pedirDatos(ArrayList<Factura> facturas) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		id = 1;
		if (facturas.size() > 0) {
			id = facturas.getLast().getId() + 1;
		}

		System.out.println("Introduce el nombre del cliente:");
		cliente = leer.readLine();
		System.err.println("El id de la factura es: " + id);

	}

	public void añadirConceptoPrecio() {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numConceptos >= conceptos.length - 1)
			System.out.println("No se puede anadir mas conceptos.");
		else {
			try {
				System.out.println("Introduce el concepto:");
				conceptos[numConceptos] = leer.readLine();
				System.out.println("Introduce el importe:");
				importes[numConceptos] = Integer.parseInt(leer.readLine());
				numConceptos++;
			} catch (NumberFormatException | IOException e) {
				System.out.println("Introduce un concepto valido.");
			}
		}
	}

	public double subtotal() {
		double importeTotal = 0;
		if (numConceptos < conceptos.length) {
			for (int i = 0; i < importes.length; i++) {
				importeTotal += importes[i];
			}
		}
		return importeTotal;
	}

	public double subtotalIva() {

		return subtotal() * iva;
	}

	public double subtotalFInal() {

		return subtotal() + subtotalIva();
	}

	public void mostrarDatos() {
		System.out.println(" ---- MOSTRANDO FACTURA " + id + " ---- ");
		System.out.println("Cliente: " + cliente);
		System.out.println(" ---------------------");

		for (int i = 0; i < numConceptos; i++) {
			System.out.println("\t-" + conceptos[i] + ": " + importes[i] + "€");
		}
		System.out.println("------------");
		System.out.println("Total +IVA: " + subtotalFInal());
	}

	public int getId() {
		return id;
	}

	public String getCliente() {
		return cliente;
	}

}
