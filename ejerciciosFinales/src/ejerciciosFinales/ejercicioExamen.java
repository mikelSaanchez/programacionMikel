package ejerciciosFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicioExamen {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int nota =0;
		
		while(nota<1|| nota>10) {
			System.out.println("Introduce una nota:");
			nota = Integer.parseInt(leer.readLine());
			if(nota<1||nota>10) {
				System.out.println("Nota no valida. Es entre 1-10");
			}
		}
		System.out.println("Nota valida");
	}

}
