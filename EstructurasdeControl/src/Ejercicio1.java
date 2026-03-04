import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numero1;
		int numero2;
		System.out.println("Añada el numero 1:");
		numero1=Integer.parseInt(leer.readLine());
		System.out.println("Añada el numero 2:");
		numero2=Integer.parseInt(leer.readLine());
		
		if(numero1>numero2){
		System.out.println("El numero 1 es mayor");
		}else{
			System.out.println("El numero 2 es mayor");
		}
		
	}

}
