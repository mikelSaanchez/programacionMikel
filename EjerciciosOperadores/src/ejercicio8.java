import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su peso en libras ");
		int pesolibra = Integer.parseInt(leer.readLine());
		double pesokilo = pesolibra * 0.4535;
		System.out.println("Su peso en kilos es " + pesokilo );
		
		
		
		
		
		
		
		
		
		
		
	}

}
