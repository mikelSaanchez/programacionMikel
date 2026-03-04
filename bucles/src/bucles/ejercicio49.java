package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio49 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dime un numero:");
		int numero = Integer.parseInt(leer.readLine());
			
	 
		int contador = 1;
		for(int i= 0;i<numero;i++) {
			for(int j = 0;j<contador;j++) {
				System.out.print(contador);
			}
			contador++;
			System.out.println();
			
		}
		
		
		
	}

}
