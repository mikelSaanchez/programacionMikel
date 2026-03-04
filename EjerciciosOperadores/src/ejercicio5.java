import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su peso en kg");
		int peso = Integer.parseInt(leer.readLine()); 
		System.out.println("Añada su altura en m");
		float altura = Float.parseFloat(leer.readLine()); 
		double IMC = peso/(altura * 2); 
		
	System.out.println("Su indice de masa corporal es "+ IMC);
		
		
		
		
		
	}

}
