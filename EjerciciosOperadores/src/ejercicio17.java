import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio17 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Añada su nombre completo:");
		String nombre = leer.readLine();
		System.out.println("Añada su edad:");
		int edad = Integer.parseInt(leer.readLine());
		System.out.println("Añada su mail:");
		String mail = leer.readLine();
		System.out.println("Añada su numero de asignaturas:");
		int asig=Integer.parseInt(leer.readLine());
		System.out.println("Añada su nota media");
		float media=Float.parseFloat(leer.readLine());
		
		boolean mayoredad = edad >=18;
		boolean aprobar= media >=5;
		double añosQuedan= 30-edad;
		
		System.out.println("¿Es mayor de edad?:"+mayoredad);
		System.out.println("¿Aprueba?"+aprobar);
		System.out.println("Le quedan estos años para llegar a 30:"+añosQuedan);
		System.out.println();
		System.out.println("Fichero:");
		System.out.println("----------------------");
		System.out.println("Nombre:"+ nombre);
		System.out.println("Edad:"+edad);
		System.out.println("Mail:"+mail);
		System.out.println("Numero de asignaturas:"+asig);
		System.out.println("Nota media actual:"+media);
		
		
		
		

	}

}
