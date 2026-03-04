import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce el nombre del concursante:");
		String nombre = leer.readLine();
		System.out.println("Introduce nota profesor 1:");
		int nota1 = Integer.parseInt(leer.readLine());
		System.out.println("Introduce nota profesor 2:");
		int nota2 = Integer.parseInt(leer.readLine());
		
		double nota3 =(Math.random() * 10) + 1;
		System.out.println("Introduce nota profesor 3 aleatoria:"+nota3);
		double notaMedia = (nota1+nota2+nota3)/3;
		 		
		int pos = nombre.indexOf(" ");
		String nombreEntero = nombre.substring(0, pos -0);
		String nombreParcial= nombre.substring(pos + 1, pos + 2);
		
		System.out.println("La nota media de "+nombreEntero+" "+nombreParcial+". es:"+notaMedia);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
