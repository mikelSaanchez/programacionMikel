import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		double [] numero = new double [6];
		double totalNumeros = 0;
		for(int i = 0; i<numero.length;i++) {
		System.out.println("Introduce el numero "+(i+1)+": " );
			numero[i]=Double.parseDouble(leer.readLine());
			totalNumeros += numero[i];
				}
		System.out.println(totalNumeros);
	}
}
