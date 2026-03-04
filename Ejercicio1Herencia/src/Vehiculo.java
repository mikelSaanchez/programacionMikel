import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vehiculo {

	private int id;
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private double precio;

	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		this.id = id;

		System.out.println("Introduce la marca: ");
		marca = leer.readLine();
		System.out.println("Introduce el modelo: ");
		modelo = leer.readLine();
		System.out.println("Introduce el año de fabricacion: ");
		añoFabricacion = Integer.parseInt(leer.readLine());
		System.out.println("Introduce el precio: ");
		precio = Double.parseDouble(leer.readLine());
	}
	
	public void mostrarDatos() {
		System.out.println("Vehiculo ID: "+id);
		System.out.println("--------------------");
		System.out.println("Marca: "+marca);
		System.out.println("Modelo: "+modelo);
		System.out.println("Año de fabricacion: "+añoFabricacion);
		System.out.println("Precio: "+precio);
	}
	
}
