import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("CONCURSANTES OPERACIÓN TRIUNFO");
		System.out.println("-------------------------------");
		System.out.println("Introduce nombre:");
		String nombre= leer.readLine();
		System.out.println("Introduce año de nacimiento:");
		int añoNacimiento = Integer.parseInt(leer.readLine());
		double año = 2025 - añoNacimiento;
		System.out.println("Ha sido expulsado?S/N:");
		char expulsado= leer.readLine().charAt(0);
		System.out.println("Puntuacion media:");
		float media = Float.parseFloat(leer.readLine());
		System.out.println("-------------------------------");
		System.out.println("Concursante guardado correctamente");
		System.out.println("¿Quiere ver el concursante guardado? (S/N):");
		char ver = leer.readLine().charAt(0);
		boolean expulsado1;
		
		if(expulsado == 'S') {
			 expulsado1 = true;
		}else {
			 expulsado1= false;
		}
		if(ver=='S') {
			System.out.println(nombre+", "+año +" años, expulsado: "+ expulsado1+", puntuacion media: "+media);
		}else if(ver=='N') {
			System.out.println("Saliendo del programa");
		}else {
			System.out.println("Opcion erronea");
		}
		
	}

}
