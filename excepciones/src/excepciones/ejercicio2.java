package excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean salir = false;
		while(!salir) {
		try {
		System.out.println("Introduce una palabra: ");
		String palabra = leer.readLine();
		System.out.println("Introduce una posicion: ");
		int posicion =Integer.parseInt(leer.readLine());
		System.out.println("El caracter en esa posion es: "+palabra.charAt(posicion));
		salir = true;
		}catch(IOException  | NumberFormatException e) {
			System.out.println("Has introducido letras");
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("No exsiste ese caracter en la palabra,");
		}
		}
	}

}
