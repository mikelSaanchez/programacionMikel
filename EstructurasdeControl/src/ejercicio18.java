import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio18 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		int año;
		System.out.println("Introduce el nombre del alumno/a:");
		nombre=leer.readLine();
		System.out.println("Introduce el año de nacimiento:");
		año=Integer.parseInt(leer.readLine());
		double año1= 2025-año;
		if(año >2012 ) {
			System.out.println(nombre + ", " +año1 +" años, ¿Puede salir fuera en los recreos?: False");
		}else if (año<=2012 && año>=2008) {
			System.out.println("Añada si tiene autorizacion:S/N");
			String autorizacion = leer.readLine();
			if(autorizacion.equals("S")) {
				System.out.println(nombre + ", " +año1 +" años, ¿Puede salir fuera en los recreos?: True");
			}else if(autorizacion.equals("N")) {
				System.out.println(nombre + ", " +año1 +" años, ¿Puede salir fuera en los recreos?: False");
			}
		}else  {
			
			System.out.println(nombre + ", " +año1 +" años, ¿Puede salir fuera en los recreos?: True");
			}
		
		//Como lo ha hecho el profe
		
		System.out.println("Introduce el nombre del alumno/a:");
		String nombre1=leer.readLine();
		System.out.println("Introduce el año de nacimiento:");
		int año2=Integer.parseInt(leer.readLine());
		
		int edad = 2025- año2;
		boolean puedeSalir = false;
		if(edad>= 15 && edad<18) {
			System.out.println("Añada si tiene autorizacion:S/N");
			char autorizacionFirmada = leer.readLine().charAt(0);
			if(autorizacionFirmada=='S'||autorizacionFirmada=='s') {
				puedeSalir= true;
				
			}
		}else if (edad>=18) {
			puedeSalir=true;
		}System.out.println(nombre1 + ", " +edad +" años, ¿Puede salir fuera en los recreos?:"+puedeSalir);
		
		
		
		
		
		
		
		
		
	}

}
