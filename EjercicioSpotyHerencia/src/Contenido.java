import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Contenido {

	private int id;
	private String titulo;
	private int minutosDuracion;
	private String Categoria;
	private int reproducciones;
	private boolean playlist = false;

	public void pedirDatos(ArrayList<Contenido> contenidos) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		int idGenerado = -1;
		do {
			idGenerado = rand.nextInt(1000) + 1;
		} while (estaRepetido(contenidos, idGenerado));
		id = idGenerado;

		System.out.println("Introduce el título del contenido:");
		titulo = leer.readLine();

		do {
			System.out.println("Introduce la duración en minutos (1-180):");
			minutosDuracion = Integer.parseInt(leer.readLine());

			if (minutosDuracion < 1 || minutosDuracion > 180)
				System.out.println("El nivel tiene que estar entre 0 y 100");

		} while (minutosDuracion < 1 || minutosDuracion > 180);

		do {
			System.out.println("Introduce la categoría (música-podcast-audiolibro-meditación):");
			Categoria = leer.readLine();
			if ((!Categoria.equalsIgnoreCase("música") && !Categoria.equalsIgnoreCase("podcast")
					&& !Categoria.equalsIgnoreCase("audiolibro") && !Categoria.equalsIgnoreCase("meditación"))) {
				System.out.println("Introduce una opción válida");
			}

		} while ((!Categoria.equalsIgnoreCase("música") && !Categoria.equalsIgnoreCase("podcast")
				&& !Categoria.equalsIgnoreCase("audiolibro") && !Categoria.equalsIgnoreCase("meditación")));

		System.out.println("Introduce el número de reproducciones totales:");
		reproducciones = Integer.parseInt(leer.readLine());
	}

	private boolean estaRepetido(ArrayList<Contenido> contenidos, int idGenerado) {

		for (int i = 0; i < (contenidos.size() - 1); i++) {

			if (contenidos.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "Contenido [id=" + id + ", titulo=" + titulo + ", minutosDuracion=" + minutosDuracion + ", Categoria="
				+ Categoria + ", reproducciones=" + reproducciones + " ]";
	}

	public String getCategoria() {
		return Categoria;
	}

	public boolean isPlaylist() {
		return playlist;
	}

	public void setPlaylist(boolean playlist) {
		this.playlist = playlist;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
