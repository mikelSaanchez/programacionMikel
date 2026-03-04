package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio28 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		
		char seguirPrograma;
		int numeroMayor=0;
		int numeroMenor=999999;
		do {
			System.out.println("Añada un numero: ");
			int num = Integer.parseInt(leer.readLine());
			if(numeroMenor>num) {
				numeroMenor=num;
			}
			if(num>numeroMayor) {
				numeroMayor=num;
			}
			System.out.println("Desea seguir:(s/n) ");
			seguirPrograma =leer.readLine().charAt(0);
		
		}while(seguirPrograma != 'n');
		
		System.out.println("El numero menor es: "+numeroMenor+" y el numero mayor es:  "+numeroMayor);
	}


}


