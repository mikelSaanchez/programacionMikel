package bucles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio32 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numIntentos = 10; 
		int numAleatorio = (int)((Math.random()*100)+1);
		
		System.out.println("Añada un nummero: ");
		int numero = Integer.parseInt(leer.readLine());
		
		while(numero !=numAleatorio && numIntentos>=0 ) {
			numIntentos--;
			if(numero>numAleatorio) {
				System.out.println("Su numero es menor");
			}else {
				System.out.println("Su numero es mayor");
			}
			System.out.println("Introduce un numero:");
			numero=Integer.parseInt(leer.readLine());
		}
		if(numero== numAleatorio) {
			System.out.println("Has acaertado el numero ");
		}else {
			System.out.println("no lo has aceratado, era:"+numAleatorio);
		}
		
		
		
		
	}

}
