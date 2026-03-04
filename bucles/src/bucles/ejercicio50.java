package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio50 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Dime un número:");
		int num = Integer.parseInt(leer.readLine());
		System.out.println("Dime otro número mayor al anterior:");
		int num1 = Integer.parseInt(leer.readLine());
		int numerosPares=0;
		for(int i = num;i<=num1;i++) {
			System.out.println(i);		
				if(i % 2 == 0) {
					numerosPares++;
				}
		}
		System.out.println("La cantidad de pares son:"+ numerosPares);
		
	}

}
