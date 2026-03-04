import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Añada el primer numero ");
		double numero1 = Integer.parseInt(leer.readLine());		
		System.out.println("Añada el segundo numero ");
		double numero2 = Integer.parseInt(leer.readLine()); 
		double suma = numero1 + numero2; 
		double resta = numero1 -numero2; 
		double multiplicacion = numero1 * numero2; 
		double division= numero1/numero2; 
		double resto = numero1 %numero2;
		double raiz = Math.sqrt(numero1);
		double raiz2 =Math.sqrt(numero2);
		double c = Math.pow(numero1, numero2);
		boolean mayor = numero1 > numero2;
		System.out.println("La suma es  " + suma); 
		System.out.println("La resta es  " + resta); 
		System.out.println("La multiplicacion es  "+ multiplicacion );
		System.out.println("La division es "+ division ); 
		System.out.println("El resto es "+  resto); 
		System.out.println("El primer numero elevado al segundo es  "+ c ); 
		System.out.println("Numero1 es mayor que numero2 "+ mayor);
		System.out.println("La raiz del numero1 es: "+ raiz);
		System.out.println("La raiz del numero2 es: "+raiz2);
		
		
		
		
		
		
		


	}

}
