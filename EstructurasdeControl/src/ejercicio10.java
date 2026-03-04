import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio10 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int numero1;
		int numero2;
		int numero3;
		System.out.println("Añada el numero 1:");
		numero1=Integer.parseInt(leer.readLine());
		System.out.println("Añada el numero 2:");
		numero2=Integer.parseInt(leer.readLine());
		System.out.println("Añada el numero 3:");
		numero3=Integer.parseInt(leer.readLine());
		
		if(numero3>=numero2 && numero3>=numero1) {
			if(numero2>numero1) {
				System.out.println("Los numeros ordenados son."+numero3+"," + numero2+"," + numero1);
			}else {
				System.out.println("Los numeros ordenados son."+numero3+"," + numero1+"," + numero2);
			}
		}else if (numero2>=numero3 && numero2>=numero1) {
			if(numero3>numero2) {
				System.out.println("Los numeros ordenados son."+numero2 +"," + numero3 +"," + numero1);
			}else {
				System.out.println("Los nsumeros ordenados son."+numero2+"," + numero1+"," + numero3);
			}
		}else if(numero1>=numero2 && numero1>=numero3) {
			if(numero2>numero3) {
				System.out.println("Los numeros ordenados son."+numero1+"," + numero2+"," + numero3);
			}
		}else {
			System.out.println("Los numeros ordenados son."+numero1+"," + numero3+"," + numero2);
		}
			
	}
}		
		
		
		
		
