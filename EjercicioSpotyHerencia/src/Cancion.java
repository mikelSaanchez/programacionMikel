import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Cancion extends Contenido {

	private String artista;
	private int numeroStreams;
	private int añolanzamiento;

	public void pedirDatos(ArrayList<Contenido> contenidos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		super.pedirDatos(contenidos);
		System.out.println("Introduce el nombre del artista:");
		artista = leer.readLine();

		System.out.println("Introduce el número de streams globales: ");
		numeroStreams = Integer.parseInt(leer.readLine());

		do {
			System.out.println("Introduce el año de lanzamiento (1950-2025):");
			añolanzamiento = Integer.parseInt(leer.readLine());

			if (añolanzamiento < 1950 || añolanzamiento > 2025)
				System.out.println("El nivel tiene que estar entre 1950 y 2025");

		} while (añolanzamiento < 1950 || añolanzamiento > 2025);
	}

	public String toString() {
		return super.toString() + "Cancion [artista=" + artista + ", numeroStreams=" + numeroStreams
				+ ", añolanzamiento=" + añolanzamiento + "]";
	}

}
