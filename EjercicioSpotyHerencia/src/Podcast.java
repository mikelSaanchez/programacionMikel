import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Podcast extends Contenido {

	private String presentador;
	private int numeroEpisodio;
	private char transcripcion;
	private boolean tieneTrascripcion = false;

	public void pedirDatos(ArrayList<Contenido> contenidos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(contenidos);
		System.out.println("Introduce el nombre del presentador:");
		presentador = leer.readLine();

		System.out.println("Introduce el número de episodio:");
		numeroEpisodio = Integer.parseInt(leer.readLine());

		System.out.println("¿Tiene transcripción disponible? (S/N):");
		transcripcion = leer.readLine().toUpperCase().charAt(0);

		if (transcripcion == 'S') {
			tieneTrascripcion = true;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Podcast [presentador=" + presentador + ", numeroEpisodio=" + numeroEpisodio
				+ ", transcripcion=" + transcripcion + ", tieneTrascripcion=" + tieneTrascripcion + "]";
	}

}
