import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Pokedex> pokemons = new ArrayList<Pokedex>();

		boolean salir = false;
		do {
			System.out.println("\n=== POKÉDEX DEL PROFESOR OAK ===");
			System.out.println("1. ¿¡Hazte con todos!? (Registrar nuevo Pokémon)");
			System.out.println("2. ¿Dónde están los de mi tipo? (Buscar Pokémon por tipo)");
			System.out.println("3. ¡Pikachu, usa POO! (Enseñar ataque)");
			System.out.println("4. ¡El Equipo Rocket gana! (Salir)");
			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== REGISTRAR NUEVO POKÉMON ===");
				menu1(pokemons);
				break;
			case 2:
				System.out.println("=== BUSCAR POKÉMON POR TIPO ===");
				menu2(pokemons);
				break;
			case 3:
				System.out.println("=== ENSEÑAR ATAQUE ===");
				menu3(pokemons);
				break;
			case 4:
				System.out.println("¡El Equipo Rocket ha robado tu código! ¡Wobbuffet!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}

		} while (!salir);
	}

	private static void menu1(ArrayList<Pokedex> pokemons) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean parar = false;
		while (parar == false) {
			pokemons.add(new Pokedex());
			pokemons.getLast().pedirDatos(pokemons);
			System.out.println("¿Desea introducir otro Pokemon? (S/N)");
			char opcion1 = leer.readLine().toUpperCase().charAt(0);
			if (opcion1 == 'N') {
				parar = true;
			}
		}
	}

	private static void menu2(ArrayList<Pokedex> pokemons) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String tipoAbuscar;
		do {
			System.out.println("Introduce el tipo a buscar: ");
			tipoAbuscar = leer.readLine();

		} while (!tipoAbuscar.equalsIgnoreCase("fuego") && !tipoAbuscar.equalsIgnoreCase("agua")
				&& !tipoAbuscar.equalsIgnoreCase("planta") && !tipoAbuscar.equalsIgnoreCase("eléctrico"));

		for (Pokedex p : pokemons) {
			if (tipoAbuscar.equalsIgnoreCase("fuego") && tipoAbuscar.equalsIgnoreCase("agua")
					&& tipoAbuscar.equalsIgnoreCase("planta") && tipoAbuscar.equalsIgnoreCase("eléctrico")) {
				p.mostrarDatos();
			}
		}
	}

	private static void menu3(ArrayList<Pokedex> pokemons) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del pokemon a añadir un ataque: ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		boolean enc = false;
		for (Pokedex p : pokemons) {
			if (p.getId() == idABuscar) {
				p.amadirAtaque();
				enc = true;
				if (p.amadirAtaque() == false) {
					System.out.println("ERROR: ya conoce 4 ataques. No puede aprender más.");
				} else {
					System.out.println("Su pokemon a aprendido el ataque!");
				}
			}
		}

		if (!enc) {
			System.out.println("No se ha encontrado el pokemon");
		}

	}
}