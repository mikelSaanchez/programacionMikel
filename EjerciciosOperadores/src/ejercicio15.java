import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.processing.SupportedSourceVersion;

public class ejercicio15 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su nombre y apellidos:");
		String nombre = leer.readLine();
		System.out.println("Añada su año de nacimiento:");
		int añoNacimiento =Integer.parseInt(leer.readLine());
		System.out.println("Añada en donde vive::");
		String ciudad =leer.readLine();
		System.out.println("Añada su profesion:");
		String profesion = leer.readLine();
		
		int añoActual = 2025;
		int edad = añoActual - añoNacimiento;
		System.out.println("Su edad actual es:"+edad);
		System.out.println("Me llamo "+nombre + "tengo "+ edad +" años, vivo en "+ ciudad+" y trabajo de "+profesion);
		
		String inicialNombre= nombre.substring(0,1);
		int pos = nombre.indexOf(" ");
		String inicialApellido= nombre.substring(pos + 1, pos + 2);
		System.out.println(inicialNombre + inicialApellido);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
