import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio19 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su nombre completo:");
		String nombre= leer.readLine();
		System.out.println("Añada su año de nacimiento:");
		String año=(leer.readLine());
		System.out.println("Añada su color favorito:");
		String color= leer.readLine();
		
		String tresPrimeras = nombre.substring(0,3).toUpperCase();
		String dosUltimos = año.substring(2,4);
		String primeraColor = color.substring(0,1).toLowerCase();
		Double numAleatorio= Math.floor(Math.random()* 100) + 1;
		
		
		
		
		System.out.println("Su contraseña generada es:"+tresPrimeras + dosUltimos +primeraColor + numAleatorio);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
