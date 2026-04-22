package ejercicio6_Interfaces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void main(String[] args) throws IOException {

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		boolean salir = false;
		do {
			System.out.println("1. Guardar objetos libros al fichero");
			System.out.println("2. Leer los datos");

			System.out.print("Introduce una opción: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (IOException e) {
					System.err.println("Solo puedes introducir números.");
				}
			}

			switch (opcion) {
			case 1:
				opcion1();
				break;
			case 2:
				opcion2();
				break;
			case 3:
				System.out.println("Saliendo del programa. ¡Hasta pronto!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
			}

		} while (!salir);

	}

	private static void opcion1() throws IOException {
		ArrayList<Libro> libros = new ArrayList<>();

		Libro libro = new Libro();
		libro.pedirDatos();

		libros.add(libro);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		FileWriter fw = new FileWriter("libros.json", true);

		gson.toJson(libros, fw);
		fw.close();

	}
	
	private static void opcion2() throws IOException {
		
		Gson gson = new Gson();
		Type tipo = new TypeToken<ArrayList<Libro>> () {}.getType();

		try {
			FileReader fr = new FileReader("libros.json");
			ArrayList<Libro> listaLibros = gson.fromJson(fr, tipo);
			
			for(Libro l:listaLibros) {
				System.out.println(l.toString());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
