package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añade un numero");
		int N=Integer.parseInt(leer.readLine());
		int numeroActual=0;
		
		while(numeroActual<N) {
			
			if(numeroActual%5==0) {
				System.out.println(numeroActual+"Es multiplo de 5 ");
			}
			numeroActual++;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
