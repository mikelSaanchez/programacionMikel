import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada el radio de la circunferencia ");
		int radio = Integer.parseInt(leer.readLine()); 
		double pi = 3.141592;	
		double area = pi *(radio * radio); 
		double circunferencia = (2 * pi * radio); 
		System.out.println(area);
		 System.out.println(circunferencia);
		
		
		
		
		
		
	}

}
