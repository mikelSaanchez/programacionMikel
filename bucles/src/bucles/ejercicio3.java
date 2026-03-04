package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		int numero=0;
		
		do {
			System.out.println("Añada un numero: ");
			numero=Integer.parseInt(leer.readLine());
			if(numero % 2 ==0) { 
				System.out.println("Multiplo de 2");
				if(numero % 3 ==0) 
					System.out.println("Multiplo de 3");
					if(numero % 2 ==0) 
						System.out.println("Multiplo de 5");
						}
			}
		while(numero!=0);
			
		
				
	}		
}
	



