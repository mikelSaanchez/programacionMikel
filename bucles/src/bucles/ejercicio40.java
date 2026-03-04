package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio40 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int sumaPares=0;
		int sumaImpares=0;
		int numPares=0;
		int numImpares=0;
		double media=0;	
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i<10; i++) {
			System.out.println("Añada un numero");
			int num = Integer.parseInt(leer.readLine());
			if(num % 2 == 0) {
				sumaPares=sumaPares+num;
				numPares++;
				System.out.println(" Su numero es par");
			}else {
				sumaImpares=sumaImpares+num;
				numImpares++;
				System.out.println(" Su numero es impar");	
			}
		}
		System.out.println("La suma de los impares es:"+sumaImpares);
		System.out.println("La suma de los pares es:"+sumaPares);
		media = sumaImpares/numImpares;
		System.out.println("La media de los impares es:"+media);
	}

}
