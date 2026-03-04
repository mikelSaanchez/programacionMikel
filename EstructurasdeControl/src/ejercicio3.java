import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un numero");
		int numero;
		numero=Integer.parseInt(leer.readLine());
		if (numero%2==0){
			System.out.println("Su numero es par");
		}else {
			System.out.println("Su numero es impar");
		}
	}

}
