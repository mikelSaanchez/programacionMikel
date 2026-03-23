package ejercicio1_FicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TiendaDeportes {

	private int id;
	private String nombre;
	private double precio;
	private int stockDisponible;

	public void pedirDatos() {

		id = Lecturas.leerEntero("Introduce el id: ");
		nombre = Lecturas.leerString("Introduce el nombre:");
		precio = Lecturas.leerDouble("Introduce el precio:");
		stockDisponible = Lecturas.leerEnteroMayorQue("Introduce el stock:", 0);

	}

	public void guardar() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("inventario.dat", false);
		DataOutputStream ds;
		try {
			ds = new DataOutputStream(fos);

			ds.writeInt(id);
			ds.writeUTF(nombre);
			ds.writeDouble(precio);
			ds.writeInt(stockDisponible);

			fos.close();
			ds.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
