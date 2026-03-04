package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio13 {
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Añada un numero: ");
		int num = leerInt();
		System.out.println(cuentaAtras(num));
	}
	public static int cuentaAtras (int num) {
		
		if(num==1) {
			return 1;
		}else {
			System.out.println(num);
			return(cuentaAtras(num-1));
		}		
	}
}
