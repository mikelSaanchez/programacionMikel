package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio41 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));	
		int numeroPositico = 0;
		int numeroNegativo = 0;
		int cero= 0;
		for(int i= 0; i<=20;i++) {
			System.out.println("Añada un numeros por:");
			int num= Integer.parseInt(leer.readLine());
			if(num>0) {
				System.out.println("Su numero es positivo");
				numeroPositico++;
			}else if(num<0) {
				System.out.println("Su numero es negativo");
				numeroNegativo++;
			}else {
				System.out.println("Su numero es nulo");
				cero++;
			}
				
		}
		System.out.println("Hay "+numeroPositico+ " numeros positivos");
		System.out.println("Hay "+numeroNegativo+ " numeros negativos");
		System.out.println("Hay "+cero+ " numeros nulos");
	}

}
