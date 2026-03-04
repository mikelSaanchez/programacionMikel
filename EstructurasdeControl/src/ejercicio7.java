import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un numero del uno al diez:");
		int numero;
		numero=Integer.parseInt(leer.readLine());
		if(numero<3) {
			System.out.println("Muy deficiente");
		}else if(numero>=3 && numero<5) {
			System.out.println("Insuficiente");
		}else if(numero>=5 && numero<6) {
			System.out.println("Bien");
		}else if (numero>=6 && numero<9) {
			System.out.println("notable");
		}else if (numero>=9 && numero<=10) {
		System.out.println("Sobresaliente");
		}
	}
}