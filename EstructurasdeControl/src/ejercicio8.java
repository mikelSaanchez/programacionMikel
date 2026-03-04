import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio8 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada un año");
		int año= Integer.parseInt(leer.readLine());
		
		if((año%4==0 && año % 100!= 0) || (año % 400 ==0)) {
			System.out.println("Su año es bisiesto");
		}else {
			System.out.println("Su año no es bisiesto");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
