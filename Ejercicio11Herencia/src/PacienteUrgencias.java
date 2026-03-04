import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PacienteUrgencias extends Paciente {

	private int gravedad;
	private String[] historial = new String[5];
	private int numTratamiento;

	public void pedirDatos(int id) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(id);

		do {
			System.out.println("Añada la gravedad del paciente(1-5): ");
			gravedad = Integer.parseInt(leer.readLine());

			if (gravedad < 1 || gravedad > 5) {
				System.out.println("Tiene que ser un numero del 1 al 5.");
			}
		} while (gravedad < 1 || gravedad > 5);

		for (int i = 0; i < historial.length; i++) {
			System.out.println("Añada el historial " + (i + 1) + " :");
			historial[i] = leer.readLine();
		}
	}

	public boolean añadirTratamiento() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numTratamiento < 5) {
			System.out.println("Introdue el tratamiento " + numTratamiento);
			historial[numTratamiento] = leer.readLine();
			numTratamiento++;
			return true;
		} else {
			return false;
		}
	}

	public int getGravedad() {
		return gravedad;
	}

	public void mostrarDatos() {
		super.mostrarDatos();

		System.out.println("Gravedad: " + this.gravedad);

		for (String tratamiento : historial) {
			System.out.print(tratamiento + " ");
		}

		System.out.println("");
		System.out.println("----------------------------");

	}

}
