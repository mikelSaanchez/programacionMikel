import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("REPARTO DE TEMAS OT");
		System.out.println("----------------------------");
		System.out.println("Nombre de concursante:");
		String nombre = leer.readLine();
		System.out.println("¿Favorito/a de la semana? (S/N):");
		char favorito = leer.readLine().charAt(0);
		System.out.println("Porcentaje de voto:");
		int porcentaje=Integer.parseInt(leer.readLine());
		System.out.println("¿Duo antes?Si/No:");
		String duo=leer.readLine();
		
		if((favorito=='S')||(porcentaje>=80)) {
			System.out.println("Tipo de tema: Solitario");
		}else if((porcentaje<=60)|| (duo.equals("No"))) {
			System.out.println("Tipo de tema: Duo");
		}else {
			System.out.println("Tipo de tema: Grupo");
		}
		
	}

}
