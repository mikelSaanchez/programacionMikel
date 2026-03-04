import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ejercicio5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <Integer> nums = new ArrayList<>();
		
		boolean salir = false;
		int sumaTotal = 0;
		
		for(int i = 0; !salir ;i++) {
			System.out.println("Añada numeros: ");
			int n = Integer.parseInt(leer.readLine());
			
			nums.add(n);
			 sumaTotal += n;
			
			 if(n==-1) {
				salir = true;
			}
		}
		System.out.println("La suma total es: "+sumaTotal);

	}

}
