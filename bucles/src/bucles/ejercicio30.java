package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio30 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

	BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	int numero;
	int numMayor; 
	int sumaFallados = 0; 
	int totalNum= 0;
	System.out.println("Introduzca numero inicial: ");
	numero= Integer.parseInt(leer.readLine());
	numMayor=numero;
	while(numero != 0) {
		if(numMayor>numero) {
			sumaFallados++;
			System.out.println("Fallo menor.");
		}else {
			numMayor = numero;
		}
		totalNum++;
		System.out.println("Introduzca un numero:");
		numero=Integer.parseInt(leer.readLine());
	}
		System.out.println("Numero fallados: "+sumaFallados);
		System.out.println("Total de numeros introducidos"+totalNum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
