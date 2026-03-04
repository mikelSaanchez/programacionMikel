import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Añada el area ");
		int radio = Integer.parseInt(leer.readLine());
		System.out.println("Añada el volumen ");
		int altura = Integer.parseInt(leer.readLine());
		double pi = 3.141592;	
		double volumen = pi * radio * radio * altura;
		double area = 2 * pi * radio * altura; 
		System.out.println("El area es " + area);
		System.out.println("El volumen es " + volumen );
	
		
		
		
		
		
		
		
		
		
	}

}
