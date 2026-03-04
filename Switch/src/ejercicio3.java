import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un mes  del año:");
		int mes = Integer.parseInt(leer.readLine());
		
		switch(mes) {
		case 1,3,5,7,9,11:
			System.out.println("Este mes tiene 31 dias");
		break;
		case 4,6,8,10,12:
			System.out.println("Este mes tiene 30 dias");
		break;
		case 2:
			System.out.println("Tiene 28 dias");
		break;
		default:
			System.out.println("Mes invalido");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
