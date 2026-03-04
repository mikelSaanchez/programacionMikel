import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio12 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Añada el primer lado  ");
		double lado1 = Integer.parseInt(leer.readLine());		
		System.out.println("Añada el segundo lado ");
		double lado2 = Integer.parseInt(leer.readLine());  
		System.out.println("Añada el tercer lado ");
		double lado3 = Integer.parseInt(leer.readLine());
		
		double p = lado1 + lado2 + lado3; 
		double area = (p*(p-lado1)*(p-lado2)*(p-lado3))*0.5;
		System.out.println("El perimetro es:"+p );
		System.out.println("El area es:"+area);
		
		
		
		
	}

}
