package ejercicio3Ficheros;

import java.util.ArrayList;

public class videoJuego {

	private String nombre;
	private ArrayList<Integer> notas;

	public videoJuego(String nombre) {
		this.nombre = nombre;
		notas = new ArrayList<Integer>();

	}

	public void añadirNota(int nota) {
		notas.add(nota);
	}
	
	public double calcularMedia() {
		int suma = 0;
		for(int nota:notas) {
			suma+= nota;
		}
		double notaMeida = suma / notas.size();
		return notaMeida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Integer> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}

}
