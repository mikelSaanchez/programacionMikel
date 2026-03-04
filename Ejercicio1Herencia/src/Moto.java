import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moto extends Vehiculo {

	private int cilindradas;

	public void pedirDatos(int id) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(id);

		System.out.println("Añada las cilindradas: ");
		cilindradas = Integer.parseInt(leer.readLine());
	}
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Cilindradas: "+cilindradas);
	}
}
