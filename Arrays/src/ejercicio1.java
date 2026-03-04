import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int [] numero = new int [10];
		
		for(int i = 0; i<numero.length;i++) {
		System.out.println("Introduce el numero "+(i+1)+": " );
			numero[i]=leerInt();
		}
		System.out.println("EL numero 1 es: "+numero[0]);
		System.out.println("El numero 2 es: "+numero[numero.length-1]);
	}
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
