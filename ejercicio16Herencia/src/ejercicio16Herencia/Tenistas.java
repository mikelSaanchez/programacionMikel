package ejercicio16Herencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tenistas extends Deportistas {

	private int posRanking;
	private ArrayList<String> historialtorneos = new ArrayList<String>();

	public void pedirDatos(ArrayList<Deportistas> deportistas) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		super.pedirDatos(deportistas);

		System.out.println("Introduce el ranking :");
		posRanking = Integer.parseInt(leer.readLine());

		for (int i = 0; i < historialtorneos.size(); i++) {
			System.out.println("Introduce los torneos ganados:");

		}
	}

	public void añadirTorneo() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (historialtorneos.size() < 10) {
			System.out.println("Introduce el nombre del nuevo torneo ganado: ");
			historialtorneos.add(leer.readLine());
			System.out.println("Torneo añadido");
		} else {
			System.out.println("No se puede añadir el torneo por que hay 10");
		}
	}

	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("----------");
		System.out.println("Posicion del Ranking" + this.posRanking);
		for (String torneo : historialtorneos) {
			System.out.println("Categoria" + torneo);
		}
	}

	public int getPosRanking() {
		return posRanking;
	}

}
