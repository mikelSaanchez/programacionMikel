import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio14 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su nombre:");
		String Nombre = leer.readLine();
		System.out.println("Añada tres notas:");
		double nota1 = Integer.parseInt(leer.readLine());
		double nota2 = Integer.parseInt(leer.readLine());
		double nota3 = Integer.parseInt(leer.readLine());
		
		double mediaNotas= (nota1 + nota2 +nota3)/3;
		
		System.out.println("Hola "+Nombre +" tu nota media es " + mediaNotas);
		
		
		
		
		
		
		
		
	}

}
