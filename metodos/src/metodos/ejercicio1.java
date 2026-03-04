package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {
	static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		System.out.println("Introduce tu nombre: ");
		String nom= leer.readLine();
		saludo(nom);
	}

	public static void saludo(String nombre) {
	System.out.println("Hola ,"+nombre);
}

}
