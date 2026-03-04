package metodos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {
public static int multiplicacion (int a, int b) {
	return a*b;
	
}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce numero: ");
		int num = Integer.parseInt(leer.readLine());
		System.out.println("Introduce numero: ");
		int num1 = Integer.parseInt(leer.readLine());
		int resultado = multiplicacion(num,num1);
		System.out.println("El resultado es: "+resultado);
	}

}
