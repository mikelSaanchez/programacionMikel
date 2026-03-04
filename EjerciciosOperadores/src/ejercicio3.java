import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Pon la base y la altura del rectangulo");
		int Base = Integer.parseInt(leer.readLine()); 
		int altura = Integer.parseInt(leer.readLine()); 
		double Superficie = Base* altura;
		double Perimetro = 2 * (Base + altura); 
		
		System.out.println("La superficie del rectangulo es " +Superficie);
		System.out.println("El perimetro del rectangulo es " + Perimetro);
		
		
	}

}
