import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio11 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int lado1;
		int lado2;
		int lado3;
		System.out.println("Añada el lado 1:");
		lado1=Integer.parseInt(leer.readLine());
		System.out.println("Añada el lado 2:");
		lado2=Integer.parseInt(leer.readLine());
		System.out.println("Añada el lado 3:");
		lado3=Integer.parseInt(leer.readLine());
		
		if(lado1 == lado2 && lado2 == lado3 && lado1==lado3) {
			System.out.println("Su triangulo es Equilatero");
		}else if((lado1 == lado2 && lado2 != lado3) || (lado1 == lado3 && lado2!=lado1)||(lado2==lado3 && lado1!= lado2)) {
			System.out.println("Su triangulo es Isosceles");
		}else if(lado1 != lado2 && lado1 !=lado3 && lado2!=lado3 ) {
			System.out.println("su triangulo es escaleno");
		}
		
		
		
		
		

	}

}
