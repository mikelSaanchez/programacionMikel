package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio12 {
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Introduce un numero: ");
		int n = leerInt();
		System.out.println(sumaNumeros(n));
	}
	public static int sumaNumeros(int num) {
		if(num == 1) {
			return 1;
		}else{
		return num+sumaNumeros(num-1);
		}
		
	}
}
