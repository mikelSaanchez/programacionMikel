import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Añada una distancia en km ");
		int km = Integer.parseInt(leer.readLine());
		double metros = km *100; 
		double cm = km*100000; 
		double milla= km * 0.621371; 
		System.out.println("Su distancia en metros es " + metros);
		System.out.println("Su distancia en cm  es " + cm );
		System.out.println("Su distancia en millas es " + milla);
				
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
