import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numero1;
		int numero2;
		System.out.println("Añada un numero");
		numero1=Integer.parseInt(leer.readLine());
		System.out.println("Añada un segundo numero");
		numero2=Integer.parseInt(leer.readLine());
		
		if(numero2==0) {
			System.out.println("Error");
		}else {
			double division = numero1/numero2;
			System.out.println("El resultado de su division es:"+division);
		}
	}

}
