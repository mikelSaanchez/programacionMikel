import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio15 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Número de alumnos:");
		int numeroAlumnos=Integer.parseInt(leer.readLine());
		
		
		
		if(numeroAlumnos>=100) {
			double costo=numeroAlumnos*65;
			System.out.println("Si son 100 o mas alumnos el costo es:"+costo);
			
		}else if(numeroAlumnos>=30 && numeroAlumnos<=49) {
			double costo1=numeroAlumnos*95;
			System.out.println("Si son entre 30 y 49 alumnos el costo es:"+costo1);
		}else if(numeroAlumnos<30 ) {
			double costo2= 4000/numeroAlumnos;
			System.out.println("Si son menos de 30 alumnos el costo es:"+costo2);
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
