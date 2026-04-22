package ejercicio6_Interfaces;

public class Libro {

	private String libro;
	private String autor;

	public void pedirDatos() {
		libro = Lecturas.leerString("Añada el titulo");
		autor = Lecturas.leerString("Añada el autor");
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [libro=" + libro + ", autor=" + autor + "]";
	}



}
