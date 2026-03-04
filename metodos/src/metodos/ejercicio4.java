package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static int multiplicacion (int a, int b) {
		return a*b;
	
}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un numero que quiera multiplicar: ");
		int num = Integer.parseInt(leer.readLine());
		
		for(int i = 0; i<10;i++) {
			int resultado = multiplicacion(num,i);
				System.out.println("El resultado de "+num+" * "+i+" es: "+resultado);
			}
		
		
	
	
	}

}
