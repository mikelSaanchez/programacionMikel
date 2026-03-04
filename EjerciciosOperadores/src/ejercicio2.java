import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Añada el lado del cuadrado ");
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		int lado = Integer.parseInt(leer.readLine()); 
		
		double Area = lado * lado;
		double Perimetro = 4 *lado; 
		
		System.out.println("El area del cuadrado es " +Area);
		System.out.println("El perimetro del cuadrado es "+ Perimetro);
	}

}
