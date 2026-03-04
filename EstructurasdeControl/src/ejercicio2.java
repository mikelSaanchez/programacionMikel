import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numero;
		System.out.println("Añada un numero:");
		numero=Integer.parseInt(leer.readLine());
		
		if(numero<0){
			System.out.println("Su nuemero es negativo");
		}else if(numero == 0 ){
		System.out.println("Su numero es 0");
		}else {
			System.out.println("Su numero es postivo");
		}
		
	}

}
