import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Añada su edad: ");
		double edad = Integer.parseInt(leer.readLine());
		boolean mayorEdad = edad >= 18;
		boolean edadVieja=edad <=65;
		boolean edadExacta= edad==18;
		boolean edadLaboral= edad >=18 && edad<=65;
		boolean edadJubilado= edad <=65;
		

		System.out.println("¿Es mayor de edad?:"+mayorEdad);
		System.out.println("¿Es menor que 65 años?:"+edadVieja);
		System.out.println("¿Tiene entre 18 y 65 años?:"+edadLaboral);
		System.out.println("¿Tiene exactamente 18 años?:"+edadExacta);
		System.out.println("¿No es jubilado?:"+edadJubilado);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
