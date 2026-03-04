import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su nombre de usuario:");
		String usuario=leer.readLine();
		System.out.println("Añada su contraseña:");
		String contraseña=leer.readLine();
	
		
		if(usuario.equals("alumno") && contraseña.equals("daw1programacion")) {
			System.out.println("Has entrado al sistema");
		}else {
			System.out.println("error");
		}
	}

}
