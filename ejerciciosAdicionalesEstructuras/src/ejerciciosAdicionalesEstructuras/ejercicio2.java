package ejerciciosAdicionalesEstructuras;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su contraseña:");
		String contraseña = leer.readLine();
		System.out.println("contiene número S/N");
		char numero = leer.readLine().charAt(0);
		System.out.println("contiene Mayuscula S/N");
		char mayus = leer.readLine().charAt(0);
		contraseña.length();
		
		
		
		
	if(contraseña.length()>=8){
		if(numero=='s'&& mayus=='s') {
			System.out.println("Contraseña valida");
		}else if(numero=='n'&& mayus=='n') {
			System.out.println("Contraseña invalida");
		}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
