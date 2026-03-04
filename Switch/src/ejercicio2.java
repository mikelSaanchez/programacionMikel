import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada la estacion del año:");
		int mes = Integer.parseInt(leer.readLine());
		
		switch(mes) {
		case 1,2,12:
			System.out.println("Esta en invierno");
		 	break;
		case 3,4,5:
			System.out.println("Esta en primavera");
			break;
		case 6,7,8:
			System.out.println("Esta en verano");
			break;
		case 9,10,11:
			System.out.println("Esta en otoño");
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
