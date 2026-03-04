import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <Double> nums = new ArrayList<>();
		
		for(int i = 0;i<8;i++) {
			System.out.println("Añada numeros: ");
			double n = Double.parseDouble(leer.readLine());
			nums.add(n);
		}
		
		System.out.println("Que numero quieres buscar: ");
		double numBuscar = Double.parseDouble(leer.readLine());
		
		if(	nums.contains(numBuscar)==true) {
			System.out.println("Su numero si que esta.");
		}else {
			System.out.println("Su numero no esta.");
		}
		

	}

}
