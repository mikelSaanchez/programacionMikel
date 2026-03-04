import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int [] numero = new int [8];
		
	
		int numMayor = numero[0];
		int posMayor = 0;
		
		int numMenor = numero[0];
		int posMenor = 0;
		
		for(int i = 0 ; i< numero.length;i++) {
			System.out.println("Introduce el numero "+(i+1)+": " );
			numero[i]=Integer.parseInt(leer.readLine());
			
			if(numero[i] > numMayor) {
				numMayor = numero[i];
				posMayor = i;
			}else if(numero[i] < numMenor) {
				numMenor = numero[i];
				posMenor = i;
			}
		}
		System.out.println("El numero mayor es: "+numMayor+" y la posicion es: "+posMayor);
		System.out.println("El numero menor es: "+numMenor+" y la posicion es: "+posMenor);
	}
}
