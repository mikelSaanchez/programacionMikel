import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Añada grados C");
		int C = Integer.parseInt(leer.readLine()); 
		double F  =(9.0/5.0 * C) + 32;
		System.out.println(F);
		

		
		
		
		
	}

}
