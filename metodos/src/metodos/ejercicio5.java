package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static boolean par (int a) {
	if(a % 2 == 0 ) {
		return true;
	}else {
		return false;
	}	
	
}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un numero : ");
		int num = Integer.parseInt(leer.readLine());
		boolean resultado = par(num);
		System.out.println(resultado);
	}

}
