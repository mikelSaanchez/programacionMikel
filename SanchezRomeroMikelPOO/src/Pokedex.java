import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pokedex {

	private int id;
	private String nombre;
	private String tipo;
	private int ps;
	private int nivel;
	private String[] ataques = new String[4];
	private int numAtaques;
	 
	public void pedirDatos(ArrayList<Pokedex> pokemon) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Introduce el número de Pokédex (1-1025):");
			id = Integer.parseInt(leer.readLine());

			if (id < 0 || id > 1025)
				System.out.println("El id tiene que estar entre 0 y 1025.");
			if (estaRepetido(pokemon, id) == true) {
				System.out.println("ERROR: Ya existe un Pokémon con el ID " + id + " en la Pokédex.");
			}
		} while (id < 0 || id > 1025 || estaRepetido(pokemon, id) == true);

		System.out.println("Introduce el nombre:");
		nombre = leer.readLine();

		do {
			System.out.println("Introduce el tipo:");
			tipo = leer.readLine();
			if ((!tipo.equalsIgnoreCase("fuego") && !tipo.equalsIgnoreCase("agua") && !tipo.equalsIgnoreCase("planta")
					&& !tipo.equalsIgnoreCase("eléctrico"))) {
				System.out.println(
						"ERROR: El tipo todavía no ha sido añadido.\r\n" + "Solo fuego, agua, planta o eléctrico");
			}

		} while (!tipo.equalsIgnoreCase("fuego") && !tipo.equalsIgnoreCase("agua") && !tipo.equalsIgnoreCase("planta")
				&& !tipo.equalsIgnoreCase("eléctrico"));

		do {
			System.out.println("Introduce el nivel (1-100):");
			nivel = Integer.parseInt(leer.readLine());

			if (nivel < 0 || nivel > 100)
				System.out.println("El nivel tiene que estar entre 0 y 100");

		} while (nivel < 0 || nivel > 100);

		System.out.println("Introduce los PS:");
		ps = Integer.parseInt(leer.readLine());

	}

	private boolean estaRepetido(ArrayList<Pokedex> pokemons, int idGenerado) {

		for (int i = 0; i < (pokemons.size() - 1); i++) {

			if (pokemons.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void mostrarDatos() {
		System.out.println("ID: " + id + " | " + nombre);
		System.out.println("Nivel: " + nivel + " | PS:" + ps);
		System.out.println("Ataques: " + ataques);
		System.out.println(nivelAlto());

	}

	public boolean amadirAtaque() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		if (numAtaques >= ataques.length - 1) {
			System.out.println("No se puede anadir mas ataques a ese pokemon");
			return false;
		} else {

			do {
				System.out.println("Pokémon encontrado: " + nombre);
				System.out.println("Introduce el nombre del nuevo ataque: ");
				ataques[numAtaques] = leer.readLine();
			} while (numAtaques >= 4);
			numAtaques++;
			return true;
		}
	}

	private String nivelAlto() {
		if (nivel > 50) {
			return "Estado: ¡Pokemon fuerte!";
		}
		return "Estado: Le queda por mejorar";
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getNivel() {
		return nivel;
	}

	public int getNumAtaques() {
		return numAtaques;
	}

}
