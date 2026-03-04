package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int suma = 0;
		int numInteracciones = 0;
		int media;
		
		while(numInteracciones<5) {
			System.out.println("Añada su nota: ");
			int numero = Integer.parseInt(leer.readLine());
			suma= suma +numero;
			numInteracciones++;
		}
		media= suma/5;
		System.out.println("Su media es: "+media);
		
		
		
		
	}

}
