import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("VOTACIONES OT25");
		System.out.println("--------------");
		System.out.println("Introduce el usuario:");
		String usuario = leer.readLine();
		System.out.println("introduce contraseña:");
		String contraseña = leer.readLine();
		
		if(usuario.equals("usuario1") && contraseña.equals("contraseña12345")) {
			System.out.println("Datos correctos");
			System.out.println();
			 String nombre1 = "Ivan Rojo";
			 String nombre2 = "Claudia";
			System.out.println("Introduce los datos de " + nombre1+":");
			int datos1 = Integer.parseInt(leer.readLine());
			System.out.println("Introduce los datos de " + nombre2+":");
			int datos2 = Integer.parseInt(leer.readLine());
			double porcentaje1 = (datos1 *100)/(datos1+datos2);
			double porcentaje2 = (datos2 *100)/(datos1+datos2);
			System.out.println("Los datos de concursante1: "+porcentaje1);
			System.out.println("Los datos de concursante2: "+porcentaje2);
			System.out.println();
			if(porcentaje1>porcentaje2) {
				System.out.println("El ganador es: "+nombre1);
			}else if(porcentaje1<porcentaje2) {
				System.out.println("El ganador es: "+nombre2);
			}
		}else {
			System.out.println("Los datos introducidos son incorrectos");
		}
		
		
	}

}
