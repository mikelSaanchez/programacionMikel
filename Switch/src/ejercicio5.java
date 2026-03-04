import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añade el numero 1");
		int numero=Integer.parseInt(leer.readLine());
		System.out.println("Añada el operador");
		String operador=leer.readLine();
		System.out.println("Añade el numero 2");
		int numero1=Integer.parseInt(leer.readLine());
	
		switch (operador) {
		case "+":
			double suma = numero+ numero1;
			System.out.println("La suma es: "+suma);
			break;
		case "-":
			double resta = numero- numero1;
			System.out.println("La resta es: "+resta);
			break;
		case "*":
			double multiplicacion = numero* numero1;
			System.out.println("La multiplicacion es: "+multiplicacion);
			break;
		case "/":
			double division = numero/numero1;
			System.out.println("La division es: "+division);
			break;

		}
			 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
