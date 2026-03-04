package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio33 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada una palabra");
		String palabra=leer.readLine();
		boolean esPalindromo = true;
		for(int i = 0; i<palabra.length()/2;i++) {
			if(palabra.charAt(i)!=palabra.charAt(palabra.length()-1-i)) {
				System.out.println("No es palindromo");
				esPalindromo=false;
			}
		}
		if(esPalindromo) {
			System.out.println(palabra +" es palindromo");
		}
	}

}
