import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int [] numero = new int [8];
		
		for(int i = 0; i<numero.length;i++) {
		System.out.println("Introduce el numero "+(i+1)+": " );
			numero[i]=leerInt();
		}
		for(int i = 0; i<numero.length;i++) {
			System.out.println(numero[i]+" ");
		}
	}
	public static int leerInt() throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(leer.readLine());
		return num;
	}
}
